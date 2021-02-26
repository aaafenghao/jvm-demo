package com.fh.single;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator3 {

    private AtomicLong id = new AtomicLong();

    private static IdGenerator3 instance;

    private IdGenerator3(){

    }

    private static IdGenerator3 getInstance(){
        if(instance == null){
            synchronized (IdGenerator3.class){
                if(instance == null){
                    instance = new IdGenerator3();
                }
            }
        }
        return instance;
    }

    private long getId(){
        return id.incrementAndGet();
    }
}
