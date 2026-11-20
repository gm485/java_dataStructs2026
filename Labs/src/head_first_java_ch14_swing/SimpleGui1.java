package head_first_java_ch14_swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGui1 implements ActionListener {

    private JButton button;

    public static void main(String[] args) {
        SimpleGui1 simpleGui1 = new SimpleGui1();
        simpleGui1.setupDisplayFrame();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        button.setText("I've been clicked");

    }

    public void buttomMsg(JButton button) {
        button.setText("I've been clicked");
    }
    public void setupDisplayFrame() {
        button = new JButton("Click Me");
        JFrame frame = new JFrame();
        /*
        MyDrawPanel panel = new MyDrawPanel();
         */
        MyCirclePanel circlePanel = new MyCirclePanel();

        button.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(button, BorderLayout.SOUTH);
        frame.getContentPane().add(circlePanel, BorderLayout.CENTER);

        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

   }
