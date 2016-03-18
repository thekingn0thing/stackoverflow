package com.stackoverflow.q36086167;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Simple.class)
public class ProcessorTest {

    @Test
    public void doMe() throws Exception {
        Simple spy = PowerMockito.spy(new Simple());
        PowerMockito.doReturn("hello").when(spy, "privateMethod");
        String res = spy.doMe();

        PowerMockito.verifyPrivate(spy, Mockito.times(1)).invoke(
                "privateMethod");
        Assert.assertEquals( res, "hello");
    }


}