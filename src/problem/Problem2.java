package problem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.CardLayout;

import main.main;
import problem.Problem1.Dragon;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;

public class Problem2 {

	private JFrame frame;
	private JTextField fibonacciField;
	
	
	long findLastDigit(int n)
    {
    	long first = 0;
    	long second = 1;
        
    	long res = 1;
        
        for (int i = 2; i <= n; i++) {
            res = (first + second) % 10;
            first = second;
            second = res;
        }
        
        return res;
    }


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problem2 window = new Problem2();
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
	public Problem2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String quest="F0=1, F1=1, Fn=Fn-1+Fn-2 томьёо өгөгдсөн бол n-р гишүүний нэгжийн цифрийг ол.";
		
		JLabel lblNewLabel = new JLabel("<html>"+quest+"</html>");
		
		JLabel lblNewLabel_1 = new JLabel("Enter n");
		
		fibonacciField = new JTextField();
		fibonacciField.setColumns(10);
		
		JLabel lblResultTable = new JLabel("Result:");
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fibonacciField.getText().isBlank())
					lblResultTable.setText("Error: You need to enter N number");
				else {
					int n= Integer.parseInt(fibonacciField.getText());
					lblResultTable.setText("Result: "+findLastDigit(n));
				}
			}
		});
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				main mainPage=new main();
				mainPage.main(null);
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(10)
									.addComponent(lblNewLabel_1)
									.addGap(18)
									.addComponent(fibonacciField, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
									.addGap(36)
									.addComponent(btnCalculate))
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(81)
							.addComponent(lblResultTable))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton)))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(fibonacciField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCalculate))
					.addGap(26)
					.addComponent(lblResultTable)
					.addContainerGap(106, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
