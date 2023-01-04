package com.uday.practise.ps;

public class DigitSum {

    public static void main(String[] args) {

        long num = 123456;

        DigitSum digitSum = new DigitSum();

        System.out.print(digitSum.allDigitSum(num) + " => ");
        System.out.println(digitSum.digitSumToSingleDigit(num));
    }

    /**
     * This gives sum of all digit but not in single digit but the total sum
     *
     * @param number
     * @return
     */
    private long allDigitSum(long number) {

        long digit = number % 10;
        if (number > 0)
            return digit + allDigitSum(number / 10);
        return 0;
    }

    /**
     * This gives sum of all digits till single digit output
     * For example 178 -> 1+7+8=16 -> 1+6=7
     * @param number
     * @return
     */
    private long digitSumToSingleDigit(long number) {
        if(number % 9 == 0)
            return 9;
        return number % 9;
    }
}
