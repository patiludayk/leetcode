package com.uday.practise.ps;

import java.util.Arrays;

/**
 * Given an array of strings, return another array containing all of its longest strings.
 *
 * Example
 *
 * For inputArray = ["aba", "aa", "ad", "vcd", "aba"], the output should be
 * solution(inputArray) = ["aba", "vcd", "aba"].
 *
 * Input/Output
 *
 * [execution time limit] 3 seconds (java)
 *
 * [input] array.string inputArray
 *
 * A non-empty array.
 *
 * Guaranteed constraints:
 * 1 ≤ inputArray.length ≤ 10,
 * 1 ≤ inputArray[i].length ≤ 10.
 *
 * [output] array.string
 *
 * Array of the longest strings, stored in the same order as in the inputArray.
 */
public class LongestStringInArray {

    private String[] solution(String[] inputArray) {
        final String s1 = Arrays.stream(inputArray).reduce((s, s2) -> s.length() > s2.length() ? s : s2).get();
        System.out.println(s1);
        return null;
    }

    public static void main(String[] args) {
        LongestStringInArray longestStringInArray = new LongestStringInArray();
        longestStringInArray.solution(new String[]{"aba", "aa", "ad", "vcd", "aba"}); //output: ["aba", "vcd", "aba"]
    }
}
