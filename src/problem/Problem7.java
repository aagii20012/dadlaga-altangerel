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
import javax.swing.JTextField;

public class Problem7 {

	private JFrame frame;
	private JTextField wordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problem7 window = new Problem7();
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
	public Problem7() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 688, 408);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				main mainPage=new main();
				mainPage.main(null);
			}
		});
		
		String quest="Нэтэд хүмүүс үгийн үсгүүдийг жижиг томоор хольж бичдэг нь Васягийн "
				+ "сэтгэлийг маш ихээр гонсойлгодог. Тиймээс тэр өөрийн дуртай веб хөтөч "
				+ "дээрээ бүх үгийг нэг бол зөвхөн жижиг үсгүүдээс тогтсон нөгөө бол зөвхөн"
				+ " том үсгүүдээс тогтсон болгодог нэмэлт бүтээхээр шийдсэн. Вася үүнийг хйихдээ"
				+ " аль болох бага үсэг өөрчилдөг байхаар хийхийг хүссэн. Жишээ нь HoUse гэсэн үгийг"
				+ " house гэсэн үгээр сольж, харин ViP гэсэн үг байвал VIP гэсэн үгээр солих юм. Хэрвээ"
				+ " үгийн жижиг болон том үсгийн тоо тэнцүү байвал бүх үсгийг жижиг болгон өөрчилнө. Жишээ"
				+ " нь maTRIx гэсэн үг нь matrix болж өөрчлөгдөнө. Таны даалгавар бол уг өөрчлөлтийг хийдэг "
				+ "програмыг зохиох юм.";
		
		JLabel lblQuestLabel = new JLabel("<html>"+quest+"</html>");
		
		JLabel lblNewLabel = new JLabel("Enter word");
		
		JLabel lblResultLabel = new JLabel("Result");
		
		wordField = new JTextField();
		wordField.setColumns(10);
		
		JButton btnConvertButton_1 = new JButton("Convert");
		btnConvertButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String word, result;
				boolean isContainNumber=false;
				int upperCase = 0, lowerCase = 0;
				
				word = wordField.getText();
				
				if( word.isBlank()) {
					lblResultLabel.setText("Error: Please enter word");
					return;
				}
				
				for(char chr:word.toCharArray()) {
					if (Character.isDigit(chr)) {
						isContainNumber = true;
						break;
					}
					if (Character.isUpperCase(chr)) upperCase++;
					if (Character.isLowerCase(chr)) lowerCase++;
				}
				if(isContainNumber) {
					lblResultLabel.setText("Error: Please enter only words");
					return;
				}
				
				if(upperCase>lowerCase) 
					lblResultLabel.setText("Result: " + word.toUpperCase());
				else
					lblResultLabel.setText("Result: " + word.toLowerCase());
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(47, Short.MAX_VALUE)
					.addComponent(lblQuestLabel)
					.addGap(26))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(88)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblResultLabel)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(wordField, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(btnConvertButton_1)))
					.addContainerGap(279, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(lblQuestLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(wordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnConvertButton_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblResultLabel)
					.addGap(179))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
