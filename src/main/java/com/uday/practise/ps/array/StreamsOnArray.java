package com.uday.practise.ps.array;

import java.util.Arrays;
import java.util.Collections;

import static com.uday.practise.util.array.InputArrayUtil.COMMON_RANDOM_ARRAY;
import static com.uday.practise.util.array.InputArrayUtil.printArray;

public class StreamsOnArray {
    public static void main(String[] args) {
        StreamsOnArray m = new StreamsOnArray();

        printArray(COMMON_RANDOM_ARRAY);
        m.getMaxFromArray(COMMON_RANDOM_ARRAY);
    }

    private void getMaxFromArray(int[] arr) {

        System.out.println("max: " + Arrays.stream(arr).max().getAsInt());
        System.out.println("min: " + Arrays.stream(arr).min().getAsInt());
        System.out.println("sum: " + Arrays.stream(arr).sum());
        System.out.println("average: " + Arrays.stream(arr).average().getAsDouble());
    }
}
