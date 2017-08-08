package com.stackoverflow.q38695401;

import java.util.Date;

/**
 *
 */
public class LogUtils {

    public static enum Type {
        T(1),
        D(2);

        private int type;

        Type(int type) {
            type = type;
        }
    }

    public static void log(Type t, String msg) {
        System.out.println("skip this method");
    }
}