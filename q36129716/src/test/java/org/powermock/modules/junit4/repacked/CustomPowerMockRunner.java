package org.powermock.modules.junit4.repacked;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.*;
import org.junit.runner.notification.RunNotifier;
import org.powermock.core.MockRepository;
import org.powermock.modules.junit4.common.internal.JUnit4TestSuiteChunker;
import org.powermock.modules.junit4.common.internal.impl.JUnit4TestSuiteChunkerImpl;
import org.powermock.modules.junit4.internal.impl.DelegatingPowerMockRunner;
import org.powermock.reflect.Whitebox;

import java.lang.annotation.Annotation;

/**
 * Purpose of this class - create a custom implementation of the {@link JUnit4TestSuiteChunkerImpl}.
 */
public class CustomPowerMockRunner extends Runner implements Filterable, Sortable {

    private JUnit4TestSuiteChunker suiteChunker;

    public CustomPowerMockRunner(Class<?> klass) throws Exception {
        suiteChunker = new CustomJUnit4TestSuiteChunkerImpl(klass, DelegatingPowerMockRunner.class);
        MockRepository.clear();
    }

    /**
     * Clean up some state to avoid OOM issues
     */
    @Override
    public void run(RunNotifier notifier) {
        Description description = getDescription();
        try {
            doRun(notifier);
        } finally {
            Whitebox.setInternalState(description, "fAnnotations", new Annotation[]{});
        }
    }

    private void doRun(RunNotifier notifier) {
        try {
            suiteChunker.run(notifier);
        } finally {
            // To avoid out of memory errors!
            suiteChunker = null;
        }
    }

    @Override
    public Description getDescription() {
        return suiteChunker.getDescription();
    }

    @Override
    public synchronized int testCount() {
        return suiteChunker.getTestCount();
    }

    @Override
    public void filter(Filter filter) throws NoTestsRemainException {
        suiteChunker.filter(filter);
    }

    @Override
    public void sort(Sorter sorter) {
        suiteChunker.sort(sorter);
    }


}
