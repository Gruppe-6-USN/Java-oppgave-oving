package org.example.gui;

import org.example.database.Customer;
import org.example.database.DatabaseConnection;
import org.example.database.OrdersList;
import org.example.gui.exceptions.MissingTextFieldException;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.IOException;

import java.sql.SQLException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.Color;



public class OrderTab extends JPanel {

	DatabaseConnection db = new DatabaseConnection();
	JFileChooser fileChooser = new JFileChooser();

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
	private JComboBox<Integer> addCustomerNumberComboBox;
	private JButton addOrderBtn;
	private JLabel updOrdNumLabel;
	private JLabel updateOrderDateLabel;
	private JLabel updOrderRequiredLabel;
	private JLabel updOrderShippedLabel;
	private JLabel updOrderStatusLabel;
	private JLabel updOrderCommentsLabel;
	private JComboBox<Integer> updateOrderNumberComboBox;
	private JTextField updateOrderDateTextField;
	private JTextField updateOrderRequiredTextField;
	private JTextField updateOrderShippedTextField;
	private JTextField updateOrderStatusTextField;
	private JTextField updateOrderCommentsTextField;
	private JButton updateOrderBtn;
	private JLabel orderNumberLabel;
	private JComboBox<Integer> deleteOrderNumberComboBox;
	private JButton deleteOrderBtn;
	private JPanel OrderDbView;
	private JTextArea databaseTextArea;
	private JButton refreshOrderDbViewBtn;
	private JPanel OrderConsolePanel;
	private JTextArea orderConsoleTextArea;
	private JButton clearOrderConsoleBtn;
	private JLabel searchByDateLabel;
	private JLabel dateFromLabel;
	private JLabel dateToLabel;
	private JTextField dateFromTextField;
	private JTextField dateToTextField;
	private JButton searchByDateBtn;
	private JButton saveOrderBtn;

	public OrderTab() {


		GridBagLayout gbl_employeeTab = new GridBagLayout();
		gbl_employeeTab.columnWidths = new int[]{80, 80, 80, 80, 80, 80, 80, 80, 80, 80};
		gbl_employeeTab.rowHeights = new int[]{60, 60, 60, 60, 60, 60, 60, 60, 60, 60};
		gbl_employeeTab.columnWeights = new double[]{1.0};
		gbl_employeeTab.rowWeights = new double[]{Double.MIN_VALUE};
		employeeTab.setLayout(gbl_employeeTab);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{266, 266, 266, 0};
		gridBagLayout.rowHeights = new int[]{130, 130, 228};
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
		gbl_AddOrdPanel.columnWidths = new int[]{95, 112, 0};
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

		addCustomerNumberComboBox = new JComboBox<Integer>();
		GridBagConstraints gbc_addCustomerNumberComboBox = new GridBagConstraints();
		gbc_addCustomerNumberComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_addCustomerNumberComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_addCustomerNumberComboBox.gridx = 1;
		gbc_addCustomerNumberComboBox.gridy = 6;
		AddOrdPanel.add(addCustomerNumberComboBox, gbc_addCustomerNumberComboBox);

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
		gbl_DelOrdPanel.columnWidths = new int[]{101, 0, 133, 0};
		gbl_DelOrdPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_DelOrdPanel.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0};
		gbl_DelOrdPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		DelOrdPanel.setLayout(gbl_DelOrdPanel);

		orderNumberLabel = new JLabel("Order Number: ");
		GridBagConstraints gbc_orderNumberLabel = new GridBagConstraints();
		gbc_orderNumberLabel.insets = new Insets(0, 0, 5, 5);
		gbc_orderNumberLabel.anchor = GridBagConstraints.EAST;
		gbc_orderNumberLabel.gridx = 0;
		gbc_orderNumberLabel.gridy = 0;
		DelOrdPanel.add(orderNumberLabel, gbc_orderNumberLabel);

		deleteOrderNumberComboBox = new JComboBox<Integer>();
		GridBagConstraints gbc_deleteOrderNumberComboBox = new GridBagConstraints();
		gbc_deleteOrderNumberComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_deleteOrderNumberComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_deleteOrderNumberComboBox.gridx = 2;
		gbc_deleteOrderNumberComboBox.gridy = 0;
		DelOrdPanel.add(deleteOrderNumberComboBox, gbc_deleteOrderNumberComboBox);

		deleteOrderBtn = new JButton("Delete order");
		GridBagConstraints gbc_deleteOrderBtn = new GridBagConstraints();
		gbc_deleteOrderBtn.insets = new Insets(0, 0, 5, 5);
		gbc_deleteOrderBtn.gridx = 2;
		gbc_deleteOrderBtn.gridy = 1;
		DelOrdPanel.add(deleteOrderBtn, gbc_deleteOrderBtn);

		searchByDateLabel = new JLabel("Search order by date:");
		GridBagConstraints gbc_searchByDateLabel = new GridBagConstraints();
		gbc_searchByDateLabel.insets = new Insets(0, 0, 5, 5);
		gbc_searchByDateLabel.gridx = 0;
		gbc_searchByDateLabel.gridy = 2;
		DelOrdPanel.add(searchByDateLabel, gbc_searchByDateLabel);

		dateFromLabel = new JLabel("Date from (format yyyy-mm-dd):");
		GridBagConstraints gbc_dateFromLabel = new GridBagConstraints();
		gbc_dateFromLabel.anchor = GridBagConstraints.EAST;
		gbc_dateFromLabel.insets = new Insets(0, 0, 5, 5);
		gbc_dateFromLabel.gridx = 0;
		gbc_dateFromLabel.gridy = 3;
		DelOrdPanel.add(dateFromLabel, gbc_dateFromLabel);

		dateFromTextField = new JTextField();
		GridBagConstraints gbc_dateFromTextField = new GridBagConstraints();
		gbc_dateFromTextField.insets = new Insets(0, 0, 5, 5);
		gbc_dateFromTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateFromTextField.gridx = 2;
		gbc_dateFromTextField.gridy = 3;
		DelOrdPanel.add(dateFromTextField, gbc_dateFromTextField);
		dateFromTextField.setColumns(10);

		dateToLabel = new JLabel("Date to (format yyyy-mm-dd):");
		GridBagConstraints gbc_dateToLabel = new GridBagConstraints();
		gbc_dateToLabel.insets = new Insets(0, 0, 5, 5);
		gbc_dateToLabel.gridx = 0;
		gbc_dateToLabel.gridy = 4;
		DelOrdPanel.add(dateToLabel, gbc_dateToLabel);

		dateToTextField = new JTextField();
		GridBagConstraints gbc_dateToTextField = new GridBagConstraints();
		gbc_dateToTextField.insets = new Insets(0, 0, 5, 5);
		gbc_dateToTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateToTextField.gridx = 2;
		gbc_dateToTextField.gridy = 4;
		DelOrdPanel.add(dateToTextField, gbc_dateToTextField);
		dateToTextField.setColumns(10);

		searchByDateBtn = new JButton("Search order");
		GridBagConstraints gbc_searchByDateBtn = new GridBagConstraints();
		gbc_searchByDateBtn.insets = new Insets(0, 0, 0, 5);
		gbc_searchByDateBtn.gridx = 2;
		gbc_searchByDateBtn.gridy = 5;
		searchByDateBtn.setToolTipText("Search to find a specific order");
		DelOrdPanel.add(searchByDateBtn, gbc_searchByDateBtn);

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
		gbl_UpdateOrderPanel.columnWidths = new int[]{104, 133, 0};
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

		updateOrderNumberComboBox = new JComboBox<Integer>();
		GridBagConstraints gbc_updateEmployeeNumberComboBox = new GridBagConstraints();
		gbc_updateEmployeeNumberComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_updateEmployeeNumberComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateEmployeeNumberComboBox.gridx = 1;
		gbc_updateEmployeeNumberComboBox.gridy = 0;
		UpdateOrderPanel.add(updateOrderNumberComboBox, gbc_updateEmployeeNumberComboBox);

		updateOrderDateLabel = new JLabel("Order date: ");
		GridBagConstraints gbc_updateOrderDateLabel = new GridBagConstraints();
		gbc_updateOrderDateLabel.anchor = GridBagConstraints.EAST;
		gbc_updateOrderDateLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updateOrderDateLabel.gridx = 0;
		gbc_updateOrderDateLabel.gridy = 1;
		UpdateOrderPanel.add(updateOrderDateLabel, gbc_updateOrderDateLabel);

		updateOrderDateTextField = new JTextField();
		updateOrderDateTextField.setColumns(10);
		GridBagConstraints gbc_updateEmployeeFirstNameTextField = new GridBagConstraints();
		gbc_updateEmployeeFirstNameTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateEmployeeFirstNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateEmployeeFirstNameTextField.gridx = 1;
		gbc_updateEmployeeFirstNameTextField.gridy = 1;
		UpdateOrderPanel.add(updateOrderDateTextField, gbc_updateEmployeeFirstNameTextField);

		updOrderRequiredLabel = new JLabel("Required date: ");
		GridBagConstraints gbc_updEmpLastNameLabel = new GridBagConstraints();
		gbc_updEmpLastNameLabel.anchor = GridBagConstraints.EAST;
		gbc_updEmpLastNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updEmpLastNameLabel.gridx = 0;
		gbc_updEmpLastNameLabel.gridy = 2;
		UpdateOrderPanel.add(updOrderRequiredLabel, gbc_updEmpLastNameLabel);

		updateOrderRequiredTextField = new JTextField();
		updateOrderRequiredTextField.setColumns(10);
		GridBagConstraints gbc_updateEmployeeLastNameTextField = new GridBagConstraints();
		gbc_updateEmployeeLastNameTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateEmployeeLastNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateEmployeeLastNameTextField.gridx = 1;
		gbc_updateEmployeeLastNameTextField.gridy = 2;
		UpdateOrderPanel.add(updateOrderRequiredTextField, gbc_updateEmployeeLastNameTextField);

		updOrderShippedLabel = new JLabel("Shipped date: ");
		GridBagConstraints gbc_updEmpExtensionLabel = new GridBagConstraints();
		gbc_updEmpExtensionLabel.anchor = GridBagConstraints.EAST;
		gbc_updEmpExtensionLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updEmpExtensionLabel.gridx = 0;
		gbc_updEmpExtensionLabel.gridy = 3;
		UpdateOrderPanel.add(updOrderShippedLabel, gbc_updEmpExtensionLabel);

		updateOrderShippedTextField = new JTextField();
		updateOrderShippedTextField.setColumns(10);
		GridBagConstraints gbc_updateEmployeeExtensionTextField = new GridBagConstraints();
		gbc_updateEmployeeExtensionTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateEmployeeExtensionTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateEmployeeExtensionTextField.gridx = 1;
		gbc_updateEmployeeExtensionTextField.gridy = 3;
		UpdateOrderPanel.add(updateOrderShippedTextField, gbc_updateEmployeeExtensionTextField);

		updOrderStatusLabel = new JLabel("Status: ");
		GridBagConstraints gbc_updEmpEmailLabel = new GridBagConstraints();
		gbc_updEmpEmailLabel.anchor = GridBagConstraints.EAST;
		gbc_updEmpEmailLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updEmpEmailLabel.gridx = 0;
		gbc_updEmpEmailLabel.gridy = 4;
		UpdateOrderPanel.add(updOrderStatusLabel, gbc_updEmpEmailLabel);

		updateOrderStatusTextField = new JTextField();
		updateOrderStatusTextField.setColumns(10);
		GridBagConstraints gbc_updateEmployeeEmailTextField = new GridBagConstraints();
		gbc_updateEmployeeEmailTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateEmployeeEmailTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateEmployeeEmailTextField.gridx = 1;
		gbc_updateEmployeeEmailTextField.gridy = 4;
		UpdateOrderPanel.add(updateOrderStatusTextField, gbc_updateEmployeeEmailTextField);

		updOrderCommentsLabel = new JLabel("Comments: ");
		GridBagConstraints gbc_updEmpOfficeCodeLabel = new GridBagConstraints();
		gbc_updEmpOfficeCodeLabel.anchor = GridBagConstraints.EAST;
		gbc_updEmpOfficeCodeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_updEmpOfficeCodeLabel.gridx = 0;
		gbc_updEmpOfficeCodeLabel.gridy = 5;
		UpdateOrderPanel.add(updOrderCommentsLabel, gbc_updEmpOfficeCodeLabel);

		updateOrderCommentsTextField = new JTextField();
		updateOrderCommentsTextField.setColumns(10);
		GridBagConstraints gbc_updateEmployeeOfficeCodeTextField = new GridBagConstraints();
		gbc_updateEmployeeOfficeCodeTextField.insets = new Insets(0, 0, 5, 5);
		gbc_updateEmployeeOfficeCodeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateEmployeeOfficeCodeTextField.gridx = 1;
		gbc_updateEmployeeOfficeCodeTextField.gridy = 5;
		UpdateOrderPanel.add(updateOrderCommentsTextField, gbc_updateEmployeeOfficeCodeTextField);

		updateOrderBtn = new JButton("Update order");
		GridBagConstraints gbc_updateEmployeeBtn = new GridBagConstraints();
		gbc_updateEmployeeBtn.insets = new Insets(0, 0, 0, 5);
		gbc_updateEmployeeBtn.gridx = 1;
		gbc_updateEmployeeBtn.gridy = 8;
		UpdateOrderPanel.add(updateOrderBtn, gbc_updateEmployeeBtn);

		OrderDbView = new JPanel();
		OrderDbView.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Order table view", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_OrderDbView = new GridBagConstraints();
		gbc_OrderDbView.gridheight = 2;
		gbc_OrderDbView.fill = GridBagConstraints.BOTH;
		gbc_OrderDbView.gridx = 2;
		gbc_OrderDbView.gridy = 1;
		add(OrderDbView, gbc_OrderDbView);
		GridBagLayout gbl_OrderDbView = new GridBagLayout();
		gbl_OrderDbView.columnWidths = new int[]{41, 133, 0};
		gbl_OrderDbView.rowHeights = new int[]{18, 0, 0, 0};
		gbl_OrderDbView.columnWeights = new double[]{0.0, 1.0, 0.0};
		gbl_OrderDbView.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		OrderDbView.setLayout(gbl_OrderDbView);

		databaseTextArea = new JTextArea();
		databaseTextArea.setEditable(false);
		databaseTextArea.setForeground(Color.WHITE);
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

		refreshOrderDbViewBtn = new JButton("Refresh view");
		GridBagConstraints gbc_refreshEmployeeDbViewBtn = new GridBagConstraints();
		gbc_refreshEmployeeDbViewBtn.insets = new Insets(0, 0, 0, 5);
		gbc_refreshEmployeeDbViewBtn.gridx = 0;
		gbc_refreshEmployeeDbViewBtn.gridy = 2;
		OrderDbView.add(refreshOrderDbViewBtn, gbc_refreshEmployeeDbViewBtn);

		saveOrderBtn = new JButton("Save to file");
		GridBagConstraints gbc_saveOrderBtn = new GridBagConstraints();
		gbc_saveOrderBtn.insets = new Insets(0, 0, 0, 5);
		gbc_saveOrderBtn.gridx = 1;
		gbc_saveOrderBtn.gridy = 2;
		saveOrderBtn.setToolTipText("Save everything in the order database in a text file");
		OrderDbView.add(saveOrderBtn, gbc_saveOrderBtn);

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

		orderConsoleTextArea = new JTextArea();
		orderConsoleTextArea.setEditable(false);
		orderConsoleTextArea.setForeground(Color.WHITE);
		orderConsoleTextArea.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_employeeConsoleTextArea = new GridBagConstraints();
		gbc_employeeConsoleTextArea.insets = new Insets(0, 0, 5, 0);
		gbc_employeeConsoleTextArea.fill = GridBagConstraints.BOTH;
		gbc_employeeConsoleTextArea.gridx = 0;
		gbc_employeeConsoleTextArea.gridy = 0;
		OrderConsolePanel.add(orderConsoleTextArea, gbc_employeeConsoleTextArea);

		JScrollPane consoleScroll = new JScrollPane(orderConsoleTextArea);
		consoleScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_consoleScroll = new GridBagConstraints();
		gbc_consoleScroll.gridwidth = 3;
		gbc_consoleScroll.insets = new Insets(0, 0, 5, 0);
		gbc_consoleScroll.fill = GridBagConstraints.BOTH;
		gbc_consoleScroll.gridx = 0;
		gbc_consoleScroll.gridy = 0;
		OrderConsolePanel.add(consoleScroll, gbc_consoleScroll);

		clearOrderConsoleBtn = new JButton("Clear console");
		GridBagConstraints gbc_clearEmployeeConsoleBtn = new GridBagConstraints();
		gbc_clearEmployeeConsoleBtn.gridx = 0;
		gbc_clearEmployeeConsoleBtn.gridy = 1;
		OrderConsolePanel.add(clearOrderConsoleBtn, gbc_clearEmployeeConsoleBtn);
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
		refreshOrderNumberComboBox();
		refreshDatabaseTextArea();
		refreshCustomerNumberComboBox();

		/////////////////Action listeners //////////

		// SEARCH BY DATE EVENT
		searchByDateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent searchByDate) {
				try {
					if (dateFromTextField.getText().isEmpty() || dateToTextField.getText().isEmpty()) {
						throw new MissingTextFieldException("you must fill out all the dates in the Search order by date fields");
					}

					String dateString1 = dateFromTextField.getText();
					String dateString2 = dateToTextField.getText();
					DateFormat d = new SimpleDateFormat("yyyy-mm-dd");
					d.parse(dateString1);
					d.parse(dateString2);
					List<OrdersList> orders = db.searchByDate(dateString1, dateString2);
					databaseTextArea.setText("");
					for (OrdersList order : orders) {
						databaseTextArea.append(order.getOrderNumber() + ": " + order.getCustomerNumber() + ", " + order.getOrderDate() + ", " + order.getRequiredDate() + ", " + order.getShippedDate() + ", " + order.getStatus() + ", " + order.getComments() + "\n");

					}
				} catch (SQLException | ParseException error) {
					orderConsoleTextArea.append("Problem fetching from database. Error: " + " " + "Date input should be yyyy-mm-dd" + "\n") ;
				} catch (MissingTextFieldException exception) {
					orderConsoleTextArea.append(exception.getMessage() + "\n");
				}
			}
		});

		//ADD ORDER EVENT
		addOrderBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(getOrderDate().equals("") && getRequiredDate().equals("") && getShippedDate().equals("") && getStatus().equals("") && getComment().equals("")) {
						throw new MissingTextFieldException("You must fill out all the fields");
					} else if (getOrderDate().isEmpty())
						throw new MissingTextFieldException("Order date is not present");
					else if (getRequiredDate().isEmpty())
						throw new MissingTextFieldException("Require date is not present");
					else if (getShippedDate().isEmpty())
						throw new MissingTextFieldException("Shipping date is not present");
					else if (getStatus().isEmpty())
						throw new MissingTextFieldException("Status is not present");
					else if (getComment().isEmpty())
						throw new MissingTextFieldException("Comments is not present");

					int orderNumber = getOrderNumber();
					String orderDate = getOrderDate();
					String requiredDate = getRequiredDate();
					String shippedDate = getShippedDate();
					String status = getStatus();
					String comments = getComment();
					int customerNumber = getCustomerNumber();

					db.addOrder(orderNumber, orderDate, requiredDate, shippedDate, status, comments, customerNumber);

					//function to clear fields after update order
					clearAddOrderFields();

					//Refreshes combobox and TextArea
					refreshDatabaseTextArea();
					refreshOrderNumberComboBox();

				}
				catch (MissingTextFieldException missingTextFieldException) {
					orderConsoleTextArea.append("Something went wrong. Error: " + missingTextFieldException.getMessage() + "\n");
				}catch (SQLException sqlException) {
					orderConsoleTextArea.append("Something went wrong. Error: " + sqlException.getMessage() + "\n");
				}catch (NumberFormatException numberFormatException) {
					orderConsoleTextArea.append("Something went wrong. Error: " + "Customer number and Order number must be a number" + "\n");
				}catch (Exception exception) {
					orderConsoleTextArea.append("Something went wrong. Error: " + exception.getMessage() + "\n");
				}
			}
		});

		//CLEAR CONSOLE EVENT
		clearOrderConsoleBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				orderConsoleTextArea.setText("");
			}
		});

		//DELETE ORDER BUTTON EVENT
		deleteOrderBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the order? ", "Delete", JOptionPane.YES_NO_OPTION);

				if (option==0) {
					try {
						db.deleteOrder(getDeleteOrderNumber());

						//functions that refreshes the combobox values and the database view
						refreshOrderNumberComboBox();
						refreshDatabaseTextArea();
					} catch (SQLException exception) {
						exception.printStackTrace();
					}
				}
			}
		});

		//REFRESH DB BUTTON - shows updated count of all employees in database text area and refreshes job title JComboBox
		refreshOrderDbViewBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent refreshDb) {
					refreshDatabaseTextArea();
			}
        });

		//UPDATE BUTTON EVENT
		updateOrderBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (getUpdateOrderDate().isEmpty() && getUpdateRequiredDate().isEmpty() && getUpdateShippingDate().isEmpty() && getUpdateStatus().isEmpty() && getUpdateComment().isEmpty()) {
						throw new MissingTextFieldException("You must fill out all the fields");
					} else if (getUpdateOrderDate().isEmpty())
						throw new MissingTextFieldException("Order date is not present");
					else if (getUpdateRequiredDate().isEmpty())
						throw new MissingTextFieldException("Require date is not present");
					else if (getUpdateShippingDate().isEmpty())
						throw new MissingTextFieldException("Shipping date is not present");
					else if (getUpdateStatus().isEmpty())
						throw new MissingTextFieldException("Status is not present");
					else if (getUpdateComment().isEmpty())
						throw new MissingTextFieldException("Comments is not present");
					db.updateOrder(getUpdateOrderDate(), getUpdateRequiredDate(), getUpdateShippingDate(), getUpdateStatus(), getUpdateComment(), getUpdateOrderNumber());

					//functions that refreshes the combobox values and the database view
					refreshDatabaseTextArea();
					refreshOrderNumberComboBox();

					//function to clear fields after update order
					clearUpdateOrderFields();

				} catch (MissingTextFieldException missingTextFieldException) {
					orderConsoleTextArea.append("Something went wrong. Error: " + missingTextFieldException.getMessage() + "\n");

				}catch (NumberFormatException numberFormatException) {
					orderConsoleTextArea.append("Something went wrong. Error: " + "Customer number and Order number must be a number" + "\n");
				}catch (Exception exception) {
					orderConsoleTextArea.append("Something went wrong. Error: " + exception.getMessage() + "\n");
				}
			}
		});

		//SAVE ORDER BUTTON EVENT
		saveOrderBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fileChooser.setDialogTitle("Specify a file to save");
				fileChooser.setCurrentDirectory(new File("c:\\temp"));

				FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "txt", "text");
				fileChooser.setFileFilter(filter);

				int response = fileChooser.showSaveDialog(null);

				if (response == JFileChooser.APPROVE_OPTION) {
					File fileToSave = fileChooser.getSelectedFile();

					try {
						EmployeeTab.writeToFile(databaseTextArea.getText(), fileToSave);
						orderConsoleTextArea.setText("Successfully when saving the Database");
					}catch (IOException ioException) {
						orderConsoleTextArea.setText("Error writing into file");
					}
				}
			}
		});
	}

	//-----------------GETTERS----------------//
	public String getUpdateOrderDate() {
		return updateOrderDateTextField.getText();
	}

	public String getUpdateRequiredDate() {
		return updateOrderRequiredTextField.getText();
	}

	public String getUpdateShippingDate() {
		return updateOrderShippedTextField.getText();
	}

	public String getUpdateStatus() {
		return updateOrderStatusTextField.getText();
	}

	public String getUpdateComment() {
		return updateOrderCommentsTextField.getText();
	}

	public int getUpdateOrderNumber() {
		int updateOrderNumber = (int) updateOrderNumberComboBox.getSelectedItem();
		return updateOrderNumber;
	}

	public int getOrderNumber() {
		return Integer.parseInt(addOrderNumberTextField.getText());
	}

	public int getCustomerNumber() {
		int addCustomerNumber = (int) addCustomerNumberComboBox.getSelectedItem();
		return addCustomerNumber;
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

	public int getDeleteOrderNumber() {
		int deleteOrderNumber = (int) deleteOrderNumberComboBox.getSelectedItem();
		return deleteOrderNumber;
	}

	//METHOD TO REFRESH THE ORDER DATABASE VIEW
	public void refreshDatabaseTextArea() {
		try {
		List<OrdersList> orders = db.showOrders();
		databaseTextArea.setText("");
			for (OrdersList ordersList : orders) {
				databaseTextArea.append(ordersList.getOrderNumber() + ": " + ordersList.getOrderDate() + ", " + ordersList.getRequiredDate() + ", " + ordersList.getShippedDate() + ", " + ordersList.getStatus() + ", " + ordersList.getComments() + ", " + ordersList.getCustomerNumber() +   "\n");
			}
			orderConsoleTextArea.append("*refreshed the database view. \n");
		} catch (SQLException err) {
			err.printStackTrace();
		}
	}

	//METHODE TO REFRESH THE ORDER NUMBER COMBOBOX
	public void refreshOrderNumberComboBox() {
		try {
			List<OrdersList> orders = db.showOrders();
			updateOrderNumberComboBox.removeAllItems();
			deleteOrderNumberComboBox.removeAllItems();
			for (OrdersList order : orders) {
					updateOrderNumberComboBox.addItem(order.getOrderNumber());
					deleteOrderNumberComboBox.addItem(order.getOrderNumber());
			}
			orderConsoleTextArea.append("*refreshed OrderNumber comboBox. \n");
		} catch (SQLException err) {
			err.printStackTrace();
		}
	}

	//METHODE TO REFRESH THE CUSTOMER NUMBER COMBOBOX
	public void refreshCustomerNumberComboBox() {
		try {
			List<Customer> customers = db.showCustomers();
		
			addCustomerNumberComboBox.removeAllItems();
			for (Customer customer : customers) {
					addCustomerNumberComboBox.addItem(customer.getCustomerNumber());
			}
			orderConsoleTextArea.append("*refreshed OrderNumber comboBox. \n");
		} catch (SQLException err) {
			err.printStackTrace();
		}
	}

	//METHODE TO CLEAR ALL THE ADD FIELDS
	public void clearAddOrderFields() {
		addOrderNumberTextField.setText("");
		addOrderDateTextField.setText("");
		addRequiredDateTextField.setText("");
		addShippedDateTextField.setText("");
		addStatusTextField.setText("");
		addCommentsTextField.setText("");
	}

	//METHODE TO CLEAR ALL THE UPDATE FIELDS
	public void clearUpdateOrderFields() {
		updateOrderDateTextField.setText("");
		updateOrderRequiredTextField.setText("");
		updateOrderShippedTextField.setText("");
		updateOrderStatusTextField.setText("");
		updateOrderCommentsTextField.setText("");
	}
}



