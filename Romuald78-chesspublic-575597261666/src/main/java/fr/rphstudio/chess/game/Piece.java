/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IChess.ChessColor;
import fr.rphstudio.chess.interf.IChess.ChessType;

/**
 *
 * @author DOOM GUYS.
 */
public class Piece {
    
    private ChessColor color;
    private ChessType type;
         
    public Piece(ChessColor color, ChessType type){
        this.color = color;
        this.type = type;
    }
    
    public ChessColor getColor(){
        return this.color;
    }
    
    public ChessType getType(){
        return this.type;
    }
    
    
}

