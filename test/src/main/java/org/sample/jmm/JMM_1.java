package org.sample.jmm;

public class JMM_1 {

    public static int x = 20;

    public static  boolean f = false;

    public static void main(String[] args) {
        Thread a = new Thread(() ->{
            x = 40;
            f = true;
        });

        Thread b = new Thread(() ->{
            if(f == true){
                System.out.println(x);
            }
        });
        a.start();
        b.start();
    }
}
