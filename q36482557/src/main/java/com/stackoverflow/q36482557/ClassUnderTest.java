package com.stackoverflow.q36482557;

import java.util.IllegalFormatException;

/**
 *
 */
public class ClassUnderTest {

    private int someState;

    public ClassUnderTest(int someState) {
        this.someState = someState;
    }

    public void setSomeState(int someState) {
        this.someState = someState;
    }

    public void methodA(){
        // do some work
        methodC();
        // do some work which isn't depend on methodC result
    }

    public void methodB(){
        // do another some work
        methodC();
        // do more work which isn't depend on methodC result
    }

    private void methodC(){
        if (someState > 0) {
            doSomething();
        }
        else doSomethingElse();
    }

    private void doSomethingElse() {
       throw new IllegalArgumentException("doSomethingElse");
    }

    private void doSomething() {
        throw new IllegalStateException("doSomething");
    }

}
