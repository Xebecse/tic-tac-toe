package mainpack;

import java.util.Scanner;

public class Game {
	static Scanner input = new Scanner(System.in);
	public static String[] boardChoices = new String[9];	
	
	public static void main(String[] args) {
        initializeBoard();

        while (true) {
            printBoard();

            String currentPlayer = playerTurn();
            makeMove(currentPlayer);

            String winner = checkWinner();
            if (winner != null) {
            	printBoard();
                System.out.println(winner + " wins!");
                break;
            }

            if (isBoardFull()) {
            	printBoard();
                System.out.println("It's a tie!");
                break;
            }
        }
    }

    // Create the board with empty spaces
    public static void initializeBoard() {
        for (int i = 0; i < 9; i++) {
            boardChoices[i] = " ";
        }
    }

    // Checks for current players turn
    public static String playerTurn() {
        int turnCount = 0;
        for (String choice : boardChoices) {
            if (!choice.equals(" ")) {
                turnCount++;
            }
        }
        return turnCount % 2 == 0 ? "X" : "O";
    }

    // Allow the current player to make a move
    public static void makeMove(String player) {
        while (true) {
            System.out.print(player + "'s turn. Enter a position (1-9): ");
            int position = input.nextInt() - 1;      

            if (position >= 0 && position < 9 && boardChoices[position].equals(" ")) {
                boardChoices[position] = player;
                break;
            } else {
                System.out.println("Invalid position or position already filled. Try again.");
            }
        }
    }

    // Checks to see if the board is full
    public static boolean isBoardFull() {
        for (String choice : boardChoices) {
            if (choice.equals(" ")) {
                return false;
            }
        }
        return true;
    }
     
    
    public static void printBoard() {	
	    System.out.println(" " + boardChoices[0] + " | " + boardChoices[1] + " | " + boardChoices[2] + " ");
	    System.out.println("___|___|___");
	    System.out.println(" " + boardChoices[3] + " | " + boardChoices[4] + " | " + boardChoices[5] + " ");
	    System.out.println("___|___|___");
	    System.out.println(" " + boardChoices[6] + " | " + boardChoices[7] + " | " + boardChoices[8] + " ");
	    System.out.println("   |   |   ");   
	}
	
	static String checkWinner()
	{
	     for (int a = 0; a < 8; a++) {
	           String line = null;
	 
	            switch (a) {
	            case 0:
	                line = Game.boardChoices[0] + Game.boardChoices[1] + Game.boardChoices[2];
	                break;
	            case 1:
	                line = Game.boardChoices[3] + Game.boardChoices[4] + Game.boardChoices[5];
	                break;
	            case 2:
	                line = Game.boardChoices[6] + Game.boardChoices[7] + Game.boardChoices[8];
	                break;
	            case 3:
	                line = Game.boardChoices[0] + Game.boardChoices[3] + Game.boardChoices[6];
	                break;
	            case 4:
	                line = Game.boardChoices[1] + Game.boardChoices[4] + Game.boardChoices[7];
	                break;
	            case 5:
	                line = Game.boardChoices[2] + Game.boardChoices[5] + Game.boardChoices[8];
	                break;
	            case 6:
	                line = Game.boardChoices[0] + Game.boardChoices[4] + Game.boardChoices[8];
	                break;
	            case 7:
	                line = Game.boardChoices[2] + Game.boardChoices[4] + Game.boardChoices[6];
	                break;
	            }
	            //For X winner
	            if (line.equals("XXX")) {
	                return "X";
	            }
	             
	            // For O winner
	            else if (line.equals("OOO")) {
	                return "O";
	            }
	     }
		return null;
	}
}