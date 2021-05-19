package org.example.gui;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

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
    	//add content to main frame and tabbed pane
        tabbedPane.add("EMPLOYEES", employeeTab);
        tabbedPane.add("ORDERS", orderTab);
        tabbedPane.add("OFFICES", officesTab);
        frame.setJMenuBar(menu.appMenu);
        frame.getContentPane().add(tabbedPane);
        frame.setTitle("DB-ADMIN V3.0");
        
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(860, 550);
        frame.pack(); //squishes everything together
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}
