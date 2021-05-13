package org.example.gui;
//import org.example.database.DatabaseConnection;

import org.example.database.DatabaseConnection;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.border.EtchedBorder;

public class MainFrame extends Component {
	private DatabaseConnection databaseConnection = new DatabaseConnection();

	public JFrame frame;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField emailTextField;
	private JTextField departmentTextField;
	private JTextField salaryTextField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 564, 565);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {40, 0, 0, 0, 0, 40, 40, 40, 40, 40, 40, 40, 40, 40};
		gridBagLayout.rowHeights = new int[] {40, 40, 40, 40, 40, 40, 40, 40, 40, 40};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		frame.getContentPane().setLayout(gridBagLayout);
		
		// tabbed panel
		JTabbedPane tabbedPanel = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPanel = new GridBagConstraints();
		gbc_tabbedPanel.gridwidth = 4;
		gbc_tabbedPanel.gridheight = 7;
		gbc_tabbedPanel.fill = GridBagConstraints.BOTH;
		gbc_tabbedPanel.insets = new Insets(0, 0, 5, 5);
		gbc_tabbedPanel.gridx = 0;
		gbc_tabbedPanel.gridy = 0;
		frame.getContentPane().add(tabbedPanel, gbc_tabbedPanel);
		
		//delete panel
		JPanel deletePanel = new JPanel();
		tabbedPanel.addTab("Delete", null, deletePanel, null);
		GridBagLayout gbl_deletePanel = new GridBagLayout();
		gbl_deletePanel.columnWidths = new int[] {40, 40, 0, 40, 40, 40};
		gbl_deletePanel.rowHeights = new int[] {40, 0, 40, 40, 40, 40, 40, 40};
		gbl_deletePanel.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_deletePanel.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		deletePanel.setLayout(gbl_deletePanel);
		
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
		gbl_deleteIdPanel.columnWidths = new int[]{88, 15, 86, 0};
		gbl_deleteIdPanel.rowHeights = new int[]{20, 0, 0, 0};
		gbl_deleteIdPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_deleteIdPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		deleteIdPanel.setLayout(gbl_deleteIdPanel);
		
		JLabel idLabel = new JLabel("ID:");
		GridBagConstraints gbc_idLabel = new GridBagConstraints();
		gbc_idLabel.anchor = GridBagConstraints.WEST;
		gbc_idLabel.insets = new Insets(0, 0, 5, 5);
		gbc_idLabel.gridx = 1;
		gbc_idLabel.gridy = 1;
		deleteIdPanel.add(idLabel, gbc_idLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.anchor = GridBagConstraints.NORTHWEST;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		deleteIdPanel.add(textField, gbc_textField);
		
		JButton deleteBtn = new JButton("Delete");
		GridBagConstraints gbc_deleteBtn = new GridBagConstraints();
		gbc_deleteBtn.gridx = 2;
		gbc_deleteBtn.gridy = 2;
		deleteIdPanel.add(deleteBtn, gbc_deleteBtn);
		
		//add panel
		JPanel addPanel = new JPanel();
		tabbedPanel.addTab("Add", null, addPanel, null);
		GridBagLayout gbl_addPanel = new GridBagLayout();
		gbl_addPanel.columnWidths = new int[] {40, 40, 40, 40, 40, 40, 40, 40, 40, 40};
		gbl_addPanel.rowHeights = new int[] {40, 40, 40, 40, 40, 40};
		gbl_addPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_addPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		addPanel.setLayout(gbl_addPanel);
		
		JPanel addDataPanel = new JPanel();
		addDataPanel.setBorder(new TitledBorder(null, "Add data", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_addDataPanel = new GridBagConstraints();
		gbc_addDataPanel.gridwidth = 9;
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
		
		//first name label
		JLabel firstNameLabel = new JLabel("First name:");
		GridBagConstraints gbc_firstNameLabel = new GridBagConstraints();
		gbc_firstNameLabel.anchor = GridBagConstraints.EAST;
		gbc_firstNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_firstNameLabel.gridwidth = 2;
		gbc_firstNameLabel.gridx = 0;
		gbc_firstNameLabel.gridy = 0;
		addDataPanel.add(firstNameLabel, gbc_firstNameLabel);
		
		//first name text field
		firstNameTextField = new JTextField();
		firstNameTextField.setColumns(10);
		GridBagConstraints gbc_firstNameTextField = new GridBagConstraints();
		gbc_firstNameTextField.gridwidth = 4;
		gbc_firstNameTextField.insets = new Insets(0, 0, 5, 0);
		gbc_firstNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_firstNameTextField.gridx = 2;
		gbc_firstNameTextField.gridy = 0;
		addDataPanel.add(firstNameTextField, gbc_firstNameTextField);
		
		//last name label
		JLabel lastNameLabel = new JLabel("Last name:");
		GridBagConstraints gbc_lastNameLabel = new GridBagConstraints();
		gbc_lastNameLabel.anchor = GridBagConstraints.EAST;
		gbc_lastNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lastNameLabel.gridwidth = 2;
		gbc_lastNameLabel.gridx = 0;
		gbc_lastNameLabel.gridy = 1;
		addDataPanel.add(lastNameLabel, gbc_lastNameLabel);
		
		//last name text field
		lastNameTextField = new JTextField();
		lastNameTextField.setColumns(10);
		GridBagConstraints gbc_lastNameTextField = new GridBagConstraints();
		gbc_lastNameTextField.gridwidth = 4;
		gbc_lastNameTextField.insets = new Insets(0, 0, 5, 0);
		gbc_lastNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_lastNameTextField.gridx = 2;
		gbc_lastNameTextField.gridy = 1;
		addDataPanel.add(lastNameTextField, gbc_lastNameTextField);
		
		//email label
		JLabel emailLabel = new JLabel("Email:");
		GridBagConstraints gbc_emailLabel = new GridBagConstraints();
		gbc_emailLabel.anchor = GridBagConstraints.EAST;
		gbc_emailLabel.insets = new Insets(0, 0, 5, 5);
		gbc_emailLabel.gridwidth = 2;
		gbc_emailLabel.gridx = 0;
		gbc_emailLabel.gridy = 2;
		addDataPanel.add(emailLabel, gbc_emailLabel);
		
		//email text field
		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		GridBagConstraints gbc_emailTextField = new GridBagConstraints();
		gbc_emailTextField.gridwidth = 4;
		gbc_emailTextField.insets = new Insets(0, 0, 5, 0);
		gbc_emailTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_emailTextField.gridx = 2;
		gbc_emailTextField.gridy = 2;
		addDataPanel.add(emailTextField, gbc_emailTextField);
		
		//department label
		JLabel departmentLabel = new JLabel("Department:");
		GridBagConstraints gbc_departmentLabel = new GridBagConstraints();
		gbc_departmentLabel.anchor = GridBagConstraints.EAST;
		gbc_departmentLabel.insets = new Insets(0, 0, 5, 5);
		gbc_departmentLabel.gridwidth = 2;
		gbc_departmentLabel.gridx = 0;
		gbc_departmentLabel.gridy = 3;
		addDataPanel.add(departmentLabel, gbc_departmentLabel);
		
		//department text field
		departmentTextField = new JTextField();
		departmentTextField.setColumns(10);
		GridBagConstraints gbc_departmentTextField = new GridBagConstraints();
		gbc_departmentTextField.gridwidth = 4;
		gbc_departmentTextField.insets = new Insets(0, 0, 5, 0);
		gbc_departmentTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_departmentTextField.gridx = 2;
		gbc_departmentTextField.gridy = 3;
		addDataPanel.add(departmentTextField, gbc_departmentTextField);
		
		//salary label
		JLabel salaryLabel = new JLabel("Salary:");
		GridBagConstraints gbc_salaryLabel = new GridBagConstraints();
		gbc_salaryLabel.anchor = GridBagConstraints.EAST;
		gbc_salaryLabel.gridwidth = 2;
		gbc_salaryLabel.insets = new Insets(0, 0, 5, 5);
		gbc_salaryLabel.gridx = 0;
		gbc_salaryLabel.gridy = 4;
		addDataPanel.add(salaryLabel, gbc_salaryLabel);
		
		//salary text field
		salaryTextField = new JTextField();
		salaryTextField.setColumns(10);
		GridBagConstraints gbc_salaryTextField = new GridBagConstraints();
		gbc_salaryTextField.insets = new Insets(0, 0, 5, 0);
		gbc_salaryTextField.gridwidth = 4;
		gbc_salaryTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_salaryTextField.gridx = 2;
		gbc_salaryTextField.gridy = 4;
		addDataPanel.add(salaryTextField, gbc_salaryTextField);
		
		//apply buttton
		JButton applyBtn = new JButton("Apply");
		GridBagConstraints gbc_applyBtn = new GridBagConstraints();
		gbc_applyBtn.gridwidth = 3;
		gbc_applyBtn.insets = new Insets(0, 0, 0, 5);
		gbc_applyBtn.gridx = 1;
		gbc_applyBtn.gridy = 5;
		addDataPanel.add(applyBtn, gbc_applyBtn);
		applyBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					databaseConnection.addEmployee(getFirstName(), getLastName(), getEmail(), getDepartment(), 35000);
					displayMessage("You added: ");
				} catch (Exception exception) {
					displayMessage("Something went wrong when adding new Employee");
				}
			}
		});
		
		//clear button
		JButton clearBtn = new JButton("Clear");
		GridBagConstraints gbc_clearBtn = new GridBagConstraints();
		gbc_clearBtn.gridwidth = 3;
		gbc_clearBtn.gridx = 3;
		gbc_clearBtn.gridy = 5;
		addDataPanel.add(clearBtn, gbc_clearBtn);
		clearBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				firstNameTextField.setText(null);
				lastNameTextField.setText(null);
				emailTextField.setText(null);
				departmentTextField.setText(null);
				emailTextField.setText(null);
				salaryTextField.setText(null);
			}
		});
		
		//update panel
		JPanel updatePanel = new JPanel();
		tabbedPanel.addTab("Update", null, updatePanel, null);
		
		JPanel databasePanel = new JPanel();
		databasePanel.setBorder(new TitledBorder(null, "Database", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_databasePanel = new GridBagConstraints();
		gbc_databasePanel.gridheight = 7;
		gbc_databasePanel.gridwidth = 7;
		gbc_databasePanel.insets = new Insets(0, 0, 5, 0);
		gbc_databasePanel.fill = GridBagConstraints.BOTH;
		gbc_databasePanel.gridx = 4;
		gbc_databasePanel.gridy = 0;
		frame.getContentPane().add(databasePanel, gbc_databasePanel);
		GridBagLayout gbl_databasePanel = new GridBagLayout();
		gbl_databasePanel.columnWidths = new int[] {40, 40, 40, 40, 40, 40};
		gbl_databasePanel.rowHeights = new int[] {40, 40, 40, 40, 40, 40, 40};
		gbl_databasePanel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_databasePanel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		databasePanel.setLayout(gbl_databasePanel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 5, 0);
		gbc_textArea.gridheight = 6;
		gbc_textArea.gridwidth = 7;
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 0;
		databasePanel.add(textArea, gbc_textArea);
		
		JButton refreshDbBtn = new JButton("Refresh");
		GridBagConstraints gbc_refreshDbBtn = new GridBagConstraints();
		gbc_refreshDbBtn.insets = new Insets(0, 0, 0, 5);
		gbc_refreshDbBtn.gridwidth = 2;
		gbc_refreshDbBtn.gridx = 1;
		gbc_refreshDbBtn.gridy = 6;
		databasePanel.add(refreshDbBtn, gbc_refreshDbBtn);
		
		JButton clearDbBtn = new JButton("Clear");
		GridBagConstraints gbc_clearDbBtn = new GridBagConstraints();
		gbc_clearDbBtn.gridwidth = 2;
		gbc_clearDbBtn.gridx = 3;
		gbc_clearDbBtn.gridy = 6;
		databasePanel.add(clearDbBtn, gbc_clearDbBtn);
		
		//console panel
		JPanel consolePanel = new JPanel();
		consolePanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Console", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_consolePanel = new GridBagConstraints();
		gbc_consolePanel.gridwidth = 11;
		gbc_consolePanel.gridheight = 3;
		gbc_consolePanel.fill = GridBagConstraints.BOTH;
		gbc_consolePanel.gridx = 0;
		gbc_consolePanel.gridy = 7;
		frame.getContentPane().add(consolePanel, gbc_consolePanel);
		GridBagLayout gbl_consolePanel = new GridBagLayout();
		gbl_consolePanel.columnWidths = new int[] {40, 40, 40, 40, 40, 40, 40, 40, 40, 40};
		gbl_consolePanel.rowHeights = new int[] {40, 40, 40};
		gbl_consolePanel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_consolePanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		consolePanel.setLayout(gbl_consolePanel);
		
		//console text area
		JTextArea consoleTextArea = new JTextArea();
		consoleTextArea.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_consoleTextArea = new GridBagConstraints();
		gbc_consoleTextArea.gridwidth = 10;
		gbc_consoleTextArea.gridheight = 3;
		gbc_consoleTextArea.insets = new Insets(0, 0, 0, 5);
		gbc_consoleTextArea.fill = GridBagConstraints.BOTH;
		gbc_consoleTextArea.gridx = 0;
		gbc_consoleTextArea.gridy = 0;
		consolePanel.add(consoleTextArea, gbc_consoleTextArea);
	}

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


	/*public double getSalary() {
		return salaryTextField;
	}*/

	public void displayMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

}
