package problem;

import java.awt.EventQueue;

import javax.swing.JFrame;

import main.main;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSpinner;

public class Problem4 {

	private JFrame frame;
	
	public int solve(int n) {
		if (n<=0)
			return 0;
		int sum=0;
		
		for(int i=1;i<=n;i++) {
			int multi=1;
			for( int q=i;q<=2*i;q++)
				multi*=q;
			sum+=multi;
		}
		return sum;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problem4 window = new Problem4();
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
	public Problem4() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 497, 373);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				main mainPage=new main();
				mainPage.main(null);
			}
		});
		
		String quest="1*2  + 2*3*4 + 3*4*5*6 + ... + n*(n+1)*...*2*n илэрхийллийг бод.";
		
		JLabel lblQuestLabel = new JLabel("<html>"+quest+"</html>");
		
		JLabel lblNumberLabel = new JLabel("New label");
		
		JSpinner nNumber = new JSpinner();
		
		JLabel lblRsultLabel = new JLabel("Result:");
		
		JButton btnCalculateButton = new JButton("Calculate");
		btnCalculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result,n;
				
				n=(int) nNumber.getValue();
				result=solve(n);
				
				lblRsultLabel.setText("Result: "+result);
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
									.addComponent(lblNumberLabel)
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblRsultLabel)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(nNumber, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
											.addGap(37)
											.addComponent(btnCalculateButton)))))))
					.addContainerGap(161, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblQuestLabel)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumberLabel)
						.addComponent(nNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCalculateButton))
					.addGap(18)
					.addComponent(lblRsultLabel)
					.addContainerGap(199, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
