package hu.ppke.itk.java2020.verjo2.hf3;

/**
 * implementing queen
 */
public class Queen extends ChessPiece {
    public Queen(int side, ChessBoard board) throws IllegalArgumentException {
        super(side, board);
        this.type = "q";
    }

    @Override
    boolean isValidStep(int i, int k, int j, int l) {
        if((i==j && k == l) || ((Math.abs(i-j) != Math.abs(k-l)) && (i != j && k != l)))
            return false;

        /**
         * check if there is anyone in the way if going diagonally
         */
        if(i<j)
        {
            if(k<l)
            {
                for(int m = 1; m< Math.abs(i-j); m++)
                    if(board.getSideAt(i+m, k+m) != 0)
                        return false;
            }
            if(k>l)
            {
                for(int m = 1; m< Math.abs(i-j); m++)
                    if(board.getSideAt(i+m, k-m) != 0)
                        return false;
            }
        }
        if(i>j)
        {
            if(k<l)
            {
                for(int m = 1; m< Math.abs(i-j); m++)
                    if(board.getSideAt(i-m, k+m) != 0)
                        return false;
            }
            if(k>l)
            {
                for(int m = 1; m< Math.abs(i-j); m++)
                    if(board.getSideAt(i-m, k-m) != 0)
                        return false;
            }
        }

        /**
         * if going horizontally or vertically
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


        if(board.getSideAt(j,l) != this.side)
            return true;

        return true;
    }
}
