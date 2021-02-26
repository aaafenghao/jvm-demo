package com.fh.status;

public class FireMario implements IMario{

    private final static FireMario instance = new FireMario();

    public static FireMario getInstance(){
        return instance;
    }

    @Override
    public State getName() {
        return State.FIRE;
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
