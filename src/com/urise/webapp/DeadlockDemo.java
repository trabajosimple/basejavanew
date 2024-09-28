package com.urise.webapp;

public class DeadlockDemo {

    // Два объекта-ресурса
    public final static Object one = new Object(), two = new Object();

    public static void main(String[] args) {
        // Создаем два потока, которые будут
        // конкурировать за доступ к объектам
        // one и two
        Thread t1 = new Thread(() -> {
            // Блокировка первого объекта
            System.out.println("t1 - synchronized (one) ");
            synchronized (one) {
                Thread.yield();
                // Блокировка второго объекта
                System.out.println("t1 - synchronized (two) ");
                synchronized (two) {
                    System.out.println("t1 Success!");
                }
            }
        });
        Thread t2 = new Thread(() -> {
            // Блокировка второго объекта
            System.out.println("t2 - synchronized (two) ");
            synchronized (two) {
                Thread.yield();
                // Блокировка первого объекта
                System.out.println("t2 - synchronized (one) ");
                synchronized (one) {
                    System.out.println("t2 Success!");
                }
            }
        });
        // Запускаем потоки
        t1.start();
        t2.start();
    }
}
