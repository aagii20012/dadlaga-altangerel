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
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.beans.VetoableChangeListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

public class Summary {

	private JFrame frame;
	private JTextField numberField;
	private static JTable table;
	static DbConnection conn = new DbConnection();
	static Accounting accounting = new Accounting();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Summary window = new Summary();
					getAllRecords();
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
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Income", "Outcome"}));
		panel.add(comboBox, "flowx,cell 2 0,grow");
		
		JButton btnNewButton = new JButton("Add ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double amount = Double.parseDouble(numberField.getText());
				String type = (String) comboBox.getSelectedItem();
				
				Account acc = new Account(amount, type);
				conn.connect();
				
				accounting.createRecord(conn.dbConnection, acc);
				
				conn.close();
				getAllRecords();
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
	}
	
	public static void getAllRecords() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		conn.connect();
		List<Account> acc = accounting.getAllRecord(conn.dbConnection);
		int index = 1;
		for (Account s : acc) {
			  Object[] row = { s.getId(), s.getAmount(), s.getType(), s.getDate()};
			  model = (DefaultTableModel) table.getModel();
			  model.addRow(row);
		}
		conn.close();
	}
}
