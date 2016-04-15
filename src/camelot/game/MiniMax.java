/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package camelot.game;

import java.util.ArrayList;

/**
 *
 * @author Abhishek
 */
class MinMaxResult
{
    Move move;
    double val;
    MinMaxResult()
    {
        
    }
    MinMaxResult(Move move, double val)
    {
        this.move = move;
        this.val = val;
    }
}

public class MiniMax {
 
    public MinMaxResult Mini(int depth, CamelotGame cg){
        int i, j;
        if (depth == 0){
            return new MinMaxResult(null, cg.getHashValue());
        }
        MinMaxResult res = new MinMaxResult(null, 0.0);
        ArrayList<Move> moveList = new ArrayList<>();
        Piece piece;
        //For all valid moves
        for(i=1; i<=16; i++){
            for(j=1; j<=12; j++){
                if(null != (piece = cg.getPiece(i, j)))
                {
                    Merge(moveList, piece.getValidMoves(getHash(cg)));
                }
            }
        }
        
        // Applying Max algo on obtained Moves
        for(Move move : moveList)
        {
            cg.singleMove(move);            
            MinMaxResult tempres = Maxi(depth-1, cg);
            if(tempres.val < res.val)
            {
                res.val = tempres.val;
                res.move = move;
            }
            cg.revertMove(move);
        }
        return res;
    }
    
    public MinMaxResult Maxi(int depth, CamelotGame cg){
        int i, j;
        if (depth == 0){
            return new MinMaxResult(null, cg.getHashValue());
        }
        MinMaxResult res = new MinMaxResult(null, 0.0);
        ArrayList<Move> moveList = new ArrayList<>();
        Piece piece;
        //For all valid moves
        for(i=1; i<=16; i++){
            for(j=1; j<=12; j++){
                if(null != (piece = cg.getPiece(i, j)))
                {
                    Merge(moveList, piece.getValidMoves(getHash(cg)));
                }
            }
        }
        
        // Applying Max algo on obtained Moves
        for(Move move : moveList)
        {
            cg.singleMove(move);            
            MinMaxResult tempres = Mini(depth-1, cg);
            if(tempres.val > res.val)
            {
                res.val = tempres.val;
                res.move = move;
            }
            cg.revertMove(move);
        }
        return res;
    }
    void Merge(ArrayList<Move> moveList, ArrayList<Move> pieceList)
    {
        
    }
    String getHash(CamelotGame cg)
    {
        String hashValue= new String();
        return hashValue;
    }
    
}
