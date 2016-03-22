package com.stackoverflow.q36129716;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.powermock.modules.junit4.repacked.CustomPowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

// need custom PowerMockRunner to add custom MockTransformer which will transform interfaces
@RunWith(CustomPowerMockRunner.class)
// replace MockitoJUnitRunner.class to VertxUnitRunner.class
@PowerMockRunnerDelegate(MockitoJUnitRunner.class)
@PrepareForTest({StaticServiceInterface.class, ServiceInterface.class, ServiceInterfaceWithDefault.class})
public class StaticInterfaceMockTest {

    @Mock
    ServiceInterface serviceInterface;

    @Mock
    ServiceInterfaceWithDefault serviceInterfaceWithDefault;

    @Test
    public void testStaticCallInterface() throws Exception {
        mockStatic(StaticServiceInterface.class);

        final String value = "Static Mock Works";
        when(StaticServiceInterface.say(anyString())).thenReturn(value);

        assertEquals(value, StaticServiceInterface.say(""));
    }

    @Test
    public void testCallInterface() throws Exception {
        final String value = "Interface Mock Works";
        when(serviceInterface.say(anyString())).thenReturn(value);

        assertEquals(value, serviceInterface.say(""));
    }

    @Test
    public void testCallInterfaceWithDefault() throws Exception {
        final String value = "Interface default method Mock Works";
        when(serviceInterfaceWithDefault.say(anyString())).thenReturn(value);

        assertEquals(value, serviceInterfaceWithDefault.say(""));
    }

}