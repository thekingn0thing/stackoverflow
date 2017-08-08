package com.stackoverflow.q45414070;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import static org.assertj.core.api.Assertions.assertThat;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(
    value = MyEnum.class,
    fullyQualifiedNames = {
                              "com.stackoverflow.q45414070.MyEnum$1",
                              "com.stackoverflow.q45414070.MyEnum$2"
    })
public class MyTestClass {
    
    @Test
    public void should_return_sum_of_stubs() throws Exception {
        
        final MyEnum one = mock(MyEnum.ONE.getClass());
        final MyEnum two = mock(MyEnum.TWO.getClass());
        
        mockStatic(MyEnum.class);
        when(MyEnum.values()).thenReturn(new MyEnum[]{one, two});
    
        when(one.myMethod()).thenReturn(10);
        when(two.myMethod()).thenReturn(20);
        
        assertThat(new Consumer().consumer())
            .isEqualTo(30);
    }
    
    @Test
    public void should_return_stubs() {
    
        final MyEnum one = mock(MyEnum.ONE.getClass());
    
        when(one.myMethod()).thenReturn(10);
    
        Whitebox.setInternalState(MyEnum.class, "ONE", one);
    
        assertThat(MyEnum.ONE.myMethod()).isEqualTo(10);
    }
}
