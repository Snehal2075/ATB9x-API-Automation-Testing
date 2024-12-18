package com.snehalsawant.Task12122024;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class TestCase_4_InValidBookingId_NonBDDStyle {

    //URL: https://restful-booker.herokuapp.com/booking/1
    //BaseURI: https://restful-booker.herokuapp.com
    //BasePath:/booking/1

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

 @Description("Negative Test case 1")
    @Test
    public void testNegativeInValidBookingId() {

        String bookingid = "-2";
        r = RestAssured
                .given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/" + bookingid);

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
@Description("Negative Testcase 2")
    @Test
    public void testCharInValidBookingId(){
        String bookingid = "@$%^%$$";
        r = RestAssured
                .given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/" + bookingid);

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