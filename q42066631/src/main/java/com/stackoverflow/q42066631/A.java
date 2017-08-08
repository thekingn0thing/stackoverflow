package com.stackoverflow.q42066631;

import akka.actor.UntypedActor;


public class A extends UntypedActor {
    
    private B b;
    
    @Override
    public void onReceive(Object message) throws Exception {
        if (b != null){
            throw new RuntimeException("b not null");
        }
    }
}
