/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess.ChessPosition;
import java.util.List;

/**
 * The trilogy
 * @author DOOM GUYS.
 */
public class BackToTheFuture {
    //private ChessBoard chesboard;
    private ChessPosition cp0;
    private Piece p0;
    private ChessPosition cp1;
    private Piece p1;
    private long timer;
    
    /**
     * This is the constructor of the classBackToTheFuture
     * @param cp0 is the position of the piece that moves
     * @param p0 is the piece that moves
     * @param cp1 is the position of the piece after that moves
     * @param p1 is the piece that is potentially eaten
     */
    public BackToTheFuture(ChessPosition cp0, Piece p0, ChessPosition cp1, Piece p1, long timer){
        this.cp0 = cp0;
        this.p0 = p0;
        this.cp1 = cp1;
        this.p1 = p1;
        this.timer = timer;
    }
    
    public ChessPosition getCp0(){
        return cp0;
    }
    
    public Piece getP0(){
        return p0;
    }
    
    public ChessPosition getCp1(){
        return cp1;
    }
    
    public Piece getP1(){
        return p1;
    }
    
    public long getTimer(){
        return timer;
    }
}
