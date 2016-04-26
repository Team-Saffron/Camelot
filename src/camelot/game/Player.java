/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package camelot.game;

/**
 *
 * @author aakashtyagi
 */
public class Player {
    public String name;
    public int castleMoves;
    public int piecesLeft, deadPawnCount, deadKnightCount;
    
    public Player()
    {
        name = "Guest";
        castleMoves = 0;piecesLeft = 14;
        deadPawnCount = deadKnightCount = 0;
    }
    
    public Player(String str)
    {
        name = str;
        castleMoves = 0;piecesLeft = 14;
    }
}
