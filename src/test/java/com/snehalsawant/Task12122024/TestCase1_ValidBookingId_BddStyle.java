package com.snehalsawant.Task12122024;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestCase1_ValidBookingId_BddStyle {

    //URL: https://restful-booker.herokuapp.com/booking/1
    //BaseURI: https://restful-booker.herokuapp.com
    //BasePath:/booking/1
   @Description ("Check the BookingId is valid or not")
    @Test
    public void test_ValidBookingId(){
       String bookingid = "4184";
       RestAssured
               .given()
               .baseUri("https://restful-booker.herokuapp.com")
               .basePath("/booking/"+bookingid)
               .when().log().all().get()
               .then()
               .statusCode(200);




   }


}
