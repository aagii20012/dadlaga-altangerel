package problem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

import main.main;

public class Problem3 {

	private JFrame frame;
	private JTextField textCubeLvlField;

	public long solution(int n){
		long result=0;
		
		result=(n+1)*n/2;
		
		return result*result;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problem3 window = new Problem3();
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
	public Problem3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String quest="Өгөгдсөн n тоо хүртэлх натурал тоонуудын кубуудын нийлбэрийг ол.\n"
				+ "\n Давталт ашиглахгүй бодвол сайн. \r\n"
				+ "\n 1^3+2^3+3^3+...+n^3.";
		
		JLabel lblNewLabel = new JLabel("<html>"+quest+"</html>");
		
		JLabel lblNewLabel_1 = new JLabel("Enter n number");
		
		textCubeLvlField = new JTextField();
		textCubeLvlField.setColumns(10);
		
		JLabel lblResultTable = new JLabel("Result:");
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textCubeLvlField.getText().isBlank())
					lblResultTable.setText("Error: You need to enter N number");
				else {
					int n= Integer.parseInt(textCubeLvlField.getText());
					lblResultTable.setText("Result: "+solution(n));
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
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel_1)
								.addGap(18)
								.addComponent(textCubeLvlField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(29)
								.addComponent(btnCalculate)
								.addGap(120))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblResultTable, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(330)))))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addContainerGap(335, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(textCubeLvlField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnCalculate)))
					.addGap(47)
					.addComponent(lblResultTable)
					.addContainerGap(100, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
