// Done By:
// AK MOHD AFIF NURZAKWAN BIN PG HJ ASRI SUKAIMI    B20230069  
// MUHAMMAD ALI KHANAFIAH BIN HAJI JULKIPELI        B20210141 
// CHONG JIA HOE                                    B20230397 

// • Create a Game class to manage the Tic Tac Toe game.
// • Include methods to:
//      o Start a new game.
//      o Allow players to take turns marking cells on the board.
//      o Check for a winner after each turn.
//      o Declare the winner or a draw when appropriate.
//      o Prompt players for their moves.
// • Ensure proper encapsulation and error handling.

import java.util.Scanner;

public class Game {
    private Board board; // The game board
    private Player player1; // Player 1
    private Player player2; // Player 2
    private Player currentPlayer; // Current player taking the turn
    private boolean gameEnded; // Flag to track if the game has ended (win or draw)

    public Game(String name1, String name2) {
        board = new Board();
        player1 = new Player(name1, 'X');
        player2 = new Player(name2, 'O');
        currentPlayer = player1; // Player 1 starts the game
        gameEnded = false;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Starting Tic Tac Toe Game!");

        while (!gameEnded) {
            board.displayBoard(); // Display the current state of the board
            System.out.println();
            System.out.print(currentPlayer.getName() + "'s turn. Enter a position (1-9): ");
            int position = scanner.nextInt();

            if (isValidMove(position)) {
                // Mark the cell with the current player's symbol
                board.markCell(position, currentPlayer.getSymbol());
                // Check if the current player wins after making the move
                char winner = board.checkWinner();
                if (winner != '-') {
                    board.displayBoard();
                    // Display the winning message in the color of the winning player
                    System.out.print("\u001B[");
                    if (winner == 'X') {
                        System.out.print("31m"); // Red color for 'X' (Player 1)
                    } else {
                        System.out.print("34m"); // Blue color for 'O' (Player 2)
                    }
                    System.out.println(currentPlayer.getName() + " wins!");
                    System.out.println();
                    gameEnded = true; // End the game
                } else if (isBoardFull()) {
                    board.displayBoard();
                    System.out.println("It's a draw!");
                    gameEnded = true; // End the game (draw)
                } else {
                    // Switch to the next player for the next turn
                    currentPlayer = (currentPlayer == player1) ? player2 : player1;
                }
            } else {
                System.out.println("Invalid move! Position is already taken or out of range. Try again.");
            }
        }

        scanner.close();
    }

    private boolean isValidMove(int position) {
        // Check if the specified position is a valid move (empty and within range)
        return position >= 1 && position <= 9 && board.isCellEmpty(position);
    }

    private boolean isBoardFull() {
        // Check if the board is full (all positions are occupied)
        for (int position = 1; position <= 9; position++) {
            if (board.isCellEmpty(position)) {
                return false; // Board is not full
            }
        }
        return true; // Board is full
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter Player 1's name: ");
        String name1 = scanner.nextLine();
        System.out.print("Enter Player 2's name: ");
        String name2 = scanner.nextLine();
        
        Game ticTacToe = new Game(name1, name2);
        ticTacToe.start(); // Start the Tic Tac Toe game
        
        scanner.close();
    }
}
