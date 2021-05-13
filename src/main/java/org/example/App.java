package org.example;

import org.example.gui.*;
import java.awt.EventQueue;
import javax.swing.*;

public class App {
	
    public static void main( String[] args )
    {
    	//launches the application
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
    
}
