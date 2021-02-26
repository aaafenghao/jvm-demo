package com.fh.enjoyment.games;

import java.util.HashMap;
import java.util.Map;

public class ChessPieceUnitFactory {

    private static final Map<Integer,ChessPieceUnit> pieces = new HashMap<>();

    static {
        pieces.put(1,new ChessPieceUnit(1,"马", ChessPieceUnit.Color.BLACK));
    }

    public static ChessPieceUnit getChessPiece(int chessPieceId){
        return pieces.get(chessPieceId);
    }


}
