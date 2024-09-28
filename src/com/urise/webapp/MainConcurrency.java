package com.urise.webapp;

import java.util.ArrayList;
import java.util.List;

public class MainConcurrency {
    public static final int THREADS_NUMBER = 10000;
    private int counter;
    private static final Object LOCK = new Object();

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Thread thread0 = new Thread() {
            @Override
            public void run() {
                System.out.println(getName() + ", " + getState());
                throw new IllegalStateException();
            }
        };
        thread0.start();
        //            private void inc() {
//                synchronized (this) {
//                    counter++;
//                }
//            }
        new Thread(() -> System.out.println(Thread.currentThread().getName() + ", " + Thread.currentThread().getState())).start();
        System.out.println(thread0.getState());
        final MainConcurrency mainConcurrency = new MainConcurrency();
        List<Thread> threads = new ArrayList<>(THREADS_NUMBER);
        System.out.println("mainConcurrency.inc()");
        for (int i = 0; i < THREADS_NUMBER; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    mainConcurrency.inc();
                }
            });
            thread.start();
            threads.add(thread);
        }
        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(mainConcurrency.counter);
        final String lock1 = "lock1";
        final String lock2 = "lock2";
        deadLock(lock1, lock2);
        deadLock(lock2, lock1);
    }

    private static void deadLock(Object lock1, Object lock2) {
        new Thread(() -> {
            System.out.println("Waiting " + lock1);
            synchronized (lock1) {
                System.out.println("Holding " + lock1);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Waiting " + lock2);
                synchronized (lock2) {
                    System.out.println("Holding " + lock2);
                }
            }
        }).start();
    }

    private synchronized void inc() {
//        synchronized (this) {
//        synchronized (MainConcurrency.class) {
        counter++;
//                wait();
//                readFile
//                ...
//        }
    }

//    public static class WaitThread implements Runnable {
//        private final Object shared;
//
//        public WaitThread(Object o) {
//            shared = o;
//        }
//
//        public void run() {
//            synchronized (shared) {
//                System.out.println("before wait");
//                try {
//                    shared.wait();
//                } catch (InterruptedException e) {
//                    System.out.println(e);
//                }
//                System.out.println("after wait");
//            }
//        }
//
//        public void main(String[] args) {
//            Object o = new Object();
//            new Thread(new WaitThread(o)).start();
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                System.out.println(e);
//            }
//            System.out.println("before notify");
//            synchronized (o) {
//                o.notifyAll();
//                System.out.println("before notify 1");
//            }
//        }
//    }
}