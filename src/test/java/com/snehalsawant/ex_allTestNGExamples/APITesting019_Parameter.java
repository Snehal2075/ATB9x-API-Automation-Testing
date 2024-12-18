package com.snehalsawant.ex_allTestNGExamples;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class APITesting019_Parameter {

    @Parameters("Browser")
    @Test
    public void demo1 (String value){
        System.out.println("Browser is " + value);

        if (value.equalsIgnoreCase("chrome"))
            System.out.println("Start My Testing");

        if(value.equalsIgnoreCase("Firefox"))
            System.out.println("Start My Firefox");
    }


}



