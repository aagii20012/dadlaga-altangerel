package problem;

import main.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JSpinner;

public class Problem1 {

	private JFrame frame;
	private JTextField dragonPower;
	private JTextField dragonBonus;
	private JTable table;
	private JLabel lblResultLabel;
	public Collection<Dragon> datas= new ArrayList<>();
	public Krito hero=new Krito(0);
	
	public String solveProblem(){
		hero.updateBonus(0);
		Collections.sort((List<Dragon>) datas);
		for (Dragon data : datas){
			if( !hero.isVictory(data.getPower(), data.getBonus()))
				return "NO";
		}
		return "YES";
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problem1 window = new Problem1();
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
	public Problem1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 715, 518);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String quest=" Крито тоглож байгаад MMORPG тоглоомныхоо нэг үе дээр гацчихаад байна. "
				+ "Уг үеийг давахын тулд n лууг ялах хэрэгтэй гэнэ. Крито болон луунууд бүхэл тоогоор илэрхийлэгдэх чадалтай. "
				+ "Тулаан болох үед хэн их чадалтай нь ялдаг гэнэ. Анх Крито s чадалтай байсан.\r\n"
				+ "\r\n"
				+ "Хэрвээ Крито i-р (1≤i≤n) луутай тулалдах үед түүний чадал нь лууны чадал xi\r\n"
				+ "-р бага байвал тэр ялагдаж, тоглоом дуусна. Хэрвээ Критогийн чадал лууныхаас их байвал тэр ялж, луу үхэж, Крито yi\r\n"
				+ " бонус чадал өөртөө авна.\r\n"
				+ "\r\n"
				+ "Крито луунуудтай хүссэн дарааллаарааа тулалдаж чадах бол тэр бүх лууг ялж, дараагийн үедээ орж чадах эсэхийг тодорхойл.";
		
		JLabel questLabel = new JLabel("<html>"+quest+"</html>");
		
		JLabel lblTitleLabel = new JLabel("Add new dragon");
		
		JLabel dragonPowerLabel = new JLabel("Dragon power");
		
		dragonPower = new JTextField();
		dragonPower.setColumns(10);
		
		JLabel dragonBonusLabel = new JLabel("Dragon bonus");
		
		dragonBonus = new JTextField();
		dragonBonus.setColumns(10);
		
		JButton btnAddDragonButton = new JButton("Add dargon");
		btnAddDragonButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int power,bonus,lastIndex;
				
				lastIndex=table.getRowCount()+1;
				
				power=Integer.parseInt(dragonPower.getText());
				bonus=Integer.parseInt(dragonBonus.getText());
				
				Object[] row = { lastIndex, power, bonus};
				
				Dragon data=new Dragon(lastIndex, power, bonus);
				datas.add(data);
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				model.addRow(row);
			}
		});
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"#", "Power", "Bonus"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(datas.isEmpty()) 
				{
					lblResultLabel.setText("Error: You need to enter dragons data");
					lblResultLabel.setBackground(Color.RED);
				}
				else 
				{
					lblResultLabel.setText("Result: "+solveProblem());
					lblResultLabel.setBackground(Color.BLACK);
				}
			}
		});
		
		lblResultLabel = new JLabel("Result:");
		lblResultLabel.setForeground(new Color(0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("enter Krito power");
		
		JSpinner spinner = new JSpinner();
		
		JButton btnSavePower = new JButton("save");
		btnSavePower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int power=(int) spinner.getValue();
				hero.updatePower(power);
			}
		});
		
		JButton btnResetButton = new JButton("Reset");
		btnResetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datas.removeAll(datas);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				hero.reset();
				dragonPower.setText("");
				dragonBonus.setText("");
				spinner.setValue(0);
			}
		});
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
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
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(33)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(28)
									.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
									.addGap(32)
									.addComponent(btnSavePower))
								.addComponent(questLabel, GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(17)
									.addComponent(btnCalculate, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnResetButton, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE))
								.addComponent(table, GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE))))
					.addGap(31))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(121)
					.addComponent(lblResultLabel)
					.addContainerGap(544, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTitleLabel, GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(39)
							.addComponent(dragonPowerLabel)
							.addGap(18)
							.addComponent(dragonPower, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(dragonBonusLabel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(dragonBonus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(34)
							.addComponent(btnAddDragonButton)))
					.addGap(31))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(623, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(btnBack)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(questLabel)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSavePower))
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addComponent(lblTitleLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAddDragonButton)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(dragonPowerLabel)
							.addComponent(dragonPower, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(dragonBonusLabel))
						.addComponent(dragonBonus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnResetButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnCalculate, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(lblResultLabel)
					.addGap(34))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	public class Dragon implements Comparable<Dragon> {
		  
	    public int number;
	    public int power;
	    public int bonus;
	    
	    Dragon(int number, int power,int bonus)
	    {
	        this.number = number;
	        this.power = power;
	        this.bonus = bonus;
	    }
	    
	    public int getPower(){
	        return power;
	     }
	    
	    public int getBonus() {
	        return bonus;
	    }

		@Override
		public int compareTo(Dragon o) {
			// TODO Auto-generated method stub
			return this.power-o.getPower();
		}
	    
	    
	}
	
	public class Krito{
	    public int power;
	    public int bonus;
	    
	    Krito(int power)
	    {
	        this.power = power;
	        this.bonus = 0;
	    }
	    
	    public boolean isVictory(int dragonPower,int bonus){
	    	if(this.power<dragonPower)
	    		return false;
	    	this.power+=bonus;
	    	return true;
	    }
	    
	    public void updatePower(int power) {
	    	this.power=power;
	    }
	    
	    public void updateBonus(int bonus) {
	    	this.bonus=bonus;
	    }
	    
	    public void reset() {
	    	this.power=0;
	    	this.bonus=0;
	    }
		
	}
}
