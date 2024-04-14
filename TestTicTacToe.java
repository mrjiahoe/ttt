// Done By:
// AK MOHD AFIF NURZAKWAN BIN PG HJ ASRI SUKAIMI    B20230069  
// MUHAMMAD ALI KHANAFIAH BIN HAJI JULKIPELI        B20210141 
// CHONG JIA HOE                                    B20230397 

// The objective of this assignment is to assess students' understanding of Object-Oriented
// Programming (OOP) concepts in Java, including class design, inheritance, encapsulation, and
// polymorphism. Students will implement a simple Tic Tac Toe game where two players can take
// turns to mark cells on a 3x3 grid.

import java.util.Scanner;

public class TestTicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter Player 1's name: ");
        String name1 = scanner.nextLine();
        System.out.print("Enter Player 2's name: ");
        String name2 = scanner.nextLine();
        
        // Create a new Tic Tac Toe game instance with the entered player names
        Game ticTacToe = new Game(name1, name2);
        ticTacToe.start(); // Start the game
        
        scanner.close();
    }
}
