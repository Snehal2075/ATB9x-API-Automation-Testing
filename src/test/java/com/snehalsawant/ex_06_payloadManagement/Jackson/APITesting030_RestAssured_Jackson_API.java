package com.snehalsawant.ex_06_payloadManagement.Jackson;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.snehalsawant.ex_06_payloadManagement.Gson_Demo.Booking;
import com.snehalsawant.ex_06_payloadManagement.Gson_Demo.BookingResponse;
import com.snehalsawant.ex_06_payloadManagement.Gson_Demo.Bookingdates;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class APITesting030_RestAssured_Jackson_API {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;

    @Test
    public void test_Create_Booking_Positive() {


        // Step1 - POST
        // URL -> Base URI + base Path
        // HEADER
        // BODY
        // Auth - NO

        // Step 2
        // prepare the Payload ( Object -> JSON String)
        // send the request

        //Step 3
        // Validate Response ( JSON String -> Object)
        // FirstName,
        // Status Code
        // Time Response

        Booking booking = new Booking();
        booking.setFirstname("Snehal");
        booking.setLastname("Sawant");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);

//        // Java Object -> JSON
//        Gson gson = new Gson();
//        String jsonStringBooking = gson.toJson(booking);
//        System.out.println(jsonStringBooking);

        ObjectMapper objectMapper;
        objectMapper = new ObjectMapper();
        String payload;
        try {
             payload= objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(payload);


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload).log().all();

        Response response = requestSpecification.when().post();
        String jsonResponseString = response.asString();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        // Case1 - extract() - Direct Extraction
        String firstname1 = response.then().extract().path("booking.firstname");
        System.out.println(firstname1);

        // Case 2 - jsonPath.getString("")  JSON Path Extraction

        JsonPath jsonPath = new JsonPath(response.asString());
        String bookingId = jsonPath.getString("bookingid");
        String firstname = jsonPath.getString("booking.firstname");
        System.out.println(bookingId);
        System.out.println(firstname);

        // Case 3 - DeSer - Extraction

//        BookingResponse bookingResponse = gson.fromJson(jsonResponseString, BookingResponse.class);

        BookingResponse bookingResponse = null;
        try {
            bookingResponse = objectMapper.readValue(response.asString(), BookingResponse.class
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(bookingResponse.getBookingid());
        System.out.println(bookingResponse.getBooking().getFirstname());
        System.out.println(bookingResponse.getBooking().getLastname());

        assertThat(bookingResponse.getBookingid()).isNotZero().isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Snehal").isNotNull().isNotEmpty();


    }
}