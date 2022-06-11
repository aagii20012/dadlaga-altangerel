package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;
import user.User;
import user.UserSignUp;
import user.UserSingInCheck;

public class SingUp {

	private JFrame frame;
	private JTextField emailField;
	private JTextField passwordField;
	private JLabel lblErrorLabel ;
	DbConnection conn = new DbConnection();
	UserSignUp createUser = new UserSignUp();
	private JTextField usernameField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SingUp window = new SingUp();
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
	public SingUp() {
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
		
		JLabel lblNewLabel = new JLabel("Sing Up");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 33));
		frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[46px][226px,grow][]", "[20px][20px][23px][][][]"));
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		panel.add(lblNewLabel_1, "cell 0 0,alignx trailing");
		
		usernameField = new JTextField();
		panel.add(usernameField, "cell 1 0,growx");
		usernameField.setColumns(10);
		
		JLabel lblEmailLabel = new JLabel("Email");
		panel.add(lblEmailLabel, "cell 0 1,alignx left,aligny center");
		
		emailField = new JTextField();
		panel.add(emailField, "cell 1 1,growx,aligny top");
		emailField.setColumns(10);
		
		JLabel lblPasswordLabel = new JLabel("Password");
		panel.add(lblPasswordLabel, "cell 0 2,alignx left,aligny center");
		
		passwordField = new JTextField();
		panel.add(passwordField, "cell 1 2,growx,aligny top");
		passwordField.setColumns(10);
		
		JButton btnSingUpButton = new JButton("Sign Up");
		btnSingUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String email = emailField.getText();
				String password = passwordField.getText();
				
				if(!validate(email, password,username))
				{
					System.out.println("hrere");
					return;
				}
				conn.connect();
				
				User user = createUser.signup(conn.dbConnection, username, password, email);
				
				if( user == null) {
					setError("User not found");
				}
				
				conn.close();
				
			}
		});
		
		lblErrorLabel = new JLabel(" ");
		panel.add(lblErrorLabel, "cell 1 3");
		panel.add(btnSingUpButton, "cell 0 4 2 1,growx,aligny top");
		
		JButton btnLogInButton = new JButton("Already hava account? Click here");
		btnLogInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LoginPage.main(null);
			}
		});
		panel.add(btnLogInButton, "cell 0 5 2 1,growx");
	}
	
	protected boolean validate(String email, String password, String username) {
		resetError();
		if(username.isBlank()) {
			setError("Username must be entered");
			return false;
		}
		if(email.isBlank()) {
			setError("Email must be entered");
			return false;
		}
		if(patternMatches(email)) {
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
		String regexPattern = "^(.+)@(\\S+)$";
	    //return Pattern.compile(regexPattern)
	    //  .matcher(emailAddress)
	    //  .matches();
		
		return false;
	}
	
	private void resetError() {
		lblErrorLabel.setText("<html></html>");
	}

	private void setError(String string) {
		lblErrorLabel.setText("<html>Error: " + string + "</html>");
	}

}
