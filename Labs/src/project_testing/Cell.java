package project_testing;
import java.util.Random;

public class Cell {

    public char element;
    public boolean visited;
    public Cell parent;
    //coordinate in the actual grid
    int row;
    int col;
    public boolean left, right, top, bottom;


    public Cell(int r, int c) {
        this.visited = false;
        this.row = r;
        this.col = c;
        this.left = this.right = this.top = this.bottom = true;

        //generate random number
        Random rand = new Random();
        this.element = (char) ('A' + rand.nextInt(26));
    }
}
