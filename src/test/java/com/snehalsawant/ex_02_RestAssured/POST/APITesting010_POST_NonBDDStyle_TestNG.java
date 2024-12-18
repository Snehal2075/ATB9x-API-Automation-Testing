package com.snehalsawant.ex_02_RestAssured.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class APITesting010_POST_NonBDDStyle_TestNG {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;


    @Description("Verify the POST Req Positive")
    @Test
    public void test_POST_NonBDDStyle(){

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";


        RequestSpecification r = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .contentType(ContentType.JSON).log().all()
                .body(payload);


        Response response1  = r.when().log().all().post();

        ValidatableResponse vr = response1.then().log().all().statusCode(200);


    }

}

