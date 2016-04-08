package com.stackoverflow.q36482557;

/**
 *
 */
public class ClassUnderTestAfterRefactoring {

    private int result;

    public int getResult() {
        return result;
    }

    public void methodA(){
        // do some work
        result = methodC();
        // do some work which isn't depend on methodC result
    }

    public void methodB(){
        // do another some work
        result = methodC();
        // do more work which isn't depend on methodC result
    }

    public int methodC(){
        return new SomethingClass().invoke();
    }

}
