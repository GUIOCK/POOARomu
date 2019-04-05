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
 * BishopMove manage the possible move of every Bishop in the game.
 * @author DOOM GUYS.
 */
public class BishopMove implements IMove {

    /**
     * This function call the method which allows set the Diagonal movement and apply it
     * @param pos 
     * @param board
     * @return 
     */
    @Override
    public List<IChess.ChessPosition> getPossibleMove(IChess.ChessPosition pos, ChessBoard board) {
        return UtilMove.DiagonalMove(pos, board);
    }
}
