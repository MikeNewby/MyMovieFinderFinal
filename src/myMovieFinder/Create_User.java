package myMovieFinder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;

public class Create_User {

	private JFrame frame;
	private JTextField txtUserName;
	private JPasswordField passwordField;
	private JTextField txtUserEmail;

	/**
	 * Launch the application.
	 */
	public static void 	main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Create_User window = new Create_User();
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
	public Create_User() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 254, 271);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Create New User");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLogin.setBounds(25, 32, 186, 36);
		frame.getContentPane().add(lblLogin);
		
		txtUserName = new JTextField();
		txtUserName.setForeground(Color.LIGHT_GRAY);
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
		
		JButton btnCreateUser = new JButton("Create");
		btnCreateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uid;
				String pw;
				try {
					uid = txtUserName.getText();
					pw = passwordField.getText();
					
					
				}catch(Exception e1) {
					//handle bad data
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnCreateUser.setBounds(25, 164, 88, 41);
		frame.getContentPane().add(btnCreateUser);
		
		JLabel lblMyMovieFinder = new JLabel("My Movie Finder");
		lblMyMovieFinder.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMyMovieFinder.setBounds(25, 11, 186, 27);
		frame.getContentPane().add(lblMyMovieFinder);
		
		JLabel lblEmailAddress = new JLabel("Email:");
		lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmailAddress.setBounds(25, 133, 80, 20);
		frame.getContentPane().add(lblEmailAddress);
		
		txtUserEmail = new JTextField();
		txtUserEmail.setForeground(Color.LIGHT_GRAY);
		txtUserEmail.setColumns(10);
		txtUserEmail.setBounds(73, 135, 138, 20);
		frame.getContentPane().add(txtUserEmail);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Main_GUI.main(null);
			}
		});
		btnCancel.setBounds(123, 164, 88, 41);
		frame.getContentPane().add(btnCancel);
		
		
	}
}
