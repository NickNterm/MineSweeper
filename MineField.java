// AM 5477 NTERMARIS NIKOLAS 

import java.util.Random;

class MineField {
    // Number of mines in the whole field
    private int numberOfMines;

    // List of the cells in the field
    private Cell[][] cells;

    // Constructor
    public MineField(int size, int numberOfMines){
        // initialize the number of mines 
        this.numberOfMines = numberOfMines;

        // create the table
        cells = new Cell[size][size];

        // initialize the cells
        initializeCells();
        initializeMines();
    }

    public void initializeCells(){
        // create a cell object everywhere
        for(int i = 0; i < cells.length; i++){
            for(int j = 0; j < cells.length;j++){
                cells[i][j] = new Cell(i, j);
            }
        }
        // add the neighbours
        // Because the addNeighbor function add the cell in its self 
        // but in the other cell too, we need to add the neighbours only once
        // add the bottom and right neighbours only if they exist
        // add the bottom right neighbours only if they exist
        // add the bottom left neighbours only if they exist
        for(int i = 0; i < cells.length; i++){
            for(int j = 0; j < cells.length; j++){
                // add the bottom neighbour
                if(i < cells.length - 1){
                    cells[i][j].addNeighbor(cells[i + 1][j]);
                }
                // add the right neighbour
                if(j < cells.length - 1){
                    cells[i][j].addNeighbor(cells[i][j + 1]);
                }
                // add the bottom left neighbour
                if(i < cells.length - 1 && j > 0){
                    cells[i][j].addNeighbor(cells[i + 1][j - 1]);
                }
                // add the bottom right neighbour
                if(i < cells.length - 1 && j < cells.length - 1){
                    cells[i][j].addNeighbor(cells[i + 1][j + 1]);
                }
            }
        }
    }
    
    public void initializeMines(){
        Random random = new Random();
        // see if the code works Remove in the final version
        // random.setSeed(2023);

        // get a counter for the mines
        int count = 0;

        while(count < numberOfMines){
            // get random row, column and place a mine there
            int row = random.nextInt(cells.length);
            int column = random.nextInt(cells.length);
            // check if the cell is already a mine
            if(!cells[row][column].containsMine()){
                // place a mine
                cells[row][column].addMine();
                // increment the counter
                count++;
            }
        }
    }

    public Cell getCell(int row, int column){
        // return the cell at the given row and column
        return cells[row][column];
    }

    public void print(){
        // print the number in the first line
        System.out.print(" \t");
        for(int i = 0; i < cells.length; i++){
            System.out.print(i + "  ");
        }
        System.out.println();
        System.out.println();
        // print the rest of the table
        for(int i = 0; i < cells.length; i++){
            System.out.print(i + "\t");
            for(int j = 0; j < cells.length; j++){
                System.out.print(cells[i][j]);
                System.out.print("  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        // create a minefield
        MineField mineField = new MineField(10, 20);
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10;j++){
                // open all the cells
                mineField.getCell(i, j).open();
            }
        }
        //print the field
        mineField.print();
    }
}
