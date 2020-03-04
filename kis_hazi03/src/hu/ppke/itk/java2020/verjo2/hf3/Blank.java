package hu.ppke.itk.java2020.verjo2.hf3;

/**
 * The spaces where does not stand a piece
 */
public class Blank extends ChessPiece {
    Blank(int side)
    {
        super(side);
        this.type = " ";
    }

    @Override
    boolean isValidStep(int i, int k, int j, int l) {
        return false;
    }

}
