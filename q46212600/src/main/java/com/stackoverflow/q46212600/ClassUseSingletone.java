package com.stackoverflow.q46212600;


public class ClassUseSingletone {
    
    public void doSomething(String value){
        if ("do".equals(value)) {
            Singleton.INSTANCE.doSomething();
        }
    }
    
}
