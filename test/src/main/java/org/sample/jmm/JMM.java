package org.sample.jmm;

public class JMM {

    static int num = 0;

    public static void main(String[] args) {
        new Thread(() ->{
            System.out.println("Child :"+num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num++;
            System.out.println("Child End :"+num);
        }).start();

        while (num==0);
        System.out.println("Main End :"+num);
    }
    
    
    
    
    

}
