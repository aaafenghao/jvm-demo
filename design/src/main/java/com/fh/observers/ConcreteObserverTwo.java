package com.fh.observers;

public class ConcreteObserverTwo implements Observer{
    @Override
    public void update(Message message) {
        System.out.println("two------------------");
    }
}
