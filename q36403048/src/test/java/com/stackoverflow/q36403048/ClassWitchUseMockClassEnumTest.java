package com.stackoverflow.q36403048;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.powermock.api.mockito.PowerMockito.doNothing;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.whenNew;

/**
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {MockClass.class})
public class ClassWitchUseMockClassEnumTest {

    private MockClass instance;

    @Before
    public void setUp() throws Exception {
        instance = mock(MockClass.class);
        Whitebox.setInternalState(MockClass.class,"INSTANCE", instance);
    }

    @Test
    public void mockEnum() throws Exception {

        doNothing().when(instance).convertToString(anyInt());

        MockClass.INSTANCE.convertToString(1);

        assertThat(SomeClass.string).isNull();
    }

}
