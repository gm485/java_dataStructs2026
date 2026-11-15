package project_testing;

public class Grid {

    Cell [][] grid;


    public Grid() {
        //default constructor
        this.grid = new Cell[10][10];
        generateGrid();
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
    public Cell getCell(int r, int c) {
        return this.grid[r][c];
    }


}
