package com.uday.practise.ps;

import java.util.Arrays;

public class SortDigitsInNumber {
    public static void main(String[] args) {

        int number = 56454482;

        SortDigitsInNumber sortDigits = new SortDigitsInNumber();
        System.out.println(sortDigits.sortDigits(number));
        //sortDigits.sortDigitsInSingleIteration(number);
    }

    /**
     * NOT WORKING
     * @param number
     */
    private void sortDigitsInSingleIteration(int number) {

        final int length = String.valueOf(number).length();
        int[] numberArray = new int[length];  //length of number
        for (int i = 0; i < length; i++) {
            numberArray[i] = number % 10;
            number = number / 10;
        }

        /*Arrays.sort(numberArray);
        System.out.println(Arrays.toString(numberArray));*/

        for (int i = 1; i < numberArray.length; i++) {
            if (numberArray[i - 1] > numberArray[i]) {
                int temp = numberArray[i];
                numberArray[i] = numberArray[i - 1];
                numberArray[i - 1] = temp;

                i--;
            }
        }
        System.out.println(Arrays.toString(numberArray));
    }

    /**
     * this has time complexit of O(n*m) where n is no of digits and m is max occurrences of any digit
     *
     * @param number
     * @return
     */
    private int sortDigits(int number) {
        int[] count = new int[10];  //size 10 because as any number contains digits between 0-9 only
        int n = number;
        while (n != 0) {    //fill count array with digit counts
            count[n % 10]++;    //increase digit count
            n /= 10;    //get next dogot from number
        }

        int sorted = 0;
        for (int digit = 1; digit < count.length; digit++) {
            for (int frequency = count[digit]; frequency > 0; frequency--) {    //iterate for all occurrences of digit
                sorted = sorted * 10 + digit;   //add next digit to sorted number
            }
        }
        return sorted;
    }

    private int sortDesc(final int num) {
        //Your code
        int[] count = new int[10];  //size 10 because as any number contains digits between 0-9 only
        int n = num;
        while (n != 0) {    //fill count array with digit counts
            count[n % 10]++;    //increase digit count
            n /= 10;    //get next dogot from number
        }

        int sorted = 0;
        for (int digit = 9; digit >= 0; digit--) {
            for (int index = count[digit]; index > 0; index--) {    //iterate for all occurrences of digit
                sorted = sorted * 10 + digit;   //add next digit to sorted number
            }
        }
        return sorted;
    }
}
