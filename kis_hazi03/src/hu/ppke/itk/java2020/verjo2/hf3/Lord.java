package hu.ppke.itk.java2020.verjo2.hf3;

/**
 * Implementing lord. Castle not solved.
 */
public class Lord extends ChessPiece{
    public Lord(int side, ChessBoard board) throws IllegalArgumentException {
        super(side, board);
        this.type = "l";
    }

    @Override
    boolean isValidStep(int i, int k, int j, int l) {
        if((Math.abs(i-j)<=1 && Math.abs(k-l)<=1) && (i!= j && k!=l)) {
            if (board.getSideAt(k, l) != this.side)
                return true;
        }

        return false;
    }
}
