package problem;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;

import main.main;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Problem19 {

	private JFrame frame;
	private JSpinner firstNumberSpinner;
	private JSpinner secondNumberSpinner;
	private JSpinner thirdNumberSpinner;
	private JLabel lblResultLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problem19 window = new Problem19();
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
	public Problem19() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 347);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				main mainPage=new main();
				mainPage.main(null);
			}
		});
		
		String quest="Өгөгдсөн 3 натурал тооны хамгийн бага ерөнхий хуваагдагчийг (ХБЕХ) ол.";
		
		JLabel lblQuestLabel = new JLabel("<html>"+quest+"</html>");
		
		JPanel panel = new JPanel();
		
		JButton btnCalcButton = new JButton("Calculate");
		btnCalcButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int firstN, secondN, thirdN;
				boolean isZero = false;
				String result;

				firstN = (int) firstNumberSpinner.getValue();
				secondN = (int) secondNumberSpinner.getValue();
				thirdN = (int) thirdNumberSpinner.getValue();
				
				isZero = checkIsValid(firstN, secondN, thirdN);
				
				if(isZero)
					return;
				
				result = solver(firstN, secondN, thirdN);
				
				setResult(result);
			}
		});
		
		lblResultLabel = new JLabel("Result:");
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnCalcButton, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblResultLabel, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)))
								.addComponent(lblQuestLabel, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(lblQuestLabel)
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnCalcButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblResultLabel, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
					.addGap(76))
		);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("First Number");
		panel.add(lblNewLabel);
		
		firstNumberSpinner = new JSpinner();
		panel.add(firstNumberSpinner);
		
		JLabel lblNewLabel_2 = new JLabel("Second Number");
		panel.add(lblNewLabel_2);
		
		secondNumberSpinner = new JSpinner();
		panel.add(secondNumberSpinner);
		
		JLabel lblNewLabel_3 = new JLabel("Third Number");
		panel.add(lblNewLabel_3);
		
		thirdNumberSpinner = new JSpinner();
		panel.add(thirdNumberSpinner);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	public int hbeh(int firstN, int secondN) {
		int mult = firstN * secondN;
		
		while ( firstN != secondN )
			if ( firstN > secondN)
				firstN -= secondN;
			else 
				secondN -= firstN;
		return mult / firstN;
	}

	public void setResult(String result) {
		lblResultLabel.setText("Result: " + result);
	}

	public String solver(int firstN, int secondN, int thirdN) {
		String result = "";
		
		result += hbeh(hbeh(firstN, secondN), thirdN);
			
		return result;
	}

	public boolean checkIsValid(int firstN, int secondN, int thirdN) {
		
		if ( firstN < 1 )
		{
			error("First number");
			return true;
		}
		if ( secondN < 1 )
		{
			error("Second number");
			return true;
		}
		if ( thirdN < 1 )
		{
			error("Third number");
			return true;
		}
		return false;
	}
	
	public void error(String message) {
		lblResultLabel.setText("Error: " + message + " must be more than 0 door");
	}
}