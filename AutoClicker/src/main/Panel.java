package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Panel extends JPanel {

    final int screenWidth = 255;
    final int screenHeight = 350;

    boolean isClicking = false;

    Robot robot = new Robot();

    JButton toggleButton = new JButton("Toggle AutoClicker");

    public Panel() throws AWTException {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.add(toggleButton);
        this.setLayout(null);
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();

                switch (keyCode) {
                    case KeyEvent.VK_G:
                        if (!isClicking) {
                            toggleButton.setText("AutoClicker: ON");
                            startAutoClick();
                        }
                        else {
                            toggleButton.setText("AutoClicker: OFF");
                            stopAutoClicking();
                        }
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        toggleButton.setVisible(true);
        toggleButton.setBounds(50,100,150,75);
        toggleButton.setFocusable(false);

        toggleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!isClicking) {
                    startAutoClick();
                    toggleButton.setText("AutoClicker: ON");
                }
                else {
                    stopAutoClicking();
                    toggleButton.setText("AutoClicker: OFF");
                }
            }
        });
    }

    void startAutoClick() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                isClicking = true;
                performAutoClicking();
            }
        });
        thread.start();
    }

    void stopAutoClicking() {
        isClicking = false;
    }

    void performAutoClicking() {
        while (isClicking) {
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.delay(10);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
            robot.delay(10);
        }
    }
}
