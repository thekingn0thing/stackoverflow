package com.stackoverflow.q36403048;

public enum MockClass{
    INSTANCE;

    private MockClass(){
        //private constructor
    }

    public void convertToString(Integer a){
        SomeClass.setString(a.toString());
    }

}