package hu.ppke.itk.java2020.verjo2.hf3;

/**
 * Implementing knight
 */
public class Knight extends ChessPiece {
    public Knight(int side, ChessBoard board) throws IllegalArgumentException {
        super(side, board);
        this.type = "k";
    }

    @Override
    boolean isValidStep(int i, int k, int j, int l) {
        if((Math.abs(i-j)==2 && Math.abs(k-l)==1) || (Math.abs(i-j)== 1 && Math.abs(k-l) == 2 ))
        {
            if(board.getSideAt(j,l) != this.side)
                return true;
        }


        return false;
    }
}
