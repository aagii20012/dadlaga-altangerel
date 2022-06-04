package problem;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;

import main.main;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSpinner;

public class Problem15 {

	private JFrame frame;
	private JLabel lblResultLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problem15 window = new Problem15();
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
	public Problem15() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 287);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				main mainPage=new main();
				mainPage.main(null);
			}
		});
		
		String quest="Гурвалжны 3 тал нь бүхэл тоогоор өгөгдсөн бол хэлбэрийг нь тодорхойл."
				+ " Хэлбэр нь тэгш өнцөгт, хурц өнцөгт, мохоо өнцөгтийн аль нэг байна.";
		
		JLabel lblQuestLabel = new JLabel("<html>"+quest+"</html>");
		
		JLabel lblNewLabel = new JLabel("First side");
		
		JSpinner sideOneSpinner = new JSpinner();
		
		JLabel lblThirdSide = new JLabel("Third side");
		
		JSpinner sideThreeSpinner = new JSpinner();
		
		JLabel lblSecondSide = new JLabel("Second side");
		
		JSpinner sideTwoSpinner = new JSpinner();
		
		lblResultLabel = new JLabel("Result:");
		
		JButton btnCalcButton = new JButton("Calculator");
		btnCalcButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int side1,side2,side3;
				String result;
				
				side1 = (int) sideOneSpinner.getValue();
				side2 = (int) sideTwoSpinner.getValue();
				side3 = (int) sideThreeSpinner.getValue();
				
				if( side1 <= 0 && side2 <= 0 && side3 <= 0)
				{
					error();
					return;
				}
				
				result = solver(side1, side2, side3);
				
				setResult(result);
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
								.addComponent(lblQuestLabel)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel)
										.addComponent(lblSecondSide)
										.addComponent(lblThirdSide))
									.addGap(31)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(sideTwoSpinner, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
										.addComponent(sideOneSpinner, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
										.addComponent(sideThreeSpinner, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
									.addGap(28)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblResultLabel, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnCalcButton))))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(lblQuestLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(sideOneSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCalcButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSecondSide)
								.addComponent(sideTwoSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblThirdSide)
								.addComponent(sideThreeSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblResultLabel, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
					.addGap(60))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	protected String solver(int a, int b, int c) {
		if(a>b && a>c)
		{
		    if(b*b+c*c==a*a)
			    return "Right";
			if(c*c+b*b>a*a)
				return "Acute";
			if(c*c+b*b<a*a)
				return "Obtuse";
		}
		
		if(b>c&&b>a)
		{
			if(c*c+a*a==b*b)
				return "Right";
			if(c*c+a*a>b*b)
				return "Acute";
			if(c*c+a*a<b*b)
				return "Obtuse";
		}
		if(c>b&&c>a)
		{
			if(b*b+a*a==c*c)
				return "Right";
			if(b*b+a*a>c*c)
				return "Acute";
			if(b*b+a*a<c*c)
				return "Obtuse";
		}
		return "side must be diffrent";
	}

	protected void error() {
		lblResultLabel.setText("<html>Error: All side must be greate than 0</html>");
	}
	
	protected void setResult(String message) {
		lblResultLabel.setText("Result: " + message);
	}

}
