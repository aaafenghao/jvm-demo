package org.sample.jmm;

import java.util.LinkedList;

public class StringTest {

    public static void main(String[] args) {
        /*String str = "哈哈哈";

        String a = new String("哈哈哈");
        System.out.println(a == str);
        a = a.intern();
        System.out.println(a == str);*/

        System.out.println("Byte.SIZE=" + Byte.SIZE / 8);
        System.out.println("Character.SIZE=" + Character.SIZE / 8);
        System.out.println("Short.SIZE=" + Short.SIZE / 8);
        System.out.println("Integer.SIZE=" + Integer.SIZE / 8);
        System.out.println("Long.SIZE=" + Long.SIZE / 8);
        System.out.println("Float.SIZE=" + Float.SIZE / 8);
        System.out.println("Double.SIZE=" + Double.SIZE / 8);

        LinkedList<String> linkedList = new LinkedList<>();
        for (String s : linkedList) {
            System.out.println(s);
        }
    }
}
