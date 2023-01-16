package com.uday.practise.ps;

/**
 * Input is a string like "AAAAABBCCAA" and it should print "5A2B2C2A".
 * 5 being the continuous number of occurance for character 'A'.
 * Same is with other characters also.
 */
public class EachCharacterFrequency {

    public static void main(String[] args) {

        String i = "AAAAABBCCAA";
        System.out.println(printEachCharacterFreq(i));
    }

    private static String printEachCharacterFreq(String input) {

        StringBuilder op = new StringBuilder();

        int temp = 1;
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                temp += 1;
            } else {
                op.append(input.charAt(i));
                op.append(temp);

                temp = 1;
            }
        }

        op.append(input.charAt(input.length() - 1));
        op.append(temp);

        return op.toString();

    }
}
