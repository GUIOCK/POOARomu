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
public class PawnMove implements IMove {

    @Override
    public List<IChess.ChessPosition> getPossibleMove(IChess.ChessPosition pos, ChessBoard board) {
        
        IChess.ChessPosition possiblePos;
        List<IChess.ChessPosition> ListPossiblePos = new ArrayList<IChess.ChessPosition>();
        
        if (board.getPiece(pos).getColor() == IChess.ChessColor.CLR_WHITE) {
            if (board.getPiece(pos).getMoveCount() == 0){
            possiblePos = new IChess.ChessPosition(pos.x,pos.y-1);
            possiblePos = new IChess.ChessPosition(pos.x,pos.y-2);
            ListPossiblePos.add(possiblePos);
        }
            else{
            possiblePos = new IChess.ChessPosition(pos.x,pos.y-1);
            ListPossiblePos.add(possiblePos);    
                    }
        }
        else if (board.getPiece(pos).getColor() == IChess.ChessColor.CLR_BLACK){
            possiblePos = new IChess.ChessPosition(pos.x,pos.y+1);
            ListPossiblePos.add(possiblePos);
        }
        /*       
                if( possiblePos.y >= 1 && possiblePos.x == 1 ){
                    if (null != board.getPiece(possiblePos)){
                        if( board.getPiece(possiblePos).getColor() != board.getPiece(pos).getColor()){
                            ListPossiblePos.add(possiblePos);
                        }
                    }else{
                        ListPossiblePos.add(possiblePos);
                    }
                }
        */    
        return ListPossiblePos;
    }
    
}
