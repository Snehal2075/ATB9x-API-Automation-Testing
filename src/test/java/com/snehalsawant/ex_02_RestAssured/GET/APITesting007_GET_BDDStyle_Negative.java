package com.snehalsawant.ex_02_RestAssured.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting007_GET_BDDStyle_Negative {
    public static void main(String[] args) {


        String pincode = "-1";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/us/66213")
                .when().log().all().get()
                .then().log().all().statusCode(200);
    }}


