package com.fh.status;

import com.fh.observers.asyc.Subscribe;

public class SuperMario implements IMario {

    private final static SuperMario instance = new SuperMario();

    public static SuperMario getInstance(){
        return instance;
    }

    @Override
    public State getName() {
        return State.SUPER;
    }

    @Override
    public void obtionMushRoom(MarioStateMachine2 machine2) {

    }

    @Override
    public void obtionCape(MarioStateMachine2 machine2) {

    }

    @Override
    public void obtionFireFlower(MarioStateMachine2 machine2) {

    }

    @Override
    public void meetMonster(MarioStateMachine2 machine2) {

    }
}
