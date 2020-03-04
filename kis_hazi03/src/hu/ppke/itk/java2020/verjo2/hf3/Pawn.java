package hu.ppke.itk.java2020.verjo2.hf3;

/**
 * implementing pawn
 */

public class Pawn extends ChessPiece {


    public Pawn(int side, ChessBoard board) throws IllegalArgumentException {
        super(side, board);
        this.type = "p";
    }


    @Override
    boolean isValidStep(int i, int k, int j, int l) {
        /**
         * if it stays in the same column
         */
        if(i == j && board.getSideAt(j,l) == 0){
            /**
             * does it steps one, and if yes, from which direction to where
             */
           if((l-k)*(-1)*side == 1)
            return true;
           /**
            * if it does two steps
            */
           if((l-k)*(-1)*side == 2)
           /**
            * is the pawn on the base line?
            */
               if(side == -1 && k == 1) {
                   if(board.getSideAt(i, k+1) == 0)
                        return true;
               }
                if (side == 1 && k == 6) {
                    if(board.getSideAt(i, k-1) == 0)
                        return true;
                }
        }
        /**
         * handles when the pawn hits another piece
         */
        if(Math.abs(i-j) == 1 && (l-k)*(-1)*side == 1 && board.getSideAt(j, l) == (-1)*this.getSide())
            return true;
        return false;
    }
}
