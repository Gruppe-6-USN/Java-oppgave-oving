package org.example.gui;

import java.awt.Component;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.example.gui.exceptions.MissingTextFieldException;
import org.example.database.*;

import javax.swing.JTabbedPane;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class OfficesTab extends JPanel {

	DatabaseConnection db = new DatabaseConnection();
	java.util.HashSet unique = new HashSet();
	JFileChooser fileChooser = new JFileChooser();
	
	private final JPanel employeeTab = new JPanel();
	private JPanel updateOfficePanel;
	private JLabel updateCountryLabel;
	private JLabel updatePostalCodeLabel;
	private JTextField updateCountryTextField;
	private JTextField updatePostalCodeTextField;
	private JButton updateOfficeBtn;
	private JPanel OfficeDbView;
	private JTextArea databaseTextArea;
	private JButton refreshDatabaseTextAreaBtn;
	private JPanel OfficeConsolePanel;
	private JTextArea officeConsoleTextArea;
	private JButton clearConsoleBtn;
	private JLabel updateTerritoryLabel;
	private JTextField updateTerritorytextField;
	private JLabel updateOfficeCodeLabel_1;
	private JLabel updateStateLabel_1;
	private JComboBox officeCodeComboBox;
	private JLabel updateAptNumberLabel_1;
	private JLabel updateStreetAdressLabel_1;
	private JLabel updatePhoneLabel_1;
	private JLabel updateCityLabel;
	private JTextField updateStateTextField;
	private JTextField updateAptTextField;
	private JTextField updateStreetAddressTextField;
	private JTextField updatePhoneTextField;
	private JTextField updateCityTextField;
	private JButton saveOfficeBtn;
	
	public OfficesTab() {
		
		GridBagLayout gbl_employeeTab = new GridBagLayout();
        gbl_employeeTab.columnWidths = new int[] {80, 80, 80, 80, 80, 80, 80, 80, 80, 80};
        gbl_employeeTab.rowHeights = new int[] {60, 60, 60, 60, 60, 60, 60, 60, 60, 60};
        gbl_employeeTab.columnWeights = new double[]{1.0};
        gbl_employeeTab.rowWeights = new double[]{Double.MIN_VALUE};
        employeeTab.setLayout(gbl_employeeTab);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {350, 266};
		gridBagLayout.rowHeights = new int[] {130, 130, 228};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		updateOfficePanel = new JPanel();
		updateOfficePanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Update office:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_updateOfficePanel = new GridBagConstraints();
		gbc_updateOfficePanel.gridheight = 2;
		gbc_updateOfficePanel.insets = new Insets(0, 0, 5, 5);
		gbc_updateOfficePanel.fill = GridBagConstraints.BOTH;
		gbc_updateOfficePanel.gridx = 0;
		gbc_updateOfficePanel.gridy = 0;
		add(updateOfficePanel, gbc_updateOfficePanel);
		GridBagLayout gbl_updateOfficePanel = new GridBagLayout();
		gbl_updateOfficePanel.columnWidths = new int[] {95, 112, 0};
		gbl_updateOfficePanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_updateOfficePanel.columnWeights = new double[]{1.0, 1.0, 0.0};
		gbl_updateOfficePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		updateOfficePanel.setLayout(gbl_updateOfficePanel);
		
		updateOfficeCodeLabel_1 = new JLabel("Office code: ");
		GridBagConstraints gbc_updateOfficeCodeLabel_1 = new GridBagConstraints();
		gbc_updateOfficeCodeLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_updateOfficeCodeLabel_1.anchor = GridBagConstraints.EAST;
		gbc_updateOfficeCodeLabel_1.gridx = 0;
		gbc_updateOfficeCodeLabel_1.gridy = 0;
		updateOfficePanel.add(updateOfficeCodeLabel_1, gbc_updateOfficeCodeLabel_1);
		
		officeCodeComboBox = new JComboBox();
		GridBagConstraints gbc_officeCodeComboBox = new GridBagConstraints();
		gbc_officeCodeComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_officeCodeComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_officeCodeComboBox.gridx = 1;
		gbc_officeCodeComboBox.gridy = 0;
		updateOfficePanel.add(officeCodeComboBox, gbc_officeCodeComboBox);
		
		updateCityLabel = new JLabel("City:");
		GridBagConstraints gbc_updateCityLabel = new GridBagConstraints();
		gbc_updateCityLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updateCityLabel.anchor = GridBagConstraints.EAST;
		gbc_updateCityLabel.gridx = 0;
		gbc_updateCityLabel.gridy = 1;
		updateOfficePanel.add(updateCityLabel, gbc_updateCityLabel);
		
		updateCityTextField = new JTextField();
		updateCityTextField.setColumns(10);
		GridBagConstraints gbc_updateCityTextField = new GridBagConstraints();
		gbc_updateCityTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateCityTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateCityTextField.gridx = 1;
		gbc_updateCityTextField.gridy = 1;
		updateOfficePanel.add(updateCityTextField, gbc_updateCityTextField);
		
		updatePhoneLabel_1 = new JLabel("Phone:");
		GridBagConstraints gbc_updatePhoneLabel_1 = new GridBagConstraints();
		gbc_updatePhoneLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_updatePhoneLabel_1.anchor = GridBagConstraints.EAST;
		gbc_updatePhoneLabel_1.gridx = 0;
		gbc_updatePhoneLabel_1.gridy = 2;
		updateOfficePanel.add(updatePhoneLabel_1, gbc_updatePhoneLabel_1);
		
		updatePhoneTextField = new JTextField();
		updatePhoneTextField.setColumns(10);
		GridBagConstraints gbc_updatePhoneTextField = new GridBagConstraints();
		gbc_updatePhoneTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updatePhoneTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updatePhoneTextField.gridx = 1;
		gbc_updatePhoneTextField.gridy = 2;
		updateOfficePanel.add(updatePhoneTextField, gbc_updatePhoneTextField);
		
		updateStreetAdressLabel_1 = new JLabel("Street address:");
		GridBagConstraints gbc_updateStreetAdressLabel_1 = new GridBagConstraints();
		gbc_updateStreetAdressLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_updateStreetAdressLabel_1.anchor = GridBagConstraints.EAST;
		gbc_updateStreetAdressLabel_1.gridx = 0;
		gbc_updateStreetAdressLabel_1.gridy = 3;
		updateOfficePanel.add(updateStreetAdressLabel_1, gbc_updateStreetAdressLabel_1);
		
		updateStreetAddressTextField = new JTextField();
		updateStreetAddressTextField.setColumns(10);
		GridBagConstraints gbc_updateStreetAddressTextField = new GridBagConstraints();
		gbc_updateStreetAddressTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateStreetAddressTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateStreetAddressTextField.gridx = 1;
		gbc_updateStreetAddressTextField.gridy = 3;
		updateOfficePanel.add(updateStreetAddressTextField, gbc_updateStreetAddressTextField);
		
		updateAptNumberLabel_1 = new JLabel("Apt number:");
		GridBagConstraints gbc_updateAptNumberLabel_1 = new GridBagConstraints();
		gbc_updateAptNumberLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_updateAptNumberLabel_1.anchor = GridBagConstraints.EAST;
		gbc_updateAptNumberLabel_1.gridx = 0;
		gbc_updateAptNumberLabel_1.gridy = 4;
		updateOfficePanel.add(updateAptNumberLabel_1, gbc_updateAptNumberLabel_1);
		
		updateAptTextField = new JTextField();
		updateAptTextField.setColumns(10);
		GridBagConstraints gbc_updateAptTextField = new GridBagConstraints();
		gbc_updateAptTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateAptTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateAptTextField.gridx = 1;
		gbc_updateAptTextField.gridy = 4;
		updateOfficePanel.add(updateAptTextField, gbc_updateAptTextField);
		
		updateStateLabel_1 = new JLabel("State:");
		GridBagConstraints gbc_updateStateLabel_1 = new GridBagConstraints();
		gbc_updateStateLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_updateStateLabel_1.anchor = GridBagConstraints.EAST;
		gbc_updateStateLabel_1.gridx = 0;
		gbc_updateStateLabel_1.gridy = 5;
		updateOfficePanel.add(updateStateLabel_1, gbc_updateStateLabel_1);
		
		updateStateTextField = new JTextField();
		updateStateTextField.setColumns(10);
		GridBagConstraints gbc_updateStateTextField = new GridBagConstraints();
		gbc_updateStateTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateStateTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateStateTextField.gridx = 1;
		gbc_updateStateTextField.gridy = 5;
		updateOfficePanel.add(updateStateTextField, gbc_updateStateTextField);
		
		updateCountryLabel = new JLabel("Country:");
		GridBagConstraints gbc_updateCountryLabel = new GridBagConstraints();
		gbc_updateCountryLabel.anchor = GridBagConstraints.EAST;
		gbc_updateCountryLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updateCountryLabel.gridx = 0;
		gbc_updateCountryLabel.gridy = 6;
		updateOfficePanel.add(updateCountryLabel, gbc_updateCountryLabel);
		
		updateCountryTextField = new JTextField();
		updateCountryTextField.setColumns(10);
		GridBagConstraints gbc_updateCountryTextField = new GridBagConstraints();
		gbc_updateCountryTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateCountryTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateCountryTextField.gridx = 1;
		gbc_updateCountryTextField.gridy = 6;
		updateOfficePanel.add(updateCountryTextField, gbc_updateCountryTextField);
		
		updatePostalCodeLabel = new JLabel("Postal Code:");
		GridBagConstraints gbc_updatePostalCodeLabel = new GridBagConstraints();
		gbc_updatePostalCodeLabel.anchor = GridBagConstraints.EAST;
		gbc_updatePostalCodeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updatePostalCodeLabel.gridx = 0;
		gbc_updatePostalCodeLabel.gridy = 7;
		updateOfficePanel.add(updatePostalCodeLabel, gbc_updatePostalCodeLabel);
		
		updatePostalCodeTextField = new JTextField();
		updatePostalCodeTextField.setColumns(10);
		GridBagConstraints gbc_updatePostalCodeTextField = new GridBagConstraints();
		gbc_updatePostalCodeTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updatePostalCodeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updatePostalCodeTextField.gridx = 1;
		gbc_updatePostalCodeTextField.gridy = 7;
		updateOfficePanel.add(updatePostalCodeTextField, gbc_updatePostalCodeTextField);
		
		updateTerritoryLabel = new JLabel("Territory:");
		GridBagConstraints gbc_updateTerritoryLabel = new GridBagConstraints();
		gbc_updateTerritoryLabel.anchor = GridBagConstraints.EAST;
		gbc_updateTerritoryLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updateTerritoryLabel.gridx = 0;
		gbc_updateTerritoryLabel.gridy = 8;
		updateOfficePanel.add(updateTerritoryLabel, gbc_updateTerritoryLabel);
		
		updateTerritorytextField = new JTextField();
		updateTerritorytextField.setColumns(10);
		GridBagConstraints gbc_updateTerritorytextField = new GridBagConstraints();
		gbc_updateTerritorytextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateTerritorytextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateTerritorytextField.gridx = 1;
		gbc_updateTerritorytextField.gridy = 8;
		updateOfficePanel.add(updateTerritorytextField, gbc_updateTerritorytextField);
		
		updateOfficeBtn = new JButton("Uppdate office");
		GridBagConstraints gbc_updateOfficeBtn = new GridBagConstraints();
		gbc_updateOfficeBtn.insets = new Insets(0, 0, 0, 5);
		gbc_updateOfficeBtn.gridx = 1;
		gbc_updateOfficeBtn.gridy = 9;
		updateOfficePanel.add(updateOfficeBtn, gbc_updateOfficeBtn);
		
		OfficeDbView = new JPanel();
		OfficeDbView.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Office table view", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_OfficeDbView = new GridBagConstraints();
		gbc_OfficeDbView.gridheight = 2;
		gbc_OfficeDbView.fill = GridBagConstraints.BOTH;
		gbc_OfficeDbView.gridx = 1;
		gbc_OfficeDbView.gridy = 0;
		add(OfficeDbView, gbc_OfficeDbView);
		GridBagLayout gbl_OfficeDbView = new GridBagLayout();
		gbl_OfficeDbView.columnWidths = new int[] {41, 133, 0};
		gbl_OfficeDbView.rowHeights = new int[]{18, 0, 0, 0};
		gbl_OfficeDbView.columnWeights = new double[]{0.0, 1.0, 0.0};
		gbl_OfficeDbView.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		OfficeDbView.setLayout(gbl_OfficeDbView);
		
		databaseTextArea = new JTextArea();
		databaseTextArea.setForeground(Color.WHITE);
		databaseTextArea.setEditable(false);
		databaseTextArea.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_databaseTextArea = new GridBagConstraints();
		gbc_databaseTextArea.insets = new Insets(0, 0, 5, 0);
		gbc_databaseTextArea.fill = GridBagConstraints.BOTH;
		gbc_databaseTextArea.gridx = 0;
		gbc_databaseTextArea.gridy = 0;
		OfficeDbView.add(databaseTextArea, gbc_databaseTextArea);
		
		JScrollPane databaseScroll = new JScrollPane(databaseTextArea);
		databaseScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_databaseScroll = new GridBagConstraints();
		gbc_databaseScroll.gridheight = 2;
		gbc_databaseScroll.gridwidth = 3;
		gbc_databaseScroll.insets = new Insets(0, 0, 5, 0);
		gbc_databaseScroll.fill = GridBagConstraints.BOTH;
		gbc_databaseScroll.gridx = 0;
		gbc_databaseScroll.gridy = 0;
		OfficeDbView.add(databaseScroll, gbc_databaseScroll);
		
		refreshDatabaseTextAreaBtn = new JButton("Refresh view");
		GridBagConstraints gbc_refreshDatabaseTextAreaBtn = new GridBagConstraints();
		gbc_refreshDatabaseTextAreaBtn.insets = new Insets(0, 0, 0, 5);
		gbc_refreshDatabaseTextAreaBtn.gridx = 0;
		gbc_refreshDatabaseTextAreaBtn.gridy = 2;
		OfficeDbView.add(refreshDatabaseTextAreaBtn, gbc_refreshDatabaseTextAreaBtn);

		saveOfficeBtn = new JButton("Save to file");
		GridBagConstraints gbc_saveBtn = new GridBagConstraints();
		gbc_saveBtn.anchor = GridBagConstraints.WEST;
		gbc_saveBtn.insets = new Insets(0, 0, 0, 5);
		gbc_saveBtn.gridx = 1;
		gbc_saveBtn.gridy = 2;
		OfficeDbView.add(saveOfficeBtn, gbc_saveBtn);
		
		OfficeConsolePanel = new JPanel();
		OfficeConsolePanel.setBorder(new TitledBorder(null, "Console", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_OfficeConsolePanel = new GridBagConstraints();
		gbc_OfficeConsolePanel.gridwidth = 2;
		gbc_OfficeConsolePanel.insets = new Insets(0, 0, 0, 5);
		gbc_OfficeConsolePanel.fill = GridBagConstraints.BOTH;
		gbc_OfficeConsolePanel.gridx = 0;
		gbc_OfficeConsolePanel.gridy = 2;
		add(OfficeConsolePanel, gbc_OfficeConsolePanel);
		GridBagLayout gbl_OfficeConsolePanel = new GridBagLayout();
		gbl_OfficeConsolePanel.columnWidths = new int[]{0, 0};
		gbl_OfficeConsolePanel.rowHeights = new int[]{0, 0, 0};
		gbl_OfficeConsolePanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_OfficeConsolePanel.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		OfficeConsolePanel.setLayout(gbl_OfficeConsolePanel);
		
		officeConsoleTextArea = new JTextArea();
		officeConsoleTextArea.setForeground(Color.WHITE);
		officeConsoleTextArea.setEditable(false);
		officeConsoleTextArea.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_officeConsoleTextArea = new GridBagConstraints();
		gbc_officeConsoleTextArea.insets = new Insets(0, 0, 5, 0);
		gbc_officeConsoleTextArea.fill = GridBagConstraints.BOTH;
		gbc_officeConsoleTextArea.gridx = 0;
		gbc_officeConsoleTextArea.gridy = 0;
		OfficeConsolePanel.add(officeConsoleTextArea, gbc_officeConsoleTextArea);
		
		JScrollPane consoleScroll = new JScrollPane(officeConsoleTextArea);
		consoleScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_consoleScroll = new GridBagConstraints();
		gbc_consoleScroll.gridwidth = 3;
		gbc_consoleScroll.insets = new Insets(0, 0, 5, 0);
		gbc_consoleScroll.fill = GridBagConstraints.BOTH;
		gbc_consoleScroll.gridx = 0;
		gbc_consoleScroll.gridy = 0;
		OfficeConsolePanel.add(consoleScroll, gbc_consoleScroll);
		
		clearConsoleBtn = new JButton("Clear console");
		GridBagConstraints gbc_clearConsoleBtn = new GridBagConstraints();
		gbc_clearConsoleBtn.anchor = GridBagConstraints.WEST;
		gbc_clearConsoleBtn.gridx = 0;
		gbc_clearConsoleBtn.gridy = 1;
		OfficeConsolePanel.add(clearConsoleBtn, gbc_clearConsoleBtn);
		//DELETE BUTTON
		JButton deleteBtn = new JButton("Delete");
		GridBagConstraints gbc_deleteBtn = new GridBagConstraints();
		gbc_deleteBtn.insets = new Insets(0, 0, 5, 5);
		gbc_deleteBtn.gridx = 1;
		gbc_deleteBtn.gridy = 2;
		employeeTab.add(deleteBtn, gbc_deleteBtn);
		deleteBtn.setToolTipText("Delete an employee from the database");
		setVisible(true);
		
		//-------FUNCTIONS TO RUN AT STARTUP------//
		
		//functions that refreshes the combobox values and the database view
		refreshDatabaseTextArea();
		refreshOfficeCodeComboBox();
		
		//----------------ACTION EVENT LISTENERS--------------------//
		// + try catch blocks to fetch data without event listeners
		
		//CLEAR CONSOLE BUTTON EVENT
		clearConsoleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				officeConsoleTextArea.setText("");
			}
		});
		
		//REFRESH DB BUTTON - shows updated count of all employees in database text area and refreshes job title JComboBox
        refreshDatabaseTextAreaBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent refreshDb) {
					refreshDatabaseTextArea();
			}
        });
		
				// UPDATE OFFICE BUTTON EVENT
				updateOfficeBtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
														
							String officeCode = getOfficeCode();
							String city = getCity();
							String phone = getPhone();
							String addressLine1 = getAddressLine1();
							String addressLine2 = getAddressLine2();
							String state = getState();
							String country = getCountry();
							String postalCode = getPostalCode();
							String territory = getTerritory();
							
							if (officeCode.isEmpty() && city.isEmpty() && phone.isEmpty() && addressLine1.isEmpty() && addressLine2.isEmpty() && state.isEmpty() && country.isEmpty() && postalCode.isEmpty() && territory.isEmpty())
							{
								throw new MissingTextFieldException("you must fill out all the fields");
							} else if (officeCode.isEmpty())
								throw new MissingTextFieldException("OfficeCode must be a number");
							else if (city.isEmpty())
								throw new MissingTextFieldException("City is not present");
							else if (phone.isEmpty())
								throw new MissingTextFieldException("Phone is not present");
							else if (addressLine1.isEmpty())
								throw new MissingTextFieldException("Street address is not present");
							else if (addressLine2.isEmpty())
								throw new MissingTextFieldException("Apt number is not present");
							else if (state.isEmpty())
								throw new MissingTextFieldException("State is not present");
							else if (country.isEmpty())
								throw new MissingTextFieldException("Country is not present");
							else if (postalCode.isEmpty())
								throw new MissingTextFieldException("Postal Code is not present");
							else if (territory.isEmpty())
								throw new MissingTextFieldException("Territory is not present");

							db.updateOffice(officeCode, city, phone, addressLine1, addressLine2, state, country, postalCode, territory);
							officeConsoleTextArea.setText("Office updated: " + "the office with the office code: " + officeCode + "\nin the city: " + city + " is changed\n");
							//functions that refreshes
							refreshDatabaseTextArea();
							
							//function to clear fields after update
							clearUpdateFields();
							
						} catch(SQLException sqlErr) {
							sqlErr.printStackTrace();
						}		 	
						catch (MissingTextFieldException exception) {
						officeConsoleTextArea.append(exception.getMessage() + "\n");
						}
						catch (Exception exception) {
							exception.printStackTrace();
						}
					}
				});
		//SAVE OFFICE BUTTON EVENT
		saveOfficeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fileChooser.setDialogTitle("Specify a file to save");

				//Set default folder
				fileChooser.setCurrentDirectory(new File("c:\\temp"));

				//Just allow .txt file
				FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "txt", "text");
				fileChooser.setFileFilter(filter);

				int returnVal = fileChooser.showSaveDialog(null);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File fileToSave = fileChooser.getSelectedFile();

					try {
						EmployeeTab.writeToFile(databaseTextArea.getText(), fileToSave);
						officeConsoleTextArea.setText("Succesfull when saving the Database");
					}catch (IOException e1) {
						officeConsoleTextArea.setText("Error writing into file");
					}
				}
			}
		});
	}

	//-------------------GETTERS------------------//

	public String getOfficeCode() {
		String officeCode = (String) officeCodeComboBox.getSelectedItem();
		return officeCode;
	}

public String getCity() {
	return updateCityTextField.getText();
}

public String getPhone() {
    return updatePhoneTextField.getText();
}

public String getAddressLine1() {
	return updateStreetAddressTextField.getText();
}

public String getAddressLine2() {
	return updateAptTextField.getText();
}

public String getState() {
	return updateStateTextField.getText();
}

public String getCountry() {
	return updateCountryTextField.getText();
}

public String getPostalCode() {
	return updatePostalCodeTextField.getText();
}

public String getTerritory() {
	return updateTerritorytextField.getText();
}
//---------------ADDITIONAL METHODS-----------------//

public void refreshDatabaseTextArea() {
	try {
	List<OfficesList> offices = db.showOffices();
	databaseTextArea.setText("");
		for (OfficesList officesList : offices) {
			databaseTextArea.append(officesList.getOfficeCode() + ": " + officesList.getCity() + ", " + officesList.getPhone() + ", " + officesList.getAddressLine1() + ", " + officesList.getAddressLine2() + ", " + officesList.getState() + ", " + officesList.getCountry() +   "\n");
		}
	} catch (SQLException err) {
		err.printStackTrace();
	}
}

public void refreshOfficeCodeComboBox() {
	try {
	List<OfficesList> offices = db.showOffices();
	officeCodeComboBox.removeAllItems();
		for (OfficesList officesList : offices) {
			if (unique.add(officesList.getOfficeCode())) {
				officeCodeComboBox.addItem(officesList.getOfficeCode());
			}
		}
	}catch(SQLException err) {
		err.printStackTrace();
	}
}

public void clearUpdateFields() {
	updateCityTextField.setText("");
	updatePhoneTextField.setText("");
	updateStreetAddressTextField.setText("");
	updateAptTextField.setText("");
	updateStateTextField.setText("");
	updateCountryTextField.setText("");
	updatePostalCodeTextField.setText("");
	updateTerritorytextField.setText("");
	officeConsoleTextArea.append("*cleared text fields for update employee. \n");
}

}
