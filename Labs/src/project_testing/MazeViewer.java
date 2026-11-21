package project_testing;

import javax.swing.*;
import javax.swing.SwingUtilities;
public class MazeViewer {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Grid grid = new Grid(3,3);
            MazePanel panel = new MazePanel(grid, 28);

            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(panel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            System.out.println("All cells visited " + grid.isAllVisited());
            //get random cell and show neighbours

        });
    }
}
