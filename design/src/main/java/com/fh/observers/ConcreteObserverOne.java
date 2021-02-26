package com.fh.observers;

public class ConcreteObserverOne implements Observer {
    @Override
    public void update(Message message) {
        System.out.println("One----------------");
    }
}
