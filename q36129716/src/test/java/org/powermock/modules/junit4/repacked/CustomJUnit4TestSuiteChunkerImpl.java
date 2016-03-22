package org.powermock.modules.junit4.repacked;

import org.powermock.core.repacked.InterfaceMockClassLoader;
import org.powermock.core.transformers.MockTransformer;
import org.powermock.modules.junit4.common.internal.PowerMockJUnitRunnerDelegate;
import org.powermock.modules.junit4.common.internal.impl.JUnit4TestSuiteChunkerImpl;

/**
 *  Purpose of this class to add {@link InterfaceMockClassLoader} to mockTransformer chain.
 *  Be careful. It's important that package stats from org.powermock.modules.junit4.repacked
 */
public class CustomJUnit4TestSuiteChunkerImpl extends JUnit4TestSuiteChunkerImpl {

    public CustomJUnit4TestSuiteChunkerImpl(Class<?> testClass, Class<? extends PowerMockJUnitRunnerDelegate> runnerDelegateImplementationType) throws Exception {
        super(testClass, runnerDelegateImplementationType);
    }

    @Override
    public ClassLoader createNewClassloader(Class<?> testClass, String[] preliminaryClassesToLoadByMockClassloader, String[] packagesToIgnore, MockTransformer... extraMockTransformers) {
        return super.createNewClassloader(testClass, preliminaryClassesToLoadByMockClassloader, packagesToIgnore,
                addInterfaceMockTransformer(extraMockTransformers));
    }

    private MockTransformer[] addInterfaceMockTransformer(MockTransformer[] extraMockTransformers) {

        MockTransformer[] result = new MockTransformer[extraMockTransformers.length + 1];

        System.arraycopy(extraMockTransformers, 0, result, 0, extraMockTransformers.length);

        result[result.length - 1] = new InterfaceMockClassLoader();

        return result;
    }
}
