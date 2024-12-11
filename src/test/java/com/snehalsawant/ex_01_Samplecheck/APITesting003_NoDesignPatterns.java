package com.snehalsawant.ex_01_Samplecheck;

public class APITesting003_NoDesignPatterns {

    public void step1() {
        System.out.println("Step 1");
    }

    public void step2() {
        System.out.println("Step 2");
    }

    public void step3 (String param) {
        System.out.println("Step 3");
    }


    public static void main(String[] args) {

    APITesting003_NoDesignPatterns np = new APITesting003_NoDesignPatterns();
    np.step1();
    np.step2();
    np.step3("Snehal");
    }
}

