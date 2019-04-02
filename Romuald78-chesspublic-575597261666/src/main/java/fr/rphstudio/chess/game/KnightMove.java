/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IChess.ChessPosition;
import fr.rphstudio.chess.interf.IMove;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guiockanthony
 */
public class KnightMove implements IMove{
    
    
    
    @Override
    public List<IChess.ChessPosition> getPossibleMove(IChess.ChessPosition pos, ChessBoard board) {
        
        IChess.ChessPosition possiblePos;
        List<IChess.ChessPosition> ListPossiblePos = new ArrayList<ChessPosition>();
        
        for(int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(Math.abs((i+j)-(pos.x + pos.y)) ==3 ){

                    if(i-pos.x != 0 && j - pos.y != 0){
                        possiblePos = new ChessPosition(i, j);
                        ListPossiblePos.add(possiblePos);
                    }
                    
                }
            } 
        }
        return ListPossiblePos;
    }
}
