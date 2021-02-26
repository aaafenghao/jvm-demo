package com.fh.status;

public class MarioStateMachine {

    private int score;
    private State currentState;

    public MarioStateMachine(){
        this.score = 0;
        this.currentState = State.SMALL;
    }

    public void obtionMushRoom(){
        if(currentState.equals(State.SMALL)){
            this.currentState = State.SUPER;
            this.score += 100;
        }
    }

    public void obtionCape(){
        if(currentState.equals(State.SMALL) || currentState.equals(State.SUPER)){
            this.currentState = State.CAPE;
            this.score += 200;
        }
    }

    public void obtionFireFlower(){
        if(currentState.equals(State.SMALL) || currentState.equals(State.SUPER)){
            this.currentState = State.FIRE;
            this.score += 300;
        }
    }



    public void meetMonster(){
        if(currentState.equals(State.SUPER)){
            this.currentState = State.SMALL;
            this.score -= 100;
            return;
        }
        if(currentState.equals(State.CAPE)){
            this.currentState = State.SMALL;
            this.score -= 200;
            return;
        }
        if(currentState.equals(State.FIRE)){
            this.currentState = State.SMALL;
            this.score -= 100;
            return;
        }
    }

    public int getScore(){
        return this.score;
    }

    public State getCurrentState(){
        return this.currentState;
    }


}
