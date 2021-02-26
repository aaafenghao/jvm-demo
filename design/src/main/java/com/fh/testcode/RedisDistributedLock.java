package com.fh.testcode;

public class RedisDistributedLock {

    private static volatile RedisDistributedLock instance;

    public static RedisDistributedLock getInstance(){
        if(instance == null){
            synchronized (RedisDistributedLock.class){
                if(instance == null){
                    instance = new RedisDistributedLock();
                }
            }
        }
        return instance;
    }


    private RedisDistributedLock(){

    }


    public boolean lock(String key){
        return true;
    }


    public boolean unlock(String key){
        return true;
    }

}
