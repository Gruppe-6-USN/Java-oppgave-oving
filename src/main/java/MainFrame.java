import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;

public class MainFrame {

	private JFrame frame;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField emailTextField;
	private JTextField departmentTextField;
	private JTextField salaryTextField;

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
		frame.setBounds(100, 100, 422, 491);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {40, 40, 40, 40, 40, 40, 40, 40, 40, 40};
		gridBagLayout.rowHeights = new int[] {40, 40, 40, 40, 40, 40, 40, 40, 40, 40};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JTabbedPane tabbedPanel = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPanel = new GridBagConstraints();
		gbc_tabbedPanel.gridheight = 6;
		gbc_tabbedPanel.gridwidth = 10;
		gbc_tabbedPanel.fill = GridBagConstraints.BOTH;
		gbc_tabbedPanel.gridx = 0;
		gbc_tabbedPanel.gridy = 0;
		frame.getContentPane().add(tabbedPanel, gbc_tabbedPanel);
		
		JPanel deletePanel = new JPanel();
		tabbedPanel.addTab("Delete", null, deletePanel, null);
		
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
		gbc_addDataPanel.gridwidth = 6;
		gbc_addDataPanel.gridheight = 4;
		gbc_addDataPanel.fill = GridBagConstraints.BOTH;
		gbc_addDataPanel.gridx = 0;
		gbc_addDataPanel.gridy = 0;
		addPanel.add(addDataPanel, gbc_addDataPanel);
		GridBagLayout gbl_addDataPanel = new GridBagLayout();
		gbl_addDataPanel.columnWidths = new int[] {40, 40, 40, 40, 40, 40, 40};
		gbl_addDataPanel.rowHeights = new int[] {40, 40, 40, 40, 40, 40, 40};
		gbl_addDataPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0};
		gbl_addDataPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		addDataPanel.setLayout(gbl_addDataPanel);
		
		JLabel firstNameLabel = new JLabel("First name:");
		GridBagConstraints gbc_firstNameLabel = new GridBagConstraints();
		gbc_firstNameLabel.anchor = GridBagConstraints.EAST;
		gbc_firstNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_firstNameLabel.gridwidth = 2;
		gbc_firstNameLabel.gridx = 0;
		gbc_firstNameLabel.gridy = 0;
		addDataPanel.add(firstNameLabel, gbc_firstNameLabel);
		
		firstNameTextField = new JTextField();
		firstNameTextField.setColumns(10);
		GridBagConstraints gbc_firstNameTextField = new GridBagConstraints();
		gbc_firstNameTextField.gridwidth = 4;
		gbc_firstNameTextField.insets = new Insets(0, 0, 5, 0);
		gbc_firstNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_firstNameTextField.gridx = 2;
		gbc_firstNameTextField.gridy = 0;
		addDataPanel.add(firstNameTextField, gbc_firstNameTextField);
		
		JLabel lastNameLabel = new JLabel("Last name:");
		GridBagConstraints gbc_lastNameLabel = new GridBagConstraints();
		gbc_lastNameLabel.anchor = GridBagConstraints.EAST;
		gbc_lastNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lastNameLabel.gridwidth = 2;
		gbc_lastNameLabel.gridx = 0;
		gbc_lastNameLabel.gridy = 1;
		addDataPanel.add(lastNameLabel, gbc_lastNameLabel);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setColumns(10);
		GridBagConstraints gbc_lastNameTextField = new GridBagConstraints();
		gbc_lastNameTextField.gridwidth = 4;
		gbc_lastNameTextField.insets = new Insets(0, 0, 5, 0);
		gbc_lastNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_lastNameTextField.gridx = 2;
		gbc_lastNameTextField.gridy = 1;
		addDataPanel.add(lastNameTextField, gbc_lastNameTextField);
		
		JLabel emailLabel = new JLabel("Email:");
		GridBagConstraints gbc_emailLabel = new GridBagConstraints();
		gbc_emailLabel.anchor = GridBagConstraints.EAST;
		gbc_emailLabel.insets = new Insets(0, 0, 5, 5);
		gbc_emailLabel.gridwidth = 2;
		gbc_emailLabel.gridx = 0;
		gbc_emailLabel.gridy = 2;
		addDataPanel.add(emailLabel, gbc_emailLabel);
		
		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		GridBagConstraints gbc_emailTextField = new GridBagConstraints();
		gbc_emailTextField.gridwidth = 4;
		gbc_emailTextField.insets = new Insets(0, 0, 5, 0);
		gbc_emailTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_emailTextField.gridx = 2;
		gbc_emailTextField.gridy = 2;
		addDataPanel.add(emailTextField, gbc_emailTextField);
		
		JLabel departmentLabel = new JLabel("Department:");
		GridBagConstraints gbc_departmentLabel = new GridBagConstraints();
		gbc_departmentLabel.anchor = GridBagConstraints.EAST;
		gbc_departmentLabel.insets = new Insets(0, 0, 5, 5);
		gbc_departmentLabel.gridwidth = 2;
		gbc_departmentLabel.gridx = 0;
		gbc_departmentLabel.gridy = 3;
		addDataPanel.add(departmentLabel, gbc_departmentLabel);
		
		departmentTextField = new JTextField();
		departmentTextField.setColumns(10);
		GridBagConstraints gbc_departmentTextField = new GridBagConstraints();
		gbc_departmentTextField.gridwidth = 4;
		gbc_departmentTextField.insets = new Insets(0, 0, 5, 0);
		gbc_departmentTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_departmentTextField.gridx = 2;
		gbc_departmentTextField.gridy = 3;
		addDataPanel.add(departmentTextField, gbc_departmentTextField);
		
		JLabel salaryLabel = new JLabel("Salary:");
		GridBagConstraints gbc_salaryLabel = new GridBagConstraints();
		gbc_salaryLabel.anchor = GridBagConstraints.EAST;
		gbc_salaryLabel.gridwidth = 2;
		gbc_salaryLabel.insets = new Insets(0, 0, 5, 5);
		gbc_salaryLabel.gridx = 0;
		gbc_salaryLabel.gridy = 4;
		addDataPanel.add(salaryLabel, gbc_salaryLabel);
		
		salaryTextField = new JTextField();
		salaryTextField.setColumns(10);
		GridBagConstraints gbc_salaryTextField = new GridBagConstraints();
		gbc_salaryTextField.insets = new Insets(0, 0, 5, 0);
		gbc_salaryTextField.gridwidth = 4;
		gbc_salaryTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_salaryTextField.gridx = 2;
		gbc_salaryTextField.gridy = 4;
		addDataPanel.add(salaryTextField, gbc_salaryTextField);
		
		JButton applyBtn = new JButton("Apply");
		GridBagConstraints gbc_applyBtn = new GridBagConstraints();
		gbc_applyBtn.gridwidth = 3;
		gbc_applyBtn.insets = new Insets(0, 0, 0, 5);
		gbc_applyBtn.gridx = 1;
		gbc_applyBtn.gridy = 5;
		addDataPanel.add(applyBtn, gbc_applyBtn);
		
		JButton clearBtn = new JButton("Clear");
		GridBagConstraints gbc_clearBtn = new GridBagConstraints();
		gbc_clearBtn.gridwidth = 3;
		gbc_clearBtn.gridx = 3;
		gbc_clearBtn.gridy = 5;
		addDataPanel.add(clearBtn, gbc_clearBtn);
		
		JPanel updatePanel = new JPanel();
		tabbedPanel.addTab("Update", null, updatePanel, null);
		
		JPanel readPanel = new JPanel();
		tabbedPanel.addTab("Read", null, readPanel, null);
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
}
