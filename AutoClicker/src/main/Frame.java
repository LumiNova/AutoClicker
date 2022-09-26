package main;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public Frame() throws AWTException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        this.setTitle("FUCKING OP AC");

        Panel panel = new Panel();
        this.add(panel);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
