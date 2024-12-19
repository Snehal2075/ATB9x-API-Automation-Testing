package com.snehalsawant.ex_06_payloadManagement;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class API_Testing026_RestAssured_Payload_POJO {
    RequestSpecification r;
    ValidatableResponse vr;
    Response response;
    String token;
    Integer bookingId;


    @Test
    public void test_POST(){
//
//        String payload_POST = "{\n" +
//                "    \"firstname\": \"Snehal\",\n" +
//                "    \"lastname\": \"Sawant\",\n" +
//                "    \"totalprice\": 111,\n" +
//                "    \"depositpaid\": false,\n" +
//                "    \"bookingdates\": {\n" +
//                "        \"checkin\": \"2018-01-01\",\n" +
//                "        \"checkout\": \"2019-01-01\"\n" +
//                "    },\n" +
//                "    \"additionalneeds\": \"Lunch\"\n" +
//                "}";

//        Map<String,Object> jsonBodyusingMap = new LinkedHashMap<>();
//        jsonBodyusingMap.put("firstname","Snehal");
//        jsonBodyusingMap.put("lastname","Sawant");
//        jsonBodyusingMap.put("totalprice",123);
//        jsonBodyusingMap.put("depositpaid",true);
//
//        Map<String,Object> bookingDatesMap = new LinkedHashMap<>();
//        bookingDatesMap.put("checkin","2018-01-01");
//        bookingDatesMap.put("checkout","2019-01-01");
//
//        jsonBodyusingMap.put("bookingdates",bookingDatesMap);
//        jsonBodyusingMap.put("additionalneeds","Breakfast");
//        System.out.println(jsonBodyusingMap);

         //POJO
        Booking booking = new Booking();
        booking.setFirstname("Snehal");
        booking.setLastname("Sawant");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckIn("2024-05-01");
        bookingDates.setCheckout("2024-06-01");
        booking.setBookingDates(bookingDates);
        booking.setAdditional_needs("Breakfast");

        System.out.println(booking);




        RequestSpecification r = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
                .contentType(ContentType.JSON);
//
            r.body(booking).log().all();
//
        Response response1  = r.when().log().all().post();
        ValidatableResponse vr = response1.then().log().all();

             vr.statusCode(200);
//
           // 1. Rest Assured Assertions.
             vr.body("booking.firstname",Matchers.equalTo("Snehal"));
             vr.body("booking.lastname",Matchers.equalTo("Sawant"));
             vr.body("booking.depositpaid",Matchers.equalTo("false"));
             vr.body("bookingid",Matchers.notNullValue());
//
//
//             // TestNg Assertion
//
//        // Soft vs Hard
//            // HardAssert - If any assertion fails, the remaining statements in that test will not
//                             // be executed.
//            //
//
//
         bookingId = response1.then().extract().path("bookingid");
         String firstname = response.then().extract().path("booking.firstname");
        String lastname = response.then().extract().path("booking.lastname");
//
//         // 2. TestNg Assertions
        Assert.assertNotNull(bookingId);
        Assert.assertEquals(firstname,"Snehal");
       Assert.assertEquals(lastname,"Sawant");
//
//
        // 3.AssertJ
//
      assertThat(bookingId).isNotNull().isNotZero().isPositive().isNotNegative();
      assertThat(firstname).isEqualTo("Snehal").isNotEmpty().isNotNull().isAlphanumeric();






    }



}


