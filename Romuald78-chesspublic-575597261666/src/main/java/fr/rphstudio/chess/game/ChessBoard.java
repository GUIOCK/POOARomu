/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IChess.ChessColor;
import fr.rphstudio.chess.interf.IChess.ChessKingState;
import fr.rphstudio.chess.interf.IChess.ChessPosition;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guiockanthony
 */
public class ChessBoard {

    private Piece[][] board = new Piece[IChess.BOARD_HEIGHT][IChess.BOARD_WIDTH];
    private List<IChess.ChessType> blackP = new ArrayList<>();
    private List<IChess.ChessType> whiteP = new ArrayList<>();
    private List<BackToTheFuture> listBack = new ArrayList<>();
    private boolean isUndoDone = true;

    public ChessBoard() {

        /* We set the starting placement of all pawns on the board */
        //White Pawns's placement.
        for (int i = 0; i < IChess.BOARD_WIDTH; i++) {
            board[IChess.BOARD_POS_Y_WHITE_PAWNS][i]
                    = new Piece(IChess.ChessColor.CLR_WHITE,
                            IChess.ChessType.TYP_PAWN,
                            new PawnMove());
        }

        // White figure placement.
        board[IChess.BOARD_POS_Y_WHITE_PIECES][IChess.BOARD_POS_X_KING]
                = new Piece(IChess.ChessColor.CLR_WHITE,
                        IChess.ChessType.TYP_KING,
                        new KingMove());
        board[IChess.BOARD_POS_Y_WHITE_PIECES][IChess.BOARD_POS_X_QUEEN]
                = new Piece(IChess.ChessColor.CLR_WHITE,
                        IChess.ChessType.TYP_QUEEN,
                        new QueenMove());
        board[IChess.BOARD_POS_Y_WHITE_PIECES][IChess.BOARD_POS_X_KINGSIDE_BISHOP]
                = new Piece(IChess.ChessColor.CLR_WHITE,
                        IChess.ChessType.TYP_BISHOP,
                        new BishopMove());
        board[IChess.BOARD_POS_Y_WHITE_PIECES][IChess.BOARD_POS_X_QUEENSIDE_BISHOP]
                = new Piece(IChess.ChessColor.CLR_WHITE,
                        IChess.ChessType.TYP_BISHOP,
                        new BishopMove());
        board[IChess.BOARD_POS_Y_WHITE_PIECES][IChess.BOARD_POS_X_KINGSIDE_ROOK]
                = new Piece(IChess.ChessColor.CLR_WHITE,
                        IChess.ChessType.TYP_ROOK,
                        new RookMove());
        board[IChess.BOARD_POS_Y_WHITE_PIECES][IChess.BOARD_POS_X_QUEENSIDE_ROOK]
                = new Piece(IChess.ChessColor.CLR_WHITE,
                        IChess.ChessType.TYP_ROOK,
                        new RookMove());
        board[IChess.BOARD_POS_Y_WHITE_PIECES][IChess.BOARD_POS_X_KINGSIDE_KNIGHT]
                = new Piece(IChess.ChessColor.CLR_WHITE,
                        IChess.ChessType.TYP_KNIGHT,
                        new KnightMove());
        board[IChess.BOARD_POS_Y_WHITE_PIECES][IChess.BOARD_POS_X_QUEENSIDE_KNIGHT]
                = new Piece(IChess.ChessColor.CLR_WHITE,
                        IChess.ChessType.TYP_KNIGHT,
                        new KnightMove());

        // Black Pawns's placement.
        for (int i = 0; i < IChess.BOARD_WIDTH; i++) {
            board[IChess.BOARD_POS_Y_BLACK_PAWNS][i]
                    = new Piece(IChess.ChessColor.CLR_BLACK,
                            IChess.ChessType.TYP_PAWN,
                            new PawnMove());
        }

        // Black Figures placement.
        board[IChess.BOARD_POS_Y_BLACK_PIECES][IChess.BOARD_POS_X_KING]
                = new Piece(IChess.ChessColor.CLR_BLACK,
                        IChess.ChessType.TYP_KING,
                        new KingMove());
        board[IChess.BOARD_POS_Y_BLACK_PIECES][IChess.BOARD_POS_X_QUEEN]
                = new Piece(IChess.ChessColor.CLR_BLACK,
                        IChess.ChessType.TYP_QUEEN,
                        new QueenMove());
        board[IChess.BOARD_POS_Y_BLACK_PIECES][IChess.BOARD_POS_X_KINGSIDE_BISHOP]
                = new Piece(IChess.ChessColor.CLR_BLACK,
                        IChess.ChessType.TYP_BISHOP,
                        new BishopMove());
        board[IChess.BOARD_POS_Y_BLACK_PIECES][IChess.BOARD_POS_X_QUEENSIDE_BISHOP]
                = new Piece(IChess.ChessColor.CLR_BLACK,
                        IChess.ChessType.TYP_BISHOP,
                        new BishopMove());
        board[IChess.BOARD_POS_Y_BLACK_PIECES][IChess.BOARD_POS_X_KINGSIDE_ROOK]
                = new Piece(IChess.ChessColor.CLR_BLACK,
                        IChess.ChessType.TYP_ROOK,
                        new RookMove());
        board[IChess.BOARD_POS_Y_BLACK_PIECES][IChess.BOARD_POS_X_QUEENSIDE_ROOK]
                = new Piece(IChess.ChessColor.CLR_BLACK,
                        IChess.ChessType.TYP_ROOK,
                        new RookMove());
        board[IChess.BOARD_POS_Y_BLACK_PIECES][IChess.BOARD_POS_X_KINGSIDE_KNIGHT]
                = new Piece(IChess.ChessColor.CLR_BLACK,
                        IChess.ChessType.TYP_KNIGHT,
                        new KnightMove());
        board[IChess.BOARD_POS_Y_BLACK_PIECES][IChess.BOARD_POS_X_QUEENSIDE_KNIGHT]
                = new Piece(IChess.ChessColor.CLR_BLACK,
                        IChess.ChessType.TYP_KNIGHT,
                        new KnightMove());
    }

    public Piece getPiece(IChess.ChessPosition pos) {
        if (pos.x <= 7 && pos.x >= 0 && pos.y <= 7 && pos.y >= 0) {
            return this.board[pos.y][pos.x];
        } else {
            return null;
        }

    }

    public int getNbRemainingPieces(ChessColor color) {

        //Initialize a counter for the Pieces left on the board.
        int nbPiecesLeft = 0;

        // We parcour the board and check if there's colors.
        for (int i = 0; i < IChess.BOARD_HEIGHT; i++) {
            for (int j = 0; j < IChess.BOARD_WIDTH; j++) {

                if (board[i][j] != null) {

                    if (board[i][j].getColor() == color) {
                        nbPiecesLeft++;
                    }

                }
            }
        }

        return nbPiecesLeft;
    }

    public List<IChess.ChessType> getRemovedPieces(ChessColor color) {
        if (color == IChess.ChessColor.CLR_WHITE) {
            return whiteP;
        } else {
            return blackP;
        }
    }

    public void movePiece(ChessPosition pFirst, ChessPosition pFinal) {
        isUndoDone = false;
        this.getPiece(pFirst).incMoveCount();
        BackToTheFuture getBack = new BackToTheFuture(pFirst, 
                this.getPiece(pFirst), 
                pFinal, 
                this.getPiece(pFinal) != null ? this.getPiece(pFinal) : null);
        listBack.add(getBack);
        if (null != board[pFinal.y][pFinal.x]) {
            if (board[pFinal.y][pFinal.x].getColor() == IChess.ChessColor.CLR_WHITE) {
                whiteP.add(board[pFinal.y][pFinal.x].getType());
            } else if (board[pFinal.y][pFinal.x].getColor() == IChess.ChessColor.CLR_BLACK) {
                blackP.add(board[pFinal.y][pFinal.x].getType());
            }
        }

        board[pFinal.y][pFinal.x] = board[pFirst.y][pFirst.x];
        if (board[pFirst.y][pFirst.x].getType() == IChess.ChessType.TYP_PAWN) {
            if (pFinal.y == 7 || pFinal.y == 0) {
                board[pFinal.y][pFinal.x] = new Piece(board[pFirst.y][pFirst.x].getColor(),
                        IChess.ChessType.TYP_QUEEN,
                        new QueenMove());
            }
        }
        board[pFirst.y][pFirst.x] = null;

    }

    public ChessKingState getKingState(ChessColor color) {

        ChessPosition kingPos = null;
        ChessPosition pos;

        for (int i = 0; i < IChess.BOARD_HEIGHT; i++) {
            for (int j = 0; j < IChess.BOARD_WIDTH; j++) {

                pos = new ChessPosition(j, i);
                if (getPiece(pos) != null) {
                    if (getPiece(pos).getColor() == color && getPiece(pos).getType() == IChess.ChessType.TYP_KING) {
                        kingPos = pos;
                        break;
                    }
                }

            }
            if (kingPos != null) {
                break;
            }
        }

        List<ChessPosition> listPos = new ArrayList<>();

        for (int i = 0; i < IChess.BOARD_HEIGHT; i++) {
            for (int j = 0; j < IChess.BOARD_WIDTH; j++) {
                pos = new ChessPosition(j, i);

                if (getPiece(pos) != null) {

                    listPos = getPiece(pos).getMoves(pos, this);

                    for (ChessPosition possiblePos : listPos) {
                        if (possiblePos.equals(kingPos)) {
                            return ChessKingState.KING_THREATEN;
                        }
                    }

                }

                //End 2nd for
            }

            // End first for
        }

        return ChessKingState.KING_SAFE;
        //Here return
    }

    public ChessBoard clone() {
        ChessBoard cloB = new ChessBoard();
        for (int i = 0; i < IChess.BOARD_HEIGHT; i++) {
            for (int j = 0; j < IChess.BOARD_WIDTH; j++) {
                cloB.board[i][j] = null;
                if (null != this.board[i][j]) {
                    cloB.board[i][j] = this.board[i][j].clone();
                }
            }
        }
        return cloB;
    }
    
    public boolean undoLastMove(){
        if (!isUndoDone){
           BackToTheFuture getBack = listBack.get(listBack.size()-1); 
           this.setPiece(getBack.getP0(), getBack.getCp0());
           this.setPiece(getBack.getP1(), getBack.getCp1());
           getBack.getP0().decMoveCount();
           listBack.remove(getBack);
           isUndoDone = true;
        }else{
            return false;
        }
        
        return isUndoDone;
    }
    
    public void setPiece(Piece p, ChessPosition cp){
        this.board[cp.y][cp.x] = p;
    }
}
