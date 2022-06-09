package problem;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import main.main;

public class Problem17 {

	private JFrame frame;
	private JSpinner floorSpinner;
	private JSpinner doorSpinner;
	private JSpinner doorNumberSpinner;
	private JLabel lblResultLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problem17 window = new Problem17();
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
	public Problem17() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 496, 379);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				main mainPage=new main();
				mainPage.main(null);
			}
		});
		
		String quest="Нэг орцтой байрны давхрын тоо, давхар дахь хаалганы тоо өгөгдөв."
				+ " Айлын хаалганы дугаар мэдэгдэж байгаа үед тэрхүү айл хэд дэх"
				+ " давхрын хэд дэх хаалганд амьдардаг вэ? Давталт ашиглахгүй бодно.";
		
		JLabel lblQuestLabel = new JLabel("<html>"+quest+"</html>");
		
		JPanel panel = new JPanel();
		
		JButton btnCalcButton = new JButton("Calculate");
		btnCalcButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int doorNumber, door, floor;
				boolean isZero = false;
				String result;
				
				door = (int) doorSpinner.getValue();
				floor = (int) floorSpinner.getValue();
				doorNumber = (int) doorNumberSpinner.getValue();
				
				isZero = checkIsValid(door, floor, doorNumber);
				
				if(isZero)
					return;
				
				result = solver(doorNumber, door, floor);
				System.out.println(result);
				
				setResult(result);
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
							.addGap(22)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnCalcButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblResultLabel, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(22)
							.addComponent(lblQuestLabel, GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(lblQuestLabel)
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnCalcButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblResultLabel, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)))
					.addGap(48))
		);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Floor");
		panel.add(lblNewLabel);
		
		floorSpinner = new JSpinner();
		panel.add(floorSpinner);
		
		JLabel lblNewLabel_2 = new JLabel("Door");
		panel.add(lblNewLabel_2);
		
		doorSpinner = new JSpinner();
		panel.add(doorSpinner);
		
		JLabel label = new JLabel("");
		panel.add(label);
		
		JLabel label_1 = new JLabel("");
		panel.add(label_1);
		
		JLabel lblNewLabel_3 = new JLabel("Door number");
		panel.add(lblNewLabel_3);
		
		doorNumberSpinner = new JSpinner();
		panel.add(doorNumberSpinner);
		frame.getContentPane().setLayout(groupLayout);
	}

	public void setResult(String result) {
		lblResultLabel.setText("Result: " + result);
	}

	public String solver(int doorNumber, int door, int floor) {
		String result = "";
		int floorCount=1;
		while(doorNumber > door) {
			doorNumber -= door;
			floorCount++;
		}
		
		if (doorNumber>0)
			result += " " + floorCount + " " + doorNumber;
		else
			result += " " + floorCount + " 4";
			
		return result;
	}

	public boolean checkIsValid(
			int door, int floor, int doorNumber) {
		int limit = door * floor;
		if ( door < 1 )
		{
			error("There must be more than 0 door");
			return true;
		}
		if ( floor < 1 )
		{
			error("One entrance has many floor");
			return true;
		}
		if ( doorNumber < 1 )
		{
			error("Door number must be greater than 0");
			return true;
		}
		if( limit < doorNumber)
		{
			error("Door number must be lower than limit. Limit is " + limit);
			return true;
		}
		return false;
	}
	
	public void error(String message) {
		lblResultLabel.setText("<html>Error: " + message + "</html>");
	}
}
