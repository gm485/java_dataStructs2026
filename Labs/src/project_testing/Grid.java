package project_testing;
import lab3.StackInterface;
import lab3.StackReferenceBased;
import lab4.QueueArrayBased;
import java.util.Random;

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
        generateDFSMaze();
    }

    //custom constructor
    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new Cell[rows][cols];
        generateGrid();
        generateDFSMaze();
        isAllVisited();
    }

    public void generateGrid() {

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

    public boolean isAllVisited() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Cell cell = getCell(r, c);
                if (cell == null || !cell.visited) {
                    System.out.println("Unvisited cell at (" + r + ", " + c + ")");
                    return false;
                }
            }
        }
        return true;
    }

    //reset each visited cell node
    private void resetForBFS() {
        for(int i = 0; i < rows; i++){
            for( int j = 0; j < cols; j++) {
                Cell cell = getCell(i, j);
                if ( cell != null ) {
                    //mark each item visited and remove parent
                    cell.visited = false;
                    cell.parent = null;
                }
            }
        }
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
        Random random = new Random();
        while (!stack.isEmpty()) {
            Cell curr = (Cell) stack.peek();
            Cell[] unvisited = getUnvisitedNeighbors(curr);

            if (unvisited.length > 0) {
                Cell next = unvisited[random.nextInt(unvisited.length)];
                removeWalls(curr, next);
                next.visited = true;
                stack.push(next);
            } else {
                stack.pop();//nothing to visit backtrack and look for neighbours
            }

        }
    }
    //dfs maze generation, neighbour checking
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


    //neighbour checking for bfs walls
    public Cell[] getOpenUnvisitedNeighbors(Cell cell) {
        int r = cell.row;
        int col = cell.col;
        Cell[] potentialNeighbours = new Cell[4];
        int count = 0;

        //North
        if (!cell.top) {
            Cell north = getCell(r - 1, col);
            if (north != null && !north.bottom && !north.visited) {
                potentialNeighbours[count++] = north;
            }
        }
        //South
        if (!cell.bottom) {
            Cell south = getCell(r, col + 1);
            if (south != null && !south.bottom && !south.visited) {
                potentialNeighbours[count++] = south;
            }
        }
        //West
        if (!cell.left) {
            Cell west = getCell(r, col - 1);
            if (west != null && !west.bottom && !west.visited) {
                potentialNeighbours[count++] = west;
            }
        }
        //East
        if (!cell.right) {
            Cell east = getCell(r, col + 1);
            if (east != null && !east.bottom && !east.visited) {
                potentialNeighbours[count++] = east;
            }
        }

        Cell[] openUnvisitedNeighbours = new Cell[count];
        for (int i = 0; i < count; i++) {
            openUnvisitedNeighbours[i] = potentialNeighbours[i];
        }
        return openUnvisitedNeighbours;
    }

    public void removeWalls(Cell curr, Cell neighbour) {
        int rowDiff = curr.row - neighbour.row;
        int colDiff = curr.col - neighbour.col;

        //check north
        if (rowDiff == 1 && colDiff == 0) {
            curr.top = false;
            neighbour.bottom = false;
        }
        //south
        else if (rowDiff == -1 && colDiff == 0) {
            curr.bottom = false;
            neighbour.top = false;
        }
        //West
        else if (rowDiff == 0 && colDiff == 1) {
            curr.left = false;
            neighbour.right = false;
        }
        //East
        else if (rowDiff == 0 && colDiff == -1){
            curr.right = false;
            neighbour.left = false;
        }
    }

}
