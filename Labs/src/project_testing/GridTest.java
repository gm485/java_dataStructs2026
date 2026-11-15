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
    }
}
