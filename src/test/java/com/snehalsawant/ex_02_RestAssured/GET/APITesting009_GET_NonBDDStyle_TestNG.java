package com.snehalsawant.ex_02_RestAssured.GET;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting009_GET_NonBDDStyle_TestNG {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
@Description ("Verify the GET Req Positive")
    @Test
    public void test_GET_NonBDDStyle(){

        String pin_code = "66213";
        r = RestAssured
                .given();
               r .baseUri("https://api.zippopotam.us");
               r .basePath("/us/66213");

            response =  r .when().log().all().get();


            vr = response.then().log().all().statusCode(200);
}



    @Description ("Verify the GET Req Negative :-6 Input")
@Test
    public void test_GET_NonBDDStyle_Negative(){
        String pin_code = "-6";
        r = RestAssured
                .given();
        r .baseUri("https://api.zippopotam.us");
        r .basePath("/us/-6");

        response =  r .when().log().all().get();


        vr = response.then().log().all().statusCode(200);

}


    @Description ("Verify the GET Req Negative : -1 Input")
@Test
    public void test_GET_NonBDDStyle_Negative2(){
        String pin_code = "-1";
        r = RestAssured
                .given();


        vr = response.then().log().all().statusCode(200);


    }
}
