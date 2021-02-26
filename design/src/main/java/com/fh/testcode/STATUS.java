package com.fh.testcode;

public enum STATUS {

    TO_BE_EXECUTD(1,"将要执行"),EXECUTED(2,"执行"),
    EXPIRED(3,"过期"),FAILED(4,"FAILED");

    private int code;
    private String message;
    STATUS(int code,String message){
        this.code = code;
        this.message = message;
    }


}
