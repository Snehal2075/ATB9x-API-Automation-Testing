package com.snehalsawant.Task12122024;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class TestCase_3_ValidBookingId_NonBDDStyle {

    //URL: https://restful-booker.herokuapp.com/booking/1
    //BaseURI: https://restful-booker.herokuapp.com
    //BasePath:/booking/1

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void testValidBookingId(){

        String bookingid = "4184";
        r = RestAssured
                .given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+ bookingid);

        response = r
                .when()
                .log()
                .all()
                .get();

        vr = response
                .then()
                .log()
                .all()
                .statusCode(200);








    }

}