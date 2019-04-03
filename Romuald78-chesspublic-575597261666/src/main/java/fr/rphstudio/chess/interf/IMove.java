/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.interf;

import fr.rphstudio.chess.game.ChessBoard;
import java.util.List;

/**
 *
 * @author guiockanthony
 */
public interface IMove {

    /**
     *
     * @param pos
     * @param board
     * @return
     */
    public List<IChess.ChessPosition> getPossibleMove(IChess.ChessPosition pos, ChessBoard board);
}
