package hu.ppke.itk.java2020.verjo2.hf3;

/**
 * implementing rook
 * castle not solved
 */
public class Rook extends ChessPiece {

    public Rook(int side, ChessBoard board) throws IllegalArgumentException {
        super(side, board);
        this.type = "r";
    }

    @Override
    boolean isValidStep(int i, int k, int j, int l) {
        /**
         * At the start we throw back the inherently wrong calls
         */
        if ((i != j && k != l) || (i == j && k == l))
            return false;

        /**
         * with four fo cycles we check if the pieace has any other pieces between himself and the target place
         */
        if(i<j)
            for (int m = i+1; m < j; m++) {
                if(board.getSideAt(m,k)!= 0)
                    return false;
            }
        if(i>j)
            for (int m = j+1; m < i; m++) {
                if(board.getSideAt(m,k)!= 0)
                    return false;
            }
        if(k<l)
            for (int m = k+1; m < l; m++) {
                if(board.getSideAt(i,m)!= 0)
                    return false;
            }
        if(l<k)
            for (int m = l+1; m < k; m++) {
                if(board.getSideAt(i,m)!= 0)
                    return false;
            }


        return false;
    }
}
