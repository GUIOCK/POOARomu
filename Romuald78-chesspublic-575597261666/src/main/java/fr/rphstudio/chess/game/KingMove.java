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
        
        IChess.ChessPosition newPos;
        IChess.ChessPosition lilRoque;
        IChess.ChessPosition bigRoque;
        
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                possiblePos = new IChess.ChessPosition(i + pos.x, j + pos.y);
                if (possiblePos.x >= 0 && possiblePos.y >= 0
                        && possiblePos.x < IChess.BOARD_WIDTH && possiblePos.y < IChess.BOARD_HEIGHT) {
                    if (null != board.getPiece(possiblePos)) {
                        if (board.getPiece(possiblePos).getColor() != board.getPiece(pos).getColor()) {
                            ListPossiblePos.add(possiblePos);
                        }
                    } else {
                        ListPossiblePos.add(possiblePos);
                    }
                }
            }
        }
        
        if(UtilMove.LilRoque(board, pos)){
            lilRoque = new IChess.ChessPosition(pos.x + 3,pos.y);
            ListPossiblePos.add(lilRoque);
        }
        
        if (UtilMove.BigRoque(board, pos)){
            bigRoque = new IChess.ChessPosition(pos.x - 4,pos.y);
            ListPossiblePos.add(bigRoque);
        }
        
        
        return ListPossiblePos;
    }
    
    
}
