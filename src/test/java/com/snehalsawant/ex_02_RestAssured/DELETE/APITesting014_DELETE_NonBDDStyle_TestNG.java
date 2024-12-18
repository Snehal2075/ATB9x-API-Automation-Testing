package com.snehalsawant.ex_02_RestAssured.DELETE;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting014_DELETE_NonBDDStyle_TestNG {



    @Test

    public void DELETE_nonbdd(){
        String token = "8f95f470829f517" ;
        String booking_id = "3421";


        RequestSpecification r = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/" + booking_id)
                .contentType(ContentType.JSON)
                .cookie("token",token);
               r.log().all();

        Response response1  = r.when().log().all().delete();

        ValidatableResponse vr = response1.then().log().all().statusCode(200);

    }

}

