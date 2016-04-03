import nl.utwente.viskell.haskell.env.Environment;
import nl.utwente.viskell.haskell.type.Type;
import nl.utwente.viskell.ui.ToplevelPane;
import nl.utwente.viskell.ui.components.ConstantBlock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Type.class, ToplevelPane.class, Environment.class})
public class ValueBlockTest {
    private ToplevelPane mockToplevelPane;

    @Before
    public void Setup() {
        mockToplevelPane = mock(ToplevelPane.class);
        Environment mockEnv = mock(Environment.class);
        Type mockType = mock(Type.class);
        when(mockEnv.buildType(any())).thenReturn(mockType);
        when(mockToplevelPane.getEnvInstance()).thenReturn(mockEnv);
    }

    @Test
    public void outputTest() throws Exception {
        ConstantBlock block = new ConstantBlock(mockToplevelPane, Type.con("Float"), "0.0", true);
        block.setValue("6");
        assertEquals(block.getValue(), "6");
    }
}