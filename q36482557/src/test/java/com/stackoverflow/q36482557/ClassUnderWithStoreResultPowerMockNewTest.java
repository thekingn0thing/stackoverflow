package com.stackoverflow.q36482557;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.powermock.api.mockito.PowerMockito.*;

/**
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ClassUnderTestAfterRefactoring.class, SomethingClass.class})
public class ClassUnderWithStoreResultPowerMockNewTest {

    @Mock
    private SomethingClass somethingClass;

    private ClassUnderTestAfterRefactoring classUnderTest;

    @Before
    public void setUp() throws Exception {
        classUnderTest = new ClassUnderTestAfterRefactoring();

        whenNew(SomethingClass.class).withAnyArguments().thenReturn(somethingClass);

        when(somethingClass.invoke()).thenReturn(50);
    }

    @Test
    public void testMethodA() throws Exception {
        // arrange test
        classUnderTest.methodA();
        // assert test result
        assertThat(classUnderTest.getResult()).isEqualTo(50);
    }

    @Test
    public void testMethodB() throws Exception {
        // arrange test
        classUnderTest.methodB();
        // assert test result
        assertThat(classUnderTest.getResult()).isEqualTo(50);
    }


}
