package project_testing;

import javax.swing.*;
import java.awt.*;

public class MazePanel extends JPanel {

    private final Grid grid;
    private final int cellSize;

    public MazePanel(Grid grid, int cellSize) {
        this. grid = grid;
        this.cellSize = cellSize;
        int width = grid.getCols() * cellSize + 2;
        int height = grid.getRows() * cellSize + 2;
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.WHITE);
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
    }
}
