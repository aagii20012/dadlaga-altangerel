package main;


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
		
		JButton btnProblem1 = new JButton("Problem 1");
		btnProblem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Problem1 toQuest=new Problem1();
				toQuest.main(null);
			}
		});
		
		JButton btnProblem2 = new JButton("Problem 2");
		btnProblem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Problem2 toQuest=new Problem2();
				toQuest.main(null);
			}
		});
		
		JButton btnProblem3 = new JButton("Problem 3");
		btnProblem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Problem3 toQuest=new Problem3();
				toQuest.main(null);
			}
		});
		
		JButton btnProblem4 = new JButton("Problem 4");
		btnProblem4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Problem4 toQuest=new Problem4();
				toQuest.main(null);
			}
		});
		
		JButton btnProblem5 = new JButton("problem 5");
		btnProblem5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Problem5 toQuest=new Problem5();
				toQuest.main(null);
			}
		});
		
		JButton btnProblem6 = new JButton("problem 6");
		btnProblem6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Problem6 toQuest=new Problem6();
				toQuest.main(null);
			}
		});
		
		JButton btnProblem7 = new JButton("problem 7");
		btnProblem7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Problem7 toQuest=new Problem7();
				toQuest.main(null);
			}
		});
		
		JButton btnProblem8 = new JButton("problem 8");
		btnProblem8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Problem8 toQuest=new Problem8();
				toQuest.main(null);
			}
		});
		
		JButton btnProblem9 = new JButton("problem 9");
		btnProblem9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Problem9 toQuest=new Problem9();
				toQuest.main(null);
			}
		});
		
		JButton btnProblem10 = new JButton("problem 10");
		btnProblem10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Problem10 toQuest=new Problem10();
				toQuest.main(null);
			}
		});
		
		JButton btnProblem11 = new JButton("problem 11");
		btnProblem11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Problem11 toQuest=new Problem11();
				toQuest.main(null);
			}
		});
		
		JButton btnProblem12 = new JButton("problem 12");
		btnProblem12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Problem12 toQuest=new Problem12();
				toQuest.main(null);
			}
		});
		
		JButton btnProblem17 = new JButton("problem 17");
		btnProblem17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Problem17 toQuest=new Problem17();
				toQuest.main(null);
			}
		});
		
		JButton btnProblem18 = new JButton("problem 18");
		btnProblem18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Problem18 toQuest=new Problem18();
				toQuest.main(null);
			}
		});
		
		JButton btnProblem19 = new JButton("problem 19");
		btnProblem19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Problem19 toQuest=new Problem19();
				toQuest.main(null);
			}
		});
		
		JButton btnProblem20 = new JButton("problem 20");
		btnProblem20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Problem20 toQuest=new Problem20();
				toQuest.main(null);
			}
		});
		
		JButton btnProblem13 = new JButton("problem 13");
		btnProblem13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Problem13 toQuest=new Problem13();
				toQuest.main(null);
			}
		});
		
		JButton btnProblem14 = new JButton("problem 14");
		btnProblem14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Problem14 toQuest=new Problem14();
				toQuest.main(null);
			}
		});
		
		JButton btnProblem15 = new JButton("problem 15");
		btnProblem15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Problem15 toQuest=new Problem15();
				toQuest.main(null);
			}
		});
		
		JButton btnProblem16 = new JButton("problem 16");
		btnProblem16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Problem16 toQuest=new Problem16();
				toQuest.main(null);
			}
		});
		
		JLabel lblCalculator = new JLabel("Calculator");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(70)
							.addComponent(lblProblemLbl, GroupLayout.PREFERRED_SIZE, 470, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnProblem1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(btnProblem17, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnProblem13, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnProblem9, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnProblem5, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblCalculator, Alignment.LEADING)))
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
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnProblem5)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnProblem9)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnProblem13)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnProblem17)))
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
					.addContainerGap(147, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
