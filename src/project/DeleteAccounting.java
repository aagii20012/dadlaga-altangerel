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

public class DeleteAccounting {

	private JFrame frame;
	private JTextField idField;
	static DbConnection conn = new DbConnection();
	static Accounting accounting = new Accounting();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteAccounting window = new DeleteAccounting();
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
	public DeleteAccounting() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 382, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnCloseButton = new JButton("Close");
		btnCloseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		frame.getContentPane().setLayout(null);
		btnCloseButton.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnCloseButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(39, 45, 286, 66);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Id:");
		panel.add(lblNewLabel);
		
		idField = new JTextField();
		panel.add(idField);
		idField.setColumns(10);
		
		JLabel lblResultLabel = new JLabel(" ");
		lblResultLabel.setBounds(96, 191, 46, 14);
		frame.getContentPane().add(lblResultLabel);
		
		JButton btnDeleteButton = new JButton("Delete");
		btnDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(idField.getText());
				conn.connect();
				
				int updatedRecordNumber = accounting.deleteRecord(conn.dbConnection, id);
				
				conn.close();
				
				if(updatedRecordNumber == 1) {
					lblResultLabel.setText("deleted");
					Summary.getAllRecords();;
				}
			}
		});
		btnDeleteButton.setBounds(32, 134, 293, 23);
		frame.getContentPane().add(btnDeleteButton);
		
	}
}