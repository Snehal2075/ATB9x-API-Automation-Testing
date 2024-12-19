package com.snehalsawant.ex_04_Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class API_Testing023_RestAssured_Assertion {
    RequestSpecification r;
    ValidatableResponse vr;
    Response response;
    String token;
    Integer bookingId;

@Test
    public void test_POST(){

        String payload_POST = "{\n" +
                "    \"firstname\": \"Snehal\",\n" +
                "    \"lastname\": \"Sawant\",\n" +
                "    \"totalprice\": 111,\n" +
                "    \"depositpaid\": false,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2018-01-01\",\n" +
                "        \"checkout\": \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \"Lunch\"\n" +
                "}";


        RequestSpecification r = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
                .contentType(ContentType.JSON);

                r.body(payload_POST).log().all();

        Response response1  = r.when().log().all().post();
        ValidatableResponse vr = response1.then().log().all();
             vr.statusCode(200);


             vr.body("booking.firstname",Matchers.equalTo("Snehal"));
             vr.body("booking.lastname",Matchers.equalTo("Sawant"));
             vr.body("booking.depositpaid",Matchers.equalTo("false"));
             vr.body("bookingid",Matchers.notNullValue());

    }



}


