package myMovieFinder;

import java.awt.EventQueue;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSlider;

public class Add_Review {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Review window = new Add_Review();
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
	public Add_Review() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 618, 371);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAddReviewFor = new JLabel("Add Review for ");
		lblAddReviewFor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddReviewFor.setBounds(22, 22, 280, 36);
		frame.getContentPane().add(lblAddReviewFor);
		
		//show image from rotten tomatoes
		URL imgPath=null;   
		try {
			imgPath = new URL("http://content7.flixster.com/movie/10/93/63/10936393_det.jpg"); //remove example and pull actual path with SQL 
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon img = new ImageIcon(imgPath);
		JLabel lblMovieImage = new JLabel("");
		lblMovieImage.setIcon(img);
		lblMovieImage.setBounds(22, 56, 180, 256);
		frame.getContentPane().add(lblMovieImage);
		
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(225, 103, 339, 212);
		frame.getContentPane().add(textArea);
		
		JLabel lblRating = new JLabel("Rating (1-10)");
		lblRating.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRating.setBounds(225, 47, 104, 26);
		frame.getContentPane().add(lblRating);
		
		JSlider slider = new JSlider();
		slider.setBounds(339, 47, 200, 26);
		frame.getContentPane().add(slider);
		
		JLabel lblComments = new JLabel("Comments");
		lblComments.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblComments.setBounds(225, 81, 104, 17);
		frame.getContentPane().add(lblComments);
	}

}
