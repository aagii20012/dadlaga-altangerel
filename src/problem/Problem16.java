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
import java.awt.Panel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JSpinner;

public class Problem16 {

	private JFrame frame;
	private JSpinner floorSpinner;
	private JSpinner entranceSpinner;
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
					Problem16 window = new Problem16();
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
	public Problem16() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 373);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				main mainPage=new main();
				mainPage.main(null);
			}
		});
		
		String quest="Байшингийн давхар, орц, нэг давхарт суудаг айлын тоо мэдэгдэж байвал энэхүү "
				+ "байшингийн өгөгдсөн тоот нь хэддүгээр орцны, хэдэн давхрын хэд дэх хаалга вэ?<br>"
				+ "Жич: Давхар бүр дэх хаалганы тоо ижил.";
		
		JLabel lblQuestLabel = new JLabel("<html>"+quest+"</html>");
		
		JPanel panel = new JPanel();
		
		JButton btnCalcButton = new JButton("Calculate");
		btnCalcButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int doorNumber, door, floor, entrance;
				boolean isZero = false;
				String result;
				
				door = (int) doorSpinner.getValue();
				floor = (int) floorSpinner.getValue();
				entrance = (int) entranceSpinner.getValue();
				doorNumber = (int) doorNumberSpinner.getValue();
				
				isZero = checkIsValid(door, floor, entrance, doorNumber);
				
				if(isZero)
					return;
				
				result = solver(doorNumber, door, floor, entrance);
				
				setResult(result);
			}
		});
		
		lblResultLabel = new JLabel("Result:");
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(352, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnCalcButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblResultLabel, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
							.addGap(58))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblQuestLabel, GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
							.addGap(19))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(lblQuestLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnCalcButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblResultLabel, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)))
					.addGap(64))
		);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Floor");
		panel.add(lblNewLabel);
		
		floorSpinner = new JSpinner();
		panel.add(floorSpinner);
		
		JLabel lblNewLabel_1 = new JLabel("Entrance ");
		panel.add(lblNewLabel_1);
		
		entranceSpinner = new JSpinner();
		panel.add(entranceSpinner);
		
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
		// TODO Auto-generated method stub
		lblResultLabel.setText("Result: " + result);
	}

	public String solver(int doorNumber, int door, int floor, int entrance) {
		String result = "";
		int oneEntranceFloor, entranceCount=1, floorCount=1;
		oneEntranceFloor = floor*door;
		while(doorNumber > oneEntranceFloor + 1)
		{
			doorNumber -= oneEntranceFloor;
			entranceCount++;
		}
		while(doorNumber > door) {
			doorNumber -= door;
			floorCount++;
		}
		
		if (doorNumber>0)
			result += entranceCount + " " + floorCount + " " + doorNumber;
		else
			result += entranceCount + " " + floorCount + " 4";
			
		return result;
	}

	public boolean checkIsValid(
			int door, int floor, 
			int entrance, int doorNumber) {
		int limit = door * entrance * floor;
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
		if ( entrance < 1 )
		{
			error("Entrance must be greater than 0");
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
