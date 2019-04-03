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
public class QueenMove implements IMove {
    @Override
    public List<IChess.ChessPosition> getPossibleMove(IChess.ChessPosition pos, ChessBoard board) {
        
        List<IChess.ChessPosition> listPossiblePos = new ArrayList<>();
    
        listPossiblePos.addAll(UtilMove.DiagonalMove(pos, board));
        listPossiblePos.addAll(UtilMove.OrthogonalMove(pos, board));
        return listPossiblePos;
    }
}
