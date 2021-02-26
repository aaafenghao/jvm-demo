package com.fh.enjoyment.games;

import java.util.HashMap;
import java.util.Map;

public class ChessBoard {

    private Map<Integer,ChessPiece> chessPieces = new HashMap<>();

    public ChessBoard(){

    }

    private void init(){
        chessPieces.put(1,
                new ChessPiece(ChessPieceUnitFactory.getChessPiece(1),0,0));

    }

    public void move(int chessPieceId,int toPositionX,int toPositonY){

    }

    public static void main(String[] args) {
        Integer a = new Integer(2);
        Integer b = new Integer(2);
        System.out.println(a == b);
    }
}
