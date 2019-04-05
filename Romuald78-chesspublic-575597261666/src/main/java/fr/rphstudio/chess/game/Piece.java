/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IChess.ChessColor;
import fr.rphstudio.chess.interf.IChess.ChessType;
import fr.rphstudio.chess.interf.IMove;
import java.util.List;
import java.util.ArrayList;

/**
 * The main class to set up our pieces.
 * @author DOOM GUYS.
 */
public class Piece {

    private ChessColor color;
    private ChessType type;
    private IMove move;
    private int moveCount = 0;

    /**
     * The constructor of our Piece, takes 3 settable parameter, we set each piece on our board in ChessBoard.
     * @param color set the color of the piece.
     * @param type set the type of the piece.
     * @param move set the move type of the piece.
     */
    public Piece(ChessColor color, ChessType type, IMove move) {
        this.color = color;
        this.type = type;
        this.move = move;
    }

    /**
     * getter for the color of the piece. 
     * @return the color of the piece.
     */
    
    public ChessColor getColor() {
        return this.color;
    }
    
    /**
     * getter for the type of the piece. 
     * @return the type of the piece.
     */
    
    public ChessType getType() {
        return this.type;
    }

    /**
     * Get the list of possibles moves for each pieces.
     * @param pos the position of the piece.
     * @param board the position of the other pieces on the board.
     * @return A list of movement possible for the piece that we are interested in.
     */
    public List<IChess.ChessPosition> getMoves(IChess.ChessPosition pos, ChessBoard board) {
        return move.getPossibleMove(pos, board);
    }

    /**
     * get the move count that we set up earlier before the constructor, each piece has a counter on its own.
     * @return the movecount of the piece.
     */
    public int getMoveCount() {
        return moveCount;
    }

    /**
     * Increment the Move count, when the piece do a move, it goes up.
     */
    public void incMoveCount() {
        this.moveCount++;
    }
    
    /**
     * Decrement the Move count, when the piece undo a move, it goes down.
     */
    public void decMoveCount() {
        this.moveCount--;
    }
    
    /**
     * setter for the move count. Use to change the and access the move count in the clones.
     * @param moveCount give access to the move count even outside the class.
     */
    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }
    /**
     * Clone the piece P and set it up in the "futur" for it being tested,
     * made to avoid moving a piece and putting our own king in check.
     * @return the new object Piece p.
     */
    public Piece clone() {
        Piece p = new Piece(this.color, this.type, this.move);
        p.setMoveCount(this.moveCount);
        return p;
    }

}
