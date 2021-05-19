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
	
	private final JPanel employeeTab = new JPanel();
	private JPanel AddOfficePanel;
	private JPanel DeleteOfficePanel;
	private JPanel UpdateOfficePanel;
	private JLabel addCityLabel;
	private JTextField addCityTextField;
	private JLabel addPhoneLabel;
	private JLabel addStreetAdressLabel;
	private JLabel addAptNumberLabel;
	private JLabel addStateLabel;
	private JLabel addOfficeCodeLabel;
	private JLabel addCountryLabel;
	private JLabel addPostalCodeLabel;
	private JTextField addPhoneTextField;
	private JTextField addStreetAddressTextField;
	private JTextField addAptTextField;
	private JTextField addStateTextField;
	private JTextField addOfficeCodeTextField;
	private JTextField addCountryTextField;
	private JTextField addPostalCodeTextField;
	private JButton addOfficeBtn;
	private JLabel updateCityLabel;
	private JLabel updatePhoneLabel;
	private JLabel updateStreetAdressLabel;
	private JLabel updateAptNumberLabel;
	private JLabel updateStateLabel;
	private JLabel updateOfficeCodeLabel;
	private JLabel updateCountryLabel;
	private JLabel updatePostalCodeLabel;
	private JTextField updatePhoneTextField;
	private JTextField updateStreetAdressTextField;
	private JTextField updateAptNumberTextField;
	private JTextField updateStateTextField;
	private JTextField updateOfficeCodeTextField;
	private JTextField updateCountryTextField;
	private JTextField updatePostalCodeField;
	private JButton updateOfficeBtn;
	private JLabel deleteOfficeNumberLabel;
	private JComboBox deleteOfficeNumberComboBox;
	private JButton deleteOfficeBtn;
	private JPanel OfficeDbView;
	private JTextArea databaseTextArea;
	private JButton refreshDatabaseTextAreaBtn;
	private JComboBox chooseJobTitleComboBox;
	private JLabel chooseJobTitleLabel;
	private JPanel OfficeConsolePanel;
	private JTextArea officeConsoleTextArea;
	private JButton clearConsoleBtn;
	private JLabel addTerritoryLabel;
	private JTextField addTerritorytextField;
	private JLabel updateTerritoryLabel;
	private JTextField updateTerritoryTextField;
	private JTextField updateCityTextField;
	
	public OfficesTab() {
		
		GridBagLayout gbl_employeeTab = new GridBagLayout();
        gbl_employeeTab.columnWidths = new int[] {80, 80, 80, 80, 80, 80, 80, 80, 80, 80};
        gbl_employeeTab.rowHeights = new int[] {60, 60, 60, 60, 60, 60, 60, 60, 60, 60};
        gbl_employeeTab.columnWeights = new double[]{1.0};
        gbl_employeeTab.rowWeights = new double[]{Double.MIN_VALUE};
        employeeTab.setLayout(gbl_employeeTab);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{266, 266, 266, 0};
		gridBagLayout.rowHeights = new int[] {130, 130, 228};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		AddOfficePanel = new JPanel();
		AddOfficePanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Add office", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_AddOfficePanel = new GridBagConstraints();
		gbc_AddOfficePanel.gridheight = 2;
		gbc_AddOfficePanel.insets = new Insets(0, 0, 5, 5);
		gbc_AddOfficePanel.fill = GridBagConstraints.BOTH;
		gbc_AddOfficePanel.gridx = 0;
		gbc_AddOfficePanel.gridy = 0;
		add(AddOfficePanel, gbc_AddOfficePanel);
		GridBagLayout gbl_AddOfficePanel = new GridBagLayout();
		gbl_AddOfficePanel.columnWidths = new int[] {95, 112, 0};
		gbl_AddOfficePanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_AddOfficePanel.columnWeights = new double[]{1.0, 1.0, 0.0};
		gbl_AddOfficePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		AddOfficePanel.setLayout(gbl_AddOfficePanel);
		
		addCityLabel = new JLabel("City:");
		GridBagConstraints gbc_addCityLabel = new GridBagConstraints();
		gbc_addCityLabel.anchor = GridBagConstraints.EAST;
		gbc_addCityLabel.insets = new Insets(0, 0, 5, 5);
		gbc_addCityLabel.gridx = 0;
		gbc_addCityLabel.gridy = 0;
		AddOfficePanel.add(addCityLabel, gbc_addCityLabel);
		
		addCityTextField = new JTextField();
		GridBagConstraints gbc_addCityTextField = new GridBagConstraints();
		gbc_addCityTextField.insets = new Insets(0, 0, 5, 5);
		gbc_addCityTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_addCityTextField.gridx = 1;
		gbc_addCityTextField.gridy = 0;
		AddOfficePanel.add(addCityTextField, gbc_addCityTextField);
		addCityTextField.setColumns(10);
		
		addPhoneLabel = new JLabel("Phone:");
		GridBagConstraints gbc_addPhoneLabel = new GridBagConstraints();
		gbc_addPhoneLabel.anchor = GridBagConstraints.EAST;
		gbc_addPhoneLabel.insets = new Insets(0, 0, 5, 5);
		gbc_addPhoneLabel.gridx = 0;
		gbc_addPhoneLabel.gridy = 1;
		AddOfficePanel.add(addPhoneLabel, gbc_addPhoneLabel);
		
		addPhoneTextField = new JTextField();
		addPhoneTextField.setColumns(10);
		GridBagConstraints gbc_addPhoneTextField = new GridBagConstraints();
		gbc_addPhoneTextField.insets = new Insets(0, 0, 5, 5);
		gbc_addPhoneTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_addPhoneTextField.gridx = 1;
		gbc_addPhoneTextField.gridy = 1;
		AddOfficePanel.add(addPhoneTextField, gbc_addPhoneTextField);
		
		addStreetAdressLabel = new JLabel("Street address:");
		GridBagConstraints gbc_addStreetAdressLabel = new GridBagConstraints();
		gbc_addStreetAdressLabel.anchor = GridBagConstraints.EAST;
		gbc_addStreetAdressLabel.insets = new Insets(0, 0, 5, 5);
		gbc_addStreetAdressLabel.gridx = 0;
		gbc_addStreetAdressLabel.gridy = 2;
		AddOfficePanel.add(addStreetAdressLabel, gbc_addStreetAdressLabel);
		
		addStreetAddressTextField = new JTextField();
		addStreetAddressTextField.setColumns(10);
		GridBagConstraints gbc_addStreetAddressTextField = new GridBagConstraints();
		gbc_addStreetAddressTextField.insets = new Insets(0, 0, 5, 5);
		gbc_addStreetAddressTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_addStreetAddressTextField.gridx = 1;
		gbc_addStreetAddressTextField.gridy = 2;
		AddOfficePanel.add(addStreetAddressTextField, gbc_addStreetAddressTextField);
		
		addAptNumberLabel = new JLabel("Apt number:");
		GridBagConstraints gbc_addAptNumberLabel = new GridBagConstraints();
		gbc_addAptNumberLabel.anchor = GridBagConstraints.EAST;
		gbc_addAptNumberLabel.insets = new Insets(0, 0, 5, 5);
		gbc_addAptNumberLabel.gridx = 0;
		gbc_addAptNumberLabel.gridy = 3;
		AddOfficePanel.add(addAptNumberLabel, gbc_addAptNumberLabel);
		
		addAptTextField = new JTextField();
		addAptTextField.setColumns(10);
		GridBagConstraints gbc_addAptTextField = new GridBagConstraints();
		gbc_addAptTextField.insets = new Insets(0, 0, 5, 5);
		gbc_addAptTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_addAptTextField.gridx = 1;
		gbc_addAptTextField.gridy = 3;
		AddOfficePanel.add(addAptTextField, gbc_addAptTextField);
		
		addStateLabel = new JLabel("State:");
		GridBagConstraints gbc_addStateLabel = new GridBagConstraints();
		gbc_addStateLabel.anchor = GridBagConstraints.EAST;
		gbc_addStateLabel.insets = new Insets(0, 0, 5, 5);
		gbc_addStateLabel.gridx = 0;
		gbc_addStateLabel.gridy = 4;
		AddOfficePanel.add(addStateLabel, gbc_addStateLabel);
		
		addStateTextField = new JTextField();
		addStateTextField.setColumns(10);
		GridBagConstraints gbc_addStateTextField = new GridBagConstraints();
		gbc_addStateTextField.insets = new Insets(0, 0, 5, 5);
		gbc_addStateTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_addStateTextField.gridx = 1;
		gbc_addStateTextField.gridy = 4;
		AddOfficePanel.add(addStateTextField, gbc_addStateTextField);
		
		addOfficeCodeLabel = new JLabel("Office code: ");
		GridBagConstraints gbc_addOfficeCodeLabel = new GridBagConstraints();
		gbc_addOfficeCodeLabel.anchor = GridBagConstraints.EAST;
		gbc_addOfficeCodeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_addOfficeCodeLabel.gridx = 0;
		gbc_addOfficeCodeLabel.gridy = 5;
		AddOfficePanel.add(addOfficeCodeLabel, gbc_addOfficeCodeLabel);
		
		addOfficeCodeTextField = new JTextField();
		addOfficeCodeTextField.setColumns(10);
		GridBagConstraints gbc_addOfficeCodeTextField = new GridBagConstraints();
		gbc_addOfficeCodeTextField.insets = new Insets(0, 0, 5, 5);
		gbc_addOfficeCodeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_addOfficeCodeTextField.gridx = 1;
		gbc_addOfficeCodeTextField.gridy = 5;
		AddOfficePanel.add(addOfficeCodeTextField, gbc_addOfficeCodeTextField);
		
		addCountryLabel = new JLabel("Country:");
		GridBagConstraints gbc_addCountryLabel = new GridBagConstraints();
		gbc_addCountryLabel.anchor = GridBagConstraints.EAST;
		gbc_addCountryLabel.insets = new Insets(0, 0, 5, 5);
		gbc_addCountryLabel.gridx = 0;
		gbc_addCountryLabel.gridy = 6;
		AddOfficePanel.add(addCountryLabel, gbc_addCountryLabel);
		
		addCountryTextField = new JTextField();
		addCountryTextField.setColumns(10);
		GridBagConstraints gbc_addCountryTextField = new GridBagConstraints();
		gbc_addCountryTextField.insets = new Insets(0, 0, 5, 5);
		gbc_addCountryTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_addCountryTextField.gridx = 1;
		gbc_addCountryTextField.gridy = 6;
		AddOfficePanel.add(addCountryTextField, gbc_addCountryTextField);
		
		addPostalCodeLabel = new JLabel("Postal Code:");
		GridBagConstraints gbc_addPostalCodeLabel = new GridBagConstraints();
		gbc_addPostalCodeLabel.anchor = GridBagConstraints.EAST;
		gbc_addPostalCodeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_addPostalCodeLabel.gridx = 0;
		gbc_addPostalCodeLabel.gridy = 7;
		AddOfficePanel.add(addPostalCodeLabel, gbc_addPostalCodeLabel);
		
		addPostalCodeTextField = new JTextField();
		addPostalCodeTextField.setColumns(10);
		GridBagConstraints gbc_addPostalCodeTextField = new GridBagConstraints();
		gbc_addPostalCodeTextField.insets = new Insets(0, 0, 5, 5);
		gbc_addPostalCodeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_addPostalCodeTextField.gridx = 1;
		gbc_addPostalCodeTextField.gridy = 7;
		AddOfficePanel.add(addPostalCodeTextField, gbc_addPostalCodeTextField);
		
		addTerritoryLabel = new JLabel("Territory:");
		GridBagConstraints gbc_addTerritoryLabel = new GridBagConstraints();
		gbc_addTerritoryLabel.anchor = GridBagConstraints.EAST;
		gbc_addTerritoryLabel.insets = new Insets(0, 0, 5, 5);
		gbc_addTerritoryLabel.gridx = 0;
		gbc_addTerritoryLabel.gridy = 8;
		AddOfficePanel.add(addTerritoryLabel, gbc_addTerritoryLabel);
		
		addTerritorytextField = new JTextField();
		addTerritorytextField.setColumns(10);
		GridBagConstraints gbc_addTerritorytextField = new GridBagConstraints();
		gbc_addTerritorytextField.insets = new Insets(0, 0, 5, 5);
		gbc_addTerritorytextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_addTerritorytextField.gridx = 1;
		gbc_addTerritorytextField.gridy = 8;
		AddOfficePanel.add(addTerritorytextField, gbc_addTerritorytextField);
		
		addOfficeBtn = new JButton("Add office");
		GridBagConstraints gbc_addOfficeBtn = new GridBagConstraints();
		gbc_addOfficeBtn.insets = new Insets(0, 0, 0, 5);
		gbc_addOfficeBtn.gridx = 1;
		gbc_addOfficeBtn.gridy = 9;
		AddOfficePanel.add(addOfficeBtn, gbc_addOfficeBtn);
		
		DeleteOfficePanel = new JPanel();
		DeleteOfficePanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Delete office", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_DeleteOfficePanel = new GridBagConstraints();
		gbc_DeleteOfficePanel.insets = new Insets(0, 0, 5, 0);
		gbc_DeleteOfficePanel.fill = GridBagConstraints.BOTH;
		gbc_DeleteOfficePanel.gridx = 2;
		gbc_DeleteOfficePanel.gridy = 0;
		add(DeleteOfficePanel, gbc_DeleteOfficePanel);
		GridBagLayout gbl_DeleteOfficePanel = new GridBagLayout();
		gbl_DeleteOfficePanel.columnWidths = new int[] {101, 133, 0};
		gbl_DeleteOfficePanel.rowHeights = new int[]{0, 0, 0};
		gbl_DeleteOfficePanel.columnWeights = new double[]{0.0, 1.0, 0.0};
		gbl_DeleteOfficePanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		DeleteOfficePanel.setLayout(gbl_DeleteOfficePanel);
		
		deleteOfficeNumberLabel = new JLabel("Office Number:");
		GridBagConstraints gbc_deleteOfficeNumberLabel = new GridBagConstraints();
		gbc_deleteOfficeNumberLabel.insets = new Insets(0, 0, 5, 5);
		gbc_deleteOfficeNumberLabel.anchor = GridBagConstraints.EAST;
		gbc_deleteOfficeNumberLabel.gridx = 0;
		gbc_deleteOfficeNumberLabel.gridy = 0;
		DeleteOfficePanel.add(deleteOfficeNumberLabel, gbc_deleteOfficeNumberLabel);
		
		deleteOfficeNumberComboBox = new JComboBox();
		GridBagConstraints gbc_deleteOfficeNumberComboBox = new GridBagConstraints();
		gbc_deleteOfficeNumberComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_deleteOfficeNumberComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_deleteOfficeNumberComboBox.gridx = 1;
		gbc_deleteOfficeNumberComboBox.gridy = 0;
		DeleteOfficePanel.add(deleteOfficeNumberComboBox, gbc_deleteOfficeNumberComboBox);
		
		deleteOfficeBtn = new JButton("Delete office");
		GridBagConstraints gbc_deleteOfficeBtn = new GridBagConstraints();
		gbc_deleteOfficeBtn.insets = new Insets(0, 0, 0, 5);
		gbc_deleteOfficeBtn.gridx = 1;
		gbc_deleteOfficeBtn.gridy = 1;
		DeleteOfficePanel.add(deleteOfficeBtn, gbc_deleteOfficeBtn);
		
		UpdateOfficePanel = new JPanel();
		UpdateOfficePanel.setBorder(new TitledBorder(null, "Update employee", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_UpdateOfficePanel = new GridBagConstraints();
		gbc_UpdateOfficePanel.gridheight = 2;
		gbc_UpdateOfficePanel.insets = new Insets(0, 0, 5, 5);
		gbc_UpdateOfficePanel.fill = GridBagConstraints.BOTH;
		gbc_UpdateOfficePanel.gridx = 1;
		gbc_UpdateOfficePanel.gridy = 0;
		add(UpdateOfficePanel, gbc_UpdateOfficePanel);
		GridBagLayout gbl_UpdateOfficePanel = new GridBagLayout();
		gbl_UpdateOfficePanel.columnWidths = new int[] {104, 133, 0};
		gbl_UpdateOfficePanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_UpdateOfficePanel.columnWeights = new double[]{0.0, 1.0, 0.0};
		gbl_UpdateOfficePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		UpdateOfficePanel.setLayout(gbl_UpdateOfficePanel);
		
		updateCityLabel = new JLabel("City: ");
		GridBagConstraints gbc_updateCityLabel = new GridBagConstraints();
		gbc_updateCityLabel.anchor = GridBagConstraints.EAST;
		gbc_updateCityLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updateCityLabel.gridx = 0;
		gbc_updateCityLabel.gridy = 0;
		UpdateOfficePanel.add(updateCityLabel, gbc_updateCityLabel);
		
		updateCityTextField = new JTextField();
		updateCityTextField.setColumns(10);
		GridBagConstraints gbc_updateCityTextField = new GridBagConstraints();
		gbc_updateCityTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateCityTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateCityTextField.gridx = 1;
		gbc_updateCityTextField.gridy = 0;
		UpdateOfficePanel.add(updateCityTextField, gbc_updateCityTextField);
		
		updatePhoneLabel = new JLabel("Phone: ");
		GridBagConstraints gbc_updatePhoneLabel = new GridBagConstraints();
		gbc_updatePhoneLabel.anchor = GridBagConstraints.EAST;
		gbc_updatePhoneLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updatePhoneLabel.gridx = 0;
		gbc_updatePhoneLabel.gridy = 1;
		UpdateOfficePanel.add(updatePhoneLabel, gbc_updatePhoneLabel);
		
		updatePhoneTextField = new JTextField();
		updatePhoneTextField.setColumns(10);
		GridBagConstraints gbc_updatePhoneTextField = new GridBagConstraints();
		gbc_updatePhoneTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updatePhoneTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updatePhoneTextField.gridx = 1;
		gbc_updatePhoneTextField.gridy = 1;
		UpdateOfficePanel.add(updatePhoneTextField, gbc_updatePhoneTextField);
		
		updateStreetAdressLabel = new JLabel("Street adress: ");
		GridBagConstraints gbc_updateStreetAdressLabel = new GridBagConstraints();
		gbc_updateStreetAdressLabel.anchor = GridBagConstraints.EAST;
		gbc_updateStreetAdressLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updateStreetAdressLabel.gridx = 0;
		gbc_updateStreetAdressLabel.gridy = 2;
		UpdateOfficePanel.add(updateStreetAdressLabel, gbc_updateStreetAdressLabel);
		
		updateStreetAdressTextField = new JTextField();
		updateStreetAdressTextField.setColumns(10);
		GridBagConstraints gbc_updateStreetAdressTextField = new GridBagConstraints();
		gbc_updateStreetAdressTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateStreetAdressTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateStreetAdressTextField.gridx = 1;
		gbc_updateStreetAdressTextField.gridy = 2;
		UpdateOfficePanel.add(updateStreetAdressTextField, gbc_updateStreetAdressTextField);
		
		updateAptNumberLabel = new JLabel("Apt number: ");
		GridBagConstraints gbc_updateAptNumberLabel = new GridBagConstraints();
		gbc_updateAptNumberLabel.anchor = GridBagConstraints.EAST;
		gbc_updateAptNumberLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updateAptNumberLabel.gridx = 0;
		gbc_updateAptNumberLabel.gridy = 3;
		UpdateOfficePanel.add(updateAptNumberLabel, gbc_updateAptNumberLabel);
		
		updateAptNumberTextField = new JTextField();
		updateAptNumberTextField.setColumns(10);
		GridBagConstraints gbc_updateAptNumberTextField = new GridBagConstraints();
		gbc_updateAptNumberTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateAptNumberTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateAptNumberTextField.gridx = 1;
		gbc_updateAptNumberTextField.gridy = 3;
		UpdateOfficePanel.add(updateAptNumberTextField, gbc_updateAptNumberTextField);
		
		updateStateLabel = new JLabel("State: ");
		GridBagConstraints gbc_updateStateLabel = new GridBagConstraints();
		gbc_updateStateLabel.anchor = GridBagConstraints.EAST;
		gbc_updateStateLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updateStateLabel.gridx = 0;
		gbc_updateStateLabel.gridy = 4;
		UpdateOfficePanel.add(updateStateLabel, gbc_updateStateLabel);
		
		updateStateTextField = new JTextField();
		updateStateTextField.setColumns(10);
		GridBagConstraints gbc_updateStateTextField = new GridBagConstraints();
		gbc_updateStateTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateStateTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateStateTextField.gridx = 1;
		gbc_updateStateTextField.gridy = 4;
		UpdateOfficePanel.add(updateStateTextField, gbc_updateStateTextField);
		
		updateOfficeCodeLabel = new JLabel("Office code: ");
		GridBagConstraints gbc_updateOfficeCodeLabel = new GridBagConstraints();
		gbc_updateOfficeCodeLabel.anchor = GridBagConstraints.EAST;
		gbc_updateOfficeCodeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updateOfficeCodeLabel.gridx = 0;
		gbc_updateOfficeCodeLabel.gridy = 5;
		UpdateOfficePanel.add(updateOfficeCodeLabel, gbc_updateOfficeCodeLabel);
		
		updateOfficeCodeTextField = new JTextField();
		updateOfficeCodeTextField.setColumns(10);
		GridBagConstraints gbc_updateOfficeCodeTextField = new GridBagConstraints();
		gbc_updateOfficeCodeTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateOfficeCodeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateOfficeCodeTextField.gridx = 1;
		gbc_updateOfficeCodeTextField.gridy = 5;
		UpdateOfficePanel.add(updateOfficeCodeTextField, gbc_updateOfficeCodeTextField);
		
		updateCountryLabel = new JLabel("Country:");
		GridBagConstraints gbc_updateCountryLabel = new GridBagConstraints();
		gbc_updateCountryLabel.anchor = GridBagConstraints.EAST;
		gbc_updateCountryLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updateCountryLabel.gridx = 0;
		gbc_updateCountryLabel.gridy = 6;
		UpdateOfficePanel.add(updateCountryLabel, gbc_updateCountryLabel);
		
		updateCountryTextField = new JTextField();
		updateCountryTextField.setColumns(10);
		GridBagConstraints gbc_updateCountryTextField = new GridBagConstraints();
		gbc_updateCountryTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateCountryTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateCountryTextField.gridx = 1;
		gbc_updateCountryTextField.gridy = 6;
		UpdateOfficePanel.add(updateCountryTextField, gbc_updateCountryTextField);
		
		updatePostalCodeLabel = new JLabel("Postal Code:");
		GridBagConstraints gbc_updatePostalCodeLabel = new GridBagConstraints();
		gbc_updatePostalCodeLabel.anchor = GridBagConstraints.EAST;
		gbc_updatePostalCodeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updatePostalCodeLabel.gridx = 0;
		gbc_updatePostalCodeLabel.gridy = 7;
		UpdateOfficePanel.add(updatePostalCodeLabel, gbc_updatePostalCodeLabel);
		
		updatePostalCodeField = new JTextField();
		updatePostalCodeField.setColumns(10);
		GridBagConstraints gbc_updatePostalCodeField = new GridBagConstraints();
		gbc_updatePostalCodeField.insets = new Insets(0, 0, 5, 5);
		gbc_updatePostalCodeField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updatePostalCodeField.gridx = 1;
		gbc_updatePostalCodeField.gridy = 7;
		UpdateOfficePanel.add(updatePostalCodeField, gbc_updatePostalCodeField);
		
		updateTerritoryLabel = new JLabel("Territory:");
		GridBagConstraints gbc_updateTerritoryLabel = new GridBagConstraints();
		gbc_updateTerritoryLabel.anchor = GridBagConstraints.EAST;
		gbc_updateTerritoryLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updateTerritoryLabel.gridx = 0;
		gbc_updateTerritoryLabel.gridy = 8;
		UpdateOfficePanel.add(updateTerritoryLabel, gbc_updateTerritoryLabel);
		
		updateTerritoryTextField = new JTextField();
		updateTerritoryTextField.setColumns(10);
		GridBagConstraints gbc_updateTerritoryTextField = new GridBagConstraints();
		gbc_updateTerritoryTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateTerritoryTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateTerritoryTextField.gridx = 1;
		gbc_updateTerritoryTextField.gridy = 8;
		UpdateOfficePanel.add(updateTerritoryTextField, gbc_updateTerritoryTextField);
		
		updateOfficeBtn = new JButton("Update office");
		GridBagConstraints gbc_updateOfficeBtn = new GridBagConstraints();
		gbc_updateOfficeBtn.insets = new Insets(0, 0, 0, 5);
		gbc_updateOfficeBtn.gridx = 1;
		gbc_updateOfficeBtn.gridy = 9;
		UpdateOfficePanel.add(updateOfficeBtn, gbc_updateOfficeBtn);
		
		OfficeDbView = new JPanel();
		OfficeDbView.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Office table view", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_OfficeDbView = new GridBagConstraints();
		gbc_OfficeDbView.gridheight = 2;
		gbc_OfficeDbView.fill = GridBagConstraints.BOTH;
		gbc_OfficeDbView.gridx = 2;
		gbc_OfficeDbView.gridy = 1;
		add(OfficeDbView, gbc_OfficeDbView);
		GridBagLayout gbl_OfficeDbView = new GridBagLayout();
		gbl_OfficeDbView.columnWidths = new int[] {41, 133, 0};
		gbl_OfficeDbView.rowHeights = new int[]{18, 0, 0, 0};
		gbl_OfficeDbView.columnWeights = new double[]{0.0, 1.0, 0.0};
		gbl_OfficeDbView.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		OfficeDbView.setLayout(gbl_OfficeDbView);
		
		chooseJobTitleLabel = new JLabel("Job title: ");
		GridBagConstraints gbc_chooseJobTitleLabel = new GridBagConstraints();
		gbc_chooseJobTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_chooseJobTitleLabel.anchor = GridBagConstraints.EAST;
		gbc_chooseJobTitleLabel.gridx = 0;
		gbc_chooseJobTitleLabel.gridy = 0;
		OfficeDbView.add(chooseJobTitleLabel, gbc_chooseJobTitleLabel);
		
		chooseJobTitleComboBox = new JComboBox();
		GridBagConstraints gbc_chooseJobTitleComboBox = new GridBagConstraints();
		gbc_chooseJobTitleComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_chooseJobTitleComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_chooseJobTitleComboBox.gridx = 1;
		gbc_chooseJobTitleComboBox.gridy = 0;
		OfficeDbView.add(chooseJobTitleComboBox, gbc_chooseJobTitleComboBox);
		
		databaseTextArea = new JTextArea();
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
		gbc_databaseScroll.gridwidth = 3;
		gbc_databaseScroll.insets = new Insets(0, 0, 5, 0);
		gbc_databaseScroll.fill = GridBagConstraints.BOTH;
		gbc_databaseScroll.gridx = 0;
		gbc_databaseScroll.gridy = 1;
		OfficeDbView.add(databaseScroll, gbc_databaseScroll);
		
		refreshDatabaseTextAreaBtn = new JButton("Refresh view");
		GridBagConstraints gbc_refreshDatabaseTextAreaBtn = new GridBagConstraints();
		gbc_refreshDatabaseTextAreaBtn.insets = new Insets(0, 0, 0, 5);
		gbc_refreshDatabaseTextAreaBtn.gridx = 0;
		gbc_refreshDatabaseTextAreaBtn.gridy = 2;
		OfficeDbView.add(refreshDatabaseTextAreaBtn, gbc_refreshDatabaseTextAreaBtn);
		
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
		
		//CLEAR CONSOLE BUTTON EVENT
		clearConsoleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				officeConsoleTextArea.setText("");
			}
		});
				
				addOfficeBtn.addActionListener(new ActionListener() {
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

							db.addOffice(officeCode, city, phone, addressLine1, addressLine2, state, country, postalCode, territory);
							officeConsoleTextArea.setText("Office updated: " + " " + officeCode + " " + city + " is added\n");


						} catch (Exception exception) {
							officeConsoleTextArea.append("Something went wrong when adding new Office : " + exception.getMessage() + "\n");
						}
					}
				});
	}



public String getOfficeCode() {
    return addOfficeCodeTextField.getText();
}

public String getCity() {
	return addCityTextField.getText();
}

public String getPhone() {
    return addPhoneTextField.getText();
}

public String getAddressLine1() {
	return addStreetAddressTextField.getText();
}

public String getAddressLine2() {
	return addAptTextField.getText();
}

public String getState() {
	return addStateTextField.getText();
}

public String getCountry() {
	return addCountryTextField.getText();
}

public String getPostalCode() {
	return addPostalCodeTextField.getText();
}

public String getTerritory() {
	return addTerritorytextField.getText();
}


}
