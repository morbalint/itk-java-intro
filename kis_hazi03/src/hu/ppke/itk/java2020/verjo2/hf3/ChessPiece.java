package hu.ppke.itk.java2020.verjo2.hf3;

import java.io.IOException;
import java.nio.charset.CharacterCodingException;

/**
 * This class is the parent of all of chesspieces.
 */
abstract class ChessPiece {
    /**
     * if 1 -> whiteside
     * if 0 -> blank
     * if -1-> darkside
     */
    protected int side;

    /**
     * type of the pawn
     * x blank
     * p pawn
     * r rook
     * b bishop
     * q queen
     * l lord (not king because k is needed for knight)
     * k knight
     */
    protected String type;

    /**
     * So it can view the chessboard
     */
    protected ChessBoard board;
    /**
     *constructor of chesspieces
     * @param side is it white, black or blank
     * @throws IllegalArgumentException
     */
    public ChessPiece(int side) throws IllegalArgumentException {
        if(!(side>=-1 && side<=1))
            throw new IllegalArgumentException("The piece side could not be determined");
        this.side = side;
    }

    /**
     *constructor of chesspieces
     * @param side  is it white, black, or blank
     * @param board to see the board
     * @throws IllegalArgumentException
     */
    public ChessPiece(int side, ChessBoard board) throws IllegalArgumentException {
        if(!(side>=-1 && side<=1))
            throw new IllegalArgumentException("The piece side could not be determined");
        this.side = side;
        this.board=board;
    }

    /**
     * checks if a step is valid
     * @param i which column does it steps from
     * @param k which row does it steps from
     * @param j which column does it steps to
     * @param l which row does it steps to
     * @return  is the step valid
     */
    abstract boolean isValidStep(int i, int k, int j, int l);


    /**
     * get the type of the piece
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Gets which side is the piece is on
     * @return Is it white, black or blank
     */
    public int getSide() {
        return side;
    }

    /**
     * Get the symbol of the pawn.
     * @return the symbol of the pawn. If its on the darkside its capital case so it is easier to differenciate
     */
    @Override
    public String toString() {
        if (side == 1)
        {
            return type.toLowerCase();
        }
        else
            return type.toUpperCase();
    }
}
