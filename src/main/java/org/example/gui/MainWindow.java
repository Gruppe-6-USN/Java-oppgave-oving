package org.example.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;

public class MainWindow {
	
	//making the main frame
    JFrame frame = new JFrame();
    
    //importing tabs
    JTabbedPane tabbedPane = new JTabbedPane();
    EmployeeTab employeeTab = new EmployeeTab();
    OrderTab orderTab = new OrderTab();
    OfficesTab officesTab = new OfficesTab();
    
    //importing menu
    AppMenu menu = new AppMenu();

    public MainWindow() {
        frame.setJMenuBar(menu.appMenu);
        frame.getContentPane().setLayout(new MigLayout("", "[800px]", "[550px]"));
        //add content to main frame and tabbed pane
        tabbedPane.add("EMPLOYEES", employeeTab);
        tabbedPane.add("ORDERS", orderTab);
        tabbedPane.add("OFFICES", officesTab);
        frame.getContentPane().add(tabbedPane, "cell 0 0,alignx left,aligny top");
        frame.setTitle("DB-ADMIN V3.0");
      
        
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 750);
        frame.pack(); //squishes everything together
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}
