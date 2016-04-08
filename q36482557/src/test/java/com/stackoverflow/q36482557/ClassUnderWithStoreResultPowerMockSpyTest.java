package com.stackoverflow.q36482557;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import static org.assertj.core.api.Assertions.assertThat;
import static org.powermock.api.mockito.PowerMockito.doReturn;
import static org.powermock.api.mockito.PowerMockito.spy;

/**
 *
 */
@RunWith(Enclosed.class)
public class ClassUnderWithStoreResultPowerMockSpyTest {

    public static class CaseWithMethodC extends BaseCase {

        @Test
        public void testMethodC_doSomething() throws Exception {
            classUnderTest.setSomeState(10);
            int actual = Whitebox.invokeMethod(classUnderTest, "methodC");
            assertThat(actual).isEqualTo(20);
        }

        @Test
        public void testMethodC_doSomethingElse() throws Exception {
            classUnderTest.setSomeState(-1);
            int actual = Whitebox.invokeMethod(classUnderTest, "methodC");
            assertThat(actual).isEqualTo(10);
        }
    }


    @RunWith(PowerMockRunner.class)
    @PrepareForTest({ClassUnderTestWithStoreResult.class})
    public static class CaseWithoutMethodC extends BaseCase {

        @Override
        @Before
        public void setUp() throws Exception {
            super.setUp();
            classUnderTest = spy(classUnderTest);
            doReturn(50).when(classUnderTest,"methodC");
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

    public abstract static class BaseCase {
        ClassUnderTestWithStoreResult classUnderTest;

        @Before
        public void setUp() throws Exception {
            classUnderTest = new ClassUnderTestWithStoreResult(0);
        }

    }

}
