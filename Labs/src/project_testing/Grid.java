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

    //dfs maze generation
    public void generateDFSMaze() {
        StackInterface stack = new StackReferenceBased();
        Cell start = getCell(0, 0);
        //special case, null pointer on insertion of matrix
        if ( start == null) {
            return;
        }
        //visit node and push to stack
        start.visited = true;
        stack.push(start);
        //look for neighbour
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
                unvisitedNeighours[index] = neighbour;
                index++;
            }
        }
        return unvisitedNeighours;
    }

    public void removeWalls(Cell curr, Cell neighbour) {
        int rowDiff = curr.row - neighbour.row;
        int colDiff = curr.col - neighbour.col;

        //check north
        if (rowDiff == -1 && colDiff == -1) {
            curr.top = false;
            neighbour.bottom = false;
        }
        //south
        else if (rowDiff == 1 && colDiff == 0) {
            curr.bottom = false;
            neighbour.top = false;
        }
        //West
        else if (rowDiff == 0 && colDiff == -1) {
            curr.left = false;
            neighbour.right = false;
        }
        //East
        else if (rowDiff == 0 && colDiff == 1){
            curr.right = false;
            neighbour.left = false;
        }
    }

}
