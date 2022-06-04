package problem;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import main.main;
import problem.Problem1.Dragon;

import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.ScrollPane;
import javax.swing.JSpinner;

public class Problem13 {

	private JFrame frame;
	private JTable table;
	/**
	 * @wbp.nonvisual location=329,199
	 */
	private final ScrollPane scrollPane = new ScrollPane();
	
	public List<Integer> massive = new ArrayList<Integer>();
	public int tableLen=0;
	
	public String solver() {
		String result = "";
		Integer max = Collections.max(massive);  
		Set<Integer> distinct = new HashSet<>(massive);
		
		result += max + " " + Collections.frequency(massive, max);
		
		return result;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problem13 window = new Problem13();
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
	public Problem13() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 493);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				main mainPage=new main();
				mainPage.main(null);
			}
		});
		
		String quest="Өгөгдсөн нэг хэмжээст бүхэл тоон массивын хамгийн их элемент хэд дэх нь вэ? "
				+ "Хэрэв хамгийн их элемент 1-ээс их бол бага дугаарыг нь хэвлэнэ.";
		
		JLabel lblQuestLabel = new JLabel("<html>"+quest+"</html>");
		
		JLabel lblNewLabel = new JLabel("Enter value");
		
		JSpinner valueSpinner = new JSpinner();
		
		JLabel lblNewLabel_1 = new JLabel("Result:");
		
		JButton btnAddButton = new JButton("Add");
		btnAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer n;
				n = (Integer) valueSpinner.getValue();
				
				massive.add(n);
				tableLen++;
				Object[] row = { "Massive #"+tableLen, n};
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(row);
			}
		});
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Massive #", "Value"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		JButton btnFindButton = new JButton("Find");
		btnFindButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String result;
				result = solver();
				lblNewLabel_1.setText("Result: "+result);
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
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(valueSpinner, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnAddButton))
								.addComponent(lblQuestLabel, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
								.addComponent(table, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
								.addComponent(btnFindButton, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))))
					.addContainerGap(71, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(120)
					.addComponent(lblNewLabel_1)
					.addContainerGap(268, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(lblQuestLabel)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(valueSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAddButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addGap(26)
					.addComponent(btnFindButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(41))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
