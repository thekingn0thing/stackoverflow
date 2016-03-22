package com.stackoverflow.q36129716;

/**
 *
 */
public interface ServiceInterfaceWithDefault {

    default String say(String string) {
        return "Hello " + string;
    }
}
