package com.fh.reconfig.sec;

import com.fh.reconfig.first.LogTraceIdGenerator;
import com.google.common.annotations.VisibleForTesting;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

public class RandomIdGenerator implements LogTraceIdGenerator {
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
            substrOfHostName = getLastSubstrSplittedByDot(hostName);
            return substrOfHostName;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return substrOfHostName;
    }

    @VisibleForTesting
    protected String getLastSubstrSplittedByDot(String hostName){
        String[] tokens = hostName.split("\\.");
        return tokens[tokens.length - 1];
    }
    

    @VisibleForTesting
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
