package com.fh.enjoyment.games;

public class ChessPiece {

    private ChessPieceUnit chessPieceUnit;
    private int positionX;
    private int positionY;

    public ChessPiece(ChessPieceUnit unit,int positionX,int positionY){
        this.chessPieceUnit = unit;
        this.positionX = positionX;
        this.positionY = positionY;
    }
}
