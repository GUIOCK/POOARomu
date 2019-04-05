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

    public static ChessModel getInstance() {
        if (ChessModel.INSTANCE == null) {
            ChessModel.INSTANCE = new ChessModel();

        }
        return ChessModel.INSTANCE;
    }

    @Override
    public void reinit() {
        this.chessboard = new ChessBoard();
    }

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

    @Override
    public int getNbRemainingPieces(ChessColor color) {
        return chessboard.getNbRemainingPieces(color);
    }

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

    @Override
    public void movePiece(ChessPosition p0, ChessPosition p1) {
        chessboard.movePiece(p0, p1);

    }

    @Override
    public ChessKingState getKingState(ChessColor color) {
        return chessboard.getKingState(color);
    }

    @Override
    public List<ChessType> getRemovedPieces(ChessColor color) {
        return chessboard.getRemovedPieces(color);
    }

    @Override
    public boolean undoLastMove() {
        return chessboard.undoLastMove();
    }

    @Override
    public long getPlayerDuration(ChessColor color, boolean isPlaying) {
        return chessboard.getPlayerDuration(color, isPlaying);
    }

}
