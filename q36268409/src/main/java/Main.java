import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public class Main
{
    private static final Logger slf4jLogger = LoggerFactory.getLogger(Main.class);
    private static final Marker marker      = MarkerFactory.getMarker("Test");

    public static void main(String[] args)
    {
        System.out.println(slf4jLogger);
        slf4jLogger.debug(marker, "Hallo");
        slf4jLogger.trace(marker, "Hallo");
        slf4jLogger.info(marker, "Hallo");
        slf4jLogger.warn(marker, "Hallo");
        slf4jLogger.error(marker, "Hallo");
    }

}