package com.fh.testcode;

import java.util.UUID;

public class IdGenerator {

    public static String generateTransactionId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
