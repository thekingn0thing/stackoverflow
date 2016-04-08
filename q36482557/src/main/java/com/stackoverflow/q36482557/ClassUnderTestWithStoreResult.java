package com.stackoverflow.q36482557;

/**
 *
 */
public class ClassUnderTestWithStoreResult {

    private int someState;
    private int result;

    public ClassUnderTestWithStoreResult(int someState) {
        this.someState = someState;
    }

    public void setSomeState(int someState) {
        this.someState = someState;
    }

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

    private int methodC(){
        if (someState > 0)
            return doSomething();
        else
            return doSomethingElse();
    }

    private int doSomethingElse() {
        return 10;
    }

    private int doSomething() {
        return 20;
    }

}
