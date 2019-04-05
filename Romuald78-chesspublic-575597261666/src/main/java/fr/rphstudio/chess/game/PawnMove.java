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
 * @author DOOM GUYS.
 */
public class PawnMove implements IMove {
/**
 * This function allows the mouvement for the pawn like eat in diagonal forward one square in front him , can move to the square directly in front if the case is clear and for it's first moovement he can move to two squares  
 * @param pos acutal conrdinate for eacch pawn on (x,y)
 * @param board the board with every Chess piece 
 * @return all possible movements  for the pawn
 */
    @Override
    public List<IChess.ChessPosition> getPossibleMove(IChess.ChessPosition pos, ChessBoard board) {

        IChess.ChessPosition possiblePos;
        List<IChess.ChessPosition> ListPossiblePos = new ArrayList<>();
        IChess.ChessPosition eatPos;

        //Choose the pawn color (white)
        if (board.getPiece(pos).getColor() == IChess.ChessColor.CLR_WHITE) {
            if (board.getPiece(pos).getMoveCount() == 0) {
                possiblePos = new IChess.ChessPosition(pos.x, pos.y - 2);
                if (possiblePos.x <= 7 && possiblePos.x >= 0 && possiblePos.y >= 0 && possiblePos.y <= 7) {
                    if (board.getPiece(possiblePos) == null && board.getPiece(new IChess.ChessPosition(pos.x, pos.y - 1)) == null) {
                        ListPossiblePos.add(possiblePos);
                    }
                }
            }
            possiblePos = new IChess.ChessPosition(pos.x, pos.y - 1);
            if (possiblePos.x <= 7 && possiblePos.x >= 0 && possiblePos.y >= 0 && possiblePos.y <= 7) {
                if (board.getPiece(possiblePos) == null) {
                    ListPossiblePos.add(possiblePos);
                }
                for (int i = -1; i < 2; i += 2) {
                    eatPos = new IChess.ChessPosition(pos.x + i, pos.y - 1);
                    if (board.getPiece(eatPos) != null) {
                        if (!board.getPiece(eatPos).getColor().equals(board.getPiece(pos).getColor())) {
                            ListPossiblePos.add(eatPos);
                        }
                    }
                }
            }
        } //Choose the pawn color (black)
        else {
            //The pawn movement , we say if he never move he can move 2 "y" or 1 "y"
            if (board.getPiece(pos).getMoveCount() == 0) {
                possiblePos = new IChess.ChessPosition(pos.x, pos.y + 2);
                if (possiblePos.x <= 7 && possiblePos.x >= 0 && possiblePos.y >= 0 && possiblePos.y <= 7) {
                    if (board.getPiece(possiblePos) == null && board.getPiece(new IChess.ChessPosition(pos.x, pos.y + 1)) == null) {
                        ListPossiblePos.add(possiblePos);
                    }
                }
            }
            //Can only move 1 "y"
            possiblePos = new IChess.ChessPosition(pos.x, pos.y + 1);
            if (possiblePos.x <= 7 && possiblePos.x >= 0 && possiblePos.y >= 0 && possiblePos.y <= 7) {
                //Can't move if the case in front him are null 
                if (board.getPiece(possiblePos) == null) {
                    ListPossiblePos.add(possiblePos);
                }
                // Eat only in diagonal if a enemy are here
                for (int i = -1; i < 2; i += 2) {
                    eatPos = new IChess.ChessPosition(pos.x + i, pos.y + 1);
                    if (board.getPiece(eatPos) != null) {
                        if (!board.getPiece(eatPos).getColor().equals(board.getPiece(pos).getColor())) {
                            ListPossiblePos.add(eatPos);
                        }
                    }
                }
            }
        }

        return ListPossiblePos;
    }

}
