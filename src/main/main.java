package main;

import calculator.CalculatorUI;
import problem.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.JLayeredPane;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;

public class main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
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
	public main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 474, 393);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblProblemLbl = new JLabel("Problems");
		
		JButton btnProblem1 = new JButton("RGB7589");
		btnProblem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Problem1.main(null);
			}
		});
		
		JButton btnProblem2 = new JButton("RGB7607");
		btnProblem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Problem2.main(null);
			}
		});
		
		JButton btnProblem3 = new JButton("RGB7075");
		btnProblem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Problem3.main(null);
			}
		});
		
		JButton btnProblem4 = new JButton("RGB7406");
		btnProblem4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Problem4.main(null);
			}
		});
		
		JButton btnProblem5 = new JButton("RGB7318");
		btnProblem5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Problem5.main(null);
			}
		});
		
		JButton btnProblem6 = new JButton("RGB7345");
		btnProblem6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Problem6.main(null);
			}
		});
		
		JButton btnProblem7 = new JButton("RGB7556");
		btnProblem7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Problem7.main(null);
			}
		});
		
		JButton btnProblem8 = new JButton("RGB7603");
		btnProblem8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Problem8.main(null);
			}
		});
		
		JButton btnProblem9 = new JButton("RGB7312");
		btnProblem9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Problem9.main(null);
			}
		});
		
		JButton btnProblem10 = new JButton("RGB7032");
		btnProblem10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Problem10.main(null);
			}
		});
		
		JButton btnProblem11 = new JButton("RGB7521");
		btnProblem11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Problem11.main(null);
			}
		});
		
		JButton btnProblem12 = new JButton("RGB7600");
		btnProblem12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Problem12.main(null);
			}
		});
		
		JButton btnProblem17 = new JButton("RGB7170");
		btnProblem17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Problem17.main(null);
			}
		});
		
		JButton btnProblem18 = new JButton("RGB7137");
		btnProblem18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Problem18.main(null);
			}
		});
		
		JButton btnProblem19 = new JButton("RGB7316");
		btnProblem19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Problem19.main(null);
			}
		});
		
		JButton btnProblem20 = new JButton("RGB7556");
		btnProblem20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Problem20.main(null);
			}
		});
		
		JButton btnProblem13 = new JButton("RGB7507");
		btnProblem13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Problem13.main(null);
			}
		});
		
		JButton btnProblem14 = new JButton("RGB7237");
		btnProblem14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Problem14.main(null);
			}
		});
		
		JButton btnProblem15 = new JButton("RGB7172");
		btnProblem15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Problem15.main(null);
			}
		});
		
		JButton btnProblem16 = new JButton("RGB7171");
		btnProblem16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Problem16.main(null);
			}
		});
		
		JLabel lblCalculator = new JLabel("Calculator");
		
		JButton btnCalculatorButton = new JButton("Calculator");
		btnCalculatorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				CalculatorUI.main(null);
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(70)
							.addComponent(lblProblemLbl, GroupLayout.PREFERRED_SIZE, 470, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnCalculatorButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnProblem1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnProblem17, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnProblem13, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnProblem9, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnProblem5, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCalculator))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnProblem2, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
										.addComponent(btnProblem6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnProblem10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnProblem14, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnProblem18, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnProblem3, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
										.addComponent(btnProblem7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnProblem11, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnProblem15, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnProblem19, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnProblem4, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
										.addComponent(btnProblem8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnProblem12, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnProblem16, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnProblem20, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
							.addGap(123)))
					.addGap(0))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblProblemLbl)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnProblem1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnProblem5)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnProblem9)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnProblem13)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnProblem17))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnProblem2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnProblem6)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnProblem10)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnProblem14)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnProblem18)))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnProblem3)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnProblem7)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnProblem11)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnProblem15)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnProblem19)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnProblem4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnProblem8)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnProblem12)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnProblem16)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnProblem20)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblCalculator)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCalculatorButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(98, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
