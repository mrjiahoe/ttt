// Done By:
// AK MOHD AFIF NURZAKWAN BIN PG HJ ASRI SUKAIMI    B20230069  
// MUHAMMAD ALI KHANAFIAH BIN HAJI JULKIPELI        B20210141 
// CHONG JIA HOE                                    B20230397 

// Create a Board class that represents the game board.
// • Implement a 3x3 grid to store the state of the game.
// • Include methods to:
//      o Initialize the board.
//      o Display the current state of the board.
//      o Check for a winner (if any).

public class Board {
    private char[][] grid; // Represents the 3x3 grid for the Tic Tac Toe board

    public Board() {
        grid = new char[3][3];
        initializeBoard(); // Initialize the board with empty cells
    }

    public void initializeBoard() {
        char cellNumber = '1';
        // Fill the board with numbers 1-9 to represent positions
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                grid[row][col] = cellNumber;
                cellNumber++;
            }
        }
    }

    public void displayBoard() {
        // Display the current state of the board with positions and player moves
        System.out.println("-------------");
        for (int row = 0; row < 3; row++) {
            System.out.print("| ");
            for (int col = 0; col < 3; col++) {
                char symbol = grid[row][col];
                if (symbol == 'X') {
                    System.out.print("\u001B[31m" + symbol + "\u001B[0m | "); // Red color for 'X'
                } else if (symbol == 'O') {
                    System.out.print("\u001B[34m" + symbol + "\u001B[0m | "); // Blue color for 'O'
                } else {
                    System.out.print(symbol + " | ");
                }
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public boolean isCellEmpty(int position) {
        // Check if the specified position on the board is empty
        int row = (position - 1) / 3;
        int col = (position - 1) % 3;
        return grid[row][col] != 'X' && grid[row][col] != 'O';
    }

    public void markCell(int position, char symbol) {
        // Mark a cell on the board with the specified player symbol (X or O)
        int row = (position - 1) / 3;
        int col = (position - 1) % 3;
        grid[row][col] = symbol;
    }

    public char checkWinner() {
        // Check if there is a winner on the board (rows, columns, or diagonals)
        // Return the winning symbol ('X' or 'O') or '-' if no winner
        
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) {
                return grid[i][0]; // Winner found in row
            }
            if (grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i]) {
                return grid[0][i]; // Winner found in column
            }
        }

        // Check diagonals
        if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
            return grid[0][0]; // Winner found in top-left to bottom-right diagonal
        }
        if (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) {
            return grid[0][2]; // Winner found in top-right to bottom-left diagonal
        }

        return '-'; // No winner yet
    }
}

