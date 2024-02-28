import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class assignment2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("RadioButtonDemo");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel();
        frame.add(label, BorderLayout.CENTER);

        String[] images = {"bird.jpg", "cat.jpg", "dog.jpg", "pig.jpg", "rabbit.jpg"};

        JRadioButton[] radioButtons = {
            new JRadioButton("Bird"),
            new JRadioButton("Cat"),
            new JRadioButton("Dog"),
            new JRadioButton("Pig"),
            new JRadioButton("Rabbit")
        };

        ButtonGroup buttonGroup = new ButtonGroup();

        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));

        for (int i = 0; i < radioButtons.length; i++) {
            int index = i;  // To use in inner class
            radioButtons[i].addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        label.setIcon(new ImageIcon(images[index]));
                    }
                }
            });

            buttonGroup.add(radioButtons[i]);
            radioPanel.add(radioButtons[i]);

            if (i == 0) {  // Select first by default and set image
                radioButtons[i].setSelected(true);
                label.setIcon(new ImageIcon(images[i]));
            }
        }

        frame.add(radioPanel, BorderLayout.WEST);
        frame.setVisible(true);
    }
}

