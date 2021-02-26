package com.fh.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ArrayListDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        Iterator<String> iterator = list.iterator();

        list.remove("a");

        while (iterator.hasNext()){
            iterator.next();
        }
    }
}
