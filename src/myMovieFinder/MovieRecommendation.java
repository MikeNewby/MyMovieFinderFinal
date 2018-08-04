package myMovieFinder;

import javax.swing.JFrame;
import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MovieRecommendation {

	private JFrame frame;
	private JTable table;
	private Connection connection = null;
	private static Statement statement = null;
    private static ResultSet resultSet = null;
	private Context context;
	
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
		connection = Connect.getConnection();
		this.context = context;
		initialize();
		System.out.println("Current context.userId" + context.userId);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		
		try {
			if (connection == null) {
				System.out.println("connection is null!!!");
			}
			statement = connection.createStatement();
    			resultSet = statement.executeQuery(buildQueryString());
			table.setModel(DbUtils.resultSetToTableModel(resultSet));
		} catch(Exception e1) {
			//handle bad data
			JOptionPane.showMessageDialog(null, e1);
		}
	}
	
	protected String buildQueryString() {
		//build query string systematically using all possible input data. 
		String qry = "Select * from movies where movieID IN (select distinct movieID from user_ratedmovies where rating = 5 and movieID IN "
				+ "(select distinct movieID from movie_genres where genre IN "
				+ "(select genre from likedGenre where userID = " + context.userId +")))"
				+ " order by rtAudienceRating desc limit 10";
		System.out.println("Query: " + qry);
		return qry;
	}
}
