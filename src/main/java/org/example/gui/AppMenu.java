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

		//SAVE TO FILE FILE MENU ITEM
		JMenuItem saveToFileItem = new JMenuItem("Save to file");
		saveToFileItem.setHorizontalAlignment(SwingConstants.LEFT);
		fileMenu.add(saveToFileItem);


		//BULK IMPORT FILE MENU ITEM
		JMenuItem bulkImportItem = new JMenuItem("Bulk import from file...");
		bulkImportItem.setHorizontalAlignment(SwingConstants.LEFT);
		fileMenu.add(bulkImportItem);
		bulkImportItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser(".");
				jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

				int response = jfc.showSaveDialog(null);

				if (response == JFileChooser.APPROVE_OPTION) {
					File file = jfc.getSelectedFile();

					try {
						Scanner fileIn = new Scanner(file);
						if (file.isFile()) {

							while (fileIn.hasNextLine()) {
								String line = fileIn.nextLine();
								//System.out.println(line);
								try (Scanner data = new Scanner(line)) {
											/*while(!data.hasNextInt()) {
												employeeNumber += data.nextInt() + " ";
											}
											employeeNumber = employeeNumber.trim();*/

									if (data.hasNextInt()) {
										employeeNumber = data.nextInt();
									}


									if (data.hasNextLine()) {
										lastName = data.next();
									}
									if (data.hasNextLine()) {
										firstName = data.next();
									}
									if (data.hasNextLine()) {
										extension = data.next();
									}
									if (data.hasNextLine()) {
										email = data.next();
									}
									if (data.hasNextLine()) {
										officeCode = data.next();
									}
									if (data.hasNextInt()) {
										reportsTo = data.nextInt();
									}
									if (data.hasNextLine()) {
										jobTitle = data.next();
									}
								}
								db.addEmployee(employeeNumber, firstName, lastName, extension, email, officeCode, reportsTo, jobTitle);

							}
						} else {
							System.out.println("Not a file");
						}
						fileIn.close();
					} catch (FileNotFoundException err1) {
						System.out.println("Filen eksisterer ikke");
					} catch (NumberFormatException numberFormatException) {
						numberFormatException.printStackTrace();
					} catch (SQLException throwables) {
						throwables.printStackTrace();
					}
				}
			}
		});

		//INFO MENU ITEM
		JMenuItem infoItem = new JMenuItem("Info");
		infoItem.setHorizontalAlignment(SwingConstants.LEFT);
		infoItem.setToolTipText("hdjhjdhf");
		fileMenu.add(infoItem);


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

}
