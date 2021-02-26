package com.fh.reconfig.first;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

public class RandomIdGenerator implements LogTraceIdGenerator{
    @Override
    public String generator() {
        String lastFieldHostName = getLastFieldHostName();
        long l = System.currentTimeMillis();
        String s = generateRandomAlphameric(8);
        String id = String.format("%s-%d-%s", lastFieldHostName, l, s);
        return id;
    }

    private String getLastFieldHostName(){
        String substrOfHostName =  null;
        try {
            String hostName = InetAddress.getLocalHost().getHostName();
            String[] tokens = hostName.split("\\.");
            substrOfHostName = tokens[tokens.length - 1];
            return substrOfHostName;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return substrOfHostName;
    }


    private String generateRandomAlphameric(int length){
        char[] randomChars = new char[length];
        int count = 0;
        Random random = new Random();
        while (count < length){
            int maxAscii = 'z';
            int randomAscii = random.nextInt(maxAscii);
            boolean isDigit = randomAscii >= '0' && randomAscii <= '9';
            boolean isUppercase = randomAscii >='A' && randomAscii <= 'Z';
            boolean isLowercase = randomAscii >='a' && randomAscii <= 'z';
            if(isDigit || isUppercase || isLowercase){
                randomChars[count] = (char)randomAscii;
                ++count;
            }
        }
        return new String(randomChars);
    }
}
