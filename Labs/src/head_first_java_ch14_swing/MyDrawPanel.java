package head_first_java_ch14_swing;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class MyDrawPanel extends JPanel {
    private final Image image;

    public MyDrawPanel() {
        URL imgUrl = getClass().getResource("./resources/ashPokemon.png");
        System.out.println("imgUrl = " + imgUrl);
        this.image = (imgUrl != null) ? new ImageIcon(imgUrl).getImage() : null;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0,0, getWidth(), getHeight(), this);
        }
    }
}
