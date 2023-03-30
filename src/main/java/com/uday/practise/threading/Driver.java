package com.uday.practise.threading;

/**
 * Problem:
 * 3 threads are created - t1, t2, t3
 * 1 object a of class A is created
 * All the three threads use this object a to call
 * the 3 different methods respectively
 * i.e. t1 calls first method
 * t2 calls second method
 * t3 calls third method
 * If all the 3 threads are started at same time
 * In how much time will all of them be completed
 */
public class Driver {

    public static void main(String[] args) {
        Driver d = new Driver();

        d.run();
    }

    private void run() {

        Employee e = new Employee();

        Thread t1 = new Thread(() -> {
            try {
                e.printA();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }, "t1");

        /*Thread t4 = new Thread(() -> {
            try {
                e.printA();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }, "t4");*/

        Thread t2 = new Thread(() -> {
            try {
                e.printB();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }, "t2");

        Thread t3 = new Thread(() -> {
            try {
                e.printC();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }, "t3");

        long startTime = System.currentTimeMillis()/1000;
        System.out.println(">>>" + startTime);
        t2.start();
        t1.start();
        t3.start();
        //t4.start();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println(">>>totalTime" + (System.currentTimeMillis()/1000 - startTime));
        }));


    }
}
