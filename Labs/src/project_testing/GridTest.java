package project_testing;

public class GridTest {
    static void main() {
        Grid grid = new Grid();

        System.out.println("--Maze grid test:");

        //loop grid
        for (int r = 0; r< grid.getRows(); r++) {
            for(int c = 0; c<grid.getCols(); c++) {
                Cell currentCell = grid.getCell(r, c);

                System.out.print("[" + currentCell.element + "]");
            }
            System.out.println();
        }


        //test for neighours
        Cell corner  = grid.getCell(0,0);
        Cell[] cornerNeighbours = grid.getUnvisitedNeighbors(corner);
        System.out.println("testing for corner cell (0, 0)");
        System.out.println("expected neighbour count = 2");
        System.out.println("actual neighbour count = " + cornerNeighbours.length);
        for (Cell n : cornerNeighbours) {
            System.out.println("-> Found unvisited neighbour at:" + n.row + ", " + n.col);
        }
    }
}
