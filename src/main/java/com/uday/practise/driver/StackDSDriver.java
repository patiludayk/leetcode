package com.uday.practise.driver;

import com.uday.practise.ds.StackDS;

public class StackDSDriver {
    public static void main(String[] args) {

        StackDS<Integer> intStack = new StackDS<>();

        for (int i = 0; i < 5; i++){
            intStack.push(i);
            System.out.println(intStack.toString());
        }

        for (int i = 7; i > 0; i--){
            intStack.pop();
            System.out.println(intStack.toString());
        }
    }
}
