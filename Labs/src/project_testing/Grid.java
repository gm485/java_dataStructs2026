package project_testing;
import lab3.StackInterface;
import lab3.StackReferenceBased;
import java.util.Random;
public class Grid implements Graph{

    Cell [][] grid;
    int rows;
    int cols;
    int nodeCount;
    //cell neighbours
    Cell[] neighbours;
    Random rand = new Random();
    //random index

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

    public void init(int n) {

    }
    public int nodeCount(){return this.nodeCount;}

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

        //count visited of neighbours
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
    //inputs
    public void generateMaze() {
        //generate rules
        //steps in generating path for the graph
        //visited array, track each neighbour of the current cell
        //stack to place first node and then
        //choose a neighbour and travel to the node
        //rules upon visit
        //1. mark node as visited
        //2. place upon the stack
        //3. get neighbours of the node
    }
    public void removeWalls(Cell curr, Cell chosen) {
        //rules for removing of walls
        //compare walls on curr and neighbour
        //wall removal of both cell curr and chosen

        //North remove
        //South remove
        //West remove
        //East remove

    }
}
