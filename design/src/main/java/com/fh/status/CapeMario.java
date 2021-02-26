package com.fh.status;

public class CapeMario implements IMario {


    private final static CapeMario instance = new CapeMario();

    public static CapeMario getInstance(){
        return instance;
    }

    @Override
    public State getName() {
        return State.CAPE;
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
