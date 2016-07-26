package com.stackoverflow.q38502419;

import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.MockType;
import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.BeforeClass;
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
 * This test case shows how the issue could via {@link TestSubject}
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(MainClass.class)
public class TestSubjectApproachTestClass {

    @Mock(fieldName = "objectOfClass1inSuperClass")
    private Class1inSuperClass ob1;

    @Mock(fieldName = "objectOfClass2inSuperClass")
    private Class2inSuperClass ob2;

    @TestSubject
    private final MainClass main = new MainClass(createMock(ConfigClass.class));

    @BeforeClass
    public static void before() throws Exception {
        suppress(constructor(BaseClass.class));
    }

    @Test
    public void testMyMethod() {

        List<String> list1= new ArrayList<>();
        list1.add("somevalues");

        expect(ob2.method()).andReturn(getClass());
        expect(ob1.operation(getClass())).andReturn(list1);

        EasyMockSupport.injectMocks(main);

        replayAll();

        main.myMethod();

        assertThat(MainClass.variableToBeAsserted).isEqualTo(5);
    }
}