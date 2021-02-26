package com.fh.observers.asyc;

import com.google.common.util.concurrent.MoreExecutors;

import java.util.List;
import java.util.concurrent.Executor;

public class EventBus {

    private Executor executor;

    private ObserverRegistry  registry = new ObserverRegistry();

    public EventBus(){
        this(MoreExecutors.directExecutor());
    }

    protected EventBus(Executor executor){
        this.executor = executor;
    }

    public void register(Object object){
        registry.registry(object);
    }

    public void post(Object event){
        List<ObserverAction> matchedObserverAction = registry.getMatchedObserverAction(event);
        for (ObserverAction observerAction : matchedObserverAction) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    observerAction.execute(event);
                }
            });
        }
    }
}
