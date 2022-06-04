package problem;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import main.main;

public class Problem6 {

	private JFrame frame;
	
	public String solve(int a,int b) {
		String result="";
		
		while(a!=b) {
			if(a%2==0&&a/2>=b)
			{
				a=a/2;
				result+=":2";
			}
			else{
				a=a-1;
				result+="-1";
			}
		}
		
		return result;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problem6 window = new Problem6();
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
	public Problem6() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 354);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				main mainPage=new main();
				mainPage.main(null);
			}
		});
		
		String quest="A,B натурал тоонууд өгөгдөв. А тоон дээр дараах 2 командыг гүйцэтгэж болно."
				+ "1-р команд тоог 2 дахин багасгах (\":2\" тэмдэглэнэ)."
				+ "Сондгой үед 2 дахин багасгаж болохгүй. х (\"-1\" гэж тэмдэглэнэ)."
				+ "А тооноос В тоог гарган авахын тулд хамгийн багадаа ямар командуудыг "
				+ "биелүүлэх шаардлагатай болохыг үзүүл."
				+ "Командуудыг нэг мөрөнд бичнэ. ";
		
		JLabel lblQuestLabel = new JLabel("<html>"+quest+"</html>");
		
		JLabel lblStartLabel = new JLabel("Start");
		
		JSpinner startSpinner = new JSpinner();
		
		JLabel lblEndLabel = new JLabel("End");
		
		JSpinner endSpinner = new JSpinner();
		
		JLabel lblRsultLabel = new JLabel("Result:");
		
		JButton btnCalculateButton = new JButton("Calculate");
		btnCalculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int start,end;
				String result;
				
				start=(int) startSpinner.getValue();
				end=(int) endSpinner.getValue();
				if (start<=end)
					lblRsultLabel.setText("Error: Start must be greater than end");
				else {
					result=solve(start,end);
					lblRsultLabel.setText("Result: "+result);
				}
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
									.addComponent(lblStartLabel)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(18)
											.addComponent(lblRsultLabel))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(10)
											.addComponent(startSpinner, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lblEndLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(endSpinner, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(btnCalculateButton)))))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblQuestLabel)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStartLabel)
						.addComponent(startSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEndLabel)
						.addComponent(endSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCalculateButton))
					.addGap(18)
					.addComponent(lblRsultLabel))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
