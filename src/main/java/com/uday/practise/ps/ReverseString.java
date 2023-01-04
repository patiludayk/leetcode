package com.uday.practise.ps;

import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        ReverseString r = new ReverseString();

        String input = "Today is Thursday";
        r.reverseString(input);
    }

    private void reverseString(String input) {
        Stack<Character> charStack = new Stack<>();
        for(int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ') {
                charStack.push(input.charAt(i));
            } else {
                while(!charStack.isEmpty())
                    System.out.print(charStack.pop());
                System.out.print(" ");
            }
        }
        while(!charStack.isEmpty())
            System.out.print(charStack.pop());
        System.out.print(" ");
    }
}
