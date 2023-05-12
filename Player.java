// AM 5477 NTERMARIS NIKOLAS 

import java.util.Scanner;

class Player {
    private String name;
    private int score;

    public Player(String name){
        this.name = name;
    }

    public boolean play(MineField mf){
        System.out.println("Player " + name + " give the coordinates for the cell to open:");
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        Cell cell = mf.getCell(row, column);
        // *** Note: if we don't want to open cell that is a candidate we can replace line with:
        // while(cell.isOpen() || !cell.isCandidate()){
        while(cell.isOpen()){
            System.out.println("Player " + name + " give the coordinates for the cell to open:");
            row = scanner.nextInt();
            column = scanner.nextInt();
            cell = mf.getCell(row, column);
        }
        // if the cell is not opened then open it and check if it contains a mine
        cell.open();
        if(cell.containsMine()){
            // then add one to the player score
            score++;
        }
        return cell.containsMine();
    }

    // score accessor method
    public int getScore(){
        return score;
    }

    // name accessor method
    public String getName(){
        return name;
    }

    public void printStatus(){
        System.out.println("Player " + name + ": " + score + " mines found");
    }

}
