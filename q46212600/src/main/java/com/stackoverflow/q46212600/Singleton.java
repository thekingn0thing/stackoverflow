package com.stackoverflow.q46212600;


public enum Singleton {
    
    INSTANCE;
    
    public void doSomething(){
        callPrivateMethod();
    }
    
    private void callPrivateMethod() {
        
    }
}
