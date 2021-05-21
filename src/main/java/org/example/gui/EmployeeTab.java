package org.example.gui;

import org.example.database.DatabaseConnection;
import org.example.database.Employee;
import org.example.gui.exceptions.MissingTextFieldException;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;

public class EmployeeTab extends JPanel{
	
	DatabaseConnection db = new DatabaseConnection();
	JFileChooser fileChooser = new JFileChooser();
	
	private final JPanel employeeTab = new JPanel();
	private JPanel AddEmployeePanel;
	private JPanel DeleteEmployeePanel;
	private JPanel UpdateEmployeePanel;
	private JLabel addEmployeeNumberLabel;
	private JTextField addEmployeeNumberTextField;
	private JLabel addFirstNameLabel;
	private JLabel addLastNameLabel;
	private JLabel addExtensionLabel;
	private JLabel addEmailLabel;
	private JLabel addOfficeCodeLabel;
	private JLabel addReportsToLabel;
	private JLabel addJobTitleLabel;
	private JTextField addFirstNameTextField;
	private JTextField addLastNameTextField;
	private JTextField addExtensionTextField;
	private JTextField addEmailTextField;
	private JTextField addOfficeCodeTextField;
	private JTextField addReportsToTextField;
	private JTextField addJobTitleTextField;
	private JButton addEmployeeBtn;
	private JLabel updateEmployeeNumberLabel;
	private JLabel updateFirstNameLabel;
	private JLabel updateLastNameLabel;
	private JLabel updateExtensionLabel;
	private JLabel updateEmailLabel;
	private JLabel updateOfficeCodeLabel;
	private JLabel updateReportsToLabel;
	private JLabel updateJobTitleLabel;
	private JComboBox<Integer> updateEmployeeNumberComboBox;
	private JTextField updateFirstNameTextField;
	private JTextField updateLastNameTextField;
	private JTextField updateExtensionTextField;
	private JTextField updateEmailTextField;
	private JTextField updateOfficeCodeTextField;
	private JTextField updateReportsToTextField;
	private JTextField updateJobTitleTextField;
	private JButton updateEmployeeBtn;
	private JLabel deleteEmployeeNumberLabel;
	private JComboBox<Integer> deleteEmployeeNumberComboBox;
	private JButton deleteEmployeeBtn;
	private JPanel EmployeeDatabasePanel;
	private JTextArea databaseTextArea;
	private JButton refreshDatabaseTextAreaBtn;
	private JComboBox<String> chooseJobTitleComboBox;
	private JLabel chooseJobTitleLabel;
	private JPanel EmployeeConsolePanel;
	private JTextArea consoleTextArea;
	private JButton clearConsoleBtn;
	private JButton sortDatabaseViewBtn;
	private JButton saveBtn;
	
	//-------------------MAIN CONTENT------------------//
	public EmployeeTab() {
		
		//----------------CONTENT----------------//
		
        GridBagLayout gbl_employeeTab = new GridBagLayout();
        gbl_employeeTab.columnWidths = new int[] {80, 80, 80, 80, 80, 80, 80, 80, 80, 80};
        gbl_employeeTab.rowHeights = new int[] {60, 60, 60, 60, 60, 60, 60, 60, 60, 60};
        gbl_employeeTab.columnWeights = new double[]{1.0};
        gbl_employeeTab.rowWeights = new double[]{Double.MIN_VALUE};
        employeeTab.setLayout(gbl_employeeTab);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{266, 266, 266, 0};
		gridBagLayout.rowHeights = new int[]{130, 130, 228};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0};
		setLayout(gridBagLayout);

		AddEmployeePanel = new JPanel();
		AddEmployeePanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Add employee", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_AddEmployeePanel = new GridBagConstraints();
		gbc_AddEmployeePanel.gridheight = 2;
		gbc_AddEmployeePanel.insets = new Insets(0, 0, 5, 5);
		gbc_AddEmployeePanel.fill = GridBagConstraints.BOTH;
		gbc_AddEmployeePanel.gridx = 0;
		gbc_AddEmployeePanel.gridy = 0;
		add(AddEmployeePanel, gbc_AddEmployeePanel);
		GridBagLayout gbl_AddEmployeePanel = new GridBagLayout();
		gbl_AddEmployeePanel.columnWidths = new int[]{95, 112, 0};
		gbl_AddEmployeePanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_AddEmployeePanel.columnWeights = new double[]{1.0, 1.0, 0.0};
		gbl_AddEmployeePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		AddEmployeePanel.setLayout(gbl_AddEmployeePanel);

		addEmployeeNumberLabel = new JLabel("Employee number: ");
		GridBagConstraints gbc_addEmployeeNumberLabel = new GridBagConstraints();
		gbc_addEmployeeNumberLabel.anchor = GridBagConstraints.EAST;
		gbc_addEmployeeNumberLabel.insets = new Insets(0, 0, 5, 5);
		gbc_addEmployeeNumberLabel.gridx = 0;
		gbc_addEmployeeNumberLabel.gridy = 0;
		AddEmployeePanel.add(addEmployeeNumberLabel, gbc_addEmployeeNumberLabel);

		addEmployeeNumberTextField = new JTextField();
		GridBagConstraints gbc_addEmployeeNumberTextField = new GridBagConstraints();
		gbc_addEmployeeNumberTextField.insets = new Insets(0, 0, 5, 5);
		gbc_addEmployeeNumberTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_addEmployeeNumberTextField.gridx = 1;
		gbc_addEmployeeNumberTextField.gridy = 0;
		AddEmployeePanel.add(addEmployeeNumberTextField, gbc_addEmployeeNumberTextField);
		addEmployeeNumberTextField.setColumns(10);

		addFirstNameLabel = new JLabel("First name: ");
		GridBagConstraints gbc_addFirstNameLabel = new GridBagConstraints();
		gbc_addFirstNameLabel.anchor = GridBagConstraints.EAST;
		gbc_addFirstNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_addFirstNameLabel.gridx = 0;
		gbc_addFirstNameLabel.gridy = 1;
		AddEmployeePanel.add(addFirstNameLabel, gbc_addFirstNameLabel);

		addFirstNameTextField = new JTextField();
		addFirstNameTextField.setColumns(10);
		GridBagConstraints gbc_addFirstNameTextField = new GridBagConstraints();
		gbc_addFirstNameTextField.insets = new Insets(0, 0, 5, 5);
		gbc_addFirstNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_addFirstNameTextField.gridx = 1;
		gbc_addFirstNameTextField.gridy = 1;
		AddEmployeePanel.add(addFirstNameTextField, gbc_addFirstNameTextField);

		addLastNameLabel = new JLabel("Last name: ");
		GridBagConstraints gbc_addLastNameLabel = new GridBagConstraints();
		gbc_addLastNameLabel.anchor = GridBagConstraints.EAST;
		gbc_addLastNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_addLastNameLabel.gridx = 0;
		gbc_addLastNameLabel.gridy = 2;
		AddEmployeePanel.add(addLastNameLabel, gbc_addLastNameLabel);

		addLastNameTextField = new JTextField();
		addLastNameTextField.setColumns(10);
		GridBagConstraints gbc_addLastNameTextField = new GridBagConstraints();
		gbc_addLastNameTextField.insets = new Insets(0, 0, 5, 5);
		gbc_addLastNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_addLastNameTextField.gridx = 1;
		gbc_addLastNameTextField.gridy = 2;
		AddEmployeePanel.add(addLastNameTextField, gbc_addLastNameTextField);

		addExtensionLabel = new JLabel("Extension: ");
		GridBagConstraints gbc_addExtensionLabel = new GridBagConstraints();
		gbc_addExtensionLabel.anchor = GridBagConstraints.EAST;
		gbc_addExtensionLabel.insets = new Insets(0, 0, 5, 5);
		gbc_addExtensionLabel.gridx = 0;
		gbc_addExtensionLabel.gridy = 3;
		AddEmployeePanel.add(addExtensionLabel, gbc_addExtensionLabel);

		addExtensionTextField = new JTextField();
		addExtensionTextField.setColumns(10);
		GridBagConstraints gbc_addExtensionTextField = new GridBagConstraints();
		gbc_addExtensionTextField.insets = new Insets(0, 0, 5, 5);
		gbc_addExtensionTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_addExtensionTextField.gridx = 1;
		gbc_addExtensionTextField.gridy = 3;
		AddEmployeePanel.add(addExtensionTextField, gbc_addExtensionTextField);

		addEmailLabel = new JLabel("Email: ");
		GridBagConstraints gbc_addEmailLabel = new GridBagConstraints();
		gbc_addEmailLabel.anchor = GridBagConstraints.EAST;
		gbc_addEmailLabel.insets = new Insets(0, 0, 5, 5);
		gbc_addEmailLabel.gridx = 0;
		gbc_addEmailLabel.gridy = 4;
		AddEmployeePanel.add(addEmailLabel, gbc_addEmailLabel);

		addEmailTextField = new JTextField();
		addEmailTextField.setColumns(10);
		GridBagConstraints gbc_addEmailTextField = new GridBagConstraints();
		gbc_addEmailTextField.insets = new Insets(0, 0, 5, 5);
		gbc_addEmailTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_addEmailTextField.gridx = 1;
		gbc_addEmailTextField.gridy = 4;
		AddEmployeePanel.add(addEmailTextField, gbc_addEmailTextField);

		addOfficeCodeLabel = new JLabel("Office code: ");
		GridBagConstraints gbc_addOfficeCodeLabel = new GridBagConstraints();
		gbc_addOfficeCodeLabel.anchor = GridBagConstraints.EAST;
		gbc_addOfficeCodeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_addOfficeCodeLabel.gridx = 0;
		gbc_addOfficeCodeLabel.gridy = 5;
		AddEmployeePanel.add(addOfficeCodeLabel, gbc_addOfficeCodeLabel);

		addOfficeCodeTextField = new JTextField();
		addOfficeCodeTextField.setColumns(10);
		GridBagConstraints gbc_addOfficeCodeTextField = new GridBagConstraints();
		gbc_addOfficeCodeTextField.insets = new Insets(0, 0, 5, 5);
		gbc_addOfficeCodeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_addOfficeCodeTextField.gridx = 1;
		gbc_addOfficeCodeTextField.gridy = 5;
		AddEmployeePanel.add(addOfficeCodeTextField, gbc_addOfficeCodeTextField);

		addReportsToLabel = new JLabel("Reports to: ");
		GridBagConstraints gbc_addReportsToLabel = new GridBagConstraints();
		gbc_addReportsToLabel.anchor = GridBagConstraints.EAST;
		gbc_addReportsToLabel.insets = new Insets(0, 0, 5, 5);
		gbc_addReportsToLabel.gridx = 0;
		gbc_addReportsToLabel.gridy = 6;
		AddEmployeePanel.add(addReportsToLabel, gbc_addReportsToLabel);

		addReportsToTextField = new JTextField();
		addReportsToTextField.setColumns(10);
		GridBagConstraints gbc_addReportsToTextField = new GridBagConstraints();
		gbc_addReportsToTextField.insets = new Insets(0, 0, 5, 5);
		gbc_addReportsToTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_addReportsToTextField.gridx = 1;
		gbc_addReportsToTextField.gridy = 6;
		AddEmployeePanel.add(addReportsToTextField, gbc_addReportsToTextField);

		addJobTitleLabel = new JLabel("Job title: ");
		GridBagConstraints gbc_addJobTitleLabel = new GridBagConstraints();
		gbc_addJobTitleLabel.anchor = GridBagConstraints.EAST;
		gbc_addJobTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_addJobTitleLabel.gridx = 0;
		gbc_addJobTitleLabel.gridy = 7;
		AddEmployeePanel.add(addJobTitleLabel, gbc_addJobTitleLabel);

		addJobTitleTextField = new JTextField();
		addJobTitleTextField.setColumns(10);
		GridBagConstraints gbc_addJobTitleTextField = new GridBagConstraints();
		gbc_addJobTitleTextField.insets = new Insets(0, 0, 5, 5);
		gbc_addJobTitleTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_addJobTitleTextField.gridx = 1;
		gbc_addJobTitleTextField.gridy = 7;
		AddEmployeePanel.add(addJobTitleTextField, gbc_addJobTitleTextField);

		addEmployeeBtn = new JButton("Add employee");
		GridBagConstraints gbc_addEmployeeBtn = new GridBagConstraints();
		gbc_addEmployeeBtn.insets = new Insets(0, 0, 0, 5);
		gbc_addEmployeeBtn.gridx = 1;
		gbc_addEmployeeBtn.gridy = 8;
		AddEmployeePanel.add(addEmployeeBtn, gbc_addEmployeeBtn);

		DeleteEmployeePanel = new JPanel();
		DeleteEmployeePanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Delete employee", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_DeleteEmployeePanel = new GridBagConstraints();
		gbc_DeleteEmployeePanel.insets = new Insets(0, 0, 5, 0);
		gbc_DeleteEmployeePanel.fill = GridBagConstraints.BOTH;
		gbc_DeleteEmployeePanel.gridx = 2;
		gbc_DeleteEmployeePanel.gridy = 0;
		add(DeleteEmployeePanel, gbc_DeleteEmployeePanel);
		GridBagLayout gbl_DeleteEmployeePanel = new GridBagLayout();
		gbl_DeleteEmployeePanel.columnWidths = new int[]{101, 133, 0};
		gbl_DeleteEmployeePanel.rowHeights = new int[]{0, 0, 0};
		gbl_DeleteEmployeePanel.columnWeights = new double[]{0.0, 1.0, 0.0};
		gbl_DeleteEmployeePanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		DeleteEmployeePanel.setLayout(gbl_DeleteEmployeePanel);

		deleteEmployeeNumberLabel = new JLabel("Employee number: ");
		GridBagConstraints gbc_deleteEmployeeNumberLabel = new GridBagConstraints();
		gbc_deleteEmployeeNumberLabel.insets = new Insets(0, 0, 5, 5);
		gbc_deleteEmployeeNumberLabel.anchor = GridBagConstraints.EAST;
		gbc_deleteEmployeeNumberLabel.gridx = 0;
		gbc_deleteEmployeeNumberLabel.gridy = 0;
		DeleteEmployeePanel.add(deleteEmployeeNumberLabel, gbc_deleteEmployeeNumberLabel);

		deleteEmployeeNumberComboBox = new JComboBox<Integer>();
		GridBagConstraints gbc_deleteEmployeeNumberComboBox = new GridBagConstraints();
		gbc_deleteEmployeeNumberComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_deleteEmployeeNumberComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_deleteEmployeeNumberComboBox.gridx = 1;
		gbc_deleteEmployeeNumberComboBox.gridy = 0;
		DeleteEmployeePanel.add(deleteEmployeeNumberComboBox, gbc_deleteEmployeeNumberComboBox);

		deleteEmployeeBtn = new JButton("Delete employee");
		GridBagConstraints gbc_deleteEmployeeBtn = new GridBagConstraints();
		gbc_deleteEmployeeBtn.insets = new Insets(0, 0, 0, 5);
		gbc_deleteEmployeeBtn.gridx = 1;
		gbc_deleteEmployeeBtn.gridy = 1;
		DeleteEmployeePanel.add(deleteEmployeeBtn, gbc_deleteEmployeeBtn);

		UpdateEmployeePanel = new JPanel();
		UpdateEmployeePanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Update employee", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_UpdateEmployeePanel = new GridBagConstraints();
		gbc_UpdateEmployeePanel.gridheight = 2;
		gbc_UpdateEmployeePanel.insets = new Insets(0, 0, 5, 5);
		gbc_UpdateEmployeePanel.fill = GridBagConstraints.BOTH;
		gbc_UpdateEmployeePanel.gridx = 1;
		gbc_UpdateEmployeePanel.gridy = 0;
		add(UpdateEmployeePanel, gbc_UpdateEmployeePanel);
		GridBagLayout gbl_UpdateEmployeePanel = new GridBagLayout();
		gbl_UpdateEmployeePanel.columnWidths = new int[]{104, 133, 0};
		gbl_UpdateEmployeePanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_UpdateEmployeePanel.columnWeights = new double[]{0.0, 1.0, 0.0};
		gbl_UpdateEmployeePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		UpdateEmployeePanel.setLayout(gbl_UpdateEmployeePanel);

		updateEmployeeNumberLabel = new JLabel("Employee number: ");
		GridBagConstraints gbc_updateEmployeeNumberLabel = new GridBagConstraints();
		gbc_updateEmployeeNumberLabel.anchor = GridBagConstraints.EAST;
		gbc_updateEmployeeNumberLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updateEmployeeNumberLabel.gridx = 0;
		gbc_updateEmployeeNumberLabel.gridy = 0;
		UpdateEmployeePanel.add(updateEmployeeNumberLabel, gbc_updateEmployeeNumberLabel);

		updateEmployeeNumberComboBox = new JComboBox<Integer>();
		GridBagConstraints gbc_updateEmployeeNumberComboBox = new GridBagConstraints();
		gbc_updateEmployeeNumberComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_updateEmployeeNumberComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateEmployeeNumberComboBox.gridx = 1;
		gbc_updateEmployeeNumberComboBox.gridy = 0;
		UpdateEmployeePanel.add(updateEmployeeNumberComboBox, gbc_updateEmployeeNumberComboBox);

		updateFirstNameLabel = new JLabel("First name: ");
		GridBagConstraints gbc_updateFirstNameLabel = new GridBagConstraints();
		gbc_updateFirstNameLabel.anchor = GridBagConstraints.EAST;
		gbc_updateFirstNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updateFirstNameLabel.gridx = 0;
		gbc_updateFirstNameLabel.gridy = 1;
		UpdateEmployeePanel.add(updateFirstNameLabel, gbc_updateFirstNameLabel);

		updateFirstNameTextField = new JTextField();
		updateFirstNameTextField.setColumns(10);
		GridBagConstraints gbc_updateFirstNameTextField = new GridBagConstraints();
		gbc_updateFirstNameTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateFirstNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateFirstNameTextField.gridx = 1;
		gbc_updateFirstNameTextField.gridy = 1;
		UpdateEmployeePanel.add(updateFirstNameTextField, gbc_updateFirstNameTextField);

		updateLastNameLabel = new JLabel("Last name: ");
		GridBagConstraints gbc_updateLastNameLabel = new GridBagConstraints();
		gbc_updateLastNameLabel.anchor = GridBagConstraints.EAST;
		gbc_updateLastNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updateLastNameLabel.gridx = 0;
		gbc_updateLastNameLabel.gridy = 2;
		UpdateEmployeePanel.add(updateLastNameLabel, gbc_updateLastNameLabel);

		updateLastNameTextField = new JTextField();
		updateLastNameTextField.setColumns(10);
		GridBagConstraints gbc_updateLastNameTextField = new GridBagConstraints();
		gbc_updateLastNameTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateLastNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateLastNameTextField.gridx = 1;
		gbc_updateLastNameTextField.gridy = 2;
		UpdateEmployeePanel.add(updateLastNameTextField, gbc_updateLastNameTextField);

		updateExtensionLabel = new JLabel("Extension: ");
		GridBagConstraints gbc_updateExtensionLabel = new GridBagConstraints();
		gbc_updateExtensionLabel.anchor = GridBagConstraints.EAST;
		gbc_updateExtensionLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updateExtensionLabel.gridx = 0;
		gbc_updateExtensionLabel.gridy = 3;
		UpdateEmployeePanel.add(updateExtensionLabel, gbc_updateExtensionLabel);

		updateExtensionTextField = new JTextField();
		updateExtensionTextField.setColumns(10);
		GridBagConstraints gbc_updateExtensionTextField = new GridBagConstraints();
		gbc_updateExtensionTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateExtensionTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateExtensionTextField.gridx = 1;
		gbc_updateExtensionTextField.gridy = 3;
		UpdateEmployeePanel.add(updateExtensionTextField, gbc_updateExtensionTextField);

		updateEmailLabel = new JLabel("Email: ");
		GridBagConstraints gbc_updateEmailLabel = new GridBagConstraints();
		gbc_updateEmailLabel.anchor = GridBagConstraints.EAST;
		gbc_updateEmailLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updateEmailLabel.gridx = 0;
		gbc_updateEmailLabel.gridy = 4;
		UpdateEmployeePanel.add(updateEmailLabel, gbc_updateEmailLabel);

		updateEmailTextField = new JTextField();
		updateEmailTextField.setColumns(10);
		GridBagConstraints gbc_updateEmailTextField = new GridBagConstraints();
		gbc_updateEmailTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateEmailTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateEmailTextField.gridx = 1;
		gbc_updateEmailTextField.gridy = 4;
		UpdateEmployeePanel.add(updateEmailTextField, gbc_updateEmailTextField);

		updateOfficeCodeLabel = new JLabel("Office code: ");
		GridBagConstraints gbc_updateOfficeCodeLabel = new GridBagConstraints();
		gbc_updateOfficeCodeLabel.anchor = GridBagConstraints.EAST;
		gbc_updateOfficeCodeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updateOfficeCodeLabel.gridx = 0;
		gbc_updateOfficeCodeLabel.gridy = 5;
		UpdateEmployeePanel.add(updateOfficeCodeLabel, gbc_updateOfficeCodeLabel);

		updateOfficeCodeTextField = new JTextField();
		updateOfficeCodeTextField.setColumns(10);
		GridBagConstraints gbc_updateOfficeCodeTextField = new GridBagConstraints();
		gbc_updateOfficeCodeTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateOfficeCodeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateOfficeCodeTextField.gridx = 1;
		gbc_updateOfficeCodeTextField.gridy = 5;
		UpdateEmployeePanel.add(updateOfficeCodeTextField, gbc_updateOfficeCodeTextField);

		updateReportsToLabel = new JLabel("Reports to: ");
		GridBagConstraints gbc_updateReportsToLabel = new GridBagConstraints();
		gbc_updateReportsToLabel.anchor = GridBagConstraints.EAST;
		gbc_updateReportsToLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updateReportsToLabel.gridx = 0;
		gbc_updateReportsToLabel.gridy = 6;
		UpdateEmployeePanel.add(updateReportsToLabel, gbc_updateReportsToLabel);

		updateReportsToTextField = new JTextField();
		updateReportsToTextField.setColumns(10);
		GridBagConstraints gbc_updateReportsToTextField = new GridBagConstraints();
		gbc_updateReportsToTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateReportsToTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateReportsToTextField.gridx = 1;
		gbc_updateReportsToTextField.gridy = 6;
		UpdateEmployeePanel.add(updateReportsToTextField, gbc_updateReportsToTextField);

		updateJobTitleLabel = new JLabel("Job title: ");
		GridBagConstraints gbc_updateJobTitleLabel = new GridBagConstraints();
		gbc_updateJobTitleLabel.anchor = GridBagConstraints.EAST;
		gbc_updateJobTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updateJobTitleLabel.gridx = 0;
		gbc_updateJobTitleLabel.gridy = 7;
		UpdateEmployeePanel.add(updateJobTitleLabel, gbc_updateJobTitleLabel);

		updateJobTitleTextField = new JTextField();
		updateJobTitleTextField.setColumns(10);
		GridBagConstraints gbc_updateJobTitleTextField = new GridBagConstraints();
		gbc_updateJobTitleTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateJobTitleTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateJobTitleTextField.gridx = 1;
		gbc_updateJobTitleTextField.gridy = 7;
		UpdateEmployeePanel.add(updateJobTitleTextField, gbc_updateJobTitleTextField);

		updateEmployeeBtn = new JButton("Update employee");
		GridBagConstraints gbc_updateEmployeeBtn = new GridBagConstraints();
		gbc_updateEmployeeBtn.insets = new Insets(0, 0, 0, 5);
		gbc_updateEmployeeBtn.gridx = 1;
		gbc_updateEmployeeBtn.gridy = 8;
		UpdateEmployeePanel.add(updateEmployeeBtn, gbc_updateEmployeeBtn);

		EmployeeDatabasePanel = new JPanel();
		EmployeeDatabasePanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Employee table view", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_EmployeeDatabasePanel = new GridBagConstraints();
		gbc_EmployeeDatabasePanel.gridheight = 2;
		gbc_EmployeeDatabasePanel.fill = GridBagConstraints.BOTH;
		gbc_EmployeeDatabasePanel.gridx = 2;
		gbc_EmployeeDatabasePanel.gridy = 1;
		add(EmployeeDatabasePanel, gbc_EmployeeDatabasePanel);
		GridBagLayout gbl_EmployeeDatabasePanel = new GridBagLayout();
		gbl_EmployeeDatabasePanel.columnWidths = new int[]{41, 133, 0};
		gbl_EmployeeDatabasePanel.rowHeights = new int[]{18, 0, 0, 0};
		gbl_EmployeeDatabasePanel.columnWeights = new double[]{0.0, 1.0, 0.0};
		gbl_EmployeeDatabasePanel.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		EmployeeDatabasePanel.setLayout(gbl_EmployeeDatabasePanel);

		chooseJobTitleLabel = new JLabel("Job title: ");
		GridBagConstraints gbc_chooseJobTitleLabel = new GridBagConstraints();
		gbc_chooseJobTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_chooseJobTitleLabel.anchor = GridBagConstraints.EAST;
		gbc_chooseJobTitleLabel.gridx = 0;
		gbc_chooseJobTitleLabel.gridy = 0;
		EmployeeDatabasePanel.add(chooseJobTitleLabel, gbc_chooseJobTitleLabel);

		chooseJobTitleComboBox = new JComboBox<String>();
		GridBagConstraints gbc_chooseJobTitleComboBox = new GridBagConstraints();
		gbc_chooseJobTitleComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_chooseJobTitleComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_chooseJobTitleComboBox.gridx = 1;
		gbc_chooseJobTitleComboBox.gridy = 0;
		EmployeeDatabasePanel.add(chooseJobTitleComboBox, gbc_chooseJobTitleComboBox);
		
		sortDatabaseViewBtn = new JButton("Sort");
		GridBagConstraints gbc_sortDatabaseViewBtn = new GridBagConstraints();
		gbc_sortDatabaseViewBtn.insets = new Insets(0, 0, 5, 0);
		gbc_sortDatabaseViewBtn.gridx = 2;
		gbc_sortDatabaseViewBtn.gridy = 0;
		sortDatabaseViewBtn.setToolTipText("Sort to find everything in a specific job title");
		EmployeeDatabasePanel.add(sortDatabaseViewBtn, gbc_sortDatabaseViewBtn);

		databaseTextArea = new JTextArea();
		databaseTextArea.setForeground(Color.WHITE);
		databaseTextArea.setEditable(false);
		databaseTextArea.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_databaseTextArea = new GridBagConstraints();
		gbc_databaseTextArea.insets = new Insets(0, 0, 5, 0);
		gbc_databaseTextArea.fill = GridBagConstraints.BOTH;
		gbc_databaseTextArea.gridx = 0;
		gbc_databaseTextArea.gridy = 0;
		EmployeeDatabasePanel.add(databaseTextArea, gbc_databaseTextArea);

		JScrollPane databaseScroll = new JScrollPane(databaseTextArea);
		databaseScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_databaseScroll = new GridBagConstraints();
		gbc_databaseScroll.gridwidth = 3;
		gbc_databaseScroll.insets = new Insets(0, 0, 5, 0);
		gbc_databaseScroll.fill = GridBagConstraints.BOTH;
		gbc_databaseScroll.gridx = 0;
		gbc_databaseScroll.gridy = 1;
		EmployeeDatabasePanel.add(databaseScroll, gbc_databaseScroll);

		refreshDatabaseTextAreaBtn = new JButton("Refresh view");
		GridBagConstraints gbc_refreshDatabaseTextAreaBtn = new GridBagConstraints();
		gbc_refreshDatabaseTextAreaBtn.insets = new Insets(0, 0, 0, 5);
		gbc_refreshDatabaseTextAreaBtn.gridx = 0;
		gbc_refreshDatabaseTextAreaBtn.gridy = 2;
		EmployeeDatabasePanel.add(refreshDatabaseTextAreaBtn, gbc_refreshDatabaseTextAreaBtn);
		
		saveBtn = new JButton("Save to file");
		GridBagConstraints gbc_saveBtn = new GridBagConstraints();
		gbc_saveBtn.insets = new Insets(0, 0, 0, 5);
		gbc_saveBtn.gridx = 1;
		gbc_saveBtn.gridy = 2;
		saveBtn.setToolTipText("Save everything in the employee database in a text file");
		EmployeeDatabasePanel.add(saveBtn, gbc_saveBtn);

		EmployeeConsolePanel = new JPanel();
		EmployeeConsolePanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Console", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_EmployeeConsolePanel = new GridBagConstraints();
		gbc_EmployeeConsolePanel.gridwidth = 2;
		gbc_EmployeeConsolePanel.insets = new Insets(0, 0, 0, 5);
		gbc_EmployeeConsolePanel.fill = GridBagConstraints.BOTH;
		gbc_EmployeeConsolePanel.gridx = 0;
		gbc_EmployeeConsolePanel.gridy = 2;
		add(EmployeeConsolePanel, gbc_EmployeeConsolePanel);
		GridBagLayout gbl_EmployeeConsolePanel = new GridBagLayout();
		gbl_EmployeeConsolePanel.columnWidths = new int[]{0, 0};
		gbl_EmployeeConsolePanel.rowHeights = new int[]{0, 0, 0};
		gbl_EmployeeConsolePanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_EmployeeConsolePanel.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		EmployeeConsolePanel.setLayout(gbl_EmployeeConsolePanel);

		consoleTextArea = new JTextArea();
		consoleTextArea.setForeground(Color.WHITE);
		consoleTextArea.setEditable(false);
		consoleTextArea.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_consoleTextArea = new GridBagConstraints();
		gbc_consoleTextArea.insets = new Insets(0, 0, 5, 0);
		gbc_consoleTextArea.fill = GridBagConstraints.BOTH;
		gbc_consoleTextArea.gridx = 0;
		gbc_consoleTextArea.gridy = 0;
		EmployeeConsolePanel.add(consoleTextArea, gbc_consoleTextArea);

		JScrollPane consoleScroll = new JScrollPane(consoleTextArea);
		consoleScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_consoleScroll = new GridBagConstraints();
		gbc_consoleScroll.gridwidth = 3;
		gbc_consoleScroll.insets = new Insets(0, 0, 5, 0);
		gbc_consoleScroll.fill = GridBagConstraints.BOTH;
		gbc_consoleScroll.gridx = 0;
		gbc_consoleScroll.gridy = 0;
		EmployeeConsolePanel.add(consoleScroll, gbc_consoleScroll);

		clearConsoleBtn = new JButton("Clear console");
		GridBagConstraints gbc_clearConsoleBtn = new GridBagConstraints();
		gbc_clearConsoleBtn.anchor = GridBagConstraints.WEST;
		gbc_clearConsoleBtn.gridx = 0;
		gbc_clearConsoleBtn.gridy = 1;
		EmployeeConsolePanel.add(clearConsoleBtn, gbc_clearConsoleBtn);
		
		
		//-------FUNCTIONS TO RUN AT STARTUP------//
		
				//functions that refreshes the combobox values and the database view
				refreshDatabaseTextArea();
				refreshEmployeeNumberComboBox();
				refreshJobTitleComboBox();
		
		//----------------ACTION EVENT LISTENERS--------------------//
		// + try catch blocks to fetch data without event listeners
		
		//SORT DATABASE VIEW BUTTON - filters database view from chooseJobTitleComboBox
		sortDatabaseViewBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					refreshDatabaseTextArea(getChosenJobTitle());
					consoleTextArea.append("Employees filtered by: '" + getChosenJobTitle() + "'.\n");
				}catch(Exception err){
					err.printStackTrace();
				}
			}
		});
		
		//DELETE EMPLOYEE BUTTON EVENT - deletes employee and refreshes jobtitle and employee number comboboxes
		deleteEmployeeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the employee? ", "Delete", JOptionPane.YES_NO_OPTION);

				if (option==0){
					try{
						db.deleteEmployee(getDeleteEmployeeNumber());
						
						refreshDatabaseTextArea();
						refreshEmployeeNumberComboBox();
						refreshJobTitleComboBox();
						//functions that refreshes the combobox values and the database view
					}catch (NumberFormatException | SQLException error) {
						consoleTextArea.append("ID must be a valid ID\n");
					}
				}
			}
		});
		
		//REFRESH DB BUTTON - shows updated count of all employees in database text area and refreshes job title JComboBox
        refreshDatabaseTextAreaBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent refreshDb) {
					refreshDatabaseTextArea();
			}
        });
        
		//UPDATE BUTTON EVENT 
		updateEmployeeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (getUpdateFirstName().isEmpty() && getUpdateLastName().isEmpty() && getUpdateExtension().isEmpty() && getUpdateEmail().isEmpty() && getUpdateOfficeCode().isEmpty() && getUpdateJobTitle().isEmpty()) {
						throw new MissingTextFieldException("you must fill out all the fields");
					} else if (getUpdateFirstName().isEmpty())
						throw new MissingTextFieldException("Firstname is not present");
					else if (getUpdateLastName().isEmpty())
						throw new MissingTextFieldException("Lastname is not present");
					else if (getUpdateExtension().isEmpty())
						throw new MissingTextFieldException("Extension is not present");
					else if (getUpdateEmail().isEmpty())
						throw new MissingTextFieldException("Email is not present");
					else if (!getUpdateEmail().contains("@"))
						throw new Exception("Email must include @");
					else if(getUpdateOfficeCode().isEmpty())
						throw new MissingTextFieldException("Officecode is not present");
					else if (!getUpdateOfficeCode().matches("[1-7]"))
						throw new MissingTextFieldException("Office code does not exist");
					else if (getUpdateJobTitle().isEmpty())
						throw new MissingTextFieldException("Job title is not present");


					db.updateUser(getUpdateLastName(), getUpdateFirstName(), getUpdateExtension(), getUpdateEmail(), getUpdateOfficeCode(), getUpdateReportsTo(), getUpdateJobTitle(), getUpdateEmployeeNumber());


					//functions that refreshes the combobox values and the database view
					refreshDatabaseTextArea();
					refreshEmployeeNumberComboBox();
					refreshJobTitleComboBox();

					//function to clear fields after update
					clearUpdateFields();
				}catch(NumberFormatException err) {
					consoleTextArea.append("Something went wrong. Error" + " " + "Report to must be a number  " + "\n");
				} catch(MissingTextFieldException err){
					consoleTextArea.append("Something went wrong. Error: " + err.getMessage() + "\n");
					err.printStackTrace();
				} catch(Exception errEmail) {
					consoleTextArea.append("Something went wrong. Error: " + errEmail.getMessage() + "\n");
				}
			}
		});
		
		//CLEAR CONSOLE BUTTON EVENT
		clearConsoleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consoleTextArea.setText("");
			}
		});

		//ADD EMPLOYEE BUTTON EVENT
		addEmployeeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (getFirstName().equals("") && getLastName().equals("") && getExtension().equals("") && getEmail().equals("") && getOfficeCode().equals("") && getJobTitle().equals(""))
					{
						throw new MissingTextFieldException("you must fill out all the fields");
					} else if (getFirstName().isEmpty())
						throw new MissingTextFieldException("Firstname is not present");
					else if (getLastName().isEmpty())
						throw new MissingTextFieldException("Lastname is not present");
					else if(getExtension().isEmpty())
							throw new MissingTextFieldException("Extension is not present");
					else if (getEmail().isEmpty())
						throw new MissingTextFieldException("Email is not present");
					else if (!getEmail().contains("@"))
						throw new MissingTextFieldException("Email must include @");
					else if(getOfficeCode().isEmpty())
						throw new MissingTextFieldException("Officecode is not present");
					else if(!getOfficeCode().matches("[1-7]"))
						throw new MissingTextFieldException("Office code does not exist");
					else if (getJobTitle().isEmpty())
						throw new MissingTextFieldException("Job title is not present");


					int employeeNumber = getEmployeeNumber();
					String firstName = getFirstName();
					String lastName = getLastName();
					String extension = getExtension();
					String email = getEmail();
					String officeCode = getOfficeCode();
					int reportsTo = getReportsTo();
					String jobTitle = getJobTitle();


					db.addEmployee(employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle);
					
					
					//functions that refreshes the combobox values and the database view
					refreshDatabaseTextArea();
					refreshEmployeeNumberComboBox();
					refreshJobTitleComboBox();
					
					//function to clear textfields
					clearAddFields();

				}  catch (MissingTextFieldException missingTextFieldException) {
					consoleTextArea.append("Something went wrong. Error: " + missingTextFieldException.getMessage() + "\n");
				} catch(NumberFormatException numErr) {
					consoleTextArea.append("Something went wrong. Error: " + "Employee number and reports to has to be a number \n");
				} catch(Exception broadErr) {
					consoleTextArea.append("Something went wrong. Error" + broadErr.getMessage());
				}
				
				
			}
		});

		//SAVE TO FILE BUTTON
		saveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fileChooser.setDialogTitle("Specify a file to save");
				fileChooser.setCurrentDirectory(new File("c:\\temp"));

				FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "txt", "text");
				fileChooser.setFileFilter(filter);

				int returnVal = fileChooser.showSaveDialog(null);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File fileToSave = fileChooser.getSelectedFile();

					try {
						writeToFile(databaseTextArea.getText(), fileToSave);
						consoleTextArea.setText("Successfully when saving the Database");
					}catch (IOException ioException) {
						consoleTextArea.setText("Error writing into file");
					}
				}
			}
		});
	}
	
	//-------------------GETTERS------------------//
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
		return updateEmailTextField.getText();
	}

	public int getUpdateReportsTo() {
		return Integer.parseInt(updateReportsToTextField.getText());
	}

	public String getUpdateJobTitle() {
		return updateJobTitleTextField.getText();
	}
	
	public int getUpdateEmployeeNumber() {
		int updateEmployeeNumber = (int) updateEmployeeNumberComboBox.getSelectedItem();
		return updateEmployeeNumber;
	}
	
	public int getDeleteEmployeeNumber() {
		int deleteEmployeeNumber = (int)deleteEmployeeNumberComboBox.getSelectedItem();
		return deleteEmployeeNumber;
	}
	
	public int getEmployeeNumber() {
		return Integer.parseInt(addEmployeeNumberTextField.getText());
	}

	public String getLastName() {
		return addLastNameTextField.getText();
	}

	public String getFirstName() {
		return addFirstNameTextField.getText();
	}

	public String getExtension() {
		return addExtensionTextField.getText();
	}

	public String getEmail() {
		return addEmailTextField.getText();
	}

	public String getOfficeCode() {
		return addOfficeCodeTextField.getText();
	}

	public int getReportsTo() {
		return Integer.parseInt(addReportsToTextField.getText());
	}

	public String getJobTitle() {
		return addJobTitleTextField.getText();
	}

	public String getChosenJobTitle() {
		String chosenJobTitle = (String) chooseJobTitleComboBox.getSelectedItem();
		return chosenJobTitle;
	}
	//---------------ADDITIONAL METHODS-----------------//
	public static void writeToFile(String text, File file) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		writer.write(text);
		writer.close();
	}

	//METHODE TO REFRESH EMPLOYEE NUMBER COMOBOX
	public void refreshEmployeeNumberComboBox() {
		try {
		List<Employee> employees = db.showEmployees();
		updateEmployeeNumberComboBox.removeAllItems();
		deleteEmployeeNumberComboBox.removeAllItems();
			for (Employee employee : employees) {
					updateEmployeeNumberComboBox.addItem(employee.getEmployeeNumber());
					deleteEmployeeNumberComboBox.addItem(employee.getEmployeeNumber());
			}
		consoleTextArea.append("*refreshed employee number selection. \n");
		}catch(SQLException err) {
			err.printStackTrace();
		}
	}

	//METHODE TO REFRESH JOB TITLE COMBOBOX
	public void refreshJobTitleComboBox() {
		try {
			chooseJobTitleComboBox.removeAllItems();
		List<Employee> employees = db.showEmployees();
		HashSet<String> unique = new HashSet<String>();
			for (Employee employee : employees) {
				if (unique.add(employee.getJobTitle())) {
					chooseJobTitleComboBox.addItem(employee.getJobTitle());
				}
			}
		consoleTextArea.append("*refreshed job title selection. \n");
		}catch(SQLException err) {
			err.printStackTrace();
		}
	}
	
	//METHODE TO REFRESH THE EMPLOYEE TABLE VIEW
	public void refreshDatabaseTextArea() {
		try {
		List<Employee> employees = db.showEmployees();
		databaseTextArea.setText("");
			for (Employee employee : employees) {
				databaseTextArea.append(employee.getEmployeeNumber() + ", " + employee.getLastName() + ", " + employee.getFirstName() + ", " + employee.getExtension() + ", " + employee.getEmail() + ", " + employee.getOfficeCode() + ", " + employee.getReportsTo() + ", " + employee.getJobTitle() + "\n");
			}
		consoleTextArea.append("*refreshed the database view. \n");
		} catch (SQLException err) {
			err.printStackTrace();
		}
	}
	
	public void refreshDatabaseTextArea(String chosenJobTitle) {
		try {
		List<Employee> employees = db.sortEmployeesJobTitle(chosenJobTitle);
		databaseTextArea.setText("");
			for (Employee employee : employees) {
					databaseTextArea.append(employee.getEmployeeNumber() + ": " + employee.getLastName() + ", " + employee.getFirstName() + ", " + employee.getExtension() + ", " + employee.getEmail() + ", " + employee.getOfficeCode() + ", "  + employee.getReportsTo() + ", " + employee.getJobTitle() + "\n");
			}
		consoleTextArea.append("*refreshed the database view. \n");
		} catch (SQLException err) {
			err.printStackTrace();
		}
	}

	//METHODE TO CLEAR UPDATE EMPLOYEE FIELDS
	public void clearUpdateFields() {
		updateFirstNameTextField.setText("");
		updateLastNameTextField.setText("");
		updateExtensionTextField.setText("");
		updateOfficeCodeTextField.setText("");
		updateEmailTextField.setText("");
		updateReportsToTextField.setText("");
		updateJobTitleTextField.setText("");
		consoleTextArea.append("*cleared text fields for update employee. \n");
	}

	//METHODE TO CLEAR ADD EMPLOYEE FIELDS
	public void clearAddFields() {
		addEmployeeNumberTextField.setText("");
		addFirstNameTextField.setText("");
		addLastNameTextField.setText("");
		addExtensionTextField.setText("");
		addOfficeCodeTextField.setText("");
		addEmailTextField.setText("");
		addReportsToTextField.setText("");
		addJobTitleTextField.setText("");
		consoleTextArea.append("*cleared text fields for add employee. \n");
	}


}
