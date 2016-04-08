package com.stackoverflow.q36482557;


import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import static org.powermock.api.support.SuppressCode.suppressMethod;

/**
 *
 */
@RunWith(Enclosed.class)
public class ClassUnderTestPowerMockTest {

    public static class CaseWithMethodC extends BaseCase{


        @Test(expected = IllegalStateException.class)
        public void testMethodC_doSomething() throws Exception {
            classUnderTest.setSomeState(10);
            Whitebox.invokeMethod(classUnderTest,"methodC");
        }

        @Test(expected = IllegalArgumentException.class)
        public void testMethodC_doSomethingElse() throws Exception {
            classUnderTest.setSomeState(-1);
            Whitebox.invokeMethod(classUnderTest,"methodC");
        }
    }


    @RunWith(PowerMockRunner.class)
    @PrepareForTest({ClassUnderTest.class})
    public static class CaseWithoutMethodC extends BaseCase{

        @Override
        @Before
        public void setUp() throws Exception {
            super.setUp();
            suppressMethod(ClassUnderTest.class, "methodC");
        }


        @Test
        public void testMethodA() throws Exception {
            // arrange test
            classUnderTest.methodA();
            // assert test result
        }

        @Test
        public void testMethodB() throws Exception {
            // arrange test
            classUnderTest.methodB();
            // assert test result
        }
    }

    public abstract static class BaseCase {
        ClassUnderTest classUnderTest;

        @Before
        public void setUp() throws Exception {
            classUnderTest = new ClassUnderTest(0);
        }

    }


}