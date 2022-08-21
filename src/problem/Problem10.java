package problem;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import main.main;
import javax.swing.JSpinner;

public class Problem10 {

	private JFrame frame;
	
	public double  solver(int cicleLen){
		double surface ,rad;
		
		rad = cicleLen/(2*3.141592); 
		surface  = rad*rad*3.141592; 
		
		return surface;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problem10 window = new Problem10();
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
	public Problem10() {
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
		
		String quest="Тойргийн урт өгөгдөв. Энэ тойргоор хүрээлэгдсэн дугуйн талбайг ол.";
		
		JLabel lblQuestLabel = new JLabel("<html>"+quest+"</html>");
		
		JLabel lblNewLabel = new JLabel("Circle length");
		
		JSpinner circleSpinner = new JSpinner();
		
		JLabel lblResultLabel = new JLabel("Result:");
		
		JButton btnCalculatorButton = new JButton("Calculator");
		btnCalculatorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int len;
				double result;
				len = (int) circleSpinner.getValue();
				
				result = solver(len);
				DecimalFormat df = new DecimalFormat("#.###");
				lblResultLabel.setText("Result: "+df.format(result));
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
							.addComponent(lblQuestLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(72)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(circleSpinner, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnCalculatorButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(97)
							.addComponent(lblResultLabel)))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblQuestLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(circleSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCalculatorButton)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addComponent(lblResultLabel)
					.addGap(138))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
