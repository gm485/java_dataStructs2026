package project_testing;

import javax.swing.*;
import java.awt.*;

public class MazePanel extends JPanel {

    private final Grid grid;
    private final int cellSize;
    private Cell[] path = new Cell[0];

    public MazePanel(Grid grid, int cellSize) {
        this. grid = grid;
        this.cellSize = cellSize;
        int width = grid.getCols() * cellSize + 2;
        int height = grid.getRows() * cellSize + 2;
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.WHITE);
    }

    public void setPath(Cell[] path) {
        this.path = (path != null) ? path : new Cell[0];
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(2f));

        for (int r = 0; r < grid.getRows(); r++) {
            for (int c = 0; c < grid.getCols(); c++) {
                Cell cell = grid.getCell(r, c);
                if (cell == null) {
                    continue;
                }

                int x = c * cellSize;
                int y = r * cellSize;

                if (cell.top) {
                    g2.drawLine(x, y, x + cellSize, y);
                }
                if (cell.bottom) {
                    g2.drawLine(x, y + cellSize, x + cellSize, y + cellSize);
                }
                if (cell.left) {
                    g2.drawLine(x, y, x, y + cellSize);
                }
                if (cell.right) {
                    g2.drawLine(x + cellSize, y, x + cellSize, y + cellSize);
                }
            }
        }

        if ( path != null && path.length > 1){
            g2.setColor(Color.RED);
            g2.setStroke(new BasicStroke(Math.max(2f, cellSize / 6f)));

            for (int i = 0; i < path.length - 1; i++) {
                Cell a = path[i];
                Cell b = path[i + 1];

                if (a != null && b != null) {
                    int x1 = a.col * cellSize + cellSize / 2;
                    int y1 = a.row * cellSize + cellSize / 2;
                    int x2 = b.col * cellSize + cellSize / 2;
                    int y2 = b.row * cellSize + cellSize / 2;
                    g2.drawLine(x1, y1, x2, y2);
                }
            }
        }
    }
}
