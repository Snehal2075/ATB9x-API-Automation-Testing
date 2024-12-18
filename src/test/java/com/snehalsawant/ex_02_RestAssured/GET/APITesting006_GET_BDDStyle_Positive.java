package com.snehalsawant.ex_02_RestAssured.GET;

import io.restassured.RestAssured;


public class APITesting006_GET_BDDStyle_Positive {

    public static void main(String[] args) {

           String pin_code = "66213";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/us/66213")
                .when().log().all().get()
                .then().log().all().statusCode(200);



    }

}
