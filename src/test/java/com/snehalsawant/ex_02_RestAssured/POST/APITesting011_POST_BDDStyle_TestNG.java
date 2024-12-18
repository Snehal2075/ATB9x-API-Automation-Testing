package com.snehalsawant.ex_02_RestAssured.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting011_POST_BDDStyle_TestNG {



    @Description("Verify the POST Req Positive")
    @Test
    public void test_POST_BDDStyle(){

        //url,body,header
        //url :https://restful-booker.herokuapp.com/auth
        //body : {
        //    "username" : "admin",
        //    "password" : "password123"
        //}
        //Content type : Application/Json

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";


        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .contentType(ContentType.JSON)
                .log().all().body(payload)
                .when().log().all().post()
                .then().log().all().statusCode(200);


    }

}

