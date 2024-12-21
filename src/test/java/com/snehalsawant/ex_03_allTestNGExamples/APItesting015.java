package com.snehalsawant.ex_03_allTestNGExamples;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APItesting015 {


    @BeforeTest()
    public void getToken() {
        System.out.println("1");

    }

    @BeforeTest()
    public void getBookingId() {
        System.out.println("2");
    }


    @Test
    public void test_PUT() {
        //Token and BookingId
        System.out.println("3");
    }

    @AfterTest
    public void CloseAllThings(){
        System.out.println("close");
    }
}



