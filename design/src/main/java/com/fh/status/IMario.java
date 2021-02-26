package com.fh.status;

public interface IMario {

    State getName();

    void obtionMushRoom(MarioStateMachine2 machine2);

    void obtionCape(MarioStateMachine2 machine2);

    void obtionFireFlower(MarioStateMachine2 machine2);

    void meetMonster(MarioStateMachine2 machine2);
}
