/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IChess.ChessColor;

/**
 *
 * @author guiockanthony
 */
public class ChessBoard{
    
    private Piece[][] board = new Piece[IChess.BOARD_HEIGHT][IChess.BOARD_WIDTH];
    
    public ChessBoard(){
       
        /* We set the starting placement of all pawns on the board */
        
        //White Pawns's placement.
        for (int i = 0; i < IChess.BOARD_WIDTH; i++){
            board[IChess.BOARD_POS_Y_WHITE_PAWNS][i] = 
                    new Piece(IChess.ChessColor.CLR_WHITE, 
                            IChess.ChessType.TYP_PAWN);
        }
        
        
        // White figure placement.
        board[IChess.BOARD_POS_Y_WHITE_PIECES][IChess.BOARD_POS_X_KING]=
                new Piece(IChess.ChessColor.CLR_WHITE, 
                        IChess.ChessType.TYP_KING);
        board[IChess.BOARD_POS_Y_WHITE_PIECES][IChess.BOARD_POS_X_QUEEN]=
                new Piece(IChess.ChessColor.CLR_WHITE, 
                        IChess.ChessType.TYP_QUEEN);
        board[IChess.BOARD_POS_Y_WHITE_PIECES][IChess.BOARD_POS_X_KINGSIDE_BISHOP]=
                new Piece(IChess.ChessColor.CLR_WHITE, 
                        IChess.ChessType.TYP_BISHOP);
        board[IChess.BOARD_POS_Y_WHITE_PIECES][IChess.BOARD_POS_X_QUEENSIDE_BISHOP]=
                new Piece(IChess.ChessColor.CLR_WHITE, 
                        IChess.ChessType.TYP_BISHOP);
        board[IChess.BOARD_POS_Y_WHITE_PIECES][IChess.BOARD_POS_X_KINGSIDE_ROOK]=
                new Piece(IChess.ChessColor.CLR_WHITE, 
                        IChess.ChessType.TYP_ROOK);
        board[IChess.BOARD_POS_Y_WHITE_PIECES][IChess.BOARD_POS_X_QUEENSIDE_ROOK]=
                new Piece(IChess.ChessColor.CLR_WHITE, 
                        IChess.ChessType.TYP_ROOK);
        board[IChess.BOARD_POS_Y_WHITE_PIECES][IChess.BOARD_POS_X_KINGSIDE_KNIGHT]=
                new Piece(IChess.ChessColor.CLR_WHITE, 
                        IChess.ChessType.TYP_KNIGHT);
        board[IChess.BOARD_POS_Y_WHITE_PIECES][IChess.BOARD_POS_X_QUEENSIDE_KNIGHT]=
                new Piece(IChess.ChessColor.CLR_WHITE, 
                        IChess.ChessType.TYP_KNIGHT);
        
        // Black Pawns's placement.
        for (int i = 0; i < IChess.BOARD_WIDTH; i++){
            board[IChess.BOARD_POS_Y_BLACK_PAWNS][i] = 
                    new Piece(IChess.ChessColor.CLR_BLACK, 
                            IChess.ChessType.TYP_PAWN); 
        }
        
        // Black Figures placement.
        board[IChess.BOARD_POS_Y_BLACK_PIECES][IChess.BOARD_POS_X_KING]=
                new Piece(IChess.ChessColor.CLR_BLACK, 
                        IChess.ChessType.TYP_KING);
        board[IChess.BOARD_POS_Y_BLACK_PIECES][IChess.BOARD_POS_X_QUEEN]=
                new Piece(IChess.ChessColor.CLR_BLACK, 
                        IChess.ChessType.TYP_QUEEN);
        board[IChess.BOARD_POS_Y_BLACK_PIECES][IChess.BOARD_POS_X_KINGSIDE_BISHOP]=
                new Piece(IChess.ChessColor.CLR_BLACK, 
                        IChess.ChessType.TYP_BISHOP);
        board[IChess.BOARD_POS_Y_BLACK_PIECES][IChess.BOARD_POS_X_QUEENSIDE_BISHOP]=
                new Piece(IChess.ChessColor.CLR_BLACK, 
                        IChess.ChessType.TYP_BISHOP);
        board[IChess.BOARD_POS_Y_BLACK_PIECES][IChess.BOARD_POS_X_KINGSIDE_ROOK]=
                new Piece(IChess.ChessColor.CLR_BLACK, 
                        IChess.ChessType.TYP_ROOK);
        board[IChess.BOARD_POS_Y_BLACK_PIECES][IChess.BOARD_POS_X_QUEENSIDE_ROOK]=
                new Piece(IChess.ChessColor.CLR_BLACK, 
                        IChess.ChessType.TYP_ROOK);
        board[IChess.BOARD_POS_Y_BLACK_PIECES][IChess.BOARD_POS_X_KINGSIDE_KNIGHT]=
                new Piece(IChess.ChessColor.CLR_BLACK, 
                        IChess.ChessType.TYP_KNIGHT);
        board[IChess.BOARD_POS_Y_BLACK_PIECES][IChess.BOARD_POS_X_QUEENSIDE_KNIGHT]=
                new Piece(IChess.ChessColor.CLR_BLACK, 
                        IChess.ChessType.TYP_KNIGHT);
    }
    
    
    public Piece getBoard(IChess.ChessPosition pos){
        
        return this.board[pos.y][pos.x];
        
    }
    
    public int getNbRemainingPieces(ChessColor color){
        
        //Initialize a counter for the Pieces left on the board.
        int nbPiecesLeft= 0; 
        
        // We parcour the board and check if there's colors.
        for (int i = 0; i < IChess.BOARD_HEIGHT; i++){
            for (int j = 0; j < IChess.BOARD_WIDTH; j++){
                
                if (board[i][j] != null){
                    
                    if(board[i][j].getColor() == color){
                        nbPiecesLeft++;
                    }
                    
                }
            } 
        }
        
        return nbPiecesLeft;
    }
    
}
