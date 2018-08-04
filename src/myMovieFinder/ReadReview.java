package myMovieFinder;

import java.awt.EventQueue;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Font;

public class ReadReview {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void run(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReadReview window = new ReadReview();
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
	public ReadReview() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 908, 616);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
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
		lblMovieImage.setBounds(29, 11, 180, 256);
		frame.getContentPane().add(lblMovieImage);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(274, 42, 426, 405);
		frame.getContentPane().add(textArea);
		
		JLabel lblReviewOfBy = new JLabel("Review of          by");
		lblReviewOfBy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblReviewOfBy.setBounds(274, 11, 180, 32);
		frame.getContentPane().add(lblReviewOfBy);
		
		table = new JTable();
		table.setBounds(29, 299, 208, 148);
		frame.getContentPane().add(table);
		
		JLabel lblSelectAReview = new JLabel("Select a Review");
		lblSelectAReview.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSelectAReview.setBounds(29, 272, 149, 32);
		frame.getContentPane().add(lblSelectAReview);
		
		JLabel lblRating = new JLabel("Rating: ");
		lblRating.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRating.setBounds(584, 11, 73, 32);
		frame.getContentPane().add(lblRating);
		
	}
}
