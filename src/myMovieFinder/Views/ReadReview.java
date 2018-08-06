package myMovieFinder.Views;

import myMovieFinder.Context;
import myMovieFinder.ViewControllers.ReadReviewController;

import java.awt.EventQueue;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Font;

public class ReadReview {
	private Context context;
	private JFrame frame;
	private JTable table;
	private String title;
	private URL movieImageUrl;
	private ReadReviewController controller;

	public void setMovieImageUrl(URL movieImageUrl) {
		this.movieImageUrl = movieImageUrl;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Launch the application.
	 */
	public static void run(Context context) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReadReview window = new ReadReview(context);
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
	public ReadReview(Context context) {
		this.context = context;
		controller = new ReadReviewController(context, this);

		frame = new JFrame();
		frame.setBounds(100, 100, 908, 616);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		ImageIcon movieImage = new ImageIcon(movieImageUrl);
		JLabel movieImageLabel = new JLabel("");
		movieImageLabel.setIcon(movieImage);
		movieImageLabel.setBounds(29, 11, 180, 256);
		frame.getContentPane().add(movieImageLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(274, 42, 426, 405);
		frame.getContentPane().add(textArea);
		
		JLabel lblReviewOfBy = new JLabel(title);
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
