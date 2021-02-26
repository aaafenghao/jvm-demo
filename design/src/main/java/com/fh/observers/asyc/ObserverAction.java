package com.fh.observers.asyc;

import com.google.common.base.Preconditions;

import java.lang.reflect.Method;

public class ObserverAction {

    private Object target;
    private Method method;

    public ObserverAction(Object object,Method method){
        this.target = Preconditions.checkNotNull(object);
        this.method = method;
        this.method.setAccessible(true);
    }

    public void execute(Object event){
        try {
            method.invoke(target,event);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
