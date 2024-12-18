package com.snehalsawant.ex_02_RestAssured.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting008_GET_BDDStyle_TestNG {

@Test
    public void test_GET_Req_POSITIVE(){

    String pin_code = "66213";
    RestAssured.given()
            .baseUri("https://api.zippopotam.us")
            .basePath("/us/66213")
            .when().log().all().get()
            .then().log().all().statusCode(200);

}

    @Test
    public void test_GET_Req_NEGATIVE(){

        String pincode = "-1";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/us/66213")
                .when().log().all().get()
                .then().log().all().statusCode(200);
    }
}


