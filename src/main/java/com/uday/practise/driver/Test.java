package com.uday.practise.driver;

import java.util.Stack;

public class Test {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack();

        stack.push(1);
        System.out.println(stack);
        stack.push(2);
        System.out.println(stack);
        stack.push(3);
        System.out.println(stack);
        stack.push(4);
        System.out.println(stack.toString());

        stack.pop();
        System.out.println(stack.toString());


    }
}
