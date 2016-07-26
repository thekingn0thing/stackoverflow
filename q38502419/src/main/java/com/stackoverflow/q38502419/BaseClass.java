package com.stackoverflow.q38502419;

/**
 *
 */
public class BaseClass {

    protected Class1inSuperClass objectOfClass1inSuperClass;
    protected Class2inSuperClass objectOfClass2inSuperClass;
    protected int someInt;

    public BaseClass(ConfigClass config) {
        throw new RuntimeException("1");
    }

    protected boolean methodInSuperClass() {
        return someInt++  < 10;
    }
}
