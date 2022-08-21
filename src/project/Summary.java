package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import accounting.Account;
import accounting.Accounting;

import com.jgoodies.forms.layout.FormSpecs;
import net.miginfocom.swing.MigLayout;
import user.User;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.beans.VetoableChangeListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import javax.swing.JSplitPane;

public class Summary {

	private JFrame frame;
	private JTextField numberField;
	private static JTable table;
	private static JLabel lblTotalIcome;
	private static JLabel lblTotalCost;
	private static JLabel lblTotal;
	static DbConnection conn = new DbConnection();
	static Accounting accounting = new Accounting();
	private static User user;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if(user == null) {
						LoginPage.main(null);
						return;
					}
					Summary window = new Summary();
					getAllRecords();
					assagnTotals();
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
	public Summary() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 732, 376);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setForeground(Color.WHITE);
		panel.setBounds(10, 11, 516, 43);
		frame.getContentPane().add(panel);
		panel.setLayout(new MigLayout("", "[][471px][]", "[1px][20px][23px]"));
		
		JLabel lblNewLabel_1 = new JLabel("Amount");
		panel.add(lblNewLabel_1, "flowx,cell 1 0");
		
		numberField = new JTextField();
		panel.add(numberField, "cell 1 0,grow");
		numberField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Income", "Cost"}));
		panel.add(comboBox, "flowx,cell 2 0,grow");
		
		JButton btnNewButton = new JButton("Add ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double amount = Double.parseDouble(numberField.getText());
				String type = (String) comboBox.getSelectedItem();
				
				Account acc = new Account(amount, type);
				conn.connect();
				
				accounting.createRecord(conn.dbConnection, acc, user);
				
				conn.close();
				refesh();
			}
		});
		panel.add(btnNewButton, "cell 2 0,grow");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"#", "Amount", "Type", "Date"
			}
		));
		table.setBounds(10, 64, 516, 213);
		frame.getContentPane().add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if ("tableCellEditor".equals(evt.getPropertyName()))
		        {
		            if (table.isEditing())
		               System.out.println("here");
		            else
		            	System.out.println("there");
		        }
			}
		});
		scrollPane.setBounds(20, 65, 508, 204);
		frame.getContentPane().add(scrollPane);
		
		JButton btnEditButton = new JButton("edit");
		btnEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditAccounting.main(null);
			}
		});
		
		btnEditButton.setBounds(536, 11, 79, 39);
		frame.getContentPane().add(btnEditButton);
		
		JButton btnDeleteButton = new JButton("Delete");
		btnDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteAccounting.main(null);
			}
		});
		btnDeleteButton.setBounds(617, 11, 89, 39);
		frame.getContentPane().add(btnDeleteButton);
		
		JButton btnNewButton_1 = new JButton("Log out");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user = null;
				frame.dispose();
				LoginPage.main(null);
			}
		});
		btnNewButton_1.setBounds(538, 68, 168, 39);
		frame.getContentPane().add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(538, 118, 168, 152);
		frame.getContentPane().add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Total Icome:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		lblTotalIcome = new JLabel("");
		GridBagConstraints gbc_lblTotalIcome = new GridBagConstraints();
		gbc_lblTotalIcome.insets = new Insets(0, 0, 5, 0);
		gbc_lblTotalIcome.gridx = 1;
		gbc_lblTotalIcome.gridy = 0;
		panel_1.add(lblTotalIcome, gbc_lblTotalIcome);
		
		JLabel lblNewLabel_2 = new JLabel("Total cost:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		lblTotalCost = new JLabel("12321");
		GridBagConstraints gbc_lblTotalCost = new GridBagConstraints();
		gbc_lblTotalCost.insets = new Insets(0, 0, 5, 0);
		gbc_lblTotalCost.gridx = 1;
		gbc_lblTotalCost.gridy = 1;
		panel_1.add(lblTotalCost, gbc_lblTotalCost);
		
		JLabel lblNewLabel_3 = new JLabel("Total");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 2;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		lblTotal = new JLabel("");
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.insets = new Insets(0, 0, 5, 0);
		gbc_lblTotal.gridx = 1;
		gbc_lblTotal.gridy = 2;
		panel_1.add(lblTotal, gbc_lblTotal);
	}
	
	public static void getAllRecords() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		conn.connect();
		List<Account> acc = accounting.getAllRecord(conn.dbConnection, user);
		int index = 1;
		for (Account s : acc) {
			  Object[] row = { index, s.getAmount(), s.getType(), s.getDate()};
			  model = (DefaultTableModel) table.getModel();
			  model.addRow(row);
			  index++;
		}
		conn.close();
	}
	
	public static void  assagnTotals() {
		conn.connect();
		List<Account> acc = accounting.getAllRecord(conn.dbConnection, user);
		double total = 0;
		double total_cost = accounting.getTotalCost(conn.dbConnection, user.getId());;
		double total_icome = accounting.getTotalIcome(conn.dbConnection, user.getId());;
		
		total = total_cost + total_icome;
		
		lblTotalIcome.setText(String.valueOf(total_icome));
		lblTotalCost.setText(String.valueOf(total_cost));
		lblTotal.setText(String.valueOf(total));
		
		conn.close();
	}
	
	public void refesh() {
		assagnTotals();
		getAllRecords();
	}
	
	public void passUser(User user) {
		this.user = user;
	}
}
