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
 * Set up available move for the Queen she take the best part of the Rook & the Bishop.
 * We call both possible list of movement and give it to the Queen.
 * @author DOOM GUYS.
 */
public class QueenMove implements IMove {
    /**
     * Same as the Rook & the Bishop, she take both of their movement.
     * @param pos Give the position of the Queen.
     * @param board Give the position of each pieces on the board.
     * @return The possible position for the Queen.
     */
    
    @Override
    public List<IChess.ChessPosition> getPossibleMove(IChess.ChessPosition pos, ChessBoard board) {

        List<IChess.ChessPosition> listPossiblePos = new ArrayList<>();
        
        //We call both List that we add to the movement of the Queen.
        
        listPossiblePos.addAll(UtilMove.DiagonalMove(pos, board));
        listPossiblePos.addAll(UtilMove.OrthogonalMove(pos, board));
        return listPossiblePos;
    }
}
