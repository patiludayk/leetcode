package com.uday.practise.ps;

public class CharacterFrequency {

    public static void main(String[] args) {

        String string = "dfasrsfdfsd";

        CharacterFrequency duplicate = new CharacterFrequency();
        duplicate.charFrequency(string);
    }

    private void charFrequency(String input) {

        final char[] charArray = input.toLowerCase().toCharArray();

        int[] charFreq = new int[26];
        for (int i = 0; i < input.length(); i++) {
//        for (int i = 0; i < charArray.length; i++) {
            charFreq[input.charAt(i) - 'a']++;
        }

        for (int i = 0; i < charFreq.length; i++) {
            if(charFreq[i] != 0){
                System.out.println((char)(i + 'a') + ":" + charFreq[i]);
            }
        }
    }
}
