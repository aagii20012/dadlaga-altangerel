package problem;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import main.main;
import javax.swing.JSpinner;

public class Problem12 {

	private JFrame frame;
	
	public int solver(int n) {
		int firstStep=1,secondStep=1;
		
		for(int i = 2; i <= n; i++) {
			int holder = secondStep;
			secondStep += firstStep;
			firstStep = holder;
		}
		
		return secondStep;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problem12 window = new Problem12();
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
	public Problem12() {
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
		
		String quest="Хүү n гишгүүртэй шатаар өгсөхдөө 2 янзаар урагшилж чадна. "
				+ "Зогсож байгаа гишгүүрийнхээ дараах гишгүүрт, эсвэл 1 алгасаад"
				+ " дараагийн гишгүүрт алхаж очно."
				+ " Нэгдүгээр гишгүүрийн өмнө зогсож байгаа хүү n-р гишгүүр хүртэл "
				+ "хичнээн ялгаатай маршрутаар алхаж очиж вэ?";
		
		JLabel lblQuestLabel = new JLabel("<html>"+quest+"</html>");
		
		JLabel lblNewLabel = new JLabel("Шатан дахь гишгүүрийн тоо ");
		
		JSpinner stairSpinner = new JSpinner();
		
		JLabel lblResultLabel = new JLabel("Result:");
		
		JButton btnCalculateButton = new JButton("Calculate");
		btnCalculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n,result;
				n = (int) stairSpinner.getValue();
				
				if(n<0) {
					lblResultLabel.setText("Error: Stair must be greate than 0");
					return;
				}
				
				result = solver(n);
				lblResultLabel.setText("Result: "+result);
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
							.addGap(35)
							.addComponent(lblQuestLabel, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(48)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(stairSpinner, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnCalculateButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(116)
							.addComponent(lblResultLabel)))
					.addContainerGap(36, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(7)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblQuestLabel)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(stairSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCalculateButton))
					.addGap(18)
					.addComponent(lblResultLabel)
					.addGap(100))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
