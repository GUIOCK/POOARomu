/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azz-kevinf
 */
public class KingMove implements IMove {
    
    @Override
    public List<IChess.ChessPosition> getPossibleMove(IChess.ChessPosition pos, ChessBoard board) {
        
        IChess.ChessPosition possiblePos;
        List<IChess.ChessPosition> ListPossiblePos = new ArrayList<IChess.ChessPosition>();
        
        for(int i = 0; i < IChess.BOARD_HEIGHT; i++) {
            for (int j = 0; j < IChess.BOARD_WIDTH; j++) {
                if(Math.abs((i-pos.x)) + Math.abs((j-pos.y)) <= 2 && Math.abs(i-pos.x) <2 && Math.abs(j-pos.y) <2){
                    possiblePos = new IChess.ChessPosition(i, j);
                    if (null != board.getPiece(possiblePos)){
                        if( board.getPiece(possiblePos).getColor() != board.getPiece(pos).getColor()){
                            ListPossiblePos.add(possiblePos);
                        }
                    }
                    else {
                        ListPossiblePos.add(possiblePos);
                    }     
                }
            } 
        }
        return ListPossiblePos;
    }
}
