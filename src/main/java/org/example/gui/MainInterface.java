package org.example.gui;

import javax.swing.*;
import java.awt.*;

public class MainInterface extends JFrame {
    private org.example.gui.Update update= new org.example.gui.Update();
    public MainInterface() {
        setSize(400, 500);
        setLocationRelativeTo(null);
        setLayout(new GridLayout());

        add(update);

        setVisible(true);
    }
}
