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
public class RookMove implements IMove {
    
    @Override
    public List<IChess.ChessPosition> getPossibleMove(IChess.ChessPosition pos, ChessBoard board) {
        
        
        IChess.ChessPosition possiblePos;
        List<IChess.ChessPosition> ListPossiblePos = new ArrayList<IChess.ChessPosition>();
        
        outer : for(int i = pos.x +1; i < IChess.BOARD_WIDTH; i++) {
            
            if(Math.abs(pos.x - i) >=0 && pos.x < IChess.BOARD_WIDTH){
                possiblePos = new IChess.ChessPosition(i, pos.y);
                if (null != board.getPiece(possiblePos)){
                    if(board.getPiece(possiblePos).getColor() != board.getPiece(pos).getColor()){
  
                        ListPossiblePos.add(possiblePos);
                                
                        }
                    break outer; 
                }
                else {
                            ListPossiblePos.add(possiblePos);
                }
             
            }
        }
        
        outer :for(int i = pos.x - 1; i >= 0; i--) {
            
            if(Math.abs(pos.x - i) >=0 && pos.x < IChess.BOARD_WIDTH){
                possiblePos = new IChess.ChessPosition(i, pos.y);
                if (null != board.getPiece(possiblePos)){
                    if(board.getPiece(possiblePos).getColor() != board.getPiece(pos).getColor()){
                                
                        ListPossiblePos.add(possiblePos);
                                
                        }
                 
                    break outer;   
                }
                else {
                            ListPossiblePos.add(possiblePos);
                }
             
            }
        }

        outer :for(int j = pos.y +1; j < IChess.BOARD_HEIGHT; j++) {
            
            if(Math.abs(pos.y - j) >=0 && pos.y < IChess.BOARD_HEIGHT){
                possiblePos = new IChess.ChessPosition(pos.x, j);
                if (null != board.getPiece(possiblePos)){
                    if( board.getPiece(possiblePos).getColor() != board.getPiece(pos).getColor()){
                        ListPossiblePos.add(possiblePos);

                    }
                    break outer; 
                }
                
                else {
                    ListPossiblePos.add(possiblePos);
                }
            }
        }    
        outer :for(int j = pos.y - 1; j >= 0; j--) {
            
            if(Math.abs(pos.y - j) >=0 && pos.y < IChess.BOARD_HEIGHT){
                possiblePos = new IChess.ChessPosition(pos.x, j);
                if (null != board.getPiece(possiblePos)){
                    if( board.getPiece(possiblePos).getColor() != board.getPiece(pos).getColor()){
                        ListPossiblePos.add(possiblePos);
                    }
                    
                 break outer;   
                }
                else {
                    ListPossiblePos.add(possiblePos);
                }
            }
        }    
        //Return placement
        return ListPossiblePos;
        
        
    }
    
}
