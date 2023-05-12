// AM 5477 NTERMARIS NIKOLAS 

import java.util.Scanner;

class Game {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        // Get the size of the board 
        System.out.println("Give the board size:");
        int size = scanner.nextInt();

        // Get the number of mines
        System.out.println("Give the number of mines:");
        int numberOfMines = scanner.nextInt();

        // Get the players Names
        System.out.println("Give the names of the players:");
        String name1 = scanner.next();
        String name2 = scanner.next();

        // Create a new MineSweeper 
        MineSweeper game = new MineSweeper(size, numberOfMines, name1, name2);

        // Start the game
        game.play();
    }
}
