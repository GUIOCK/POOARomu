/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IChess.ChessPosition;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DOOM GUYS.
 */
public class UtilMove {
    
    
    
    /**
     * Set up the Diagonal move possible for Rook and the Queen
     * @param pos the position of the piece that we are interested in (either a Queen or Rook) 
     * @param board the position of all the other pieces.
     * @return A list of position possible for the piece.
     */
    public static List<ChessPosition> OrthogonalMove(IChess.ChessPosition pos, ChessBoard board){
        
        IChess.ChessPosition nxtPos;
        List<IChess.ChessPosition> listPossiblePos = new ArrayList<>();
        
        for(int dir = 0; dir < 4; dir++){   //
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
            for (int dist = 1; dist < IChess.BOARD_HEIGHT; dist++){
                nxtPos = new IChess.ChessPosition(pos.x + (dx * dist), pos.y + (dy * dist));
                if (nxtPos.x <=7 && nxtPos.x >=0 && nxtPos.y >=0 && nxtPos.y <=7){
                    if (null != board.getPiece(nxtPos)){
                        if(board.getPiece(nxtPos).getColor() != board.getPiece(pos).getColor()){
                            listPossiblePos.add(nxtPos);
                        }
                        break;
                    } else {
                        listPossiblePos.add(nxtPos);
                    }
                }
            }
            
        }
        return listPossiblePos;
    }
    /**
     * Set up the Diagonal move possible for Bishop and the Queen
     * @param pos the position of the piece that we are interested in (either a Queen or Bishop) 
     * @param board the position of all the other pieces.
     * @return A list of position possible for the piece.
     */
    public static List<IChess.ChessPosition> DiagonalMove (IChess.ChessPosition pos, ChessBoard board) {
        
        IChess.ChessPosition nxtPos;
        List<IChess.ChessPosition> listPossiblePos = new ArrayList<>();
        
        for (int dir = 0; dir <= 3; dir++){
            int dx = 1;
            int dy = 1;
            if(dir >= 2){
                dx = -1;
            }
            if (dir % 2 ==0){
                dy = -1;
            }
            for (int dist = 1; dist < IChess.BOARD_HEIGHT; dist++){
                nxtPos = new IChess.ChessPosition(pos.x + (dist*dx), pos.y + (dist*dy));
                if (nxtPos.x <= 7 && nxtPos.x >= 0 && nxtPos.y >= 0 && nxtPos.y <= 7) {
                    if (null != board.getPiece(nxtPos)){
                        if(board.getPiece(nxtPos).getColor() != board.getPiece(pos).getColor()){
                            listPossiblePos.add(nxtPos);
                        }
                        break;
                    }
                    else {
                        listPossiblePos.add(nxtPos);
                    }
                }
            }
        }
        return listPossiblePos;
    }
    /**
     * We set up the possibility to do a little Roque on both side.
     * @param board get all pieces and the board
     * @param pos get the position of the King
     * @return a boolean true/false if it's possible or no to do the little Roque.
     */
    public static boolean LilRoque(ChessBoard board, IChess.ChessPosition pos){
        IChess.ChessPosition rookPos = null;
        
        int i;
        
        if(board.getPiece(pos).getType() == IChess.ChessType.TYP_KING
           && board.getPiece(pos).getMoveCount() == 0){
            
            IChess.ChessPosition lilRoquePossible = new ChessPosition(7, pos.y);
        
            if(board.getPiece(lilRoquePossible) != null 
               && board.getPiece(lilRoquePossible).getType() == IChess.ChessType.TYP_ROOK
               && board.getPiece(lilRoquePossible).getColor() == board.getPiece(pos).getColor()
               && board.getPiece(lilRoquePossible).getMoveCount() == 0){
                
               for (i = pos.x + 1; i <= pos.x + 2; i++){
                   rookPos = new ChessPosition(i, pos.y);
                   
                   if(board.getPiece(rookPos) == null){
                       continue;
                   }
                   else{
                       return false;
                   }
               }
               
               if(i == 7){
                   return true;
               }
               
                
            }
                
        
        }
        
        
        return false;
    }
    /**
     * We set up the possibility to do a big Roque on both side.
     * @param board get all pieces and the board
     * @param pos get the position of the King
     * @return a boolean true/false if it's possible or no to do the Big Roque.
     */
    public static boolean BigRoque(ChessBoard board, IChess.ChessPosition pos){
        IChess.ChessPosition rookPos = null;
        
        int i;
        
        if(board.getPiece(pos).getType() == IChess.ChessType.TYP_KING
           && board.getPiece(pos).getMoveCount() == 0){
            
            IChess.ChessPosition lilRoquePossible = new ChessPosition(7, pos.y);
        
            if(board.getPiece(lilRoquePossible) != null 
               && board.getPiece(lilRoquePossible).getType() == IChess.ChessType.TYP_ROOK
               && board.getPiece(lilRoquePossible).getColor() == board.getPiece(pos).getColor()
               && board.getPiece(lilRoquePossible).getMoveCount() == 0){
                
               for (i = pos.x - 1; i > 0; i--){
                   rookPos = new ChessPosition(i, pos.y);
                   
                   if(board.getPiece(rookPos) == null){
                       continue;
                   }
                   else{
                       return false;
                   }
               }
               
               if(i == 0){
                   return true;
               }
               
                
            }
                
        
        }
        
        
        return false;
    }
    

}

