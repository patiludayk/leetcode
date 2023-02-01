package com.uday.practise.ps;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int step = 3;

        System.out.println("Original array: " + Arrays.toString(arr));
        rotateClockwise(arr, step);
        rotateAntiClockwise(arr, step);
    }

    private static void rotateAntiClockwise(int[] arr, int step) {
        //check step if greater than array size
        if (step == 0 || step % arr.length == 0) {
            return;
        }

        step = step % arr.length;   //if step > array size means get remainder as step eg step 9 size 7 => 9%7 = 2 step
        int[] temp = new int[step]; //temp array of step size
        for (int i = 0; i < step; i++) {    //fill temp array with element equal to no of step length
            temp[i] = arr[i];
        }

        //rotate/move element in array by step size - at the start of array
        for (int i = 0; i < arr.length - step; i++) {
            arr[i] = arr[step + i];
        }

        //finally fill last element with step length size from temp array
        int j = 0;
        for (int i = arr.length - step; i < arr.length; i++) {
            arr[i] = temp[j++];
        }

        System.out.println("Array rotated: " + Arrays.toString(arr));
    }


    private static void rotateClockwise(int[] arr, int step) {
    }
}
