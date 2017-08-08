package com.stackoverflow.q38502419;

import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(EasyMockRunner.class)
public class TestSubject1 {


        @TestSubject
        MathApplication mathApplication;

        //@Mock annotation is used to create the mock object to be injected
        @Mock
        CalculatorService calcService;

    @Before
    public void setUp() throws Exception {
        mathApplication = new MathApplication();
    }

    @Test
        public void testAdd(){
            //add the behavior of calc service to add two numbers
            EasyMock.expect(calcService.add(10.0, 20.0)).andReturn(30.00);

            //activate the mock
            EasyMock.replay(calcService);

            //test the add functionality
            Assert.assertEquals(mathApplication.add(10.0, 20.0), 30.0, 0);
        }
    }
