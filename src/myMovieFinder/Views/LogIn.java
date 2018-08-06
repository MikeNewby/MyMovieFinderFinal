package myMovieFinder.Views;

import myMovieFinder.Connect;
import myMovieFinder.Context;
import myMovieFinder.ViewControllers.LoginController;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;

public class LogIn {
	private JFrame frame;
	private JLabel lblLogin;
	private JTextField txtUserName;
	private JPasswordField passwordField;
	private Context context;
	private LoginController controller;

	public JTextField getTxtUserName() {
		return txtUserName;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public JLabel getLblLogin() {
		return lblLogin;
	}

	public JFrame getFrame() {
		return frame;
	}

	public static void run(Context context) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn window = new LogIn(context);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LogIn(Context context) {
		this.context = context;
		context.setNumMoviesReviewed(5);
		this.controller = new LoginController(context, this);

		// Make sure Connect has a valid database connection.
		Connect.getConnection();

		frame = new JFrame();
		frame.setBounds(100, 100, 272, 236);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblLogin = new JLabel("My Movie Finder Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLogin.setBounds(25, 22, 186, 46);
		frame.getContentPane().add(lblLogin);
		
		txtUserName = new JTextField();
		txtUserName.setForeground(Color.BLACK);
		txtUserName.setBounds(104, 71, 107, 20);
		frame.getContentPane().add(txtUserName);
		txtUserName.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(104, 102, 107, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserName.setBounds(25, 69, 80, 20);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(25, 100, 69, 20);
		frame.getContentPane().add(lblPassword);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.addActionListener(controller);
		btnNewButton.setBounds(25, 131, 90, 41);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(controller);
		btnCancel.setBounds(121, 131, 90, 41);
		frame.getContentPane().add(btnCancel);
	}
}
