package com.stackoverflow.q36482557;

/**
 *
 */
public interface ServiceInterfaceWithDefault {

    default String say(String string) {
        return "Hello " + string;
    }
}
