package com.fh.status;

public class MarioStateMachine2 {

    private int score;

    private IMario currentState;

    public MarioStateMachine2(){
        this.score = 0;
        this.currentState = SmallMario.getInstance();
    }


    public void obtionMushRoom(){
        this.currentState.obtionMushRoom(this);
    }




    public void setScore(int score){
        this.score = score;
    }

    public void setCurrentState(IMario state){
        this.currentState = state;
    }

    public int getScore(){
        return this.score;
    }
}
