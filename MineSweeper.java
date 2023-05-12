// AM 5477 NTERMARIS NIKOLAS 

class MineSweeper {
    // the MineField for the game
    private MineField mf;

    // The number of mines in the field
    private int numberOfMines;

    // The number of mines found in the game session
    private int minesFound = 0;
    
    // player objects
    private Player player1;
    private Player player2;

    // Constructor
    public MineSweeper(int size, int numberOfMines, String name1, String name2){
        // initialize the num of mines
        this.numberOfMines = numberOfMines;

        // create the MineField
        mf = new MineField(size, numberOfMines);

        // create the players
        player1 = new Player(name1);
        player2 = new Player(name2);
    }

    public void play(){
        // print the game field for the first time
        mf.print();
        while(minesFound < numberOfMines){
            // player 1 plays
            // check if the player found a mine 
            if(player1.play(mf)){
                // increment the minesFound
                System.out.println("Mine found!");
                minesFound++;
                if(minesFound == numberOfMines){
                    // the game is over
                    break;
                }
            }
            // print the game state
            printGameState();

            // player 2 plays
            // check if the player found a mine
            if(player2.play(mf)){
                // increment the minesFound
                System.out.println("Mine found!");
                minesFound++;
            }
            // print the game state
            printGameState();
        }
        // Now The game is over
        
        // if the scores are equal, it's a tie
        if(player1.getScore() == player2.getScore()){
            System.out.println("It's a tie!");
        }else if(player1.getScore() > player2.getScore()){
            // player 1 won
            System.out.println(player1.getName() + " won!");
        }else{
            // player 2 won
            System.out.println(player2.getName() + " won!");
        }
    }

    public void printGameState(){
        // print the game field
        mf.print();
        // print the number of mines found
        System.out.println(minesFound + " mines found, " + (numberOfMines - minesFound) + " remaining.");
        // print the status of the players
        player1.printStatus();
        player2.printStatus();
        System.out.println();
    }
}
