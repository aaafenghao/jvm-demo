package org.example;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MyProfiler {

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(MyProfiler::dump));
    }

    public static ConcurrentHashMap<Class<?>, AtomicInteger> data = new ConcurrentHashMap<>();

    public static void fireAllocationEvent(Class<?> kclass){
        data.computeIfAbsent(kclass,kls->new AtomicInteger())
                .incrementAndGet();
    }

    public static void dump(){
        data.forEach((kls,count) ->{
            System.out.printf("%s:%d\n",kls.getName(),count.get());
        });
    }
}
