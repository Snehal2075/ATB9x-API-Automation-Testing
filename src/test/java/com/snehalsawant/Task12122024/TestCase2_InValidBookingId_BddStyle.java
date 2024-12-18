package com.snehalsawant.Task12122024;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestCase2_InValidBookingId_BddStyle {

    //URL: https://restful-booker.herokuapp.com/booking/1
    //BaseURI: https://restful-booker.herokuapp.com
    //BasePath:/booking/1
   @Description ("Check the BookingId Invalid or not")
    @Test
    public void test_InValidBookingId(){
       String bookingid = "-2";
       RestAssured
               .given()
               .baseUri("https://restful-booker.herokuapp.com")
               .basePath("/booking/"+bookingid)
               .when().log().all().get()
               .then()
               .statusCode(404);




   }


}
