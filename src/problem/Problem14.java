package problem;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;

import main.main;
import problem.Problem1.Dragon;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Problem14 {

	private JFrame frame;
	private JTextField seqNumbersField;
	private JTable table;

	public List<Float> massive = new ArrayList<Float>();
	
	public float solver() {
		float result=0,sum;
		int len;
		
		len = massive.size();
		sum = (float) massive.stream().mapToDouble(a -> a).sum();
		result = sum / len;
		System.out.println(len + " " + sum);
		
		return result;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problem14 window = new Problem14();
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
	public Problem14() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 386);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				main mainPage=new main();
				mainPage.main(null);
			}
		});
		
		String quest="Өгөгдсөн бодит тоон дарааллын арифметик дунджийг ол.";
		
		JLabel lblQuestLabel = new JLabel("<html>"+quest+"</html>");
		
		JLabel lblNewLabel = new JLabel("Enter number");
		
		seqNumbersField = new JTextField();
		seqNumbersField.setColumns(10);
		
		JLabel lblResultLabel = new JLabel("Result:");
		
		JButton btnAddButton = new JButton("Add");
		btnAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float n = 0;
				try {
					n = Float.parseFloat(seqNumbersField.getText());  
				}
				catch(Exception error) {
					lblResultLabel.setText("Error: Please only enter number");
					return;
				}
				
				massive.add(n);
				
				int lastIndex=table.getRowCount()+1;
				
				Object[] row = { lastIndex, n};
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(row);
			}
		});
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Sequence #", "Number"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		JButton btnCalcButton = new JButton("Calculator");
		btnCalcButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float result;
				result = solver();
				lblResultLabel.setText("Result: " + result);
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(63)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(seqNumbersField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnAddButton, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblQuestLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(table, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
								.addComponent(btnCalcButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(90)
							.addComponent(lblResultLabel)))
					.addContainerGap(69, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(lblQuestLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(seqNumbersField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAddButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblResultLabel)
					.addGap(18)
					.addComponent(btnCalcButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(39))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
