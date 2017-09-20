package com.stackoverflow.q46212600;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.exceptions.verification.WantedButNotInvoked;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.times;
import static org.powermock.api.mockito.PowerMockito.doNothing;

@RunWith(PowerMockRunner.class)
@PrepareForTest(value = Singleton.class, fullyQualifiedNames = "com.stackoverflow.q46212600.Singleton$INSTANCE")
public class ClassUseSingletonTest {
    
    @Test
    public void should_verify_enum_method() throws Exception {
        final Singleton spy = PowerMockito.spy(Singleton.INSTANCE);
        Whitebox.setInternalState(Singleton.class, spy);
        
        doNothing().when(spy, "callPrivateMethod");
    
        new ClassUseSingletone().doSomething("do");
        
        PowerMockito.verifyPrivate(Singleton.INSTANCE, times(1)).invoke("callPrivateMethod");
    
    }
    
    @Test
    public void should_failed_verify_enum_method() throws Exception {
        final Singleton spy = PowerMockito.spy(Singleton.INSTANCE);
        Whitebox.setInternalState(Singleton.class, spy);
        
        doNothing().when(spy, "callPrivateMethod");
    
        new ClassUseSingletone().doSomething("");
        
        assertThatThrownBy(() -> {
            PowerMockito.verifyPrivate(Singleton.INSTANCE, times(1)).invoke("callPrivateMethod");
        }).isInstanceOf(WantedButNotInvoked.class)
        .hasMessageContaining("Actually, there were zero interactions with this mock.")
        
        ;
    
    }
    
}