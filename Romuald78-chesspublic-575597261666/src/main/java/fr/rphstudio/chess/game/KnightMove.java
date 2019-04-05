/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IChess.ChessColor;
import fr.rphstudio.chess.interf.IChess.ChessPosition;
import fr.rphstudio.chess.interf.IMove;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DOOM GUYS.
 */
public class KnightMove implements IMove {

    /**
     * The base for our movement, the Knight can jump pieces, and moves in a maximum of 8 directions.
     * @param pos the position of the Knight chosen by the player.
     * @param board the position of each pieces left on the board.
     * @return 
     */
    
    @Override
    public List<IChess.ChessPosition> getPossibleMove(IChess.ChessPosition pos, ChessBoard board) {

        IChess.ChessPosition possiblePos;
        List<IChess.ChessPosition> ListPossiblePos = new ArrayList<ChessPosition>();

        for (int i = 0; i < IChess.BOARD_HEIGHT; i++) {
            for (int j = 0; j < IChess.BOARD_WIDTH; j++) {
                
                
                if (Math.abs((i - pos.x)) + Math.abs((j - pos.y)) == 3) {

                    if (i - pos.x != 0 && j - pos.y != 0) {
                        possiblePos = new ChessPosition(i, j);
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
        }
        return ListPossiblePos;
    }
}
