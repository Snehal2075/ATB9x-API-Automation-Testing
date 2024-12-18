package com.snehalsawant.ex_01_Samplecheck;



public class APITesting004_BuilderPatternDesign {


    public APITesting004_BuilderPatternDesign  step1() {
        System.out.println("Step 1");
        return this;
    }

    public APITesting004_BuilderPatternDesign  step2() {
        System.out.println("Step 2");
        return this;
    }

    public APITesting004_BuilderPatternDesign step3(String param) {
        System.out.println("Step 3");
       return this;

    }

    public static void main(String[] args) {
        APITesting004_BuilderPatternDesign bp = new APITesting004_BuilderPatternDesign();

        bp.step1().step2().step3("Hello");
    }



}
