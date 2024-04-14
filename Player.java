// Done By:
// AK MOHD AFIF NURZAKWAN BIN PG HJ ASRI SUKAIMI    B20230069  
// MUHAMMAD ALI KHANAFIAH BIN HAJI JULKIPELI        B20210141 
// CHONG JIA HOE                                    B20230397 

// Create a Player class to represent a player in the game.
// • Each player should have a name and a symbol (X or O).
// • Implement appropriate constructors and methods.

public class Player {
    private String name; // Name of the player
    private char symbol; // Symbol used by the player ('X' or 'O')

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        // Get the name of the player
        return name;
    }

    public char getSymbol() {
        // Get the symbol used by the player ('X' or 'O')
        return symbol;
    }
}
