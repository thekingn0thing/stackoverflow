package com.stackoverflow.q38502419;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.expect;
import static org.powermock.api.easymock.PowerMock.createMock;
import static org.powermock.api.easymock.PowerMock.replayAll;
import static org.powermock.api.support.membermodification.MemberMatcher.constructor;
import static org.powermock.api.support.membermodification.MemberModifier.suppress;


/**
 * This test case shows how the issue could be fixed via WhiteBox
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(MainClass.class)
public class WhiteBoxApproachTestClass {
    
    @Before
    public void setUp() throws Exception {
        suppress(constructor(BaseClass.class));
    }
    
    
    @Test
    public void testMyMethod() {
        MainClass main = new MainClass(createMock(ConfigClass.class));

        List<String> list1 = new ArrayList<>();
        list1.add("somevalues");

        Class1inSuperClass ob1 = createMock(Class1inSuperClass.class);
        Class2inSuperClass ob2 = createMock(Class2inSuperClass.class);

        expect(ob2.method()).andReturn(getClass());
        expect(ob1.operation(getClass())).andReturn(list1);

        Whitebox.setInternalState(main, "objectOfClass1inSuperClass", ob1);
        Whitebox.setInternalState(main, "objectOfClass2inSuperClass", ob2);

        replayAll();

        main.myMethod();

        assertThat(MainClass.variableToBeAsserted).isEqualTo(5);
    }
}