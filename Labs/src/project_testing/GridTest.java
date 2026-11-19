package project_testing;

public class GridTest {
    public static void main(String[] args) {
        Grid grid = new Grid(10, 10);

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

        //testing of random neighbour test
        Cell randomCell = grid.getCell(5,3);
        Cell[] randomNeighbourTest = grid.getUnvisitedNeighbors(randomCell);
        Cell chosen = grid.removeWalls(randomCell, randomNeighbourTest);
        System.out.println("chosen neighbour" + chosen);
        //return neighbours of the chosen cell


    }
}
