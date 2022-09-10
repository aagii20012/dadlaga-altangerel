package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import accounting.Account;
import accounting.Accounting;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class EditAccounting {

	private JFrame frame;
	private JTextField idField;
	private JTextField ammountField;
	private int id;
	private double amount;
	static DbConnection conn = new DbConnection();
	static Accounting accounting = new Accounting();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditAccounting window = new EditAccounting(args);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param args 
	 */
	public EditAccounting(String[] args) {
		this.id = Integer.parseInt(args[0]);
		this.amount = Double.parseDouble(args[1]);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 275);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnCloseButton = new JButton("Close");
		btnCloseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCloseButton.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnCloseButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(39, 45, 286, 101);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Id:");
		panel.add(lblNewLabel);
		
		idField = new JTextField();
		panel.add(idField);
		idField.setColumns(10);
		idField.setText(""+id );
		idField.setEditable(false);
		
		JLabel lblNewLabel_1 = new JLabel("Amount");
		panel.add(lblNewLabel_1);
		
		ammountField = new JTextField();
		panel.add(ammountField);
		ammountField.setColumns(10);
		ammountField.setText(""+amount );
		
		JLabel lblNewLabel_2 = new JLabel("Type");
		panel.add(lblNewLabel_2);
		
		JComboBox typeBox = new JComboBox();
		typeBox.setModel(new DefaultComboBoxModel(new String[] {"Income", "Cost"}));
		panel.add(typeBox);
		
		JLabel lblResultLabel = new JLabel(" ");
		lblResultLabel.setBounds(96, 191, 46, 14);
		frame.getContentPane().add(lblResultLabel);
		
		JButton btnUpdateButton = new JButton("Update");
		btnUpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(idField.getText());
				double amount = Double.parseDouble(ammountField.getText());
				String type =  (String) typeBox.getSelectedItem();
				if(amount < 0) {
					amount *= -1;
				}
				
				Account acc = new Account(id, amount, type, null);
				
				
				conn.connect();
				
				int updatedRecordNumber = accounting.updateRecord(conn.dbConnection, acc);
				
				conn.close();
				if(updatedRecordNumber == 1) {
					lblResultLabel.setText("updated");
					Summary.getAllRecords();;
				}
			}
		});
		btnUpdateButton.setBounds(39, 157, 286, 23);
		frame.getContentPane().add(btnUpdateButton);
		
	}

}
