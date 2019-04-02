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
 * @author azz-kevinf
 */
public class ChessModel implements IChess{
    
    private static ChessModel INSTANCE;

    // We create a new Object ChessBoard to set the place of all pawns.
    
    private ChessBoard chessboard;
    
    private ChessModel(){
        
    }
    
    public static ChessModel getInstance(){
        if(ChessModel.INSTANCE == null){
            ChessModel.INSTANCE = new ChessModel();
            
        }
        return ChessModel.INSTANCE;
    }

    @Override
    public void reinit() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       this.chessboard = new ChessBoard();
    }

    @Override
    public ChessType getPieceType(ChessPosition p) throws EmptyCellException, OutOfBoardException {
        

        // Checking if pieces are out of bound or not there.
        
        
        if (p.x > IChess.BOARD_WIDTH || p.y > IChess.BOARD_HEIGHT){
            throw new OutOfBoardException();
        }
        else if (chessboard.getPiece(p) == null) {
            throw new EmptyCellException();
        }
        else{
            return chessboard.getPiece(p).getType();
        } 
    }

    @Override
    public ChessColor getPieceColor(ChessPosition p) throws EmptyCellException, OutOfBoardException {
         if (p.x > IChess.BOARD_WIDTH || p.y > IChess.BOARD_HEIGHT){
            throw new OutOfBoardException();
        }
        else if (chessboard.getPiece(p) == null) {
            throw new EmptyCellException();
        }
        else{
            return chessboard.getPiece(p).getColor();
        } 
    }

    @Override
    public int getNbRemainingPieces(ChessColor color) {
        return chessboard.getNbRemainingPieces(color);
    }

    @Override
    public List<ChessPosition> getPieceMoves(ChessPosition p) {
        List<ChessPosition> listPiece = new ArrayList<ChessPosition>();
        Piece piece = chessboard.getPiece(p);
        if (null != piece){
            listPiece = piece.getMoves(p, chessboard);
        }
        return listPiece;   
    }

    @Override
    public void movePiece(ChessPosition p0, ChessPosition p1) {
        chessboard.movePiece(p0, p1);
   }

    @Override
    public ChessKingState getKingState(ChessColor color) {
        return ChessKingState.KING_SAFE;
    }

    @Override
    public List<ChessType> getRemovedPieces(ChessColor color) {
        return new ArrayList<>();
    }

    @Override
    public boolean undoLastMove() {
        return true;
    }

    @Override
    public long getPlayerDuration(ChessColor color, boolean isPlaying) {
        return 50000;
    }

}