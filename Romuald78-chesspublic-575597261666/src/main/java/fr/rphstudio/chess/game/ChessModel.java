/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.EmptyCellException;
import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.OutOfBoardException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DOOM GUYS.
 */
public class ChessModel implements IChess {

    private static ChessModel INSTANCE;

    // We create a new Object ChessBoard to set the place of all pawns.
    private ChessBoard chessboard;

    private ChessModel() {

    }
    
    /**
     * This methos allow us to get the instance of the ChessModel
     * @return the ChessModel
     */
    public static ChessModel getInstance() {
        if (ChessModel.INSTANCE == null) {
            ChessModel.INSTANCE = new ChessModel();

        }
        return ChessModel.INSTANCE;
    }
    /**
     * This method create a new ChessBoard to start a new game
     */
    @Override
    public void reinit() {
        this.chessboard = new ChessBoard();
    }
    /**
     * This method allows us to get the type of a piece from a given position
     * @param p is a position from which we can get a specific piece
     * @return a ChessType
     * @throws EmptyCellException if the cell we are pointing with the position is empty
     * @throws OutOfBoardException if the cell we are poiting is out of the Array we are looking in
     */
    @Override
    public ChessType getPieceType(ChessPosition p) throws EmptyCellException, OutOfBoardException {

        // Checking if pieces are out of bound or not there.
        if (p.x > IChess.BOARD_WIDTH || p.y > IChess.BOARD_HEIGHT) {
            throw new OutOfBoardException();
        } else if (chessboard.getPiece(p) == null) {
            throw new EmptyCellException();
        } else {
            return chessboard.getPiece(p).getType();
        }
    }
    /**
     * This method allows us to get the color of a piece from a given position
     * @param p is a position from which we can get a specific piece
     * @return a ChessColor
     * @throws EmptyCellException if the cell we are pointing with the position is empty
     * @throws OutOfBoardException if the cell we are poiting is out of the Array we are looking in
     */
    @Override
    public ChessColor getPieceColor(ChessPosition p) throws EmptyCellException, OutOfBoardException {
        if (p.x > IChess.BOARD_WIDTH || p.y > IChess.BOARD_HEIGHT) {
            throw new OutOfBoardException();
        } else if (chessboard.getPiece(p) == null) {
            throw new EmptyCellException();
        } else {
            return chessboard.getPiece(p).getColor();
        }
    }
    /**
     * This method call the method that allows us to know all the remaining pieces 
     * for each team
     * @param color is to get the colors of the player
     * @return the number (an Integer) of pieces remaining
     */
    @Override
    public int getNbRemainingPieces(ChessColor color) {
        return chessboard.getNbRemainingPieces(color);
    }
    /**
    * This method allows us to get  all the possible moves of a piece
    * @param cp is a posiiton that allows us to get the reference of a piece
    * @return a list containing all the possible moves of a piece
    */
    @Override
    public List<ChessPosition> getPieceMoves(ChessPosition cp) {
        List<ChessPosition> listPiece = new ArrayList<>();
        List<ChessPosition> listOut = new ArrayList<>();
        Piece piece = chessboard.getPiece(cp);
        if (null != piece) {
            listPiece = piece.getMoves(cp, chessboard);
        }
        IChess.ChessColor selfColor = chessboard.getPiece(cp).getColor();
        if (listPiece != null) {
            for (ChessPosition possiblePos : listPiece) {
                ChessBoard cloB = chessboard.clone();
                cloB.movePiece(cp, possiblePos);
                if (cloB.getKingState(selfColor) != IChess.ChessKingState.KING_THREATEN) {
                    //listPiece.remove(possiblePos);
                    listOut.add(possiblePos);
                }

            }
        }
        return listOut;
    }
    /**
    * This method moves a piece from position 0 to position 1
    * @param p0 the start position, where the piece begins the movement
    * @param p1 the final position, where the piece arrives
    */
    @Override
    public void movePiece(ChessPosition p0, ChessPosition p1) {
        chessboard.movePiece(p0, p1);

    }
    /**
     * This method allows us to get the state (safe, threaten...) of a king
     * @param color is to determinate whoch king we want to check the state
     * @return a KingState
     */
    @Override
    public ChessKingState getKingState(ChessColor color) {
        return chessboard.getKingState(color);
    }
    /**
     * This method allows us to get all the removed pieces and diplay them on the screen 
     * @param color is the color of the player
     * @return a list of types of removed pieces 
     */
    @Override
    public List<ChessType> getRemovedPieces(ChessColor color) {
        return chessboard.getRemovedPieces(color);
    }
    /**
     * This method undo the last move
     * @return a boolean to know if it as been done or not
     */
    @Override
    public boolean undoLastMove() {
        return chessboard.undoLastMove();
    }
    /**
     * This method displays a timer that represents the time played by each player
     * @param color to detect which timer is increased (white or black)
     * @param isPlaying to detect which player is playing
     * @return a long that represent a timer in milliseconds
     */
    @Override
    public long getPlayerDuration(ChessColor color, boolean isPlaying) {
        return chessboard.getPlayerDuration(color, isPlaying);
    }

}
