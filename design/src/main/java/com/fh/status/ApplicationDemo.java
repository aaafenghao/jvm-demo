package com.fh.status;

public class ApplicationDemo {

    public static void main(String[] args) {
        MarioStateMachine marioStateMachine = new MarioStateMachine();
        marioStateMachine.obtionMushRoom();
        int score = marioStateMachine.getScore();
        State currentState = marioStateMachine.getCurrentState();

    }
}
