import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;

/**
 *
 */
@PrepareForTest({LoggerFactory.class, Main.class})
public class MainTest {
    @Rule
    public PowerMockRule rule = new PowerMockRule();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     * Test static Fields
     *
     * @throws Exception
     */
    @Test
    public void testMain() throws Exception {
        Logger logger = PowerMockito.mock(Logger.class);

        PowerMockito.mockStatic(LoggerFactory.class);
        PowerMockito.when(LoggerFactory.getLogger(Mockito.any(Class.class))).thenReturn(logger);

        Main.main(null);

        Mockito.verify(logger).debug(Mockito.any(Marker.class), Mockito.eq("Hallo"));
        Mockito.verify(logger).trace(Mockito.any(Marker.class), Mockito.eq("Hallo"));
        Mockito.verify(logger).info(Mockito.any(Marker.class), Mockito.eq("Hallo"));
        Mockito.verify(logger).warn(Mockito.any(Marker.class), Mockito.eq("Hallo"));
        Mockito.verify(logger).error(Mockito.any(Marker.class), Mockito.eq("Hallo"));
    }

}
