package com.stackoverflow.q45414070;


public enum MyEnum {
    ONE {
        @Override
        public int myMethod() {
            return 1;
        }
    },
    
    TWO {
        @Override
        public int myMethod() {
            return 2;
        }
    };
    
    public abstract int myMethod();
}
