package myMovieFinder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Main_GUI {

	private JFrame frame;
	private Context context;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Context context = new Context();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_GUI window = new Main_GUI(context);
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
	public Main_GUI(Context context) {
		this.context = context;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 415, 208);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Log_In login = new Log_In(context);
				frame.dispose();
				login.main(context);
			}
		});
		btnLogIn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogIn.setBounds(41, 87, 138, 47);
		frame.getContentPane().add(btnLogIn);
		
		JButton btnCreateUser = new JButton("Create User");
		btnCreateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Create_User createUser = new Create_User(context);
				frame.dispose();
				createUser.main(context);
			}
		});
		btnCreateUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCreateUser.setBounds(205, 87, 138, 47);
		frame.getContentPane().add(btnCreateUser);
		
		JLabel lblWelcomeToMy = new JLabel("Welcome to My Movie Finder");
		lblWelcomeToMy.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWelcomeToMy.setBounds(41, 25, 302, 66);
		frame.getContentPane().add(lblWelcomeToMy);
	}
}
