package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IChess.ChessColor;
import fr.rphstudio.chess.interf.IChess.ChessKingState;
import fr.rphstudio.chess.interf.IChess.ChessPosition;
import java.util.ArrayList;
import java.util.List;

/**
 *A class that regroup all informations and method for the chessboard and pieces positions
 * @author doomTeam
 */
public class ChessBoard {
    
    private Piece[][] board = new Piece[IChess.BOARD_HEIGHT][IChess.BOARD_WIDTH];
    private List<IChess.ChessType> blackP = new ArrayList<>();
    private List<IChess.ChessType> whiteP = new ArrayList<>();
    private List<BackToTheFuture> listBack = new ArrayList<>();
    private boolean isUndoDone = false;
    private long timerBlack = 0;
    private long timerWhite = 0;
    private long startTime = 0;
    
    /**
     *
     */
    public ChessBoard() {
        
        /**
         *
         */
        startTime = System.currentTimeMillis();
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
    
    /**
     *
     * @param pos the position of the piece that will be returned
     * @return the piece object that is located in the cell, or null if no piece was found
     */
    public Piece getPiece(IChess.ChessPosition pos) {
        if (pos.x <= 7 && pos.x >= 0 && pos.y <= 7 && pos.y >= 0) {
            return this.board[pos.y][pos.x];
        } else {
            return null;
        }
        
    }
    
    /**
     *
     * @param color the color (Black or White) of the pieces we want to count
     * @return the number of pieces left in the board of the specified color
     */
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
    
    /**
     *
     * @param color the color (Black or White) of the pieces we want to get
     * @return a list which contain all removed pieces of the specified color
     */
    public List<IChess.ChessType> getRemovedPieces(ChessColor color) {
        if (color == IChess.ChessColor.CLR_WHITE) {
            return whiteP;
        } else {
            return blackP;
        }
    }
    
    /**
     *This method take a piece on the board, and put it in another position, possibly erase
     * an existing piece if one is already present in the pFinal position
     *
     * @param pFirst the position of the piece we want to move
     * @param pFinal the position were we want to move the piece located in the position pFirst
     */
    public void movePiece(ChessPosition pFirst, ChessPosition pFinal) {
        long currentTime = System.currentTimeMillis() - startTime;
        
        this.getPiece(pFirst).incMoveCount();
        BackToTheFuture getBack = new BackToTheFuture(pFirst,
                this.getPiece(pFirst),
                pFinal,
                this.getPiece(pFinal),
                currentTime);
        if (this.getPiece(pFirst).getColor() == IChess.ChessColor.CLR_BLACK) {
            timerBlack += currentTime;
        } else if (this.getPiece(pFirst).getColor() == IChess.ChessColor.CLR_WHITE){
            timerWhite += currentTime;
        }
        startTime = System.currentTimeMillis();
        listBack.add(getBack);
        if (null != board[pFinal.y][pFinal.x] 
                && board[pFirst.y][pFirst.x].getColor() != board[pFinal.y][pFinal.x].getColor()) {
            if (board[pFinal.y][pFinal.x].getColor() == IChess.ChessColor.CLR_WHITE) {
                whiteP.add(board[pFinal.y][pFinal.x].getType());
            } else if (board[pFinal.y][pFinal.x].getColor() == IChess.ChessColor.CLR_BLACK) {
                blackP.add(board[pFinal.y][pFinal.x].getType());
            }
        }
        
        
        if(board[pFirst.y][pFirst.x] != null
                && board[pFinal.y][pFinal.x] != null
                && board[pFirst.y][pFirst.x].getColor() == board[pFinal.y][pFinal.x].getColor()
                && board[pFirst.y][pFirst.x].getType() == IChess.ChessType.TYP_KING
                && board[pFinal.y][pFinal.x].getType() == IChess.ChessType.TYP_ROOK) {
            
            
            
            
            
            
            if(pFinal.x > pFirst.x){
                board[pFinal.y][pFinal.x - 2] = board[pFinal.y][pFinal.x];
                board[pFinal.y][pFinal.x - 1] = board[pFirst.y][pFirst.x];
                
                board[pFirst.y][pFirst.x] = null;
                board[pFinal.y][pFinal.x] = null;
                
            }
            else if(pFinal.x < pFirst.x){
                
                board[pFinal.y][pFinal.x + 3] = board[pFinal.y][pFinal.x];
                board[pFinal.y][pFinal.x + 2] = board[pFirst.y][pFirst.x];
                
                board[pFirst.y][pFirst.x] = null;
                board[pFinal.y][pFinal.x] = null;
            }
            
        }
        
        else {
            
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
        
    }
    
    /**
     *
     * @param color
     * @return
     */
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
    
    /**
     *
     * @return
     */
    public boolean undoLastMove() {
        if (listBack.size() > 0) {
            BackToTheFuture getBack = listBack.get(listBack.size() - 1);
            this.setPiece(getBack.getP0(), getBack.getCp0());
            this.setPiece(getBack.getP1(), getBack.getCp1());
            getBack.getP0().decMoveCount();
            if (getBack.getP0().getColor() == IChess.ChessColor.CLR_BLACK) {
                timerBlack -= getBack.getTimer();
            } else if (getBack.getP0().getColor() == IChess.ChessColor.CLR_WHITE) {
                timerWhite -= getBack.getTimer();
            }
            startTime = System.currentTimeMillis();
            listBack.remove(getBack);
            if (null != getBack.getP1()) {
                if (getBack.getP1().getColor() == IChess.ChessColor.CLR_WHITE) {
                    whiteP.remove(getBack.getP1().getType());
                } else if (getBack.getP1().getColor() == IChess.ChessColor.CLR_BLACK) {
                    blackP.remove(getBack.getP1().getType());
                }
            }
            isUndoDone = true;
        } else {
            isUndoDone = false;
        }
        return isUndoDone;
    }
    
    /**
     *
     * @param color
     * @param isPlaying
     * @return
     */
    public long getPlayerDuration(ChessColor color, boolean isPlaying) {
        long currentTime = System.currentTimeMillis() - startTime;
        if (color == ChessColor.CLR_BLACK) {
            if (isPlaying) {
                return timerBlack + currentTime;
            } else {
                return timerBlack;
            }
            
        } else {
            if (isPlaying) {
                
                return timerWhite + currentTime;
            } else {
                return timerWhite;
            }
        }
    }
    
    /**
     *
     * @param p
     * @param cp
     */
    public void setPiece(Piece p, ChessPosition cp) {
        this.board[cp.y][cp.x] = p;
    }
}
