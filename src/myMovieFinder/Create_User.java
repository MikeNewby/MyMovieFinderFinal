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
	private JTextField emailTextField;
	private JPasswordField passwordTextField;
	private Context context;

	/**
	 * Launch the application.
	 */
	public static void 	main(Context context) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Create_User window = new Create_User(context);
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
	public Create_User(Context context) {
		this.context = context;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 250, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel title = new JLabel("My Movie Finder");
		title.setFont(new Font("Tahoma", Font.BOLD, 16));
		title.setBounds(25, 11, 186, 27);
		frame.getContentPane().add(title);

		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		emailLabel.setBounds(25, 69, 80, 20);
		frame.getContentPane().add(emailLabel);

		emailTextField = new JTextField();
		emailTextField.setForeground(Color.LIGHT_GRAY);
		emailTextField.setBounds(104, 71, 107, 20);
		frame.getContentPane().add(emailTextField);
		emailTextField.setColumns(10);

		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordLabel.setBounds(25, 100, 69, 20);
		frame.getContentPane().add(passwordLabel);

		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(104, 102, 107, 20);
		frame.getContentPane().add(passwordTextField);

		JButton createButton = new JButton("Create");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int userId = Query.createUser(emailTextField.getText(), passwordTextField.getText());
					context.userId = userId;
					AddGenre.runAddGenre(context);

					//Add_Review.main(context);
					frame.dispose();
					
				}catch(Exception e1) {
					//handle bad data
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});

		createButton.setBounds(25, 164, 88, 41);
		frame.getContentPane().add(createButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Main_GUI.main(null);
			}
		});

		cancelButton.setBounds(123, 164, 88, 41);
		frame.getContentPane().add(cancelButton);
	}
}
