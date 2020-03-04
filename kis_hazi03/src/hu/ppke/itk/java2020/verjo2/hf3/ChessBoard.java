package hu.ppke.itk.java2020.verjo2.hf3;

import java.io.IOException;
import java.util.Arrays;

/**
 * This class implements a chess board.
 */
public class ChessBoard {
    ChessPiece[][] board;

    /**
     * it counts whos turn is it
     * 1 -> whiteside
     * -1 -> darkside
     */
    private int turn;


    /**
     * initialize the chessboard
     * it automatically starts with white turn
     */
    ChessBoard()
    {
        /**
         * 8*8 is the size
         */
        board = new ChessPiece[8][8];
        /**
         * it follows whos turn is it
         */
        turn = 1;
        /**
         * the initial values of the chessboard are blank
         */
        for(int i = 0; i < board[0].length; i++)
        {
            for(int k = 0; k < board.length; k++)
            {
                board[k][i] = new Blank(0);
            }
        }
        /**
         * set up the pieces
         */
        for (int i = 0; i < board[0].length; i++) {
            board[i][1] = new Pawn(-1, this);
            board[i][6] = new Pawn(1, this);
        }
        board[0][0] = new Rook(-1,this);
        board[7][0] = new Rook(-1,this);
        board[0][7] = new Rook(1, this);
        board[7][7] = new Rook(1,this);
        board[2][0] = new Bishop(-1, this);
        board[5][0] = new Bishop(-1, this);
        board[2][7] = new Bishop(1, this);
        board[5][7] = new Bishop(1, this);
        board[6][0] = new Knight(-1, this);
        board[1][0] = new Knight(-1, this);
        board[6][7] = new Knight(1, this);
        board[1][7] = new Knight(1, this);
        board[3][0] = new Queen(-1,this);
        board[3][7] = new Queen(1, this);
        board[4][0] = new Lord(-1, this);
        board[4][7] = new Lord(1, this);

    }


    /**
     * This handles steps on the chessboard
     * @param a from which column
     * @param i from which row
     * @param b to which column
     * @param j to which row
     * @throws IllegalArgumentException if they reference outside the chessboard, or they do not step with their own piece
     * or when a step is not legal
     */
    public void step(char a, int i, char b, int j) throws IllegalArgumentException
    {

        if(!(Arrays.asList('A','B','C','D','E','F','G','H','a','b','c','d','e','f','g','h').contains(a)))
            throw new IllegalArgumentException("The column where you wanted to start is outside of the playing field.");
        if(!(Arrays.asList('A','B','C','D','E','F','G','H','a','b','c','d','e','f','g','h').contains(b)))
            throw new IllegalArgumentException("The column where you wanted to arrive is outside of the playing field.");
        if(!(1<=i && i<=8))
            throw new IllegalArgumentException("The column where you wanted to start is outside of the playing field.");
        if(!(1<=j && j<=8))
            throw new IllegalArgumentException("The row where you wanted to arrive is outside of the playing field.");
        int startColCoord = stringToInt(a);
        int startRowCoord = board[0].length-i;
        int arrColCoord = stringToInt(b);
        int arrRowCoord = board[0].length-j;
        if(board[startColCoord][startRowCoord].getSide()!=this.turn )
            throw new IllegalArgumentException("You did not step with your own pawn. ");
        if(!(board[startColCoord][startRowCoord].isValidStep(startColCoord,startRowCoord,arrColCoord,arrRowCoord)))
            throw new IllegalArgumentException("This step was illegal.");
        else{
            board[arrColCoord][arrRowCoord] = board[startColCoord][startRowCoord];
            board[startColCoord][startRowCoord] = new Blank(0);
        }
        /**
         * switches turn if the step was valid
         */
        turn *= -1;
    }

    /**
     * Handles the conversion between the user character and the matrix dimension
     * @param a The character user input
     * @return Matrix dimension
     */
    private int stringToInt(char a)
    {
        switch (a){
            case 'A':
            case 'a':
            {
                return 0;
            }
            case 'B':
            case 'b':
            {
                return 1;
            }
            case 'C':
            case 'c':
            {
                return 2;
            }
            case 'D':
            case 'd':
            {
                return 3;
            }
            case 'E':
            case 'e':
            {
                return 4;
            }
            case 'F':
            case 'f':
            {
                return 5;
            }
            case 'G':
            case 'g':
            {
                return 6;
            }
            case 'H':
            case 'h':
            {
                return 7;
            }
            default:
                return -1;
        }
    }

    /**
     * Get whose turn is it
     * @return 1 if white, -1 if black
     */
    public int getTurn() {
        return turn;
    }

    /**
     * Get the whose side is piece is
     * @param colCoord which column
     * @param rowCoord which row
     * @return whose side (-1 if black, 0 if blank, 1 if white)
     */
    public int getSideAt(int colCoord, int rowCoord)
    {
        return board[colCoord][rowCoord].getSide();
    }

    /**
     *  get what type of piece is there
     * @param colCoord which column
     * @param rowCoord which row
     * @return the type of the piece
     */
    public String getTypeAt(int colCoord, int rowCoord)
    {
        return board[colCoord][rowCoord].getType();
    }


    /**
     * override toString to write out a matrix
     * @return with the matrix format of the chessboard
     */
    @Override
    public String toString() {
        String out = "";
        for(int i = 0; i <board[0].length ; i++)
        {
            out+= (board[0].length-i) + "\t";
            for(int k =0; k< board.length; k++)
            {
                out += board[k][i].toString() + "\t";
            }
            out += "\n";
        }
        out += "\tA\tB\tC\tD\tE\tF\tG\tH\n";
        return out;
    }
}
