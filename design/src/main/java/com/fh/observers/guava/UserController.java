package com.fh.observers.guava;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class UserController {
    
    private UserService userService;

    private EventBus eventBus;

    private static final int DEFAULT_EVENTBUS_THREAD_POOL_SIZE = 20;

    public UserController(){
        eventBus = new AsyncEventBus(Executors.newFixedThreadPool(DEFAULT_EVENTBUS_THREAD_POOL_SIZE));
    }

    public void setRegObservers(List<Object> observers){
        for (Object observer : observers) {
            eventBus.register(observer);
        }
    }

    public long register(String telephone,String password){
        long register = userService.register(telephone, password);

        eventBus.post(register);

        return register;
    }
}
