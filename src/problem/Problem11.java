package problem;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import main.main;
import problem.Problem1.Dragon;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTextField;


public class Problem11 {

	private JFrame frame;
	private JTable table;
	private JTextField massiveField;
	
	public int column=0;
	
	public static int findIndex(int arr[], int t)
    {
        int index = Arrays.binarySearch(arr, t);
        return (index < 0) ? -1 : index;
    }
	
	public String solver(int[][] arrays) {
		int max = -99999,posX=0,posY = 0;
		String result = "";
		
		for (int[] array: arrays)
		{
			int tmpMax = Arrays.stream(array).max().getAsInt();
			if(tmpMax > max)
				max = tmpMax;
			posY = findIndex(array, max) + 1;
			posX++;
		}
		
		result += max + " " + posX + " " + posY;
		return result;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problem11 window = new Problem11();
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
	public Problem11() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 502, 494);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				main mainPage=new main();
				mainPage.main(null);
			}
		});
		
		String quest="Өгөгдсөн хоёр хэмжээст массивын хамгийн их элементийг байрлалын хамт хэвлэ.<br>"
				+ "Хэрвээ хамгийн их элемент нэгээс олон байвал мөрийн бага дугаартайг нь "
				+ "(мөрийн дугаар ижил бол баганын бага дугаартайг нь) хэвлэнэ.";
		
		JLabel lblQuestLabel = new JLabel("<html>"+quest+"</html>");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Array #", "massive"
			}
		));
		
		JLabel lblNewLabel = new JLabel("Massive(please add massive with space between)");
		
		massiveField = new JTextField();
		massiveField.setColumns(10);
		
		JLabel lblResultLabel = new JLabel("Result:");
		
		JButton btnCalculateButton = new JButton("Calculate");
		btnCalculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(column == 0) {
					lblResultLabel.setText("Error: Please enter massive");
					return;
				}
				
				String result;
				int[][] array = new int[column][];
				
				for(int i = 0; i < column; i++) {
					String temp = (String)table.getModel().getValueAt(i,1);
					String[] strArray = temp.split(" ");
					int[] intArray = Arrays.stream(strArray)
	                        .mapToInt(Integer::parseInt)
	                        .toArray();
					array[i] = intArray;
				}
				
				result = solver(array);
				
				lblResultLabel.setText("Result: "+result);
			}
		});
		
		JButton btnAddMassiveButton = new JButton("Add");
		btnAddMassiveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String massive;
				massive = massiveField.getText();
				
				if(massive.isEmpty())
				{
					lblResultLabel.setText("Error: Please enter massive");
					return;
				}
				
				Object[] row = { "Massive "+(column+1), massive};
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				model.addRow(row);
				
				column++;
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addComponent(lblQuestLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(57)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(80)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblNewLabel)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(massiveField)
									.addGap(18)
									.addComponent(btnAddMassiveButton))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(135)
							.addComponent(lblResultLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(73)
							.addComponent(btnCalculateButton, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(10, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(7)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblQuestLabel)
					.addGap(27)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(massiveField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAddMassiveButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblResultLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCalculateButton, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addGap(65))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
