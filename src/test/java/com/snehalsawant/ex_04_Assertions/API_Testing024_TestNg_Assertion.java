package com.snehalsawant.ex_04_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class API_Testing024_TestNg_Assertion {
    @Test
    public void test_hardAssertExample(){
        System.out.println("Start of the program");
        Boolean is_snehal = false;
        Assert.assertTrue(is_snehal);
        System.out.println("End of the program");
        Assert.assertEquals("Snehal","Snehal");
    }

    @Test
    public void test_softAsertExamples(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(false);
        System.out.println("This line will be executed.");
        softAssert.assertAll();//This will report all collected errors


    }
}
