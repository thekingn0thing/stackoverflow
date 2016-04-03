import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

/**
 *
 */
@RunWith(PowerMockRunner.class)
public class CcpProcessorUtilitiesTest {

    @Mock
    private Logger.ALogger aLogger;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this); // for case them used another runner
        Whitebox.setInternalState(CcpProcessorUtilities.class, "LOGGER", aLogger);
    }

    @Test
    public void testLogger() throws Exception {
        CcpProcessorUtilities.convertToURl("");
        verify(aLogger).error(eq("Invalid Format"), any(IllegalArgumentException.class));
    }
}
