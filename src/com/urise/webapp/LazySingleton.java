package com.urise.webapp;

public class LazySingleton {
    //    volatile private static LazySingleton INSTANCE;
//
    private LazySingleton() {
    }

    private static class LazySingletonHolder {
        private static final LazySingleton INSTANCE = new LazySingleton();
    }
//    The implementation of the idiom relies on the initialization phase of execution
//    within the Java Virtual Machine(JVM) as specified by the Java Language Specification (JLS).
//    When the class Something is loaded by the JVM, the class goes through initialization. Since
//    the class does not have any static variables to initialize, the initialization completes
//    trivially. The static class definition
//    LazyHolder within it is not initialized until the JVM determines that LazyHolder must be
//    executed. The static class LazyHolder is only executed when the
//    static method getInstance is invoked on the class Something,and the first time this happens
//    the JVM will load and initialize the LazyHolder

    public static LazySingleton getInstance1() {
        return LazySingletonHolder.INSTANCE;
//        if (INSTANCE == null) {
//            synchronized (LazySingleton.class) {
//                if (INSTANCE == null) {
//                    INSTANCE = new LazySingleton();
//                }
//            }
//        }
//        return INSTANCE;
    }
}