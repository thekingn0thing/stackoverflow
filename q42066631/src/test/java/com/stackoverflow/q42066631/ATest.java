package com.stackoverflow.q42066631;

import akka.actor.Actor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.pattern.Patterns;
import akka.testkit.TestActorRef;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;
import scala.concurrent.Future;

@RunWith(PowerMockRunner.class)
public class ATest {
    
    static ActorSystem system;
    
    @Mock
    private B b;
    
    @InjectMocks
    private A a ;
    
    @BeforeClass
    public static void setup() {
        system = ActorSystem.create();
    }
    
    @AfterClass
    public static void teardown() {
        system.shutdown();
    }
    
    @Test
    public void test() {
        final Props props = Props.create(A.class);
        ActorRef testActorRef = TestActorRef.create(system, props);
        Future<Object> ask = Patterns.ask(testActorRef, new Object(), 100);
    }
    
}