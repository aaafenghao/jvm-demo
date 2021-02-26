package com.fh.status;

import static com.fh.status.State.*;
public class MarioStateMachine1 {

    private int score;

    private State currentState;

    private static final State[][] transitionTable = {
            {SUPER,CAPE,FIRE,SMALL},
            {SUPER,CAPE,FIRE,SMALL},
            {CAPE,CAPE,CAPE,SMALL},
            {FIRE,FIRE,FIRE,SMALL}
    };

    private static final int[][] actionTable = {
            {+100,+200,+300,+0},
            {+0,+200,+300,-100},
            {+0,+0,+0,-200},
            {+0,+0,+0,-300}
    };

    public MarioStateMachine1(){
        this.score = 0;
        this.currentState = SMALL;
    }

    public void obtionMushRoom(){
        executeEvent(Event.GOT_MUSHROOM);
    }

    public void obtionCape(){
        executeEvent(Event.GOT_CAPE);
    }

    public void obtionFireFlower(){
        executeEvent(Event.GOT_FIRE);
    }

    public void meetMonster(){
        executeEvent(Event.MET_MONSTER);
    }

    private void executeEvent(Event event){
        int value = currentState.getValue();
        int value1 = event.getValue();
        this.currentState = transitionTable[value][value1];
        this.score += actionTable[value][value1];
    }

    public int getScore(){
        return this.score;
    }

    public State getCurrentState(){
        return this.currentState;
    }
}
