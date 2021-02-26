package com.fh.practical.limit.ratelimiter.alg;






import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RateLimitAlg {

    private static final long TRY_LOCK_TIMEOUT = 200L;
    private Stopwatch stopWatch;
    private AtomicInteger currentCount = new AtomicInteger(0);
    private  int limit;
    private Lock lock = new ReentrantLock();

    protected RateLimitAlg(int limit, Stopwatch stopWatch){
        this.limit = limit;
        this.stopWatch = stopWatch;
    }

    public RateLimitAlg(int limit){
        this(limit,Stopwatch.createStarted());
    }



    public RateLimitAlg(Object object){

    }

    public boolean tryAcquire(){
        int updateCount = currentCount.incrementAndGet();
        if(updateCount < limit){
            return true;
        }
        try {
            try {
                if(lock.tryLock(TRY_LOCK_TIMEOUT, TimeUnit.MICROSECONDS)){
                    if(stopWatch.elapsed(TimeUnit.MILLISECONDS) > TimeUnit.SECONDS.toMillis(1)){
                        currentCount.set(0);
                        stopWatch.reset();
                    }
                    updateCount = currentCount.incrementAndGet();
                    return updateCount <= limit;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }finally {
            lock.unlock();
        }
        return false;
    }
}
