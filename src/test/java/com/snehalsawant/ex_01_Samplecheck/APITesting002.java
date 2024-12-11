package com.snehalsawant.ex_01_Samplecheck;

import io.restassured.RestAssured;

public class APITesting002 {

    public static void main(String[] args) {

        // Gherkins Syntax
        // Given () - Pre Request - URL, Headers, Auth, Body
        //When () - HTTP Methods - GET/POST/PUT/PATCH/DELETE
        //Then() - Validation - 200 OK / First name

        //Full URL -  https://api.zippopotam.us/us/66213
        // Base URI - https://api.zippopotam.us
        //base path - us/66213

        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                 .basePath("us/66213")
                .when()
                .get()
                .then().log().all().statusCode(200);
    }
}
