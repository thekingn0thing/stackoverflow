package com.stackoverflow.q36482557;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ClassUnderTestAfterRefactoringWithFactoryTest {

    @InjectMocks
    public ClassUnderTestAfterRefactoringWithFactory classUnderTest;

    @Mock SomethingClassFactory somethingClassFactory;

    @Mock SomethingClass somethingClass;

    @Before
    public void setUp() throws Exception {
        when(somethingClassFactory.create()).thenReturn(somethingClass);
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
