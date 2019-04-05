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
 * Manage every movement for Rooks in the game
 * @author DOOM GUYS.
 */
public class RookMove implements IMove {
/**
 * This function call the method which allows set the orthogonal movement and apply it
 * @param pos acutal conrdinate for eacch pawn on (x,y)
 * @param board the board with every Chess piece 
 * @return all the Orthogonals movements until the last block who the piece blocks him
 */
    
    @Override
    public List<IChess.ChessPosition> getPossibleMove(IChess.ChessPosition pos, ChessBoard board) {

        return UtilMove.OrthogonalMove(pos, board);

    }
}
