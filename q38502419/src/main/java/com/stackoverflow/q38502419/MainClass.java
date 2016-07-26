package com.stackoverflow.q38502419;

import java.util.List;


public class MainClass extends BaseClass {

    public static int variableToBeAsserted= 0;

    public MainClass(ConfigClass config) {
        super(config);
        someInt = 5;
    }

    public void myMethod() {
        List list = objectOfClass1inSuperClass.operation(objectOfClass2inSuperClass.method());
        while(methodInSuperClass()) {
            // doing operations with 'list'
            variableToBeAsserted++;
        }
    }


}
