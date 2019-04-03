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
public class BishopMove implements IMove{
    @Override
    public List<IChess.ChessPosition> getPossibleMove(IChess.ChessPosition pos, ChessBoard board) {
        
        IChess.ChessPosition possiblePos;
        List<IChess.ChessPosition> listPossiblePos = new ArrayList<IChess.ChessPosition>();

        for (int dir = 0; dir <= 3; dir++){
            int dx = 1;
            int dy = 1;
            if(dir >= 2){
                dx = -1;
            }
            if (dir % 2 ==0){
                dy = -1;
            }
            for (int dist = 1; dist <= 7; dist++){
                IChess.ChessPosition nxtPos = new IChess.ChessPosition(pos.x + (dist*dx), pos.y + (dist*dy));
                if (nxtPos.x <=7 && nxtPos.x >=0 && nxtPos.y >=0 && nxtPos.y <=7){ 
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