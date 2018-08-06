package myMovieFinder.Views;

import javax.swing.JFrame;

import myMovieFinder.Context;
import myMovieFinder.ViewControllers.MovieRecommendationController;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.EventQueue;
import java.awt.Font;

public class MovieRecommendation {
	private JFrame frame;
	private JTable table;
	private MovieRecommendationController controller;

	public JTable getTable() {
		return table;
	}
	
	public static void run(Context context) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println("Run login!");
					MovieRecommendation window = new MovieRecommendation(context);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MovieRecommendation(Context context) {
		controller = new MovieRecommendationController(context, this);
		controller.getMovieRecommendations();

		// Main frame to put components.
		frame = new JFrame();
		frame.setBounds(100, 100, 908, 616);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// Movie recommendation label.
		JLabel lblReviewOfBy = new JLabel("Movie Recommendation");
		lblReviewOfBy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblReviewOfBy.setBounds(274, 11, 180, 32);
		frame.getContentPane().add(lblReviewOfBy);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(223, 39, 660, 528);
		frame.getContentPane().add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);

	}
}
