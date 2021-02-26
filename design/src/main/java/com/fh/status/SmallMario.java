package com.fh.status;

public class SmallMario implements IMario {

    private final static SmallMario small = new SmallMario();

    private SmallMario(){

    }
    public static SmallMario getInstance(){
        return small;
    }


    @Override
    public State getName() {
        return State.SMALL;
    }

    @Override
    public void obtionMushRoom(MarioStateMachine2 machine2) {
        machine2.setCurrentState(SuperMario.getInstance());
        machine2.setScore(machine2.getScore() + 100);
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
