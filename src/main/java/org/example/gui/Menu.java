package org.example.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JMenuBar implements ActionListener{

    public JMenu menuDBConnection = null;
    private JMenuItem dbTestConnectionItem = null;
    private JMenu menuHelp = null;
    private JMenuItem helpItem = null;
    private JMenu menuExit = null;
    private JMenuItem exitItem = null;

    public Menu() {
        showMenu();
    }

    public void showMenu() {

        //Under connection menu
        menuDBConnection = new JMenu("DB connection");

        dbTestConnectionItem = new JMenuItem("Test database connection");
        dbTestConnectionItem.addActionListener( this);

        menuDBConnection.add(dbTestConnectionItem);

        //Under Help menu
        menuHelp = new JMenu("Help");

        helpItem = new JMenuItem("Aboute the application");
        helpItem.addActionListener( this);

        menuHelp.add(helpItem);

        //Under exit menu
        menuExit = new JMenu("Exit");

        exitItem = new JMenuItem("Close the application");
        exitItem.addActionListener( this);

        menuExit.add(exitItem);

        this.add(menuDBConnection);
        this.add(menuHelp);
        this.add(menuExit);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
