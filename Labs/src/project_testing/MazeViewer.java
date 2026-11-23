package project_testing;

import javax.swing.*;
import javax.swing.SwingUtilities;
import java.awt.*;

public class MazeViewer {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Grid grid = new Grid(40,40);
            MazePanel panel = new MazePanel(grid, 28);

            JButton solveButton = new JButton("Solve");
            solveButton.addActionListener(e -> {
                Cell start = grid.getCell(0, 0);
                Cell end = grid.getCell(grid.getRows() -1, grid.getCols() -1);
                Cell[] path = grid.solveBFS(start, end);
                panel.setPath(path);
            });

            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            frame.add(panel, BorderLayout.CENTER);
            frame.add(solveButton, BorderLayout.SOUTH);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            System.out.println("All cells visited " + grid.isAllVisited());
            //get random cell and show neighbours

        });
    }
}
