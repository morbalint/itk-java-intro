package hu.ppke.itk.java2020.verjo2.hf3;

/**
 * implementing bishop
 */
public class Bishop extends ChessPiece{

    public Bishop(int side, ChessBoard board) throws IllegalArgumentException {
        super(side, board);
        this.type = "b";
    }

    @Override
    boolean isValidStep(int i, int k, int j, int l) {
        if((i==j && k == l) || (Math.abs(i-j) != Math.abs(k-l)))
            return false;

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
        if(board.getSideAt(j,l) != this.side)
            return true;


        return false;
    }
}
