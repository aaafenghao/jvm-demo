package com.fh.interfaces;

import java.util.Map;

public class AutoToken {

    private static final long DEFAULT_EXPIRED_TIME_INTERVAL = 1 * 60 * 1000;

    private String token;

    private long createTime;

    private long expiredTimeInterval = DEFAULT_EXPIRED_TIME_INTERVAL;

    public AutoToken(String token,long createTime){

    }

    public AutoToken(String token,long createTime,long expiredTimeInterval){

    }

    public static AutoToken create(String baseUrl, long createTime, Map<String,String> params){
        return new AutoToken(null,createTime);
    }

    public String getToken(){
        return this.token;
    }

    public boolean isExpired(){
        return false;
    }

    public boolean match(AutoToken autoToken){
        return false;
    }

}
