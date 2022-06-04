package problem;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import main.main;
import problem.Problem1.Dragon;
import java.awt.ScrollPane;

public class Problem8 {

	private JFrame frame;
	private JTable table;
	
	public void clearTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
	}
	
	public int solve(int[] a,int n) {
		if(a[1] != -1) a[1] = 1;
		else a[1] = 0;
		
		if(a[2] != -1) a[2] = a[0] + a[1];
		else a[2] = 0;
		
		for(int j=3 ; j<=n; j++){
			if(a[j] != -1) a[j] = a[j - 1] + a[j - 2] + a[j - 3];
			else a[j] = 0;
		}
		
		return a[n];
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problem8 window = new Problem8();
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
	public Problem8() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 542);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				main mainPage=new main();
				mainPage.main(null);
			}
		});
		
		String quest="A,B натурал тоонууд өгөгдөв. А тоон дээр дараах 2 командыг гүйцэтгэж болно."
				+ "1-р команд тоог 2 дахин багасгах (\":2\" тэмдэглэнэ)."
				+ "Сондгой үед 2 дахин багасгаж болохгүй. х (\"-1\" гэж тэмдэглэнэ)."
				+ "А тооноос В тоог гарган авахын тулд хамгийн багадаа ямар командуудыг "
				+ "биелүүлэх шаардлагатай болохыг үзүүл."
				+ "Командуудыг нэг мөрөнд бичнэ. ";
		
		JLabel lblQuestLabel = new JLabel("<html>"+quest+"</html>");
		
		JLabel lblStartLabel = new JLabel("Stairs");
		
		JSpinner stairSpinner = new JSpinner();
		
		JLabel lblResultLabel = new JLabel("Result:");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Stair", "is broken"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JButton btnCalculateButton = new JButton("Calculate");
		btnCalculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = (int)stairSpinner.getValue(),result;
				int[] a= new int[n+1];
				a[0] = 1;
				for(int i = 1 ; i <= n ; i++) {
					boolean b = (boolean) table.getModel().getValueAt(i-1,1);
					if(b)
						a[i] = -1;
				}
				result = solve(a,n);
				
				lblResultLabel.setText("Result: "+result);
			}
		});
		
		JButton btnAddStairBtn = new JButton("add");
		btnAddStairBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearTable();
				int n;
				n= (int) stairSpinner.getValue();
				if (n<0)
					lblResultLabel.setText("Error: Stair must be more than 0");
				for(int i = 0; i < n; i++) {
					Object[] row = { "Stair "+(i+1), false};
					
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					
					model.addRow(row);
				}
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(54)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblQuestLabel)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblStartLabel)
									.addGap(35)
									.addComponent(stairSpinner, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnAddStairBtn))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(74)
							.addComponent(btnCalculateButton, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(105)
							.addComponent(lblResultLabel)))
					.addContainerGap())
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(46)
					.addComponent(table, GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
					.addGap(28))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblQuestLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStartLabel)
						.addComponent(stairSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAddStairBtn))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addComponent(lblResultLabel)
					.addGap(18)
					.addComponent(btnCalculateButton, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
