package project_testing;
import lab3.StackInterface;
import lab3.StackReferenceBased;

public class Grid {

    Cell [][] grid;
    int rows;
    int cols;

    public Grid() {
        //default constructor
        this.rows = 10;
        this.cols = 10;
        this.grid = new Cell[rows][cols];
        generateGrid();
    }

    //custom constructor
    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new Cell[rows][cols];
        generateGrid();
    }

    public void generateGrid() {
        //stack for dfs maze generation
        StackInterface stack = new StackReferenceBased();

        for (int i = 0; i < this.grid.length; i++) {
            for ( int j = 0; j < this.grid[i].length; j++) {
                grid[i][j] = new Cell(i, j);
            }
        }

    }

    public int getRows() {
        return this.grid.length;
    }

    public int getCols() {
        return this.grid[0].length;
    }
    //safe retrieval of cell getter
    public Cell getCell(int r, int c) {
        //check for out of bounds
        if (r >= 0 && r < rows && c >= 0 && c < cols){
            return grid[r][c];
        }
        return null;
    }

    public Cell[] getUnvisitedNeighbors(Cell cell){
        int r = cell.row;
        int c = cell.col;
        //get potential neighbours
        Cell[] potentialNeighbours = {
                getCell(r - 1, c),//top
                getCell(r, c-1),//left
                getCell(r + 1, c),//bottom
                getCell(r, c + 1),//right
        };

        //count visited
        int count = 0;
        for (Cell neighbour : potentialNeighbours) {
            if (neighbour != null && !neighbour.visited){
                count++;
            }
        }

        //when there is no unvisited neighbours return empty array
        if (count == 0){
            return new Cell[0];
        }

        Cell[] unvisitedNeighours = new Cell[count];
        int index = 0;
        for (Cell neighbour : potentialNeighbours) {
            if (neighbour != null && !neighbour.visited){
                unvisitedNeighours[index] = cell;
                index++;
            }
        }
        return unvisitedNeighours;
    }

}
