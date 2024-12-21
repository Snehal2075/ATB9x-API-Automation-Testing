package com.snehalsawant.ex_03_allTestNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting22_InvocationCount {

    @Test(invocationCount = 5)
    public void test01(){
        Assert.assertTrue(true);
    }
}
