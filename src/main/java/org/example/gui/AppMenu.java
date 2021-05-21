package org.example.gui;

import org.example.database.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.SQLException;
import java.util.Scanner;

public class AppMenu extends JMenuBar {
	private int employeeNumber;
	private String lastName;
	private String firstName;
	private String extension;
	private String email;
	private String officeCode;
	private int reportsTo;
	private String jobTitle;

	DatabaseConnection db = new DatabaseConnection();

	final JFileChooser fileChooser = new JFileChooser();
	private Font primaryFont = new Font("Calibri", Font.PLAIN, 40);

	JMenuBar appMenu = new JMenuBar();


	public AppMenu() {
		//MENU BAR


		appMenu.setBorderPainted(false);

		//FILE MENU
		JMenu fileMenu = new JMenu("File");
		appMenu.add(fileMenu);


		//BULK IMPORT FILE MENU ITEM
		JMenuItem bulkImportItem = new JMenuItem("Bulk import from file...");
		bulkImportItem.setHorizontalAlignment(SwingConstants.LEFT);
		fileMenu.add(bulkImportItem);
		bulkImportItem.setToolTipText("Bulk import requires each insert to be on the same line with spaces between each value");
		bulkImportItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bulkImport();
			}
		});




		//DATABASE MENU
		JMenu databaseMenu = new JMenu("Database");
		databaseMenu.setHorizontalAlignment(SwingConstants.LEFT);
		appMenu.add(databaseMenu);

		//TEST CONNECTION DATABASE MENU ITEM
		JMenuItem dbTestConnectionItem = new JMenuItem("Test database connection");
		dbTestConnectionItem.setHorizontalAlignment(SwingConstants.LEFT);
		databaseMenu.add(dbTestConnectionItem);
		dbTestConnectionItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					db.open();
					db.close();
					displayMessage("You are connected to the database. \n");
				} catch (Exception err) {
					displayMessage("Connection failed. Error: " + err.getMessage());
				}
			}
		});

		//HELP MENU
		JMenu helpMenu = new JMenu("Help");
		appMenu.add(helpMenu);

		//ABOUT HELP MENU ITEM
		JMenuItem aboutItem = new JMenuItem("About the application");
		aboutItem.setHorizontalAlignment(SwingConstants.LEFT);
		helpMenu.add(aboutItem);
		aboutItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayMessage("In this application you can perform CRUD operations");
			}
		});

		//EXIT MENU
		JMenu exitMenu = new JMenu("Exit");
		appMenu.add(exitMenu);

		//EXIT APPLICATION EXIT MENU ITEM
		JMenuItem exitItem = new JMenuItem("Exit the application");
		exitItem.setHorizontalAlignment(SwingConstants.LEFT);
		exitMenu.add(exitItem);
		exitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

 

	private void displayMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
	
	private void bulkImport() {
		JFileChooser jfc = new JFileChooser(".");
		jfc.setDialogTitle("Specify a file to import");
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		int response = jfc.showSaveDialog(null);

		if (response == JFileChooser.APPROVE_OPTION) {
			File file = jfc.getSelectedFile();
			
			try {
				BufferedReader lineReader = new BufferedReader(new FileReader(file));
				/*Scanner fileIn = new Scanner(file);*/
		        Scanner scan = new Scanner(file);
		        
		        if(file.isFile()) {
		        while(scan.hasNext()) {
		        	String line = scan.nextLine(); // "Read" your file (one line at a time).
		          
		            String[] words = line.split(", "); // Parse what you read.
		        
		            
		            int employeeNumber = Integer.parseInt(words[0]);		        
		            String lastName = words[1];
		            String firstName = words[2];
		            String extension = words[3];
		            String email = words[4];
		            String officeCode = words[5];
		            int reportsTo = Integer.parseInt(words[6]);
		            String jobTitle = words[7];
		            db.addEmployeeBulk(employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle);

		        }

		        }else {
					System.out.println("Not a file");
				}
				/*fileIn.close();*/
			} catch (FileNotFoundException err1) {
				System.out.println("Filen eksisterer ikke");
			} catch (NumberFormatException numberFormatException) {
				numberFormatException.printStackTrace();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
	}

}
