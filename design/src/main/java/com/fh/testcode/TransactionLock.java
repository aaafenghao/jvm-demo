package com.fh.testcode;

public class TransactionLock {

    public boolean lock(String id){
        return RedisDistributedLock.getInstance().lock(id);
    }

    public boolean unlock(String id){
        return RedisDistributedLock.getInstance().unlock(id);
    }
}
