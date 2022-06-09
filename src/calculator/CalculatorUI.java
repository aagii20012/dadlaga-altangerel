package calculator;

import main.main;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.DropMode;
import javax.swing.SwingConstants;
import java.awt.Font;

public class CalculatorUI {

	private JFrame frame;
	private JTextField currentNumber;
	private JTextField previesNumber;
	
	public String currentInput = "";
	public String preInput = "";
	public String lastOperation = "";
	public boolean clickedEqual = false;
	public boolean isClickedDot = false;
	public boolean isFirstZero = true;
	public boolean isResult = false;
	
	public Calculator calc = new Calculator();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorUI window = new CalculatorUI();
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
	public CalculatorUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 526);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				main mainPage=new main();
				mainPage.main(null);
			}
		});
		
		JPanel panel_1 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addContainerGap(369, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 435, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))
		);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnProcenteButton = new JButton("%");
		btnProcenteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setOperation("%");
			}
		});
		panel_2.add(btnProcenteButton);
		
		JButton btnOneDivisionButton = new JButton("1/x");
		btnOneDivisionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				singleValueCalc("1/x");
			}
		});
		panel_2.add(btnOneDivisionButton);
		
		JButton btnNumber7Button = new JButton("7");
		btnNumber7Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNumber("7");
			}
		});
		panel_2.add(btnNumber7Button);
		
		JButton btnNumber4Button = new JButton("4");
		btnNumber4Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNumber("4");
			}
		});
		panel_2.add(btnNumber4Button);
		
		JButton btnNumber1Button = new JButton("1");
		btnNumber1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNumber("1");
			}
		});
		panel_2.add(btnNumber1Button);
		
		JButton btnPosAndNegButton = new JButton("+/-");
		btnPosAndNegButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				singleValueCalc("+/-");
			}
		});
		panel_2.add(btnPosAndNegButton);
		
		JPanel panel_2_1 = new JPanel();
		panel.add(panel_2_1);
		panel_2_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnClearButton = new JButton("CE");
		btnClearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		panel_2_1.add(btnClearButton);
		
		JButton btnSquareButton = new JButton("x^2");
		btnSquareButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				singleValueCalc("x2");
			}
		});
		panel_2_1.add(btnSquareButton);
		
		JButton btnNumber8Button = new JButton("8");
		btnNumber8Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNumber("8");
			}
		});
		panel_2_1.add(btnNumber8Button);
		
		JButton btnNumber5Button = new JButton("5");
		btnNumber5Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNumber("5");
			}
		});
		panel_2_1.add(btnNumber5Button);
		
		JButton btnNumber2Button = new JButton("2");
		btnNumber2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNumber("2");
			}
		});
		panel_2_1.add(btnNumber2Button);
		
		JButton btnNumber0Button = new JButton("0");
		btnNumber0Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = currentInput + "0";
				double checkValue = Double.parseDouble(str);
				if (checkValue > 0 || isFirstZero || isClickedDot) {
					isFirstZero = false;
					setNumber("0");
				}
			}
		});
		panel_2_1.add(btnNumber0Button);
		
		JPanel panel_2_2 = new JPanel();
		panel.add(panel_2_2);
		panel_2_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnClearAllButton = new JButton("C");
		btnClearAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		panel_2_2.add(btnClearAllButton);
		
		JButton btnSqrtButton = new JButton("SQRT");
		btnSqrtButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				singleValueCalc("sqrt");
			}
		});
		panel_2_2.add(btnSqrtButton);
		
		JButton btnNumber9Button = new JButton("9");
		btnNumber9Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNumber("9");
			}
		});
		panel_2_2.add(btnNumber9Button);
		
		JButton btnNumber6Button = new JButton("6");
		btnNumber6Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNumber("6");
			}
		});
		panel_2_2.add(btnNumber6Button);
		
		JButton btnNumber3Button = new JButton("3");
		btnNumber3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNumber("3");
			}
		});
		panel_2_2.add(btnNumber3Button);
		
		JButton btnDotButton = new JButton(".");
		btnDotButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( !isClickedDot) {
					if(currentInput.chars().filter(ch -> ch == '.').count() == 1)
						return;
					if(currentInput.isEmpty())
						currentInput += "0.";
					else
						currentInput += ".";
					setOperation(".");
					isClickedDot = true;
					isFirstZero = true;
				}
			}
		});
		panel_2_2.add(btnDotButton);
		
		JPanel panel_2_1_1 = new JPanel();
		panel.add(panel_2_1_1);
		panel_2_1_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnClearOneButton = new JButton("<-");
		btnClearOneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeOne();
			}
		});
		panel_2_1_1.add(btnClearOneButton);
		
		JButton btnDivButton = new JButton("/");
		btnDivButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setOperation("/");
			}
		});
		panel_2_1_1.add(btnDivButton);
		
		JButton btnMultButton = new JButton("x");
		btnMultButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setOperation("*");
			}
		});
		panel_2_1_1.add(btnMultButton);
		
		JButton btnMinusButton = new JButton("-");
		btnMinusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setOperation("-");
			}
		});
		panel_2_1_1.add(btnMinusButton);
		
		JButton btnAddButton = new JButton("+");
		btnAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setOperation("+");
			}
		});
		panel_2_1_1.add(btnAddButton);
		
		JButton btnResultButton = new JButton("=");
		btnResultButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setOperation("=");
			}
		});
		panel_2_1_1.add(btnResultButton);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		previesNumber = new JTextField();
		previesNumber.setFont(new Font("Tahoma", Font.BOLD, 30));
		previesNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		previesNumber.setBackground(Color.WHITE);
		previesNumber.setEnabled(false);
		previesNumber.setEditable(false);
		previesNumber.setForeground(Color.BLACK);
		panel_1.add(previesNumber);
		previesNumber.setColumns(10);
		
		currentNumber = new JTextField();
		currentNumber.setFont(new Font("Tahoma", Font.BOLD, 30));
		currentNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		currentNumber.setEnabled(false);
		currentNumber.setForeground(Color.BLACK);
		currentNumber.setBackground(Color.WHITE);
		currentNumber.setEditable(false);
		panel_1.add(currentNumber);
		currentNumber.setColumns(10);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	protected void clear() {
		currentInput = "";
		isClickedDot = false;
		isFirstZero = true;
		currentNumber.setText("");
	}

	protected void reset() {
		isClickedDot = false;
		isFirstZero = true;
		currentInput = "";
		preInput = "";
		lastOperation = "";
		currentNumber.setText("");
		previesNumber.setText("");
	}

	protected void removeOne() {
		if (currentInput != null && currentInput.length() > 0)
			currentInput = currentInput.substring(0, currentInput.length() - 1);
		currentNumber.setText(currentInput);
		return;
	}
	
	protected void singleValueCalc(String operation) {
		if(operation == "x2")
			previesNumber.setText(currentInput + "^2");
		if(operation == "sqrt")
			previesNumber.setText("sqrt(" + currentInput +")");
		
		double left = 0, result;
		
		if (!currentInput.isBlank())
			left = Double.parseDouble(currentInput);
		else 
			left = 0;
		
		result = calc.makeCalculationOnOne(left, operation);
		currentInput = Double.toString(result);
		currentNumber.setText(currentInput);
		if(!(operation == "+/-"))
			lastOperation = operation;
	}
	
	protected boolean isLastOpSingle() {
		if(lastOperation == "x2" || lastOperation == "sqrt")
			return true;
		return false;
	}
	
	protected void setNumber(String number) {
		if(currentInput.equals("0"))
		{
			currentInput = number;
			currentNumber.setText(currentInput);
			return;
		}
		if(!isResult) {
			currentInput += number;
			currentNumber.setText(currentInput);
		}
		else {
			isResult = false;
			reset();
			setNumber(number);
		}
	}

	protected void setOperation(String operation) {
		if(operation == "=")
		{
			String resultOfCalc = "";
			if(isLastOpSingle()) {
				singleValueCalc(lastOperation);
				return;
			}
			
			double left = 0, rigth = 0, result;
			try {
				left = Double.parseDouble(preInput);
				rigth = Double.parseDouble(currentInput);
				clickedEqual = true;
			}
			catch(Exception e) {
				previesNumber.setText(currentInput + "=");
				return;
			}
			result = calc.makeCalculationOnTwo(left, rigth, lastOperation);
			if( result % 1 == 0 )
				resultOfCalc += (int) result;
			else
				resultOfCalc += Double.toString(result);
			isClickedDot = false;
			isFirstZero = true;
			currentInput = resultOfCalc;
			if( currentInput.contains("Infinity"))
			{
				reset();
				currentNumber.setText("Cannot divide by zero");
			}else
				currentNumber.setText(currentInput);
			previesNumber.setText("");
			isResult = true;
			return;
		}
		else if(operation == ".")
		{
			currentNumber.setText(currentInput);
		}
		else 
		{
			isResult = false;
			previesNumber.setText(currentInput + operation);
			preInput = currentInput;
			lastOperation = operation;
			currentInput = "";
		}
	}
}
