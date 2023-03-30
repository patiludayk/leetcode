package com.uday.practise.ps;

import java.util.ArrayList;
import java.util.List;

public class ForLoopTestForNull {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add(null);
        list.add("hi");
        list.add("my");
        list.add("name");
        list.add("is");
        list.add("uday");

        final long count = list.stream().count() + list.stream().count();
        System.out.println(list.size() + " " + count);

        for (String s : list){
            System.out.println(s);
        }

        System.out.println();

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

    }
}
