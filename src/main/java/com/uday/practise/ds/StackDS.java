package com.uday.practise.ds;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackDS<T> {

    private class StackNode{

    }

    private T[] dataStack;
    private int index;

    public StackDS(){

        index = 0;
    }

    public T push(T element){
        dataStack[index++] = element;
        return element;
    }

    public T pop(){
        if(index < 0){
            throw new EmptyStackException();
        }
        return dataStack[--index];
    }

    @Override
    public String toString(){
        return "stack: " + Arrays.toString(dataStack);
    }

}
