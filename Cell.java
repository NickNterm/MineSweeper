// AM 5477 NTERMARIS NIKOLAS 

import java.util.ArrayList;

class Cell {
    // The row and column of the cell
    private int row;
    private int column;
    
    // Is mine boolean
    private boolean isMine;

    // Is opened boolean
    private boolean isRevealed;
     
    // Number of mines around that cell
    private int numberOfMinesAround;

    // The list of the neighbour Cells
    private ArrayList<Cell> neighbours = new ArrayList<>();

    // Bonus boolean
    private boolean isCandidate = true;

    // Constructor
    public Cell(int row, int column){
        this.row = row;
        this.column = column;
    }

    public void addNeighbor(Cell neighbour){
        // Add the given cell to the Neighbours list
        neighbours.add(neighbour);

        // Add the current cell to the given cell's Neighbours list
        neighbour.neighbours.add(this);
    }

    public void addMine(){
        // Update the isMine boolean
        isMine = true;

        // Update the numberOfMinesAround for all the neighbours
        for(Cell neighbour : neighbours){
            if(!neighbour.containsMine()){
                neighbour.numberOfMinesAround++;
            }
        }
    }

    public void open(){
        // Update the isReveald boolean
        isRevealed = true;

        // Bonus
        // if the Cell that i try to open is not a mine
        // I want to count the opened, mine cells. 
        // if the count is equal to the number of mines around, all the neighbours other neighbours are not candidates
        //
        // For example if i open a cell with the 3 number on it and the around opened cells, with mines are 3
        // then make all that cells x
        if(!isMine){
            int openMines = 0;
            for(Cell neighbour : neighbours){
                if(neighbour.isOpen() && neighbour.containsMine()){
                    openMines++;
                }
            }
            if(openMines == numberOfMinesAround){
                for(Cell neighbour : neighbours){
                    if(!neighbour.isOpen() && !neighbour.containsMine()){
                        neighbour.notCandidate();
                    }
                }
            }
        }

        // if the cell is a mine i want to check if the neighbours are candidates
        // if the neighbours are opened and the amount of opened mines are the same as the number of mines around
        // then make all the other neighbours not candidates
        if(isMine){
            for(Cell neighbour : neighbours){
                int openMines = 0;
                for(int i = 1; i < 8; i++){
                    if(neighbour.numberOfMinesAround == i && neighbour.isOpen() && !neighbour.containsMine()){
                        for( Cell neighbour2 : neighbour.neighbours){
                            if(neighbour2.isOpen() && neighbour2.containsMine()){
                                openMines++;
                            }
                        }
                        if(openMines == neighbour.numberOfMinesAround){
                            for( Cell neighbour2 : neighbour.neighbours){
                                if(!neighbour2.isOpen() && !neighbour2.containsMine()){
                                    neighbour2.notCandidate();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean isOpen(){
        // Return isRevield
        return isRevealed;
    }

    public boolean containsMine(){
        // Return isMine
        return isMine;
    }

    // Bonus set the cell as not a candidate
    public void notCandidate(){
        // Update the isCandidate boolean
        isCandidate = false;
    }

    public boolean isCandidate(){
        // Return isCandidate
        return isCandidate;
    }

    public String toString(){
        // If the cell is not reveald, return "-"
        if(!isRevealed){
            // Bonus part 
            // If the cell is a candidate, return "x"
            if(!isCandidate){
                return "x";
            }
            return "-";
        }

        // Now it means the cell is reveald
        if(isMine){
            // If the cell is a mine, return "*"
            return "*";
        }

        // Now it means the cell is not a mine
        // the "" is to make the number of mines around a string
        return numberOfMinesAround + "";
    }
}
