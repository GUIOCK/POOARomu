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
 * @author guiockanthony
 */
public class UtilMove {
    
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
            for (int dist = 1; dist < IChess.BOARD_HEIGHT; dist++){   //
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
}
