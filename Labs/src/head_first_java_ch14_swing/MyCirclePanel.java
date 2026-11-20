package head_first_java_ch14_swing;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MyCirclePanel extends JPanel {

    public void paintComponent(Graphics g) {
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        Random rand = new Random();
        int red = rand.nextInt(255);
        int green = rand.nextInt(255);
        int blue = rand.nextInt(255);

        Color randomColor = new Color(red, green, blue);
        g.setColor(randomColor);
        g.fillOval(70,40,100,100);
    }

}
