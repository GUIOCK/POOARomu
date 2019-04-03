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
        IChess.ChessPosition eatPos;
        
        //Choose the pawn color (white)
        if (board.getPiece(pos).getColor() == IChess.ChessColor.CLR_WHITE) {
            if (board.getPiece(pos).getMoveCount() == 0){
                possiblePos = new IChess.ChessPosition(pos.x,pos.y-2);
                if(board.getPiece(possiblePos) == null){
                    ListPossiblePos.add(possiblePos);
                }
            }
            possiblePos = new IChess.ChessPosition(pos.x,pos.y-1);
            if(board.getPiece(possiblePos) == null){
                    ListPossiblePos.add(possiblePos);
                }
            for(int i = -1; i < 2; i+=2){
                eatPos = new IChess.ChessPosition(pos.x + i, pos.y - 1);
                if(board.getPiece(eatPos) != null){
                    if(!board.getPiece(eatPos).getColor().equals(board.getPiece(pos).getColor())){
                        ListPossiblePos.add(eatPos);
                    }
                }
            }
        }
        //Choose the pawn color (black)
        else{
            //The pawn movement , we say if he never move he can move 2 "y" or 1 "y"
            if (board.getPiece(pos).getMoveCount() == 0){
                possiblePos = new IChess.ChessPosition(pos.x,pos.y+2);
                if(board.getPiece(possiblePos) == null){
                    ListPossiblePos.add(possiblePos);
                }
            }
            //Can onmy move 1 "y"
            possiblePos = new IChess.ChessPosition(pos.x,pos.y+1);
            //Can't move if the case in front him are null 
            if(board.getPiece(possiblePos) == null){
                    ListPossiblePos.add(possiblePos);
                }
            // Eat only in diagonal if a enemy are here
            for(int i = -1; i < 2; i+=2){
                eatPos = new IChess.ChessPosition(pos.x + i, pos.y +1);
                if(board.getPiece(eatPos) != null){
                    if(!board.getPiece(eatPos).getColor().equals(board.getPiece(pos).getColor())){
                        ListPossiblePos.add(eatPos);
                    }
                }
            }
        }
   
        return ListPossiblePos;
    }
    
}
