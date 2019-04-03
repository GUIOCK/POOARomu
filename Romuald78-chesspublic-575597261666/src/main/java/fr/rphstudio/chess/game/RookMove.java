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
        IChess.ChessPosition nxtPos;
        List<IChess.ChessPosition> ListPossiblePos = new ArrayList<IChess.ChessPosition>();
        
        
        /*outer : for(int i = pos.x +1; i < IChess.BOARD_WIDTH; i++) {
            
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
        
        */
        for(int dir = 0; dir < 4; dir++){
            int dx = 0;
            int dy = 0;
            switch(dir){
                case 0:
                    dy = 1;
                    break;
                case 1:
                    dx = 1;
                    break;
                case 2:
                    dy = -1;
                    break;
                case 3:
                    dx = -1;
                    break;
            }
            for (int dist = 1; dist < 8; dist++){
                nxtPos = new IChess.ChessPosition(pos.x + (dx * dist), pos.y + (dy * dist));
                if (nxtPos.x <=7 && nxtPos.x >=0 && nxtPos.y >=0 && nxtPos.y <=7){ 
                    if (null != board.getPiece(nxtPos)){
                        if(board.getPiece(nxtPos).getColor() != board.getPiece(pos).getColor()){
                            ListPossiblePos.add(nxtPos);
                        }
                        break;
                    } else {
                                ListPossiblePos.add(nxtPos);
                    }
                }
            }
            
        }
        return ListPossiblePos;
    }
    
}
