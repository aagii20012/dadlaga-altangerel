package problem;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;

import main.main;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class Problem18 {

	private JFrame frame;
	private JTextField massiveNumbersField;
	private JLabel lblResultLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problem18 window = new Problem18();
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
	public Problem18() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				main mainPage=new main();
				mainPage.main(null);
			}
		});
		
		String quest="Нэг мөрөнд 3 бүхэл тоо зайгаар тусгаарлагдан өгөгдөнө. ";
		
		JLabel lblQuestLabel = new JLabel("<html>"+quest+"</html>");
		
		JLabel lblNewLabel = new JLabel("Enter numbers");
		
		massiveNumbersField = new JTextField();
		massiveNumbersField.setColumns(10);
		
		JButton btnCalcButton = new JButton("Calculate");
		btnCalcButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String massive;
				boolean isBlank = false;
				String[] result;
				
				massive = massiveNumbersField.getText();
				
				isBlank = checkIsBlank(massive);
				
				if (isBlank)
					return;
				
				solver(massive);
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
							.addGap(63)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblQuestLabel, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(10)
									.addComponent(massiveNumbersField, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblResultLabel)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(94)
							.addComponent(btnCalcButton)))
					.addContainerGap(64, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(lblQuestLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(massiveNumbersField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblResultLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCalcButton)
					.addGap(90))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	protected void solver(String massive) {
		String[] separatedStrings = massive.split(" ");
		String result = "";
		
		Arrays.sort(separatedStrings);
		
		for(String str :separatedStrings)
			result += str + " ";
		
		setResult(result);
	}

	protected boolean checkIsBlank(String massive) {
		return massive.isBlank();
	}
	
	protected void setResult(String result) {
		lblResultLabel.setText("Result: " + result);
	}

}
