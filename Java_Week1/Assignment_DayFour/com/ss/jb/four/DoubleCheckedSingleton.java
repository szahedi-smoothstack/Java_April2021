package com.ss.jb.four;

/**
 * Singleton class, to implement double checked locking
 */

public class DoubleCheckedSingleton {

    private static volatile DoubleCheckedSingleton instance = null;

    private DoubleCheckedSingleton() {}

    public static DoubleCheckedSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckedSingleton();
                }
            }
        }
        return instance;
    }

}
