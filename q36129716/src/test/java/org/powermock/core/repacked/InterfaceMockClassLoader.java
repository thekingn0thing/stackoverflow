package org.powermock.core.repacked;

import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import org.powermock.core.transformers.impl.MainMockTransformer;

/**
 *  This transformer transform interfaces to be able mock static method in interfaces which became available since
 *  Java 8.
 *  Be careful. It's important that package stats from  org.powermock.core
 */
public class InterfaceMockClassLoader extends MainMockTransformer {

    @Override
    public CtClass transform(CtClass clazz) throws Exception {

        // classes which not interfaces are transformed by MainMockTransformer

        if (!clazz.isInterface()) {
            return clazz;
        }

        allowMockingOfStaticAndFinalAndNativeMethods(clazz);

        return clazz;
    }

    // Need copy this method, because it private

    private void allowMockingOfStaticAndFinalAndNativeMethods(final CtClass clazz) throws NotFoundException, CannotCompileException {
        for (CtMethod m : clazz.getDeclaredMethods()) {
            modifyMethod(m);
        }
    }
}
