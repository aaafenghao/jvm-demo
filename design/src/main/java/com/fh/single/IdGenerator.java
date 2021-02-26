package com.fh.single;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 饿汉式
 *
 *
 */
public class IdGenerator {

    private AtomicLong id = new AtomicLong(0);

    private static final IdGenerator instance = new IdGenerator();

    private IdGenerator(){

    }

    private static IdGenerator getInstance(){
        return instance;
    }

    public long getId(){
        return id.incrementAndGet();
    }
}
