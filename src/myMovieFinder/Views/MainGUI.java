package myMovieFinder.Views;

import myMovieFinder.Context;
import myMovieFinder.ViewControllers.MainGUIController;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;

public class MainGUI {
	private JFrame frame;
	private Context context;
	private MainGUIController controller;

	public JFrame getFrame() {
		return frame;
	}

	/**
	 * This is the main entrance of the program (application). One program
	 * only has one entrance, and here is the entrance.
	 */
	public static void main(String[] args) {
		Context context = new Context();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI(context);
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
	public MainGUI(Context context) {
		this.context = context;
		this.controller = new MainGUIController(context, this);

		frame = new JFrame();
		frame.setBounds(100, 100, 415, 208);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(controller);
		btnLogIn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogIn.setBounds(41, 87, 138, 47);
		frame.getContentPane().add(btnLogIn);
		
		JButton btnCreateUser = new JButton("Create User");
		btnCreateUser.addActionListener(controller);
		btnCreateUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCreateUser.setBounds(205, 87, 138, 47);
		frame.getContentPane().add(btnCreateUser);
		
		JLabel lblWelcomeToMy = new JLabel("Welcome to My Movie Finder");
		lblWelcomeToMy.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWelcomeToMy.setBounds(41, 25, 302, 66);
		frame.getContentPane().add(lblWelcomeToMy);
	}
}
