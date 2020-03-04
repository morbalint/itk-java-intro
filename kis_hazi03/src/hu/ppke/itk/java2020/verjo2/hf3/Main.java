package hu.ppke.itk.java2020.verjo2.hf3;

import java.io.IOException;
import java.util.Scanner;

/**
 * This is a chess program.
 *
 * @author Jonah
 */
public class Main {
    public static void main(String[] args)
    {
        boolean endOfGame = false;
        ChessBoard game = new ChessBoard();
        Scanner scanner = new Scanner(System.in);
        String inStream = null;
        System.out.println("Hello, this is the chess game!");
        System.out.println("The check-mate is not implemented jet, so if you want to finish your game");
        System.out.println("please give the Q command when the program asks for a step.");
        System.out.println("You should give the command in chesslike manner.");
        System.out.println("\tLike B2B3 if you want to move your pawn from B2 to B3.\n\n");
        while(!endOfGame)
        {
            System.out.println(game);
            if(game.getTurn() == 1)
                System.out.println("It's white's turn");
            else
                System.out.println("It's dark's turn");


            boolean success = false;
            while(!success)
            try{
                System.out.println("Please give the step:");


                inStream = scanner.next();
                if(inStream.length()!=1 && inStream.length() != 4)
                    throw new IllegalArgumentException("Please give the values in the correct format!");


                if(inStream.equals("Q") || inStream.equals("q"))
                {
                    endOfGame = true;
                    break;
                }
                else if(inStream.length() == 1)
                    throw new IllegalArgumentException("Q can be the only one line command");

                game.step(inStream.charAt(0),Character.getNumericValue(inStream.charAt(1)),
                        inStream.charAt(2), Character.getNumericValue(inStream.charAt(3)));

                success = true;
            }catch(IllegalArgumentException i)
            {
                System.out.println(i);

            }


        }










    }
}
