package com.uday.practise.util.array;

import java.util.Arrays;

import static com.uday.practise.util.ColourConstant.GREEN;
import static com.uday.practise.util.ColourConstant.RESET;

public class InputArrayUtil {

    public static int[] COMMON_RANDOM_ARRAY = {4, 1, 2, 3, 5, 6, 4, 7, 9, 10, 0, 6, 4};

    public static void printArray(int[] arr){
        System.out.println(GREEN + Arrays.toString(arr) + RESET);
    }
    public static void printArray(){
        System.out.println(GREEN + Arrays.toString(COMMON_RANDOM_ARRAY) + RESET);
    }
}
