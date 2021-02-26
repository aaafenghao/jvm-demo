package org.sample.hashcode;

import java.util.*;

public class Demo {

    public static void main(String[] args) {
       /* Demo demo = new Demo();
        demo.hashCode();*/

        Map<String,String> map = new HashMap(6);

        int cap = 6;
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        n |= n >>> 32;
//        System.out.println(n+1);

        List<String> list = new ArrayList<String>(10);
        list.add(2,"1");
        //System.out.println(list.get(0));


    }
}
