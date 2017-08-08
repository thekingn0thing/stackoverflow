package com.stackoverflow.q45414070;


public class Consumer {
    int consumer() {
        int s = 0;
        for (MyEnum n : MyEnum.values()) {
            s += n.myMethod();
        }
        return s;
    }
}
