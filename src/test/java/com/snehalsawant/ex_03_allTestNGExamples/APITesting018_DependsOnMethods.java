package com.snehalsawant.ex_03_allTestNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting018_DependsOnMethods {

    @Test
    public void server_Startedok(){
        System.out.println("I will run first");
        Assert.assertTrue(true);
    }
@Test(dependsOnMethods = "server_Startedok")
    public void Method1(){
        System.out.println("Method1");
        Assert.assertTrue(true);
    }
@Test(dependsOnMethods = "server_Startedok")
    public void Method2(){
        System.out.println("Method2");
        Assert.assertTrue(true);
    }
}



