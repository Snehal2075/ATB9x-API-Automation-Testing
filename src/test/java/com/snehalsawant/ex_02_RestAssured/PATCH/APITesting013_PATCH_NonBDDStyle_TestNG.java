package com.snehalsawant.ex_02_RestAssured.PATCH;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;


public class APITesting013_PATCH_NonBDDStyle_TestNG {

    @Description("\"Verify the PATCH Request for the Restful Booker\"")
    @Test
    public void test_patch_nonbdd(){

        String token = "98b26f14f4efced" ;
        String booking_id = "3421";

        String payloadPATCH = "{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\"\n" +
                "}";
        RequestSpecification r = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/" + booking_id)
                .contentType(ContentType.JSON)
                .cookie("token",token);
        r.body(payloadPATCH).log().all();

        Response response1  = r.when().log().all().put();

        ValidatableResponse vr = response1.then().log().all().statusCode(200);

    }

    @Description("\"Verify the negative PATCH Request for the Restful Booker\"")
    @Test
    public void Negativetest_patch_nonbdd(){

        String token = "abc123" ;
        String booking_id = "-45";

        String payloadPATCH = "{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\"\n" +
                "}";
        RequestSpecification r = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/" + booking_id)
                .contentType(ContentType.JSON)
                .cookie("token",token);
        r.body(payloadPATCH).log().all();

        Response response1  = r.when().log().all().put();

        ValidatableResponse vr = response1.then().log().all().statusCode(200);



    }
}

