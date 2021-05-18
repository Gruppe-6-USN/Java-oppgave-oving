package org.example.gui;

import org.example.database.DatabaseConnection;
import org.example.database.Employee;
import org.example.gui.exceptions.MissingTextFieldException;


import java.awt.EventQueue;

import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.nio.CharBuffer;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;

import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.JTextComponent;

import java.awt.Color;
import javax.swing.border.EtchedBorder;

public class MainFrame {

private DatabaseConnection databaseConnection = new DatabaseConnection();

public JFrame frame;
private JTextField employeeNumberTextField;
private JTextField firstNameTextField;
private JTextField lastNameTextField;
private JTextField extensionTextField;
private JTextField emailTextField;
private JTextField idTextField;
private JTextField updateFirstNameTextField;
private JTextField updateIdTextField;
private JTextField updateLastNameTextField;
private JTextField updateExtensionTextField;
private JTextField updateOfficeCodeTextField;
private JTextField updateReportsToTextField;
private JTextField dateFromTextField;
private JTextField dateToTextField;
private JTextField officeCodeTextField;
private JTextField reportsToTextField;
private JTextField jobTitleTextField;
private JTextField updateEmployeeNumberTextField;
private JTextField updateEmailTextField;
private JTextField updateJobTitleTextField;

//TO-DO:
//add auto-refresh to databaseTextArea when making changes in the database
//add printStackTrace to consoleTextArea

//ADD ACTION EVENT LISTENER BENEATH THE GUI-CONTENT

	//CREATE THE APPLICATION
	public MainFrame() {
		initialize();
	}

	//INITIALIZE CONTENT
	public void initialize() {

		//MAIN FRAME
		frame = new JFrame();
		frame.setTitle("DB-Admin v2.0");
		frame.setBounds(100, 100, 973, 703);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {40, 40, 40, 40, 40, 40, 40, 40, 40, 40};
		gridBagLayout.rowHeights = new int[] {40, 40, 40, 40, 40, 40, 40, 40, 40, 40};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		frame.getContentPane().setLayout(gridBagLayout);
		
		//TABBED PANEL
		JTabbedPane tabbedPanel = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPanel = new GridBagConstraints();
		gbc_tabbedPanel.gridheight = 5;
		gbc_tabbedPanel.fill = GridBagConstraints.BOTH;
		gbc_tabbedPanel.insets = new Insets(0, 0, 5, 5);
		gbc_tabbedPanel.gridx = 0;
		gbc_tabbedPanel.gridy = 0;
		frame.getContentPane().add(tabbedPanel, gbc_tabbedPanel);
		
		//DELETE TAB
		JPanel deletePanel = new JPanel();
		tabbedPanel.addTab("Delete", null, deletePanel, null);
		GridBagLayout gbl_deletePanel = new GridBagLayout();
		gbl_deletePanel.columnWidths = new int[] {40, 40, 0, 40, 40, 40};
		gbl_deletePanel.rowHeights = new int[] {40, 0, 40, 40, 40, 40, 40, 40};
		gbl_deletePanel.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_deletePanel.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		deletePanel.setLayout(gbl_deletePanel);
		
		//DELETE PANEL
		JPanel deleteIdPanel = new JPanel();
		deleteIdPanel.setBorder(new TitledBorder(null, "Delete ID", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_deleteIdPanel = new GridBagConstraints();
		gbc_deleteIdPanel.gridheight = 8;
		gbc_deleteIdPanel.gridwidth = 6;
		gbc_deleteIdPanel.insets = new Insets(0, 0, 5, 5);
		gbc_deleteIdPanel.fill = GridBagConstraints.BOTH;
		gbc_deleteIdPanel.gridx = 0;
		gbc_deleteIdPanel.gridy = 0;
		deletePanel.add(deleteIdPanel, gbc_deleteIdPanel);
		GridBagLayout gbl_deleteIdPanel = new GridBagLayout();
		gbl_deleteIdPanel.columnWidths = new int[] {40, 40, 40, 40};
		gbl_deleteIdPanel.rowHeights = new int[]{20, 0, 0, 0};
		gbl_deleteIdPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_deleteIdPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		deleteIdPanel.setLayout(gbl_deleteIdPanel);
		
		//ID LABEL
		JLabel idLabel = new JLabel("ID:");
		GridBagConstraints gbc_idLabel = new GridBagConstraints();
		gbc_idLabel.anchor = GridBagConstraints.EAST;
		gbc_idLabel.insets = new Insets(0, 0, 5, 5);
		gbc_idLabel.gridx = 0;
		gbc_idLabel.gridy = 1;
		deleteIdPanel.add(idLabel, gbc_idLabel);
		
		//ID TEXT FIELD
		idTextField = new JTextField();
		idTextField.setColumns(10);
		GridBagConstraints gbc_idTextField = new GridBagConstraints();
		gbc_idTextField.gridwidth = 2;
		gbc_idTextField.insets = new Insets(0, 0, 5, 0);
		gbc_idTextField.anchor = GridBagConstraints.NORTHWEST;
		gbc_idTextField.gridx = 1;
		gbc_idTextField.gridy = 1;
		deleteIdPanel.add(idTextField, gbc_idTextField);
		
		//DELETE BUTTON
		JButton deleteBtn = new JButton("Delete");
		GridBagConstraints gbc_deleteBtn = new GridBagConstraints();
		gbc_deleteBtn.gridx = 1;
		gbc_deleteBtn.gridy = 2;
		deleteIdPanel.add(deleteBtn, gbc_deleteBtn);
		deleteBtn.setToolTipText("Delete an employee from the database");
		
		//ADD TAB
		JPanel addPanel = new JPanel();
		tabbedPanel.addTab("Add", null, addPanel, null);
		GridBagLayout gbl_addPanel = new GridBagLayout();
		gbl_addPanel.columnWidths = new int[] {40, 40, 40, 40, 40};
		gbl_addPanel.rowHeights = new int[] {40, 40, 40, 40, 40, 40, 40, 40};
		gbl_addPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_addPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		addPanel.setLayout(gbl_addPanel);
		
		//ADD DATA PANEL
		JPanel addDataPanel = new JPanel();
		addDataPanel.setBorder(new TitledBorder(null, "Add data", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_addDataPanel = new GridBagConstraints();
		gbc_addDataPanel.gridwidth = 5;
		gbc_addDataPanel.gridheight = 10;
		gbc_addDataPanel.fill = GridBagConstraints.BOTH;
		gbc_addDataPanel.gridx = 0;
		gbc_addDataPanel.gridy = 0;
		addPanel.add(addDataPanel, gbc_addDataPanel);
		GridBagLayout gbl_addDataPanel = new GridBagLayout();
		gbl_addDataPanel.columnWidths = new int[] {40, 40, 40, 30, 40, 40, 40};
		gbl_addDataPanel.rowHeights = new int[] {40, 40, 40, 40, 40, 40, 40, 40, 0, 40};
		gbl_addDataPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 0.0};
		gbl_addDataPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		addDataPanel.setLayout(gbl_addDataPanel);
		
		//FIRST NAME LABEL
		JLabel employeeNumberLabel = new JLabel("Employee number: ");
		GridBagConstraints gbc_employeeNumberLabel = new GridBagConstraints();
		gbc_employeeNumberLabel.anchor = GridBagConstraints.EAST;
		gbc_employeeNumberLabel.insets = new Insets(0, 0, 5, 5);
		gbc_employeeNumberLabel.gridwidth = 2;
		gbc_employeeNumberLabel.gridx = 0;
		gbc_employeeNumberLabel.gridy = 0;
		addDataPanel.add(employeeNumberLabel, gbc_employeeNumberLabel);
		
		//FIRST NAME TEXT FIELD
		employeeNumberTextField = new JTextField();
		employeeNumberTextField.setColumns(10);
		GridBagConstraints gbc_employeeNumberTextField = new GridBagConstraints();
		gbc_employeeNumberTextField.gridwidth = 4;
		gbc_employeeNumberTextField.insets = new Insets(0, 0, 5, 5);
		gbc_employeeNumberTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_employeeNumberTextField.gridx = 2;
		gbc_employeeNumberTextField.gridy = 0;
		addDataPanel.add(employeeNumberTextField, gbc_employeeNumberTextField);
		
		//LAST NAME TEXT FIELD
		JLabel firstNameLabel = new JLabel("First name:");
		GridBagConstraints gbc_firstNameLabel = new GridBagConstraints();
		gbc_firstNameLabel.anchor = GridBagConstraints.EAST;
		gbc_firstNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_firstNameLabel.gridwidth = 2;
		gbc_firstNameLabel.gridx = 0;
		gbc_firstNameLabel.gridy = 1;
		addDataPanel.add(firstNameLabel, gbc_firstNameLabel);
		
		//LAST NAME TEXT FIELD
		firstNameTextField = new JTextField();
		firstNameTextField.setColumns(10);
		GridBagConstraints gbc_firstNameTextField = new GridBagConstraints();
		gbc_firstNameTextField.gridwidth = 4;
		gbc_firstNameTextField.insets = new Insets(0, 0, 5, 5);
		gbc_firstNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_firstNameTextField.gridx = 2;
		gbc_firstNameTextField.gridy = 1;
		addDataPanel.add(firstNameTextField, gbc_firstNameTextField);
		
		//EMAIL LABEL
		JLabel lastNameLabel = new JLabel("Last name:");
		GridBagConstraints gbc_lastNameLabel = new GridBagConstraints();
		gbc_lastNameLabel.anchor = GridBagConstraints.EAST;
		gbc_lastNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lastNameLabel.gridwidth = 2;
		gbc_lastNameLabel.gridx = 0;
		gbc_lastNameLabel.gridy = 2;
		addDataPanel.add(lastNameLabel, gbc_lastNameLabel);
		
		//EMAIL TEXT FIELD
		lastNameTextField = new JTextField();
		lastNameTextField.setColumns(10);
		GridBagConstraints gbc_lastNameTextField = new GridBagConstraints();
		gbc_lastNameTextField.gridwidth = 4;
		gbc_lastNameTextField.insets = new Insets(0, 0, 5, 5);
		gbc_lastNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_lastNameTextField.gridx = 2;
		gbc_lastNameTextField.gridy = 2;
		addDataPanel.add(lastNameTextField, gbc_lastNameTextField);
		
		//DEPARTMENT LABEL
		JLabel extensionLabel = new JLabel("Extension: ");
		GridBagConstraints gbc_extensionLabel = new GridBagConstraints();
		gbc_extensionLabel.anchor = GridBagConstraints.EAST;
		gbc_extensionLabel.insets = new Insets(0, 0, 5, 5);
		gbc_extensionLabel.gridwidth = 2;
		gbc_extensionLabel.gridx = 0;
		gbc_extensionLabel.gridy = 3;
		addDataPanel.add(extensionLabel, gbc_extensionLabel);
		
		//DEPARTMENT TEXT FIELD
		extensionTextField = new JTextField();
		extensionTextField.setColumns(10);
		GridBagConstraints gbc_extensionTextField = new GridBagConstraints();
		gbc_extensionTextField.gridwidth = 4;
		gbc_extensionTextField.insets = new Insets(0, 0, 5, 5);
		gbc_extensionTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_extensionTextField.gridx = 2;
		gbc_extensionTextField.gridy = 3;
		addDataPanel.add(extensionTextField, gbc_extensionTextField);
		
		//SALARY LABEL
		JLabel emailLabel = new JLabel("Email: ");
		GridBagConstraints gbc_emailLabel = new GridBagConstraints();
		gbc_emailLabel.anchor = GridBagConstraints.EAST;
		gbc_emailLabel.gridwidth = 2;
		gbc_emailLabel.insets = new Insets(0, 0, 5, 5);
		gbc_emailLabel.gridx = 0;
		gbc_emailLabel.gridy = 4;
		addDataPanel.add(emailLabel, gbc_emailLabel);
		
		//SALARY TEXT FIELD
		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		GridBagConstraints gbc_emailTextField = new GridBagConstraints();
		gbc_emailTextField.insets = new Insets(0, 0, 5, 5);
		gbc_emailTextField.gridwidth = 4;
		gbc_emailTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_emailTextField.gridx = 2;
		gbc_emailTextField.gridy = 4;
		addDataPanel.add(emailTextField, gbc_emailTextField);
		
		officeCodeTextField = new JTextField();
		GridBagConstraints gbc_officeCodeTextField = new GridBagConstraints();
		gbc_officeCodeTextField.gridwidth = 4;
		gbc_officeCodeTextField.insets = new Insets(0, 0, 5, 5);
		gbc_officeCodeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_officeCodeTextField.gridx = 2;
		gbc_officeCodeTextField.gridy = 5;
		addDataPanel.add(officeCodeTextField, gbc_officeCodeTextField);
		officeCodeTextField.setColumns(10);
		
		JLabel reportsToLabel = new JLabel("Reports to: ");
		GridBagConstraints gbc_reportsToLabel = new GridBagConstraints();
		gbc_reportsToLabel.anchor = GridBagConstraints.EAST;
		gbc_reportsToLabel.gridwidth = 2;
		gbc_reportsToLabel.insets = new Insets(0, 0, 5, 5);
		gbc_reportsToLabel.gridx = 0;
		gbc_reportsToLabel.gridy = 6;
		addDataPanel.add(reportsToLabel, gbc_reportsToLabel);
		
		reportsToTextField = new JTextField();
		GridBagConstraints gbc_reportsToTextField = new GridBagConstraints();
		gbc_reportsToTextField.gridwidth = 4;
		gbc_reportsToTextField.insets = new Insets(0, 0, 5, 5);
		gbc_reportsToTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_reportsToTextField.gridx = 2;
		gbc_reportsToTextField.gridy = 6;
		addDataPanel.add(reportsToTextField, gbc_reportsToTextField);
		reportsToTextField.setColumns(10);
		
		JLabel jobTitleLabel = new JLabel("Job title: ");
		GridBagConstraints gbc_jobTitleLabel = new GridBagConstraints();
		gbc_jobTitleLabel.anchor = GridBagConstraints.EAST;
		gbc_jobTitleLabel.gridwidth = 2;
		gbc_jobTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_jobTitleLabel.gridx = 0;
		gbc_jobTitleLabel.gridy = 7;
		addDataPanel.add(jobTitleLabel, gbc_jobTitleLabel);
		
		jobTitleTextField = new JTextField();
		GridBagConstraints gbc_jobTitleTextField = new GridBagConstraints();
		gbc_jobTitleTextField.gridwidth = 4;
		gbc_jobTitleTextField.insets = new Insets(0, 0, 5, 5);
		gbc_jobTitleTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_jobTitleTextField.gridx = 2;
		gbc_jobTitleTextField.gridy = 7;
		addDataPanel.add(jobTitleTextField, gbc_jobTitleTextField);
		jobTitleTextField.setColumns(10);
		
		//APPLY BUTTON
		JButton applyBtn = new JButton("Apply");
		GridBagConstraints gbc_applyBtn = new GridBagConstraints();
		gbc_applyBtn.gridwidth = 3;
		gbc_applyBtn.insets = new Insets(0, 0, 0, 5);
		gbc_applyBtn.gridx = 1;
		gbc_applyBtn.gridy = 8;
		addDataPanel.add(applyBtn, gbc_applyBtn);
		applyBtn.setToolTipText("Insert information into database");
		
		//CLEAR BUTTON
		JButton clearBtn = new JButton("Clear");
		GridBagConstraints gbc_clearBtn = new GridBagConstraints();
		gbc_clearBtn.insets = new Insets(0, 0, 0, 5);
		gbc_clearBtn.gridwidth = 3;
		gbc_clearBtn.gridx = 3;
		gbc_clearBtn.gridy = 8;
		addDataPanel.add(clearBtn, gbc_clearBtn);
		clearBtn.setToolTipText("Clears all information in the form");
		
		JLabel officeCodeLabel = new JLabel("Office code: ");
		GridBagConstraints gbc_officeCodeLabel = new GridBagConstraints();
		gbc_officeCodeLabel.anchor = GridBagConstraints.EAST;
		gbc_officeCodeLabel.gridwidth = 2;
		gbc_officeCodeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_officeCodeLabel.gridx = 0;
		gbc_officeCodeLabel.gridy = 5;
		addDataPanel.add(officeCodeLabel, gbc_officeCodeLabel);
		
		//UPDATE TAB
		JPanel updatePanel = new JPanel();
		updatePanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Update data", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tabbedPanel.addTab("Update", null, updatePanel, null);
		GridBagLayout gbl_updatePanel = new GridBagLayout();
		gbl_updatePanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_updatePanel.rowHeights = new int[]{40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 0, 0};
		gbl_updatePanel.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_updatePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		updatePanel.setLayout(gbl_updatePanel);
		
		// UPDATE ID LABEL
		JLabel updateIdLabel = new JLabel("ID:");
		GridBagConstraints gbc_updateIdLabel = new GridBagConstraints();
		gbc_updateIdLabel.anchor = GridBagConstraints.EAST;
		gbc_updateIdLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updateIdLabel.gridx = 0;
		gbc_updateIdLabel.gridy = 0;
		updatePanel.add(updateIdLabel, gbc_updateIdLabel);
		
		// UPDATE ID TEXT FIELD
		updateIdTextField = new JTextField();
		updateIdTextField.setText("");
		updateIdTextField.setColumns(10);
		GridBagConstraints gbc_updateIdTextField = new GridBagConstraints();
		gbc_updateIdTextField.gridwidth = 2;
		gbc_updateIdTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateIdTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateIdTextField.gridx = 1;
		gbc_updateIdTextField.gridy = 0;
		updatePanel.add(updateIdTextField, gbc_updateIdTextField);
		
		JLabel updateEmployeeNumberLabel = new JLabel("Employee number:");
		GridBagConstraints gbc_updateEmployeeNumberLabel = new GridBagConstraints();
		gbc_updateEmployeeNumberLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updateEmployeeNumberLabel.anchor = GridBagConstraints.EAST;
		gbc_updateEmployeeNumberLabel.gridx = 0;
		gbc_updateEmployeeNumberLabel.gridy = 1;
		updatePanel.add(updateEmployeeNumberLabel, gbc_updateEmployeeNumberLabel);
		
		updateEmployeeNumberTextField = new JTextField();
		GridBagConstraints gbc_updateEmployeeNumberTextField = new GridBagConstraints();
		gbc_updateEmployeeNumberTextField.gridwidth = 2;
		gbc_updateEmployeeNumberTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateEmployeeNumberTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateEmployeeNumberTextField.gridx = 1;
		gbc_updateEmployeeNumberTextField.gridy = 1;
		updatePanel.add(updateEmployeeNumberTextField, gbc_updateEmployeeNumberTextField);
		updateEmployeeNumberTextField.setColumns(10);
		
		// UPDATE FIRST NAME LABEL
		JLabel updateFirstNameLabel = new JLabel("First Name:");
		GridBagConstraints gbc_updateFirstNameLabel = new GridBagConstraints();
		gbc_updateFirstNameLabel.anchor = GridBagConstraints.EAST;
		gbc_updateFirstNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updateFirstNameLabel.gridx = 0;
		gbc_updateFirstNameLabel.gridy = 2;
		updatePanel.add(updateFirstNameLabel, gbc_updateFirstNameLabel);
		
		// UPDATE FIRST NAME TEXT FIELD
		updateFirstNameTextField = new JTextField();
		updateFirstNameTextField.setText("");
		GridBagConstraints gbc_updateFirstNameTextField = new GridBagConstraints();
		gbc_updateFirstNameTextField.gridwidth = 2;
		gbc_updateFirstNameTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateFirstNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateFirstNameTextField.gridx = 1;
		gbc_updateFirstNameTextField.gridy = 2;
		updatePanel.add(updateFirstNameTextField, gbc_updateFirstNameTextField);
		updateFirstNameTextField.setColumns(10);
		
		// UPDATE LAST NAME LABEL
		JLabel updateLastNameLabel = new JLabel("Last Name:");
		GridBagConstraints gbc_updateLastNameLabel = new GridBagConstraints();
		gbc_updateLastNameLabel.anchor = GridBagConstraints.EAST;
		gbc_updateLastNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updateLastNameLabel.gridx = 0;
		gbc_updateLastNameLabel.gridy = 3;
		updatePanel.add(updateLastNameLabel, gbc_updateLastNameLabel);
		
		// UPDATE LAST NAME TEXT FIELD
		updateLastNameTextField = new JTextField();
		updateLastNameTextField.setText("");
		updateLastNameTextField.setColumns(10);
		GridBagConstraints gbc_updateLastNameTextField = new GridBagConstraints();
		gbc_updateLastNameTextField.gridwidth = 2;
		gbc_updateLastNameTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateLastNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateLastNameTextField.gridx = 1;
		gbc_updateLastNameTextField.gridy = 3;
		updatePanel.add(updateLastNameTextField, gbc_updateLastNameTextField);
		
		// UPDATE EMAIL LABEL
		JLabel updateExtensionLabel = new JLabel("Extension: ");
		GridBagConstraints gbc_updateExtensionLabel = new GridBagConstraints();
		gbc_updateExtensionLabel.anchor = GridBagConstraints.EAST;
		gbc_updateExtensionLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updateExtensionLabel.gridx = 0;
		gbc_updateExtensionLabel.gridy = 4;
		updatePanel.add(updateExtensionLabel, gbc_updateExtensionLabel);
		
		// UPDATE EMAIL TEXT FIELD
		updateExtensionTextField = new JTextField();
		updateExtensionTextField.setText("");
		updateExtensionTextField.setColumns(10);
		GridBagConstraints gbc_updateExtensionTextField = new GridBagConstraints();
		gbc_updateExtensionTextField.gridwidth = 2;
		gbc_updateExtensionTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateExtensionTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateExtensionTextField.gridx = 1;
		gbc_updateExtensionTextField.gridy = 4;
		updatePanel.add(updateExtensionTextField, gbc_updateExtensionTextField);
		
		JLabel updateEmailLabel = new JLabel("Email: ");
		GridBagConstraints gbc_updateEmailLabel = new GridBagConstraints();
		gbc_updateEmailLabel.anchor = GridBagConstraints.EAST;
		gbc_updateEmailLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updateEmailLabel.gridx = 0;
		gbc_updateEmailLabel.gridy = 5;
		updatePanel.add(updateEmailLabel, gbc_updateEmailLabel);
		
		updateEmailTextField = new JTextField();
		GridBagConstraints gbc_updateEmailTextField = new GridBagConstraints();
		gbc_updateEmailTextField.gridwidth = 2;
		gbc_updateEmailTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateEmailTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateEmailTextField.gridx = 1;
		gbc_updateEmailTextField.gridy = 5;
		updatePanel.add(updateEmailTextField, gbc_updateEmailTextField);
		updateEmailTextField.setColumns(10);
		
		// UPDATE DEPARTMENT LABEL
		JLabel updateOfficeCodeLabel = new JLabel("Office code: ");
		GridBagConstraints gbc_updateOfficeCodeLabel = new GridBagConstraints();
		gbc_updateOfficeCodeLabel.anchor = GridBagConstraints.EAST;
		gbc_updateOfficeCodeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updateOfficeCodeLabel.gridx = 0;
		gbc_updateOfficeCodeLabel.gridy = 6;
		updatePanel.add(updateOfficeCodeLabel, gbc_updateOfficeCodeLabel);
		
		// UPDATE DEPARTMENT TEXT FIELD
		updateOfficeCodeTextField = new JTextField();
		updateOfficeCodeTextField.setText("");
		updateOfficeCodeTextField.setColumns(10);
		GridBagConstraints gbc_updateOfficeCodeTextField = new GridBagConstraints();
		gbc_updateOfficeCodeTextField.gridwidth = 2;
		gbc_updateOfficeCodeTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateOfficeCodeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateOfficeCodeTextField.gridx = 1;
		gbc_updateOfficeCodeTextField.gridy = 6;
		updatePanel.add(updateOfficeCodeTextField, gbc_updateOfficeCodeTextField);
		
		// UPDATE SALARY LABEL
		JLabel updateReportsToLabel = new JLabel("Reports to: ");
		GridBagConstraints gbc_updateReportsToLabel = new GridBagConstraints();
		gbc_updateReportsToLabel.anchor = GridBagConstraints.EAST;
		gbc_updateReportsToLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updateReportsToLabel.gridx = 0;
		gbc_updateReportsToLabel.gridy = 7;
		updatePanel.add(updateReportsToLabel, gbc_updateReportsToLabel);
		
		// UPDATE SALARY TEXT FIELD
		updateReportsToTextField = new JTextField();
		updateReportsToTextField.setText("");
		updateReportsToTextField.setColumns(10);
		GridBagConstraints gbc_updateSalaryTextField = new GridBagConstraints();
		gbc_updateSalaryTextField.gridwidth = 2;
		gbc_updateSalaryTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateSalaryTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateSalaryTextField.gridx = 1;
		gbc_updateSalaryTextField.gridy = 7;
		updatePanel.add(updateReportsToTextField, gbc_updateSalaryTextField);
		
		JLabel updateJobTitleLabel = new JLabel("Job title: ");
		GridBagConstraints gbc_updateJobTitleLabel = new GridBagConstraints();
		gbc_updateJobTitleLabel.anchor = GridBagConstraints.EAST;
		gbc_updateJobTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updateJobTitleLabel.gridx = 0;
		gbc_updateJobTitleLabel.gridy = 8;
		updatePanel.add(updateJobTitleLabel, gbc_updateJobTitleLabel);
		
		updateJobTitleTextField = new JTextField();
		GridBagConstraints gbc_updateJobTitleTextField = new GridBagConstraints();
		gbc_updateJobTitleTextField.gridwidth = 2;
		gbc_updateJobTitleTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateJobTitleTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateJobTitleTextField.gridx = 1;
		gbc_updateJobTitleTextField.gridy = 8;
		updatePanel.add(updateJobTitleTextField, gbc_updateJobTitleTextField);
		updateJobTitleTextField.setColumns(10);
		
		// UPDATE BUTTON
		JButton updateBtn = new JButton("Update");
		GridBagConstraints gbc_updateBtn = new GridBagConstraints();
		gbc_updateBtn.insets = new Insets(0, 0, 0, 5);
		gbc_updateBtn.gridx = 1;
		gbc_updateBtn.gridy = 9;
		updatePanel.add(updateBtn, gbc_updateBtn);
		
		// CLEAR UPDATE BUTTON
		JButton ClearUpdateBtn = new JButton("Clear");
		GridBagConstraints gbc_ClearUpdateBtn = new GridBagConstraints();
		gbc_ClearUpdateBtn.insets = new Insets(0, 0, 0, 5);
		gbc_ClearUpdateBtn.gridx = 2;
		gbc_ClearUpdateBtn.gridy = 9;
		updatePanel.add(ClearUpdateBtn, gbc_ClearUpdateBtn);
		
		
		
		//DATABASE PANEL
		JPanel databasePanel = new JPanel();
		databasePanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Database View", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_databasePanel = new GridBagConstraints();
		gbc_databasePanel.gridheight = 5;
		gbc_databasePanel.gridwidth = 10;
		gbc_databasePanel.insets = new Insets(0, 0, 5, 0);
		gbc_databasePanel.fill = GridBagConstraints.BOTH;
		gbc_databasePanel.gridx = 1;
		gbc_databasePanel.gridy = 0;
		frame.getContentPane().add(databasePanel, gbc_databasePanel);
		GridBagLayout gbl_databasePanel = new GridBagLayout();
		gbl_databasePanel.columnWidths = new int[] {40, 52, 40, 52, 40, 40, 40, 40, 40, 40};
		gbl_databasePanel.rowHeights = new int[] {40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 0};
		gbl_databasePanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		gbl_databasePanel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0};
		databasePanel.setLayout(gbl_databasePanel);
		
		JLabel chooseTableLabel = new JLabel("Choose table: ");
		GridBagConstraints gbc_chooseTableLabel = new GridBagConstraints();
		gbc_chooseTableLabel.insets = new Insets(0, 0, 5, 5);
		gbc_chooseTableLabel.anchor = GridBagConstraints.EAST;
		gbc_chooseTableLabel.gridx = 0;
		gbc_chooseTableLabel.gridy = 0;
		databasePanel.add(chooseTableLabel, gbc_chooseTableLabel);
		
		//DATABASE TEXT AREA
		final JTextArea databaseTextArea = new JTextArea();
		databaseTextArea.setForeground(Color.WHITE);
		databaseTextArea.setEditable(false);
		databaseTextArea.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_databaseTextArea = new GridBagConstraints();
		gbc_databaseTextArea.insets = new Insets(0, 0, 5, 0);
		gbc_databaseTextArea.gridheight = 6;
		gbc_databaseTextArea.gridwidth = 7;
		gbc_databaseTextArea.fill = GridBagConstraints.BOTH;
		gbc_databaseTextArea.gridx = 0;
		gbc_databaseTextArea.gridy = 0;
		databasePanel.add(databaseTextArea, gbc_databaseTextArea);
		
		//DATABASE SCROLL PANE
		JScrollPane databaseScroll = new JScrollPane(databaseTextArea);
		databaseScroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		GridBagConstraints gbc_databaseScroll = new GridBagConstraints();
		gbc_databaseScroll.gridwidth = 7;
		gbc_databaseScroll.gridheight = 9;
		gbc_databaseScroll.insets = new Insets(0, 0, 5, 0);
		gbc_databaseScroll.fill = GridBagConstraints.BOTH;
		gbc_databaseScroll.gridx = 4;
		gbc_databaseScroll.gridy = 0;
		databasePanel.add(databaseScroll, gbc_databaseScroll);
		
		JLabel chooseJobTitleLabel = new JLabel("Choose jobtitle: ");
		GridBagConstraints gbc_chooseJobTitleLabel = new GridBagConstraints();
		gbc_chooseJobTitleLabel.anchor = GridBagConstraints.EAST;
		gbc_chooseJobTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_chooseJobTitleLabel.gridx = 0;
		gbc_chooseJobTitleLabel.gridy = 1;
		databasePanel.add(chooseJobTitleLabel, gbc_chooseJobTitleLabel);
		
		JComboBox chooseJobTitleComboBox = new JComboBox();
		GridBagConstraints gbc_chooseJobTitleComboBox = new GridBagConstraints();
		gbc_chooseJobTitleComboBox.gridwidth = 3;
		gbc_chooseJobTitleComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_chooseJobTitleComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_chooseJobTitleComboBox.gridx = 1;
		gbc_chooseJobTitleComboBox.gridy = 1;
		databasePanel.add(chooseJobTitleComboBox, gbc_chooseJobTitleComboBox);
		
		JLabel dateFromLabel = new JLabel("Date from: ");
		GridBagConstraints gbc_dateFromLabel = new GridBagConstraints();
		gbc_dateFromLabel.anchor = GridBagConstraints.EAST;
		gbc_dateFromLabel.insets = new Insets(0, 0, 5, 5);
		gbc_dateFromLabel.gridx = 0;
		gbc_dateFromLabel.gridy = 2;
		databasePanel.add(dateFromLabel, gbc_dateFromLabel);
		
		dateFromTextField = new JTextField();
		GridBagConstraints gbc_dateFromTextField = new GridBagConstraints();
		gbc_dateFromTextField.insets = new Insets(0, 0, 5, 5);
		gbc_dateFromTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateFromTextField.gridx = 1;
		gbc_dateFromTextField.gridy = 2;
		databasePanel.add(dateFromTextField, gbc_dateFromTextField);
		dateFromTextField.setColumns(10);
		
		JLabel dateToLabel = new JLabel("to: ");
		GridBagConstraints gbc_dateToLabel = new GridBagConstraints();
		gbc_dateToLabel.insets = new Insets(0, 0, 5, 5);
		gbc_dateToLabel.gridx = 2;
		gbc_dateToLabel.gridy = 2;
		databasePanel.add(dateToLabel, gbc_dateToLabel);
		
		dateToTextField = new JTextField();
		GridBagConstraints gbc_dateToTextField = new GridBagConstraints();
		gbc_dateToTextField.insets = new Insets(0, 0, 5, 5);
		gbc_dateToTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateToTextField.gridx = 3;
		gbc_dateToTextField.gridy = 2;
		databasePanel.add(dateToTextField, gbc_dateToTextField);
		dateToTextField.setColumns(10);
		
		JButton searchByDateBtn = new JButton("Search by date");
		GridBagConstraints gbc_searchByDateBtn = new GridBagConstraints();
		gbc_searchByDateBtn.insets = new Insets(0, 0, 5, 5);
		gbc_searchByDateBtn.gridx = 1;
		gbc_searchByDateBtn.gridy = 3;
		databasePanel.add(searchByDateBtn, gbc_searchByDateBtn);
		
		//REFRESH BUTTON
		JButton refreshDbBtn = new JButton("Refresh");
		GridBagConstraints gbc_refreshDbBtn = new GridBagConstraints();
		gbc_refreshDbBtn.insets = new Insets(0, 0, 5, 5);
		gbc_refreshDbBtn.gridwidth = 2;
		gbc_refreshDbBtn.gridx = 6;
		gbc_refreshDbBtn.gridy = 9;
		databasePanel.add(refreshDbBtn, gbc_refreshDbBtn);
		refreshDbBtn.setToolTipText("Refresh to show all the employees in the database");
		
		//CLEAR BUTTON
		JButton clearDbBtn = new JButton("Clear");
		GridBagConstraints gbc_clearDbBtn = new GridBagConstraints();
		gbc_clearDbBtn.insets = new Insets(0, 0, 5, 5);
		gbc_clearDbBtn.gridwidth = 2;
		gbc_clearDbBtn.gridx = 8;
		gbc_clearDbBtn.gridy = 9;
		databasePanel.add(clearDbBtn, gbc_clearDbBtn);
		
		JComboBox chooseTableComboBox = new JComboBox();
		GridBagConstraints gbc_chooseTableComboBox = new GridBagConstraints();
		gbc_chooseTableComboBox.gridwidth = 3;
		gbc_chooseTableComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_chooseTableComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_chooseTableComboBox.gridx = 1;
		gbc_chooseTableComboBox.gridy = 0;
		databasePanel.add(chooseTableComboBox, gbc_chooseTableComboBox);
		
		//CONSOLE PANEL
		JPanel consolePanel = new JPanel();
		consolePanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Console", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_consolePanel = new GridBagConstraints();
		gbc_consolePanel.gridwidth = 10;
		gbc_consolePanel.gridheight = 5;
		gbc_consolePanel.fill = GridBagConstraints.BOTH;
		gbc_consolePanel.gridx = 1;
		gbc_consolePanel.gridy = 5;
		frame.getContentPane().add(consolePanel, gbc_consolePanel);
		GridBagLayout gbl_consolePanel = new GridBagLayout();
		gbl_consolePanel.columnWidths = new int[] {40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40};
		gbl_consolePanel.rowHeights = new int[] {40, 40, 40, 0};
		gbl_consolePanel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_consolePanel.rowWeights = new double[]{1.0, Double.MIN_VALUE, 0.0, 1.0};
		consolePanel.setLayout(gbl_consolePanel);
		
		//CONSOLE TEXT AREA
		final JTextArea consoleTextArea = new JTextArea();
		consoleTextArea.setEditable(false);
		consoleTextArea.setForeground(Color.WHITE);
		consoleTextArea.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_consoleTextArea = new GridBagConstraints();
		gbc_consoleTextArea.gridheight = 3;
		gbc_consoleTextArea.gridwidth = 10;
		gbc_consoleTextArea.insets = new Insets(0, 0, 0, 5);
		gbc_consoleTextArea.fill = GridBagConstraints.BOTH;
		gbc_consoleTextArea.gridx = 0;
		gbc_consoleTextArea.gridy = 0;
		consolePanel.add(consoleTextArea, gbc_consoleTextArea);
		
		//CONSOLE SCROLL PANE
		JScrollPane consoleScroll = new JScrollPane(consoleTextArea);
		consoleScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_consoleScroll = new GridBagConstraints();
		gbc_consoleScroll.insets = new Insets(0, 0, 5, 0);
		gbc_consoleScroll.gridheight = 3;
		gbc_consoleScroll.gridwidth = 15;
		gbc_consoleScroll.fill = GridBagConstraints.BOTH;
		gbc_consoleScroll.gridx = 0;
		gbc_consoleScroll.gridy = 0;
		consolePanel.add(consoleScroll, gbc_consoleScroll);
		
		//CLEAR CONSOLE BUTTON
		JButton clearConsoleBtn = new JButton("Clear console");
		GridBagConstraints gbc_clearConsoleBtn = new GridBagConstraints();
		gbc_clearConsoleBtn.gridwidth = 2;
		gbc_clearConsoleBtn.insets = new Insets(0, 0, 0, 5);
		gbc_clearConsoleBtn.gridx = 0;
		gbc_clearConsoleBtn.gridy = 3;
		consolePanel.add(clearConsoleBtn, gbc_clearConsoleBtn);
		clearConsoleBtn.setToolTipText("Clear the console window");
		
		//MENU BAR
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		frame.setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		JMenuItem saveToFileItem = new JMenuItem("Save to file");
		saveToFileItem.setHorizontalAlignment(SwingConstants.LEFT);
		fileMenu.add(saveToFileItem);
		
		JMenuItem bulkImportItem = new JMenuItem("Bulk import from file...");
		bulkImportItem.setHorizontalAlignment(SwingConstants.LEFT);
		fileMenu.add(bulkImportItem);
		
		//DATABASE MENU
		JMenu databaseMenu = new JMenu("Database");
		databaseMenu.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(databaseMenu);
		
		//TEST CONNECTION DATABASE MENU ITEM
		JMenuItem dbTestConnectionItem = new JMenuItem("Test database connection");
		dbTestConnectionItem.setHorizontalAlignment(SwingConstants.LEFT);
		databaseMenu.add(dbTestConnectionItem);
		
		//HELP MENU
		JMenu helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);
		
		//ABOUT HELP MENU ITEM
		JMenuItem aboutItem = new JMenuItem("About the application");
		aboutItem.setHorizontalAlignment(SwingConstants.LEFT);
		helpMenu.add(aboutItem);
		aboutItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				consoleTextArea.setText("Hei på deg");
			}
		});
		
		//EXIT MENU
		JMenu exitMenu = new JMenu("Exit");
		menuBar.add(exitMenu);
		
		//EXIT APPLICATION EXIT MENU ITEM
		JMenuItem exitItem = new JMenuItem("Exit the application");
		exitItem.setHorizontalAlignment(SwingConstants.LEFT);
		exitMenu.add(exitItem);
		
//----------------ACTION EVENT LISTENERS---------------//
		
		//makes new stringwriter and throwable objects that can be used to print stacktrace to console text area in application
		final StringWriter stackTraceWriter = new StringWriter();
		final Throwable throwableElement = new Throwable();
		final JFileChooser fileChooser = new JFileChooser();
		
		//REFRESH DB BUTTON - shows updated count of all employees in database text area
        refreshDbBtn.addActionListener(new ActionListener() { 
        	public void actionPerformed(ActionEvent refreshDb) {
        		DatabaseConnection db = new DatabaseConnection();
        		try {
					List<Employee> employees = db.showEmployees();
					databaseTextArea.setText("");
	                for (Employee employee : employees) {
	                    databaseTextArea.append(employee.getEmployeeNumber() + ": " + employee.getLastName() + ", " + employee.getFirstName() + ", " + employee.getExtension() + ", " + employee.getEmail() +  ", " + employee.getOfficeCode() + ", " + employee.getReportsTo() + ", " + employee.getJobTitle() + "\n");
	                } 
				} catch (SQLException error) {
					consoleTextArea.append("Problem fetching from database. Error: " + error);
					throwableElement.printStackTrace(new PrintWriter(stackTraceWriter));
					consoleTextArea.append("Connection failed. Error: " + 
											throwableElement.toString() + "\n" 
											+ stackTraceWriter.toString());
				}
        	} 
        });
		
        //CLEAR DATABASE BUTTON
        clearDbBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				databaseTextArea.setText("");
				}
        });
        
		//CLEAR CONSOLE BUTTON EVENT
		clearConsoleBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				consoleTextArea.setText("");
				}
			});
		
		//DELETE BUTTON EVENT
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					databaseConnection.deleteEmployee(Integer.parseInt(employeeNumberTextField.getText()));
					consoleTextArea.append("Employee with id: " + employeeNumberTextField.getText() +  " has been deleted. \n");
					employeeNumberTextField.setText("");
					
					//REFRESHING DATABASE
					List<Employee> employees = databaseConnection.showEmployees();
					databaseTextArea.setText("");
	                for (Employee employee : employees) {
	                    databaseTextArea.append(employee.getEmployeeNumber() + ": " + employee.getLastName() + ", " + employee.getFirstName() + ", " + employee.getExtension() + ", " + employee.getEmail() + ", "  + employee.getReportsTo() + ", " + employee.getJobTitle() + "\n");
	                } 
				}catch (NumberFormatException | SQLException error) {
					consoleTextArea.append("ID must be a valid ID\n");
				}
			}
		});
		
		//UPDATE BUTTON EVENT
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					databaseConnection.updateUser(getUpdateLastName(), getUpdateFirstName(), getUpdateExtension(), getUpdateEmail(), getUpdateOfficeCode(),  getUpdateReportsTo(), getUpdateJobTitle(), getUpdateEmployeeNumber());
					consoleTextArea.append("User with user-ID: " + getUpdateId() + " has been updated. \n");
				} catch(Exception err){
					consoleTextArea.append("Something went wrong. Error: " + err + "\n");
					err.printStackTrace();
				}
			}
		});
		
		//APPLY BUTTON EVENT
		applyBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					int employeeNumber = getEmployeeNumber();
					String firstName = getFirstName();
					String lastName = getLastName();
					String extension = getExtension();
					String email = getEmail();
					String officeCode = getOfficeCode();
					int reportsTo = getReportsTo();
					String jobTitle = getJobTitle();
					
					if (firstName.isEmpty() && lastName.isEmpty() && extension.isEmpty() && email.isEmpty() && officeCode.isEmpty() && jobTitle.isEmpty())
					{
						
						throw new MissingTextFieldException("you must fill out all the fields");
					}
					
					else if (firstName.isEmpty())
						throw new MissingTextFieldException("firstName is not present");
					else if (lastName.isEmpty())
						throw new MissingTextFieldException("lastName is not present");
					else if (email.isEmpty())
						throw new MissingTextFieldException("email is not present");
					else if (!email.contains("@"))
						throw new Exception("Email must include @");
					else if (jobTitle.isEmpty())
						throw new MissingTextFieldException("Job title is not present");



					databaseConnection.addEmployee(employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle);
					consoleTextArea.setText("Employee: " + " " +  firstName + " " + lastName + " is added\n");
					
				}
				catch (NumberFormatException exception)
				{
					consoleTextArea.append("salary must be a number: " + exception.getMessage() + "\n");
				}
				catch (MissingTextFieldException exception)
				{
				    consoleTextArea.append(exception.getMessage() + "\n");        
				}
				catch (Exception exception) {
					consoleTextArea.append("Something went wrong when adding new Employee : " + exception.getMessage() + "\n");
				}
			}
		});
		
		//CLEAR BUTTON EVENT
		clearBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				employeeNumberTextField.setText(null);
				firstNameTextField.setText(null);
				lastNameTextField.setText(null);
				extensionTextField.setText(null);
				lastNameTextField.setText(null);
				emailTextField.setText(null);
				consoleTextArea.append("All fields have been cleared. \n");
				}
			});
		
		//TEST CONNECTION EVENT
		dbTestConnectionItem.addActionListener(new ActionListener() {
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
			});
		
		//EXIT EVENT
		exitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		//BULK IMPORT EVENT
		bulkImportItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fileChooser.setDialogTitle("Specify a file to write to database ");

				//Set default folder
				fileChooser.setCurrentDirectory(new File("c:\\temp"));

				fileChooser.showSaveDialog(null);
			}
		});

		//SAVE TO FILE EVENT
		saveToFileItem.addActionListener(new ActionListener() {
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
		});
		
	}
	
//-------------------------ADDITIONAL METHODS-------------------------//
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	public int getUpdateId() {
		return Integer.parseInt(updateIdTextField.getText());
	}
	
	public String getUpdateFirstName() {
		return updateFirstNameTextField.getText();
	}
	
	public String getUpdateLastName() {
		return updateLastNameTextField.getText();
	}

	public String getUpdateExtension() {
		return updateExtensionTextField.getText();
	}
	
	public String getUpdateOfficeCode() {
		return updateOfficeCodeTextField.getText();
	}
	
	public String getUpdateEmail() {
		return updateExtensionTextField.getText();
	}
	
	public int getUpdateReportsTo() {
		return Integer.parseInt(updateEmployeeNumberTextField.getText());
	}

	public String getUpdateJobTitle() {
		return updateJobTitleTextField.getText();
	}

	public int getUpdateEmployeeNumber() {
		return Integer.parseInt(updateEmployeeNumberTextField.getText());
	}


	public int getEmployeeNumber() {
		return Integer.parseInt(employeeNumberTextField.getText());
	}

	public String getLastName() {
		return firstNameTextField.getText();
	}

	public String getFirstName() {
		return employeeNumberTextField.getText();
	}

	public String getExtension() {
		return extensionTextField.getText();
	}


	public String getEmail() {
		return lastNameTextField.getText();
	}

	public String getOfficeCode() {
		return officeCodeTextField.getText();
	}

	public int getReportsTo() {
		return Integer.parseInt(reportsToTextField.getText());
	}

	public String getJobTitle() {
		return jobTitleTextField.getText();
	}

	public void writeToFile(String text, File file) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		writer.write(text);
		writer.close();
	}

	public void readFromFile(String text, File file) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		reader.read(CharBuffer.wrap(text));
		reader.close();
	}
}
