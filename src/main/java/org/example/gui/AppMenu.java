package org.example.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AppMenu extends JMenuBar {
	final JFileChooser fileChooser = new JFileChooser();
	private Font primaryFont = new Font("Calibri", Font.PLAIN, 40);

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
				/*saveToFileItem.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
						fileChooser.setDialogTitle("Specify a file to save");

						//Set default folder
						fileChooser.setCurrentDirectory(new File("c:\\temp"));

						//Just allow .txt
						FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "txt", "text");
						fileChooser.setFileFilter(filter);

						int returnVal = fileChooser.showSaveDialog(null);

						if (returnVal == JFileChooser.APPROVE_OPTION) {
							File fileToSave = fileChooser.getSelectedFile();

							try {
								writeToFile(databaseTextArea.getText(), fileToSave);
								consoleTextArea.setText("Succesfull when saving the Database");
							}catch (IOException e1) {
								consoleTextArea.setText("Error writing into file");
							}
						}
					}
				});*/


		//BULK IMPORT FILE MENU ITEM
				JMenuItem bulkImportItem = new JMenuItem("Bulk import from file...");
				bulkImportItem.setHorizontalAlignment(SwingConstants.LEFT);
				fileMenu.add(bulkImportItem);
				/*bulkImportItem.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JFileChooser jfc = new JFileChooser(".");
						jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

						int response = jfc.showSaveDialog(null);

						if (response ==JFileChooser.APPROVE_OPTION) {
							File file = jfc.getSelectedFile();

							try {
								Scanner fileIn = new Scanner(file);
								if (file.isFile()) {

									while(fileIn.hasNextLine()) {
										String line = fileIn.nextLine();
										saveData();
										System.out.println(line);
									}
								}
								else {
									System.out.println("Not a file");
								}
								fileIn.close();
							} catch (FileNotFoundException | SQLException fileNotFoundException) {
								System.out.println("Filen eksisterer ikke");
							}catch (NumberFormatException numberFormatException) {
								numberFormatException.printStackTrace();
							}
						}
					}
				});*/

				//DATABASE MENU
				JMenu databaseMenu = new JMenu("Database");
				databaseMenu.setHorizontalAlignment(SwingConstants.LEFT);
				appMenu.add(databaseMenu);

				//TEST CONNECTION DATABASE MENU ITEM
				JMenuItem dbTestConnectionItem = new JMenuItem("Test database connection");
				dbTestConnectionItem.setHorizontalAlignment(SwingConstants.LEFT);
				databaseMenu.add(dbTestConnectionItem);
				/*dbTestConnectionItem.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							databaseConnection.open();
							databaseConnection.close();
							consoleTextArea.append("Connected to database. \n");
						} catch (Exception err) {
							throwableElement.printStackTrace(new PrintWriter(stackTraceWriter));
							consoleTextArea.append("Connection failed. Error: " +
									throwableElement.toString() + "\n"
									+ stackTraceWriter.toString());
						}
					}
				});*/

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
						displayMessage("About the application");
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

	

	public void writeToFile(String text, File file) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		writer.write(text);
		writer.close();
	}

	private void displayMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
}
