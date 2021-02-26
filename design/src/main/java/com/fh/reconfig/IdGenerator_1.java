package com.fh.reconfig;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * 第一轮重构
 * 提高代码的可读性
 */
public class IdGenerator_1 {

    public static String generate(){
        String id = "";
        try {
            String hostName = InetAddress.getLocalHost().getHostName();
            String[] token = hostName.split("\\.");
            if(token.length > 0){
                hostName = token[token.length - 1];
            }
            char[] randomChars = new char[8];
            int count = 0;
            Random random = new Random();
            while (count < 8){
                int randomAscii = random.nextInt(122);
                if(randomAscii >=48 && randomAscii <= 57){
                    randomChars[count] = (char) ('0'+(randomAscii - 48));
                    count++;
                } else if(randomAscii >= 65 && randomAscii <= 90){
                    randomChars[count] = (char) ('A'+(randomAscii - 65));
                    count++;
                } else if(randomAscii >= 97 && randomAscii <= 122){
                    randomChars[count] = (char) ('a'+(randomAscii - 97));
                    count++;
                }
            }
            id = String.format("%s-%d-%s",hostName,System.currentTimeMillis(),new String(randomChars));

        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.out.println("Fail to get the host name");
        }
        return id;
    }

    public static void main(String[] args) {
        System.out.println(IdGenerator_1.generate());
    }
}
