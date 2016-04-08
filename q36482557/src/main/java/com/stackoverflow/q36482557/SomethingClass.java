package com.stackoverflow.q36482557;

/**
 *
 */
class SomethingClass {
    private int someState;

    SomethingClass() {
        this.someState = 30;
    }

    public void setSomeState(int someState) {
        this.someState = someState;
    }

    public int invoke() {
        if (someState > 0) {
            return doSomething();
        } else {
            return doSomethingElse();
        }
    }

    private int doSomething() {
        return 20;
    }

    private int doSomethingElse() {
        return 10;
    }
}
