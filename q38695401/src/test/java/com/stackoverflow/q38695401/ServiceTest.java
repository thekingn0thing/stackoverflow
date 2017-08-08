package com.stackoverflow.q38695401;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 */
@RunWith(PowerMockRunner.class)
public class ServiceTest {

    @Test
    @PrepareForTest(LogUtils.class)
    public void test() {
        PowerMockito.mockStatic(LogUtils.class);
        Service a = new Service();
        LogUtils.log(LogUtils.Type.T, "test");
        a.test();
    }
}