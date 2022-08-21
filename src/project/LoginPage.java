package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.CardLayout;
import net.miginfocom.swing.MigLayout;
import problem.Problem2;
import user.User;
import user.UserSingInCheck;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginPage {

	private JFrame frame;
	private JTextField emailField;
	private JLabel lblErrorLabel ;
	DbConnection conn = new DbConnection();
	UserSingInCheck validation = new UserSingInCheck();
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
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
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 339, 329);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Log in");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 33));
		frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[46px][226px,grow][]", "[20px][20px][23px][][][]"));
		
		JLabel lblEmailLabel = new JLabel("Email");
		panel.add(lblEmailLabel, "cell 0 1,alignx left,aligny center");
		
		emailField = new JTextField();
		panel.add(emailField, "cell 1 1,growx,aligny top");
		emailField.setColumns(10);
		
		JLabel lblPasswordLabel = new JLabel("Password");
		panel.add(lblPasswordLabel, "cell 0 2,alignx trailing,aligny center");
		
		JButton btnLogInButton = new JButton("Log in");
		btnLogInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = emailField.getText();
				String password = passwordField.getText();
				
				if(!validate(email, password))
				{
					System.out.println("hrere");
					return;
				}
				conn.connect();
				
				User user = validation.login(conn.dbConnection, email, password);
				
				if( user == null) {
					setError("User not found");
					conn.close();
					return;
				}
				conn.close();
				frame.dispose();
				Summary summary = new Summary();
				summary.passUser(user);
				summary.main(null);
			}
		});
		
		passwordField = new JPasswordField();
		panel.add(passwordField, "cell 1 2,growx");
		
		lblErrorLabel = new JLabel(" ");
		panel.add(lblErrorLabel, "cell 1 3");
		panel.add(btnLogInButton, "cell 0 4 2 1,growx,aligny top");
		
		JButton btnSignUpButton = new JButton("Sign up here");
		btnSignUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				SingUp.main(null);
			}
		});
		panel.add(btnSignUpButton, "cell 0 5 2 1,growx");
	}

	protected boolean validate(String email, String password) {
		resetError();
		if(email.isBlank()) {
			setError("Email must be entered");
			return false;
		}
		if(!patternMatches(email)) {
			setError("PLease enter valid email");
			return false;
		}
		if(password.isBlank()) {
			setError("password must be entered");
			return false;
		}
		if(password.length() < 6) {
			setError("password must be more than 6");
			return false;
		}
		return true;
	}

	public static boolean patternMatches(String emailAddress) {
		String  regexPattern = "^\\S+@\\S+$";
	    return Pattern.matches(regexPattern, emailAddress);
	}
	
	private void resetError() {
		lblErrorLabel.setText("<html></html>");
	}

	private void setError(String string) {
		lblErrorLabel.setText("<html>Error: " + string + "</html>");
	}
	
	

}
