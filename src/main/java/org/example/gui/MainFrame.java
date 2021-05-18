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
private JTextField firstNameTextField;
private JTextField lastNameTextField;
private JTextField emailTextField;
private JTextField departmentTextField;
private JTextField salaryTextField;
private JTextField idTextField;
private JTextField updateFirstNameTextField;
private JTextField updateIdTextField;
private JTextField updateLastNameTextField;
private JTextField updateEmailTextField;
private JTextField updateDepartmentTextField;
private JTextField updateSalaryTextField;

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
		frame.setBounds(100, 100, 771, 565);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {40, 40, 40, 40, 40, 40, 40, 40, 40, 40};
		gridBagLayout.rowHeights = new int[] {40, 40, 40, 40, 40, 40, 40, 40, 40, 40};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		frame.getContentPane().setLayout(gridBagLayout);
		
		//TABBED PANEL
		JTabbedPane tabbedPanel = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPanel = new GridBagConstraints();
		gbc_tabbedPanel.gridheight = 7;
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
		gbl_addPanel.rowHeights = new int[] {40, 40, 40, 40, 40, 40};
		gbl_addPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_addPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		addPanel.setLayout(gbl_addPanel);
		
		//ADD DATA PANEL
		JPanel addDataPanel = new JPanel();
		addDataPanel.setBorder(new TitledBorder(null, "Add data", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_addDataPanel = new GridBagConstraints();
		gbc_addDataPanel.gridwidth = 5;
		gbc_addDataPanel.gridheight = 6;
		gbc_addDataPanel.fill = GridBagConstraints.BOTH;
		gbc_addDataPanel.gridx = 0;
		gbc_addDataPanel.gridy = 0;
		addPanel.add(addDataPanel, gbc_addDataPanel);
		GridBagLayout gbl_addDataPanel = new GridBagLayout();
		gbl_addDataPanel.columnWidths = new int[] {40, 40, 40, 30, 40, 40, 40};
		gbl_addDataPanel.rowHeights = new int[] {40, 40, 40, 40, 40, 40, 40};
		gbl_addDataPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0};
		gbl_addDataPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		addDataPanel.setLayout(gbl_addDataPanel);
		
		//FIRST NAME LABEL
		JLabel firstNameLabel = new JLabel("First name:");
		GridBagConstraints gbc_firstNameLabel = new GridBagConstraints();
		gbc_firstNameLabel.anchor = GridBagConstraints.EAST;
		gbc_firstNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_firstNameLabel.gridwidth = 2;
		gbc_firstNameLabel.gridx = 0;
		gbc_firstNameLabel.gridy = 0;
		addDataPanel.add(firstNameLabel, gbc_firstNameLabel);
		
		//FIRST NAME TEXT FIELD
		firstNameTextField = new JTextField();
		firstNameTextField.setColumns(10);
		GridBagConstraints gbc_firstNameTextField = new GridBagConstraints();
		gbc_firstNameTextField.gridwidth = 4;
		gbc_firstNameTextField.insets = new Insets(0, 0, 5, 0);
		gbc_firstNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_firstNameTextField.gridx = 2;
		gbc_firstNameTextField.gridy = 0;
		addDataPanel.add(firstNameTextField, gbc_firstNameTextField);
		
		//LAST NAME TEXT FIELD
		JLabel lastNameLabel = new JLabel("Last name:");
		GridBagConstraints gbc_lastNameLabel = new GridBagConstraints();
		gbc_lastNameLabel.anchor = GridBagConstraints.EAST;
		gbc_lastNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lastNameLabel.gridwidth = 2;
		gbc_lastNameLabel.gridx = 0;
		gbc_lastNameLabel.gridy = 1;
		addDataPanel.add(lastNameLabel, gbc_lastNameLabel);
		
		//LAST NAME TEXT FIELD
		lastNameTextField = new JTextField();
		lastNameTextField.setColumns(10);
		GridBagConstraints gbc_lastNameTextField = new GridBagConstraints();
		gbc_lastNameTextField.gridwidth = 4;
		gbc_lastNameTextField.insets = new Insets(0, 0, 5, 0);
		gbc_lastNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_lastNameTextField.gridx = 2;
		gbc_lastNameTextField.gridy = 1;
		addDataPanel.add(lastNameTextField, gbc_lastNameTextField);
		
		//EMAIL LABEL
		JLabel emailLabel = new JLabel("Email:");
		GridBagConstraints gbc_emailLabel = new GridBagConstraints();
		gbc_emailLabel.anchor = GridBagConstraints.EAST;
		gbc_emailLabel.insets = new Insets(0, 0, 5, 5);
		gbc_emailLabel.gridwidth = 2;
		gbc_emailLabel.gridx = 0;
		gbc_emailLabel.gridy = 2;
		addDataPanel.add(emailLabel, gbc_emailLabel);
		
		//EMAIL TEXT FIELD
		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		GridBagConstraints gbc_emailTextField = new GridBagConstraints();
		gbc_emailTextField.gridwidth = 4;
		gbc_emailTextField.insets = new Insets(0, 0, 5, 0);
		gbc_emailTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_emailTextField.gridx = 2;
		gbc_emailTextField.gridy = 2;
		addDataPanel.add(emailTextField, gbc_emailTextField);
		
		//DEPARTMENT LABEL
		JLabel departmentLabel = new JLabel("Department:");
		GridBagConstraints gbc_departmentLabel = new GridBagConstraints();
		gbc_departmentLabel.anchor = GridBagConstraints.EAST;
		gbc_departmentLabel.insets = new Insets(0, 0, 5, 5);
		gbc_departmentLabel.gridwidth = 2;
		gbc_departmentLabel.gridx = 0;
		gbc_departmentLabel.gridy = 3;
		addDataPanel.add(departmentLabel, gbc_departmentLabel);
		
		//DEPARTMENT TEXT FIELD
		departmentTextField = new JTextField();
		departmentTextField.setColumns(10);
		GridBagConstraints gbc_departmentTextField = new GridBagConstraints();
		gbc_departmentTextField.gridwidth = 4;
		gbc_departmentTextField.insets = new Insets(0, 0, 5, 0);
		gbc_departmentTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_departmentTextField.gridx = 2;
		gbc_departmentTextField.gridy = 3;
		addDataPanel.add(departmentTextField, gbc_departmentTextField);
		
		//SALARY LABEL
		JLabel salaryLabel = new JLabel("Salary:");
		GridBagConstraints gbc_salaryLabel = new GridBagConstraints();
		gbc_salaryLabel.anchor = GridBagConstraints.EAST;
		gbc_salaryLabel.gridwidth = 2;
		gbc_salaryLabel.insets = new Insets(0, 0, 5, 5);
		gbc_salaryLabel.gridx = 0;
		gbc_salaryLabel.gridy = 4;
		addDataPanel.add(salaryLabel, gbc_salaryLabel);
		
		//SALARY TEXT FIELD
		salaryTextField = new JTextField();
		salaryTextField.setColumns(10);
		GridBagConstraints gbc_salaryTextField = new GridBagConstraints();
		gbc_salaryTextField.insets = new Insets(0, 0, 5, 0);
		gbc_salaryTextField.gridwidth = 4;
		gbc_salaryTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_salaryTextField.gridx = 2;
		gbc_salaryTextField.gridy = 4;
		addDataPanel.add(salaryTextField, gbc_salaryTextField);
		
		//APPLY BUTTON
		JButton applyBtn = new JButton("Apply");
		GridBagConstraints gbc_applyBtn = new GridBagConstraints();
		gbc_applyBtn.gridwidth = 3;
		gbc_applyBtn.insets = new Insets(0, 0, 0, 5);
		gbc_applyBtn.gridx = 1;
		gbc_applyBtn.gridy = 5;
		addDataPanel.add(applyBtn, gbc_applyBtn);
		applyBtn.setToolTipText("Insert information into database");
		
		//CLEAR BUTTON
		JButton clearBtn = new JButton("Clear");
		GridBagConstraints gbc_clearBtn = new GridBagConstraints();
		gbc_clearBtn.gridwidth = 3;
		gbc_clearBtn.gridx = 3;
		gbc_clearBtn.gridy = 5;
		addDataPanel.add(clearBtn, gbc_clearBtn);
		clearBtn.setToolTipText("Clears all information in the form");
		
		//UPDATE TAB
		JPanel updatePanel = new JPanel();
		updatePanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Update data", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tabbedPanel.addTab("Update", null, updatePanel, null);
		GridBagLayout gbl_updatePanel = new GridBagLayout();
		gbl_updatePanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_updatePanel.rowHeights = new int[]{40, 40, 40, 40, 40, 40, 40, 0};
		gbl_updatePanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_updatePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		gbc_updateIdTextField.gridwidth = 4;
		gbc_updateIdTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateIdTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateIdTextField.gridx = 1;
		gbc_updateIdTextField.gridy = 0;
		updatePanel.add(updateIdTextField, gbc_updateIdTextField);
		
		// UPDATE FIRST NAME LABEL
		JLabel updateFirstNameLabel = new JLabel("First Name:");
		GridBagConstraints gbc_updateFirstNameLabel = new GridBagConstraints();
		gbc_updateFirstNameLabel.anchor = GridBagConstraints.EAST;
		gbc_updateFirstNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updateFirstNameLabel.gridx = 0;
		gbc_updateFirstNameLabel.gridy = 1;
		updatePanel.add(updateFirstNameLabel, gbc_updateFirstNameLabel);
		
		// UPDATE FIRST NAME TEXT FIELD
		updateFirstNameTextField = new JTextField();
		updateFirstNameTextField.setText("");
		GridBagConstraints gbc_updateFirstNameTextField = new GridBagConstraints();
		gbc_updateFirstNameTextField.gridwidth = 4;
		gbc_updateFirstNameTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateFirstNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateFirstNameTextField.gridx = 1;
		gbc_updateFirstNameTextField.gridy = 1;
		updatePanel.add(updateFirstNameTextField, gbc_updateFirstNameTextField);
		updateFirstNameTextField.setColumns(10);
		
		// UPDATE LAST NAME LABEL
		JLabel updateLastNameLabel = new JLabel("Last Name:");
		GridBagConstraints gbc_updateLastNameLabel = new GridBagConstraints();
		gbc_updateLastNameLabel.anchor = GridBagConstraints.EAST;
		gbc_updateLastNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updateLastNameLabel.gridx = 0;
		gbc_updateLastNameLabel.gridy = 2;
		updatePanel.add(updateLastNameLabel, gbc_updateLastNameLabel);
		
		// UPDATE LAST NAME TEXT FIELD
		updateLastNameTextField = new JTextField();
		updateLastNameTextField.setText("");
		updateLastNameTextField.setColumns(10);
		GridBagConstraints gbc_updateLastNameTextField = new GridBagConstraints();
		gbc_updateLastNameTextField.gridwidth = 4;
		gbc_updateLastNameTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateLastNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateLastNameTextField.gridx = 1;
		gbc_updateLastNameTextField.gridy = 2;
		updatePanel.add(updateLastNameTextField, gbc_updateLastNameTextField);
		
		// UPDATE EMAIL LABEL
		JLabel updateEmailLabel = new JLabel("Email:");
		GridBagConstraints gbc_updateEmailLabel = new GridBagConstraints();
		gbc_updateEmailLabel.anchor = GridBagConstraints.EAST;
		gbc_updateEmailLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updateEmailLabel.gridx = 0;
		gbc_updateEmailLabel.gridy = 3;
		updatePanel.add(updateEmailLabel, gbc_updateEmailLabel);
		
		// UPDATE EMAIL TEXT FIELD
		updateEmailTextField = new JTextField();
		updateEmailTextField.setText("");
		updateEmailTextField.setColumns(10);
		GridBagConstraints gbc_updateEmailTextField = new GridBagConstraints();
		gbc_updateEmailTextField.gridwidth = 4;
		gbc_updateEmailTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateEmailTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateEmailTextField.gridx = 1;
		gbc_updateEmailTextField.gridy = 3;
		updatePanel.add(updateEmailTextField, gbc_updateEmailTextField);
		
		// UPDATE DEPARTMENT LABEL
		JLabel updateDeparmentLabel = new JLabel("Department");
		GridBagConstraints gbc_updateDeparmentLabel = new GridBagConstraints();
		gbc_updateDeparmentLabel.anchor = GridBagConstraints.EAST;
		gbc_updateDeparmentLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updateDeparmentLabel.gridx = 0;
		gbc_updateDeparmentLabel.gridy = 4;
		updatePanel.add(updateDeparmentLabel, gbc_updateDeparmentLabel);
		
		// UPDATE DEPARTMENT TEXT FIELD
		updateDepartmentTextField = new JTextField();
		updateDepartmentTextField.setText("");
		updateDepartmentTextField.setColumns(10);
		GridBagConstraints gbc_updateDepartmentTextField = new GridBagConstraints();
		gbc_updateDepartmentTextField.gridwidth = 4;
		gbc_updateDepartmentTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateDepartmentTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateDepartmentTextField.gridx = 1;
		gbc_updateDepartmentTextField.gridy = 4;
		updatePanel.add(updateDepartmentTextField, gbc_updateDepartmentTextField);
		
		// UPDATE SALARY LABEL
		JLabel updateSalaryLabel = new JLabel("Salary");
		GridBagConstraints gbc_updateSalaryLabel = new GridBagConstraints();
		gbc_updateSalaryLabel.anchor = GridBagConstraints.EAST;
		gbc_updateSalaryLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updateSalaryLabel.gridx = 0;
		gbc_updateSalaryLabel.gridy = 5;
		updatePanel.add(updateSalaryLabel, gbc_updateSalaryLabel);
		
		// UPDATE SALARY TEXT FIELD
		updateSalaryTextField = new JTextField();
		updateSalaryTextField.setText("");
		updateSalaryTextField.setColumns(10);
		GridBagConstraints gbc_updateSalaryTextField = new GridBagConstraints();
		gbc_updateSalaryTextField.gridwidth = 4;
		gbc_updateSalaryTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateSalaryTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateSalaryTextField.gridx = 1;
		gbc_updateSalaryTextField.gridy = 5;
		updatePanel.add(updateSalaryTextField, gbc_updateSalaryTextField);
		
		// UPDATE BUTTON
		JButton updateBtn = new JButton("Update");
		GridBagConstraints gbc_updateBtn = new GridBagConstraints();
		gbc_updateBtn.insets = new Insets(0, 0, 0, 5);
		gbc_updateBtn.gridx = 1;
		gbc_updateBtn.gridy = 6;
		updatePanel.add(updateBtn, gbc_updateBtn);
		
		// CLEAR UPDATE BUTTON
		JButton ClearUpdateBtn = new JButton("Clear");
		GridBagConstraints gbc_ClearUpdateBtn = new GridBagConstraints();
		gbc_ClearUpdateBtn.insets = new Insets(0, 0, 0, 5);
		gbc_ClearUpdateBtn.gridx = 2;
		gbc_ClearUpdateBtn.gridy = 6;
		updatePanel.add(ClearUpdateBtn, gbc_ClearUpdateBtn);
		
		
		
		//DATABASE PANEL
		JPanel databasePanel = new JPanel();
		databasePanel.setBorder(new TitledBorder(null, "Database", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_databasePanel = new GridBagConstraints();
		gbc_databasePanel.gridheight = 7;
		gbc_databasePanel.gridwidth = 9;
		gbc_databasePanel.insets = new Insets(0, 0, 5, 0);
		gbc_databasePanel.fill = GridBagConstraints.BOTH;
		gbc_databasePanel.gridx = 1;
		gbc_databasePanel.gridy = 0;
		frame.getContentPane().add(databasePanel, gbc_databasePanel);
		GridBagLayout gbl_databasePanel = new GridBagLayout();
		gbl_databasePanel.columnWidths = new int[] {40, 40, 40, 40, 40, 40};
		gbl_databasePanel.rowHeights = new int[] {40, 40, 40, 40, 40, 40, 40};
		gbl_databasePanel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_databasePanel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		databasePanel.setLayout(gbl_databasePanel);
		
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
		gbc_databaseScroll.gridheight = 6;
		gbc_databaseScroll.gridwidth = 7;
		gbc_databaseScroll.insets = new Insets(0, 0, 5, 0);
		gbc_databaseScroll.fill = GridBagConstraints.BOTH;
		gbc_databaseScroll.gridx = 0;
		gbc_databaseScroll.gridy = 0;
		databasePanel.add(databaseScroll, gbc_databaseScroll);
		
		//REFRESH BUTTON
		JButton refreshDbBtn = new JButton("Refresh");
		GridBagConstraints gbc_refreshDbBtn = new GridBagConstraints();
		gbc_refreshDbBtn.insets = new Insets(0, 0, 0, 5);
		gbc_refreshDbBtn.gridwidth = 2;
		gbc_refreshDbBtn.gridx = 2;
		gbc_refreshDbBtn.gridy = 6;
		databasePanel.add(refreshDbBtn, gbc_refreshDbBtn);
		refreshDbBtn.setToolTipText("Refresh to show all the employees in the database");
		
		//CLEAR BUTTON
		JButton clearDbBtn = new JButton("Clear");
		GridBagConstraints gbc_clearDbBtn = new GridBagConstraints();
		gbc_clearDbBtn.gridwidth = 2;
		gbc_clearDbBtn.gridx = 4;
		gbc_clearDbBtn.gridy = 6;
		databasePanel.add(clearDbBtn, gbc_clearDbBtn);

		//SAVE BUTTON
		JButton saveDbBtn = new JButton("Save");
		GridBagConstraints gbc_saveDbBtn = new GridBagConstraints();
		gbc_saveDbBtn.gridwidth = 2;
		gbc_saveDbBtn.gridx = 8;
		gbc_saveDbBtn.gridy = 6;
		databasePanel.add(saveDbBtn, gbc_saveDbBtn);
		saveDbBtn.setToolTipText("save the information from database to text file");
		
		//CONSOLE PANEL
		JPanel consolePanel = new JPanel();
		consolePanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Console", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_consolePanel = new GridBagConstraints();
		gbc_consolePanel.gridwidth = 10;
		gbc_consolePanel.gridheight = 3;
		gbc_consolePanel.fill = GridBagConstraints.BOTH;
		gbc_consolePanel.gridx = 0;
		gbc_consolePanel.gridy = 7;
		frame.getContentPane().add(consolePanel, gbc_consolePanel);
		GridBagLayout gbl_consolePanel = new GridBagLayout();
		gbl_consolePanel.columnWidths = new int[] {40, 40, 40, 40, 40, 40, 40, 40, 40, 40};
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
		gbc_consoleScroll.gridwidth = 10;
		gbc_consoleScroll.fill = GridBagConstraints.BOTH;
		gbc_consoleScroll.gridx = 0;
		gbc_consoleScroll.gridy = 0;
		consolePanel.add(consoleScroll, gbc_consoleScroll);
		
		//CLEAR CONSOLE BUTTON
		JButton clearConsoleBtn = new JButton("Clear");
		GridBagConstraints gbc_clearConsoleBtn = new GridBagConstraints();
		gbc_clearConsoleBtn.insets = new Insets(0, 0, 0, 5);
		gbc_clearConsoleBtn.gridx = 0;
		gbc_clearConsoleBtn.gridy = 3;
		consolePanel.add(clearConsoleBtn, gbc_clearConsoleBtn);
		clearConsoleBtn.setToolTipText("Clear the console window");
		
		//MENU BAR
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		//DATABASE MENU
		JMenu databaseMenu = new JMenu("Database");
		menuBar.add(databaseMenu);
		
		//TEST CONNECTION DATABASE MENU ITEM
		JMenuItem dbTestConnectionItem = new JMenuItem("Test database connection");
		databaseMenu.add(dbTestConnectionItem);
		
		//HELP MENU
		JMenu helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);
		
		//ABOUT HELP MENU ITEM
		JMenuItem aboutItem = new JMenuItem("About the application");
		aboutItem.setHorizontalAlignment(SwingConstants.CENTER);
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
	                    databaseTextArea.append(employee.getId() + ": " + employee.getFirstName() + ", " + employee.getLastName() + ", " + employee.getDepartment() + ", " + employee.getEmail() + ", " + employee.getSalary() + "\n");
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

        //SAVE DATABASE BUTTON
		saveDbBtn.addActionListener(new ActionListener() {
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
				DatabaseConnection db = new DatabaseConnection();
				try{
					databaseConnection.deleteEmployee(Integer.parseInt(idTextField.getText()));
					consoleTextArea.append("Employee with id: " + idTextField.getText() +  " has been deleted. \n");
					idTextField.setText("");
					
					//REFRESHING DATABASE
					List<Employee> employees = db.showEmployees();
					databaseTextArea.setText("");
	                for (Employee employee : employees) {
	                    databaseTextArea.append(employee.getId() + ": " + employee.getFirstName() + ", " + employee.getLastName() + ", " + employee.getDepartment() + ", " + employee.getEmail() + ", " + employee.getSalary() + "\n");
	                } 
				}catch (NumberFormatException | SQLException error) {
					consoleTextArea.append("ID must be a valid ID\n");
				}
			}
		});
		
		//UPDATE BUTTON EVENT
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatabaseConnection db = new DatabaseConnection();
				try {
					db.updateUser(getUpdateFirstName(), getUpdateLastName(), getUpdateDepartment(), getUpdateEmail(), getUpdateSalary(), getUpdateId());
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
					
					
					String firstName = getFirstName();
					String lastName = getLastName();
					String email = getEmail();
					String department = getDepartment();
					double salary;
					
					if (firstName.isEmpty() && lastName.isEmpty() && email.isEmpty() && department.isEmpty() && salaryTextField.getText().isEmpty())
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
					else if (department.isEmpty())
						throw new MissingTextFieldException("department is not present");
					else
					{
					 salary = getSalary();
					 if ( salary < 0 )
						throw new Exception("salary must be a positive number");
					}


					databaseConnection.addEmployee(lastName, firstName, department, email, salary);
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
				firstNameTextField.setText(null);
				lastNameTextField.setText(null);
				emailTextField.setText(null);
				departmentTextField.setText(null);
				emailTextField.setText(null);
				salaryTextField.setText(null);
				consoleTextArea.append("All fields have been cleared. \n");
				}
			});
		
		//TEST CONNECTION EVENT
		dbTestConnectionItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					DatabaseConnection db = new DatabaseConnection();
					db.open();
					db.close();
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
	
	public String getUpdateDepartment() {
		return updateDepartmentTextField.getText();
	}
	
	public String getUpdateEmail() {
		return updateEmailTextField.getText();
	}
	
	public Double getUpdateSalary() {
		return Double.parseDouble(updateSalaryTextField.getText());
	}
	
	public String getLastName() {
		return lastNameTextField.getText();
	}

	public String getFirstName() {
		return firstNameTextField.getText();
	}

	public String getDepartment() {
		return departmentTextField.getText();
	}


	public String getEmail() {
		return emailTextField.getText();
	}

	public double getSalary() {
		return Double.parseDouble(salaryTextField.getText());
	}

	public void writeToFile(String text, File file) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		writer.write(text);
		writer.close();
	}
}
