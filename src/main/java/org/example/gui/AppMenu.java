package org.example.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class AppMenu extends JMenuBar {
	
	JMenuBar appMenu = new JMenuBar();
	
	public AppMenu(){
		//MENU BAR
				
				appMenu.setBorderPainted(false);

				//FILE MENU
				JMenu fileMenu = new JMenu("File");
				appMenu.add(fileMenu);

				//SAVE TO FILE FILE MENU ITEM
				JMenuItem saveToFileItem = new JMenuItem("Save to file");
				saveToFileItem.setHorizontalAlignment(SwingConstants.LEFT);
				fileMenu.add(saveToFileItem);

				//BULK IMPORT FILE MENU ITEM
				JMenuItem bulkImportItem = new JMenuItem("Bulk import from file...");
				bulkImportItem.setHorizontalAlignment(SwingConstants.LEFT);
				fileMenu.add(bulkImportItem);

				//DATABASE MENU
				JMenu databaseMenu = new JMenu("Database");
				databaseMenu.setHorizontalAlignment(SwingConstants.LEFT);
				appMenu.add(databaseMenu);

				//TEST CONNECTION DATABASE MENU ITEM
				JMenuItem dbTestConnectionItem = new JMenuItem("Test database connection");
				dbTestConnectionItem.setHorizontalAlignment(SwingConstants.LEFT);
				databaseMenu.add(dbTestConnectionItem);

				//HELP MENU
				JMenu helpMenu = new JMenu("Help");
				appMenu.add(helpMenu);

				//ABOUT HELP MENU ITEM
				JMenuItem aboutItem = new JMenuItem("About the application");
				aboutItem.setHorizontalAlignment(SwingConstants.LEFT);
				helpMenu.add(aboutItem);
				/*aboutItem.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						consoleTextArea.setText("Hei på deg");
					}
				});*/

				//EXIT MENU
				JMenu exitMenu = new JMenu("Exit");
				appMenu.add(exitMenu);

				//EXIT APPLICATION EXIT MENU ITEM
				JMenuItem exitItem = new JMenuItem("Exit the application");
				exitItem.setHorizontalAlignment(SwingConstants.LEFT);
				exitMenu.add(exitItem);
				
				
	}

}
