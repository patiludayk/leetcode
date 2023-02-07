package com.uday.practise.threading;

import com.uday.practise.util.ColourConstant;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Employee {

    //This method performs some task and takes 2 seconds to execute completely
    public synchronized void printA() throws InterruptedException {
        //perform some task
        final String currentThread = Thread.currentThread().getName();
        long startTime = System.currentTimeMillis();
        long endTime = startTime + 15000;

        int temp = 0;
        while (endTime > startTime) {
            final String output = currentThread + ":" + temp + " ";
            System.out.print(ColourConstant.GREEN_BOLD + output + ColourConstant.RESET);

            TimeUnit.SECONDS.sleep(3);
            startTime = System.currentTimeMillis();
            temp++;
        }
        System.out.println();
    }

    //This method performs some task and takes 2 seconds to execute completely
    public synchronized void printB() throws InterruptedException {
        //perform some task
        final String currentThread = Thread.currentThread().getName();
        long startTime = System.currentTimeMillis();
        long endTime = startTime + 15000;

        int temp = 0;
        while (endTime > startTime) {
            final String output = currentThread + ":" + temp + " ";
            System.out.print(ColourConstant.PURPLE_BOLD + output + ColourConstant.RESET);

            TimeUnit.SECONDS.sleep(3);
            startTime = System.currentTimeMillis();
            temp++;
        }
        System.out.println();
    }

    //This method performs some task and takes 3 seconds to execute completely
    public static synchronized void printC() throws InterruptedException {
        //perform some task
        final String currentThread = Thread.currentThread().getName();
        long startTime = System.currentTimeMillis();
        long endTime = startTime + 10000;

        int temp = 0;
        while (endTime > startTime) {
            final String output = currentThread + ":" + temp + " ";
            System.out.print(ColourConstant.RED + output + ColourConstant.RESET);
            TimeUnit.SECONDS.sleep(1);
            startTime = System.currentTimeMillis();
            temp++;
        }
        System.out.println();
    }

}
