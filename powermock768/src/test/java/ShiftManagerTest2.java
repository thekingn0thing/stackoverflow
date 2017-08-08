import org.junit.Rule;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;

@PowerMockIgnore({"org.mockito.*", "org.robolectric.*", "android.*", "*.*"})
//@PrepareForTest({ShiftManagerTest2.TestSwitch.class})
public class ShiftManagerTest2 {

    @Rule
    public PowerMockRule rule = new PowerMockRule();

    enum AnyEnum {
        VAL_1
    }

    static class TestSwitch {

        public AnyEnum getValue() {
            return AnyEnum.VAL_1;
        }

        public void funcWithSwitch() {
            switch (getValue()) {

            }
        }
    }

    @Test
    public void testSwitch() throws Exception {
        TestSwitch spy = PowerMockito.spy(new TestSwitch());
        spy.funcWithSwitch();
    }
}
