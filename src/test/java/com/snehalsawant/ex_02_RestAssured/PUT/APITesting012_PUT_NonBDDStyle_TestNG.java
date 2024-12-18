package com.snehalsawant.ex_02_RestAssured.PUT;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting012_PUT_NonBDDStyle_TestNG {

    // bookingid , token


   // public void get_token(){}     in future we will use this
  //  public void booking_id(){}


    @Description("Verify the PUT Request for the Restful Booker")
    @Test
    public void test_put_non_bdd(){

        String token = "6f4acc075dddd96" ;
        String booking_id = "496";

        String payloadPUT = "{\n" +
                "    \"firstname\" : \"Snehal\",\n" +
                "    \"lastname\" : \"Sawant\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        RequestSpecification r = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/" + booking_id)
                .contentType(ContentType.JSON)
                .cookie("token",token);
               r.body(payloadPUT).log().all();

        Response response1  = r.when().log().all().put();

        ValidatableResponse vr = response1.then().log().all().statusCode(200);

    }




    @Description("Verify the negative PUT Request for the Restful Booker")
    @Test
    public void Negativetest_put_non_bdd(){

        String token = "abc234" ;
        String booking_id = "-45";

        String payloadPUT = "{\n" +
                "    \"firstname\" : \"Snehal\",\n" +
                "    \"lastname\" : \"Sawant\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        RequestSpecification r = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/" + booking_id)
                .contentType(ContentType.JSON)
                .cookie("token",token);
        r.body(payloadPUT).log().all();

        Response response1  = r.when().log().all().put();

        ValidatableResponse vr = response1.then().log().all().statusCode(200);
}}




