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

public class Eksamen {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eksamen window = new Eksamen();
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
	public Eksamen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 596);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JTabbedPane tabbedPanel = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPanel, "name_2473844243049800");
		
		JPanel Delete = new JPanel();
		tabbedPanel.addTab("Delete", null, Delete, null);
		
		JPanel Add = new JPanel();
		tabbedPanel.addTab("Add", null, Add, null);
		GridBagLayout gbl_Add = new GridBagLayout();
		gbl_Add.columnWidths = new int[]{0, 0, 0};
		gbl_Add.rowHeights = new int[]{0, 0, 0};
		gbl_Add.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_Add.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		Add.setLayout(gbl_Add);
		
		JLabel lblNewLabel = new JLabel("Fornavn");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		Add.add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		Add.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblEtternavn = new JLabel("Etternavn");
		lblEtternavn.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblEtternavn = new GridBagConstraints();
		gbc_lblEtternavn.anchor = GridBagConstraints.EAST;
		gbc_lblEtternavn.insets = new Insets(0, 0, 0, 5);
		gbc_lblEtternavn.gridx = 0;
		gbc_lblEtternavn.gridy = 1;
		Add.add(lblEtternavn, gbc_lblEtternavn);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		Add.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JPanel Update = new JPanel();
		tabbedPanel.addTab("Update", null, Update, null);
		
		JPanel Read = new JPanel();
		tabbedPanel.addTab("Read", null, Read, null);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
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
