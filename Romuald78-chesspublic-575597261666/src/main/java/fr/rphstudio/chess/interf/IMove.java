/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.interf;

import fr.rphstudio.chess.game.ChessBoard;
import java.util.List;

/**
 * This interface allow us to create different pattern of move with different classe that implement IMove
 * @author @author DOOM GUYS.
 */
public interface IMove {

    /**
     * This method allows us to get all the possible moves from a given piece
     * (We can get that piece from the board and the position parameters)
     * @param pos is an object ChessPosition, allow us to get a specific piece from it
     * @param board is an object ChessBoard, allow us to interact and get all the information from the board
     * @return
     */
    public List<IChess.ChessPosition> getPossibleMove(IChess.ChessPosition pos, ChessBoard board);
}
