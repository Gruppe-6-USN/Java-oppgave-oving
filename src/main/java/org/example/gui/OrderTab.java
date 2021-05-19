package org.example.gui;

import org.example.database.DatabaseConnection;

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

public class OrderTab extends JPanel{
	
	
	private final JPanel employeeTab = new JPanel();
	private JPanel AddOrdPanel;
	private JPanel DelOrdPanel;
	private JPanel UpdateOrderPanel;
	private JLabel addOrderNumberLabel;
	private JTextField addOrderNumberTextField;
	private JLabel addOrderDateLabel;
	private JLabel addRequiredDateLabel;
	private JLabel addShippedDateLabel;
	private JLabel addStatusLabel;
	private JLabel addCommentsLabel;
	private JLabel addCustomerNumberLabel;
	private JTextField addOrderDateTextField;
	private JTextField addRequiredDateTextField;
	private JTextField addShippedDateTextField;
	private JTextField addStatusTextField;
	private JTextField addCommentsTextField;
	private JTextField addCustomerNumberTextField;
	private JButton addOrderBtn;
	private JLabel updOrdNumLabel;
	private JLabel updateOrderDateLabel;
	private JLabel updEmpLastNameLabel;
	private JLabel updEmpExtensionLabel;
	private JLabel updEmpEmailLabel;
	private JLabel updEmpOfficeCodeLabel;
	private JLabel updEmpReportsToLabel;
	private JLabel updEmpJobTitleLabel;
	private JComboBox updateEmployeeNumberComboBox;
	private JTextField updateEmployeeFirstNameTextField;
	private JTextField updateEmployeeLastNameTextField;
	private JTextField updateEmployeeExtensionTextField;
	private JTextField updateEmployeeEmailTextField;
	private JTextField updateEmployeeOfficeCodeTextField;
	private JTextField updateEmployeeReportsToTextField;
	private JTextField updateEmployeeJobTitleTextField;
	private JButton updateEmployeeBtn;
	private JLabel delEmpNumLabel;
	private JComboBox deleteEmployeeNumberComboBox;
	private JButton deleteEmployeeBtn;
	private JPanel OrderDbView;
	private JTextArea databaseTextArea;
	private JButton refreshEmployeeDbViewBtn;
	private JComboBox chooseEmployeeJobTitleComboBox;
	private JLabel chooseEmpJobTitleLabel;
	private JPanel OrderConsolePanel;
	private JTextArea employeeConsoleTextArea;
	private JButton clearEmployeeConsoleBtn;
	
	public OrderTab() {
		final DatabaseConnection databaseConnection = new DatabaseConnection();
        
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
		
		AddOrdPanel = new JPanel();
		AddOrdPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Add order", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_AddOrdPanel = new GridBagConstraints();
		gbc_AddOrdPanel.gridheight = 2;
		gbc_AddOrdPanel.insets = new Insets(0, 0, 5, 5);
		gbc_AddOrdPanel.fill = GridBagConstraints.BOTH;
		gbc_AddOrdPanel.gridx = 0;
		gbc_AddOrdPanel.gridy = 0;
		add(AddOrdPanel, gbc_AddOrdPanel);
		GridBagLayout gbl_AddOrdPanel = new GridBagLayout();
		gbl_AddOrdPanel.columnWidths = new int[] {95, 112, 0};
		gbl_AddOrdPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_AddOrdPanel.columnWeights = new double[]{1.0, 1.0, 0.0};
		gbl_AddOrdPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		AddOrdPanel.setLayout(gbl_AddOrdPanel);
		
		addOrderNumberLabel = new JLabel("Order number: ");
		GridBagConstraints gbc_addOrderNumberLabel = new GridBagConstraints();
		gbc_addOrderNumberLabel.anchor = GridBagConstraints.EAST;
		gbc_addOrderNumberLabel.insets = new Insets(0, 0, 5, 5);
		gbc_addOrderNumberLabel.gridx = 0;
		gbc_addOrderNumberLabel.gridy = 0;
		AddOrdPanel.add(addOrderNumberLabel, gbc_addOrderNumberLabel);
		
		addOrderNumberTextField = new JTextField();
		GridBagConstraints gbc_addOrderNumberTextField = new GridBagConstraints();
		gbc_addOrderNumberTextField.insets = new Insets(0, 0, 5, 5);
		gbc_addOrderNumberTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_addOrderNumberTextField.gridx = 1;
		gbc_addOrderNumberTextField.gridy = 0;
		AddOrdPanel.add(addOrderNumberTextField, gbc_addOrderNumberTextField);
		addOrderNumberTextField.setColumns(10);
		
		addOrderDateLabel = new JLabel("Order date: ");
		GridBagConstraints gbc_addOrderDateLabel = new GridBagConstraints();
		gbc_addOrderDateLabel.anchor = GridBagConstraints.EAST;
		gbc_addOrderDateLabel.insets = new Insets(0, 0, 5, 5);
		gbc_addOrderDateLabel.gridx = 0;
		gbc_addOrderDateLabel.gridy = 1;
		AddOrdPanel.add(addOrderDateLabel, gbc_addOrderDateLabel);
		
		addOrderDateTextField = new JTextField();
		addOrderDateTextField.setColumns(10);
		GridBagConstraints gbc_addOrderDateTextField = new GridBagConstraints();
		gbc_addOrderDateTextField.insets = new Insets(0, 0, 5, 5);
		gbc_addOrderDateTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_addOrderDateTextField.gridx = 1;
		gbc_addOrderDateTextField.gridy = 1;
		AddOrdPanel.add(addOrderDateTextField, gbc_addOrderDateTextField);
		
		addRequiredDateLabel = new JLabel("Required date: ");
		GridBagConstraints gbc_addRequiredDateLabel = new GridBagConstraints();
		gbc_addRequiredDateLabel.anchor = GridBagConstraints.EAST;
		gbc_addRequiredDateLabel.insets = new Insets(0, 0, 5, 5);
		gbc_addRequiredDateLabel.gridx = 0;
		gbc_addRequiredDateLabel.gridy = 2;
		AddOrdPanel.add(addRequiredDateLabel, gbc_addRequiredDateLabel);
		
		addRequiredDateTextField = new JTextField();
		addRequiredDateTextField.setColumns(10);
		GridBagConstraints gbc_addRequiredDateTextField = new GridBagConstraints();
		gbc_addRequiredDateTextField.insets = new Insets(0, 0, 5, 5);
		gbc_addRequiredDateTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_addRequiredDateTextField.gridx = 1;
		gbc_addRequiredDateTextField.gridy = 2;
		AddOrdPanel.add(addRequiredDateTextField, gbc_addRequiredDateTextField);
		
		addShippedDateLabel = new JLabel("Shipped date: ");
		GridBagConstraints gbc_addShippedDateLabel = new GridBagConstraints();
		gbc_addShippedDateLabel.anchor = GridBagConstraints.EAST;
		gbc_addShippedDateLabel.insets = new Insets(0, 0, 5, 5);
		gbc_addShippedDateLabel.gridx = 0;
		gbc_addShippedDateLabel.gridy = 3;
		AddOrdPanel.add(addShippedDateLabel, gbc_addShippedDateLabel);
		
		addShippedDateTextField = new JTextField();
		addShippedDateTextField.setColumns(10);
		GridBagConstraints gbc_addShippedDateTextField = new GridBagConstraints();
		gbc_addShippedDateTextField.insets = new Insets(0, 0, 5, 5);
		gbc_addShippedDateTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_addShippedDateTextField.gridx = 1;
		gbc_addShippedDateTextField.gridy = 3;
		AddOrdPanel.add(addShippedDateTextField, gbc_addShippedDateTextField);
		
		addStatusLabel = new JLabel("Status: ");
		GridBagConstraints gbc_addStatusLabel = new GridBagConstraints();
		gbc_addStatusLabel.anchor = GridBagConstraints.EAST;
		gbc_addStatusLabel.insets = new Insets(0, 0, 5, 5);
		gbc_addStatusLabel.gridx = 0;
		gbc_addStatusLabel.gridy = 4;
		AddOrdPanel.add(addStatusLabel, gbc_addStatusLabel);
		
		addStatusTextField = new JTextField();
		addStatusTextField.setColumns(10);
		GridBagConstraints gbc_addStatusTextField = new GridBagConstraints();
		gbc_addStatusTextField.insets = new Insets(0, 0, 5, 5);
		gbc_addStatusTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_addStatusTextField.gridx = 1;
		gbc_addStatusTextField.gridy = 4;
		AddOrdPanel.add(addStatusTextField, gbc_addStatusTextField);
		
		addCommentsLabel = new JLabel("Comments: ");
		GridBagConstraints gbc_addCommentsLabel = new GridBagConstraints();
		gbc_addCommentsLabel.anchor = GridBagConstraints.EAST;
		gbc_addCommentsLabel.insets = new Insets(0, 0, 5, 5);
		gbc_addCommentsLabel.gridx = 0;
		gbc_addCommentsLabel.gridy = 5;
		AddOrdPanel.add(addCommentsLabel, gbc_addCommentsLabel);
		
		addCommentsTextField = new JTextField();
		addCommentsTextField.setColumns(10);
		GridBagConstraints gbc_addCommentsTextField = new GridBagConstraints();
		gbc_addCommentsTextField.insets = new Insets(0, 0, 5, 5);
		gbc_addCommentsTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_addCommentsTextField.gridx = 1;
		gbc_addCommentsTextField.gridy = 5;
		AddOrdPanel.add(addCommentsTextField, gbc_addCommentsTextField);
		
		addCustomerNumberLabel = new JLabel("Customer number: ");
		GridBagConstraints gbc_addCustomerNumberLabel = new GridBagConstraints();
		gbc_addCustomerNumberLabel.anchor = GridBagConstraints.EAST;
		gbc_addCustomerNumberLabel.insets = new Insets(0, 0, 5, 5);
		gbc_addCustomerNumberLabel.gridx = 0;
		gbc_addCustomerNumberLabel.gridy = 6;
		AddOrdPanel.add(addCustomerNumberLabel, gbc_addCustomerNumberLabel);
		
		addCustomerNumberTextField = new JTextField();
		addCustomerNumberTextField.setColumns(10);
		GridBagConstraints gbc_addCustomerNumberTextField = new GridBagConstraints();
		gbc_addCustomerNumberTextField.insets = new Insets(0, 0, 5, 5);
		gbc_addCustomerNumberTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_addCustomerNumberTextField.gridx = 1;
		gbc_addCustomerNumberTextField.gridy = 6;
		AddOrdPanel.add(addCustomerNumberTextField, gbc_addCustomerNumberTextField);
		
		addOrderBtn = new JButton("Add order");
		GridBagConstraints gbc_addOrderBtn = new GridBagConstraints();
		gbc_addOrderBtn.insets = new Insets(0, 0, 0, 5);
		gbc_addOrderBtn.gridx = 1;
		gbc_addOrderBtn.gridy = 7;
		AddOrdPanel.add(addOrderBtn, gbc_addOrderBtn);
		
		DelOrdPanel = new JPanel();
		DelOrdPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Delete order", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_DelOrdPanel = new GridBagConstraints();
		gbc_DelOrdPanel.insets = new Insets(0, 0, 5, 0);
		gbc_DelOrdPanel.fill = GridBagConstraints.BOTH;
		gbc_DelOrdPanel.gridx = 2;
		gbc_DelOrdPanel.gridy = 0;
		add(DelOrdPanel, gbc_DelOrdPanel);
		GridBagLayout gbl_DelOrdPanel = new GridBagLayout();
		gbl_DelOrdPanel.columnWidths = new int[] {101, 133, 0};
		gbl_DelOrdPanel.rowHeights = new int[]{0, 0, 0};
		gbl_DelOrdPanel.columnWeights = new double[]{0.0, 1.0, 0.0};
		gbl_DelOrdPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		DelOrdPanel.setLayout(gbl_DelOrdPanel);
		
		delEmpNumLabel = new JLabel("Employee number: ");
		GridBagConstraints gbc_delEmpNumLabel = new GridBagConstraints();
		gbc_delEmpNumLabel.insets = new Insets(0, 0, 5, 5);
		gbc_delEmpNumLabel.anchor = GridBagConstraints.EAST;
		gbc_delEmpNumLabel.gridx = 0;
		gbc_delEmpNumLabel.gridy = 0;
		DelOrdPanel.add(delEmpNumLabel, gbc_delEmpNumLabel);
		
		deleteEmployeeNumberComboBox = new JComboBox();
		GridBagConstraints gbc_deleteEmployeeNumberComboBox = new GridBagConstraints();
		gbc_deleteEmployeeNumberComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_deleteEmployeeNumberComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_deleteEmployeeNumberComboBox.gridx = 1;
		gbc_deleteEmployeeNumberComboBox.gridy = 0;
		DelOrdPanel.add(deleteEmployeeNumberComboBox, gbc_deleteEmployeeNumberComboBox);
		
		deleteEmployeeBtn = new JButton("Delete employee");
		GridBagConstraints gbc_deleteEmployeeBtn = new GridBagConstraints();
		gbc_deleteEmployeeBtn.insets = new Insets(0, 0, 0, 5);
		gbc_deleteEmployeeBtn.gridx = 1;
		gbc_deleteEmployeeBtn.gridy = 1;
		DelOrdPanel.add(deleteEmployeeBtn, gbc_deleteEmployeeBtn);
		
		UpdateOrderPanel = new JPanel();
		UpdateOrderPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Update order", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_UpdateOrderPanel = new GridBagConstraints();
		gbc_UpdateOrderPanel.gridheight = 2;
		gbc_UpdateOrderPanel.insets = new Insets(0, 0, 5, 5);
		gbc_UpdateOrderPanel.fill = GridBagConstraints.BOTH;
		gbc_UpdateOrderPanel.gridx = 1;
		gbc_UpdateOrderPanel.gridy = 0;
		add(UpdateOrderPanel, gbc_UpdateOrderPanel);
		GridBagLayout gbl_UpdateOrderPanel = new GridBagLayout();
		gbl_UpdateOrderPanel.columnWidths = new int[] {104, 133, 0};
		gbl_UpdateOrderPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_UpdateOrderPanel.columnWeights = new double[]{0.0, 1.0, 0.0};
		gbl_UpdateOrderPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		UpdateOrderPanel.setLayout(gbl_UpdateOrderPanel);
		
		updOrdNumLabel = new JLabel("Order number");
		GridBagConstraints gbc_updOrdNumLabel = new GridBagConstraints();
		gbc_updOrdNumLabel.anchor = GridBagConstraints.EAST;
		gbc_updOrdNumLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updOrdNumLabel.gridx = 0;
		gbc_updOrdNumLabel.gridy = 0;
		UpdateOrderPanel.add(updOrdNumLabel, gbc_updOrdNumLabel);
		
		updateEmployeeNumberComboBox = new JComboBox();
		GridBagConstraints gbc_updateEmployeeNumberComboBox = new GridBagConstraints();
		gbc_updateEmployeeNumberComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_updateEmployeeNumberComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateEmployeeNumberComboBox.gridx = 1;
		gbc_updateEmployeeNumberComboBox.gridy = 0;
		UpdateOrderPanel.add(updateEmployeeNumberComboBox, gbc_updateEmployeeNumberComboBox);
		
		updateOrderDateLabel = new JLabel("First name: ");
		GridBagConstraints gbc_updateOrderDateLabel = new GridBagConstraints();
		gbc_updateOrderDateLabel.anchor = GridBagConstraints.EAST;
		gbc_updateOrderDateLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updateOrderDateLabel.gridx = 0;
		gbc_updateOrderDateLabel.gridy = 1;
		UpdateOrderPanel.add(updateOrderDateLabel, gbc_updateOrderDateLabel);
		
		updateEmployeeFirstNameTextField = new JTextField();
		updateEmployeeFirstNameTextField.setColumns(10);
		GridBagConstraints gbc_updateEmployeeFirstNameTextField = new GridBagConstraints();
		gbc_updateEmployeeFirstNameTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateEmployeeFirstNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateEmployeeFirstNameTextField.gridx = 1;
		gbc_updateEmployeeFirstNameTextField.gridy = 1;
		UpdateOrderPanel.add(updateEmployeeFirstNameTextField, gbc_updateEmployeeFirstNameTextField);
		
		updEmpLastNameLabel = new JLabel("Last name: ");
		GridBagConstraints gbc_updEmpLastNameLabel = new GridBagConstraints();
		gbc_updEmpLastNameLabel.anchor = GridBagConstraints.EAST;
		gbc_updEmpLastNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updEmpLastNameLabel.gridx = 0;
		gbc_updEmpLastNameLabel.gridy = 2;
		UpdateOrderPanel.add(updEmpLastNameLabel, gbc_updEmpLastNameLabel);
		
		updateEmployeeLastNameTextField = new JTextField();
		updateEmployeeLastNameTextField.setColumns(10);
		GridBagConstraints gbc_updateEmployeeLastNameTextField = new GridBagConstraints();
		gbc_updateEmployeeLastNameTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateEmployeeLastNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateEmployeeLastNameTextField.gridx = 1;
		gbc_updateEmployeeLastNameTextField.gridy = 2;
		UpdateOrderPanel.add(updateEmployeeLastNameTextField, gbc_updateEmployeeLastNameTextField);
		
		updEmpExtensionLabel = new JLabel("Extension: ");
		GridBagConstraints gbc_updEmpExtensionLabel = new GridBagConstraints();
		gbc_updEmpExtensionLabel.anchor = GridBagConstraints.EAST;
		gbc_updEmpExtensionLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updEmpExtensionLabel.gridx = 0;
		gbc_updEmpExtensionLabel.gridy = 3;
		UpdateOrderPanel.add(updEmpExtensionLabel, gbc_updEmpExtensionLabel);
		
		updateEmployeeExtensionTextField = new JTextField();
		updateEmployeeExtensionTextField.setColumns(10);
		GridBagConstraints gbc_updateEmployeeExtensionTextField = new GridBagConstraints();
		gbc_updateEmployeeExtensionTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateEmployeeExtensionTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateEmployeeExtensionTextField.gridx = 1;
		gbc_updateEmployeeExtensionTextField.gridy = 3;
		UpdateOrderPanel.add(updateEmployeeExtensionTextField, gbc_updateEmployeeExtensionTextField);
		
		updEmpEmailLabel = new JLabel("Email: ");
		GridBagConstraints gbc_updEmpEmailLabel = new GridBagConstraints();
		gbc_updEmpEmailLabel.anchor = GridBagConstraints.EAST;
		gbc_updEmpEmailLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updEmpEmailLabel.gridx = 0;
		gbc_updEmpEmailLabel.gridy = 4;
		UpdateOrderPanel.add(updEmpEmailLabel, gbc_updEmpEmailLabel);
		
		updateEmployeeEmailTextField = new JTextField();
		updateEmployeeEmailTextField.setColumns(10);
		GridBagConstraints gbc_updateEmployeeEmailTextField = new GridBagConstraints();
		gbc_updateEmployeeEmailTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateEmployeeEmailTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateEmployeeEmailTextField.gridx = 1;
		gbc_updateEmployeeEmailTextField.gridy = 4;
		UpdateOrderPanel.add(updateEmployeeEmailTextField, gbc_updateEmployeeEmailTextField);
		
		updEmpOfficeCodeLabel = new JLabel("Office code: ");
		GridBagConstraints gbc_updEmpOfficeCodeLabel = new GridBagConstraints();
		gbc_updEmpOfficeCodeLabel.anchor = GridBagConstraints.EAST;
		gbc_updEmpOfficeCodeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updEmpOfficeCodeLabel.gridx = 0;
		gbc_updEmpOfficeCodeLabel.gridy = 5;
		UpdateOrderPanel.add(updEmpOfficeCodeLabel, gbc_updEmpOfficeCodeLabel);
		
		updateEmployeeOfficeCodeTextField = new JTextField();
		updateEmployeeOfficeCodeTextField.setColumns(10);
		GridBagConstraints gbc_updateEmployeeOfficeCodeTextField = new GridBagConstraints();
		gbc_updateEmployeeOfficeCodeTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateEmployeeOfficeCodeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateEmployeeOfficeCodeTextField.gridx = 1;
		gbc_updateEmployeeOfficeCodeTextField.gridy = 5;
		UpdateOrderPanel.add(updateEmployeeOfficeCodeTextField, gbc_updateEmployeeOfficeCodeTextField);
		
		updEmpReportsToLabel = new JLabel("Reports to: ");
		GridBagConstraints gbc_updEmpReportsToLabel = new GridBagConstraints();
		gbc_updEmpReportsToLabel.anchor = GridBagConstraints.EAST;
		gbc_updEmpReportsToLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updEmpReportsToLabel.gridx = 0;
		gbc_updEmpReportsToLabel.gridy = 6;
		UpdateOrderPanel.add(updEmpReportsToLabel, gbc_updEmpReportsToLabel);
		
		updateEmployeeReportsToTextField = new JTextField();
		updateEmployeeReportsToTextField.setColumns(10);
		GridBagConstraints gbc_updateEmployeeReportsToTextField = new GridBagConstraints();
		gbc_updateEmployeeReportsToTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateEmployeeReportsToTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateEmployeeReportsToTextField.gridx = 1;
		gbc_updateEmployeeReportsToTextField.gridy = 6;
		UpdateOrderPanel.add(updateEmployeeReportsToTextField, gbc_updateEmployeeReportsToTextField);
		
		updEmpJobTitleLabel = new JLabel("Job title: ");
		GridBagConstraints gbc_updEmpJobTitleLabel = new GridBagConstraints();
		gbc_updEmpJobTitleLabel.anchor = GridBagConstraints.EAST;
		gbc_updEmpJobTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updEmpJobTitleLabel.gridx = 0;
		gbc_updEmpJobTitleLabel.gridy = 7;
		UpdateOrderPanel.add(updEmpJobTitleLabel, gbc_updEmpJobTitleLabel);
		
		updateEmployeeJobTitleTextField = new JTextField();
		updateEmployeeJobTitleTextField.setColumns(10);
		GridBagConstraints gbc_updateEmployeeJobTitleTextField = new GridBagConstraints();
		gbc_updateEmployeeJobTitleTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateEmployeeJobTitleTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateEmployeeJobTitleTextField.gridx = 1;
		gbc_updateEmployeeJobTitleTextField.gridy = 7;
		UpdateOrderPanel.add(updateEmployeeJobTitleTextField, gbc_updateEmployeeJobTitleTextField);
		
		updateEmployeeBtn = new JButton("Add employee");
		GridBagConstraints gbc_updateEmployeeBtn = new GridBagConstraints();
		gbc_updateEmployeeBtn.insets = new Insets(0, 0, 0, 5);
		gbc_updateEmployeeBtn.gridx = 1;
		gbc_updateEmployeeBtn.gridy = 8;
		UpdateOrderPanel.add(updateEmployeeBtn, gbc_updateEmployeeBtn);
		
		OrderDbView = new JPanel();
		OrderDbView.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Order table view", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_OrderDbView = new GridBagConstraints();
		gbc_OrderDbView.gridheight = 2;
		gbc_OrderDbView.fill = GridBagConstraints.BOTH;
		gbc_OrderDbView.gridx = 2;
		gbc_OrderDbView.gridy = 1;
		add(OrderDbView, gbc_OrderDbView);
		GridBagLayout gbl_OrderDbView = new GridBagLayout();
		gbl_OrderDbView.columnWidths = new int[] {41, 133, 0};
		gbl_OrderDbView.rowHeights = new int[]{18, 0, 0, 0};
		gbl_OrderDbView.columnWeights = new double[]{0.0, 1.0, 0.0};
		gbl_OrderDbView.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		OrderDbView.setLayout(gbl_OrderDbView);
		
		chooseEmpJobTitleLabel = new JLabel("Job title: ");
		GridBagConstraints gbc_chooseEmpJobTitleLabel = new GridBagConstraints();
		gbc_chooseEmpJobTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_chooseEmpJobTitleLabel.anchor = GridBagConstraints.EAST;
		gbc_chooseEmpJobTitleLabel.gridx = 0;
		gbc_chooseEmpJobTitleLabel.gridy = 0;
		OrderDbView.add(chooseEmpJobTitleLabel, gbc_chooseEmpJobTitleLabel);
		
		chooseEmployeeJobTitleComboBox = new JComboBox();
		GridBagConstraints gbc_chooseEmployeeJobTitleComboBox = new GridBagConstraints();
		gbc_chooseEmployeeJobTitleComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_chooseEmployeeJobTitleComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_chooseEmployeeJobTitleComboBox.gridx = 1;
		gbc_chooseEmployeeJobTitleComboBox.gridy = 0;
		OrderDbView.add(chooseEmployeeJobTitleComboBox, gbc_chooseEmployeeJobTitleComboBox);
		
		databaseTextArea = new JTextArea();
		databaseTextArea.setEditable(false);
		databaseTextArea.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_databaseTextArea = new GridBagConstraints();
		gbc_databaseTextArea.insets = new Insets(0, 0, 5, 0);
		gbc_databaseTextArea.fill = GridBagConstraints.BOTH;
		gbc_databaseTextArea.gridx = 0;
		gbc_databaseTextArea.gridy = 0;
		OrderDbView.add(databaseTextArea, gbc_databaseTextArea);
		
		JScrollPane databaseScroll = new JScrollPane(databaseTextArea);
		databaseScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_databaseScroll = new GridBagConstraints();
		gbc_databaseScroll.gridwidth = 3;
		gbc_databaseScroll.insets = new Insets(0, 0, 5, 0);
		gbc_databaseScroll.fill = GridBagConstraints.BOTH;
		gbc_databaseScroll.gridx = 0;
		gbc_databaseScroll.gridy = 1;
		OrderDbView.add(databaseScroll, gbc_databaseScroll);
		
		refreshEmployeeDbViewBtn = new JButton("Refresh view");
		GridBagConstraints gbc_refreshEmployeeDbViewBtn = new GridBagConstraints();
		gbc_refreshEmployeeDbViewBtn.insets = new Insets(0, 0, 0, 5);
		gbc_refreshEmployeeDbViewBtn.gridx = 0;
		gbc_refreshEmployeeDbViewBtn.gridy = 2;
		OrderDbView.add(refreshEmployeeDbViewBtn, gbc_refreshEmployeeDbViewBtn);
		
		OrderConsolePanel = new JPanel();
		OrderConsolePanel.setBorder(new TitledBorder(null, "Console", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_OrderConsolePanel = new GridBagConstraints();
		gbc_OrderConsolePanel.gridwidth = 2;
		gbc_OrderConsolePanel.insets = new Insets(0, 0, 0, 5);
		gbc_OrderConsolePanel.fill = GridBagConstraints.BOTH;
		gbc_OrderConsolePanel.gridx = 0;
		gbc_OrderConsolePanel.gridy = 2;
		add(OrderConsolePanel, gbc_OrderConsolePanel);
		GridBagLayout gbl_OrderConsolePanel = new GridBagLayout();
		gbl_OrderConsolePanel.columnWidths = new int[]{0, 0};
		gbl_OrderConsolePanel.rowHeights = new int[]{0, 0, 0};
		gbl_OrderConsolePanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_OrderConsolePanel.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		OrderConsolePanel.setLayout(gbl_OrderConsolePanel);
		
		employeeConsoleTextArea = new JTextArea();
		employeeConsoleTextArea.setEditable(false);
		employeeConsoleTextArea.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_employeeConsoleTextArea = new GridBagConstraints();
		gbc_employeeConsoleTextArea.insets = new Insets(0, 0, 5, 0);
		gbc_employeeConsoleTextArea.fill = GridBagConstraints.BOTH;
		gbc_employeeConsoleTextArea.gridx = 0;
		gbc_employeeConsoleTextArea.gridy = 0;
		OrderConsolePanel.add(employeeConsoleTextArea, gbc_employeeConsoleTextArea);
		
		JScrollPane consoleScroll = new JScrollPane(employeeConsoleTextArea);
		consoleScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_consoleScroll = new GridBagConstraints();
		gbc_consoleScroll.gridwidth = 3;
		gbc_consoleScroll.insets = new Insets(0, 0, 5, 0);
		gbc_consoleScroll.fill = GridBagConstraints.BOTH;
		gbc_consoleScroll.gridx = 0;
		gbc_consoleScroll.gridy = 0;
		OrderConsolePanel.add(consoleScroll, gbc_consoleScroll);
		
		clearEmployeeConsoleBtn = new JButton("Clear console");
		clearEmployeeConsoleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_clearEmployeeConsoleBtn = new GridBagConstraints();
		gbc_clearEmployeeConsoleBtn.gridx = 0;
		gbc_clearEmployeeConsoleBtn.gridy = 1;
		OrderConsolePanel.add(clearEmployeeConsoleBtn, gbc_clearEmployeeConsoleBtn);
		//DELETE BUTTON
		JButton deleteBtn = new JButton("Delete");
		GridBagConstraints gbc_deleteBtn = new GridBagConstraints();
		gbc_deleteBtn.insets = new Insets(0, 0, 5, 5);
		gbc_deleteBtn.gridx = 1;
		gbc_deleteBtn.gridy = 2;
		employeeTab.add(deleteBtn, gbc_deleteBtn);
		deleteBtn.setToolTipText("Delete an employee from the database");
		setVisible(true);

		/////////////////Action listeners //////////

		//ADD ORDER EVENT
		addOrderBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int orderNumber = getOrderNumber();
					String orderDate = getOrderDate();
					String requiredDate = getRequiredDate();
					String shippedDate = getShippedDate();
					String status = getStatus();
					String comments = getComment();
					int customerNumber = getCustomerNumber();

					databaseConnection.addOrder(orderNumber, orderDate, requiredDate, shippedDate, status, comments, customerNumber);
					displayMessage("You added order: " + orderNumber);
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		});
	}
	public int getOrderNumber() {
		return Integer.parseInt(addOrderNumberTextField.getText());
	}

	public int getCustomerNumber() {
		return Integer.parseInt(addCustomerNumberTextField.getText());
	}

	public String getOrderDate() {
		return addOrderDateTextField.getText();
	}

	public String getRequiredDate() {
		return addOrderDateTextField.getText();
	}

	public String getShippedDate() {
		return addShippedDateTextField.getText();
	}

	public String getStatus() {
		return addStatusTextField.getText();
	}

	public String getComment() {
		return addCommentsTextField.getText();
	}

	private void displayMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

}



