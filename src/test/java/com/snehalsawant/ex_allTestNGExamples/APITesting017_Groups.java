package com.snehalsawant.ex_allTestNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting017_Groups{

    @Test(groups = {"sanity","QA","Prod"})
    public void sanityRun(){
        System.out.println("sanity");
        System.out.println("QA");
        Assert.assertTrue(true);
    }

    @Test(groups = {"Reg"})
    public void RegRun() {
        System.out.println("Reg");
        Assert.assertTrue(false);
    }
    @Test(groups = {"Smoke","QA"})
    public void SmokeRun() {
        System.out.println("Smoke");
        System.out.println("QA");
        Assert.assertTrue(false);
    }


}



