package myMovieFinder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Find_Movies {

	private JFrame frame;
	private JTable table;
	private JTextField textTitle;
	private JTextField textDirector;
	private JTextField textField_2;
	private JTextField genre;
	private JTextField actor;
	
	private Connection connection = null;
	private static Statement statement = null;
    private static ResultSet resultSet = null;
    private static int userId; //id of the logged in user. 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		String uid = args[0];
		userId = Integer.parseInt(uid);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Find_Movies window = new Find_Movies();
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
	public Find_Movies() {
		initialize();
		//init database
		connection = Connect.Connection();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 958, 613);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Review Panel
		JPanel reviewPanel = new JPanel();
		reviewPanel.setBounds(10, 397, 192, 150);
		reviewPanel.setLayout(null);
//frame.getContentPane().add(reviewPanel);  //hide initially. uncomment for testing. TODO	
		
		JLabel lblMovieName = new JLabel("");
		lblMovieName.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovieName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMovieName.setBounds(0, 26, 192, 25);
		reviewPanel.add(lblMovieName);
		
		JLabel lblReview = new JLabel("Review this movie!");
		lblReview.setHorizontalAlignment(SwingConstants.CENTER);
		lblReview.setBounds(0, 0, 192, 25);
		lblReview.setFont(new Font("Tahoma", Font.PLAIN, 16));
		reviewPanel.add(lblReview);
		
		JButton btnNewReview = new JButton("New Review");
		btnNewReview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_Review.main(null);
			}
		});
		btnNewReview.setBounds(31, 60, 127, 40);
		reviewPanel.add(btnNewReview);
		
		JButton btnReadReviews = new JButton("Read Reviews");
		btnReadReviews.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Read_Review.main(null);
			}
		});
		btnReadReviews.setBounds(31, 104, 127, 40);
		reviewPanel.add(btnReadReviews);
		
		//main 
		JLabel lblFindMovies = new JLabel("Find Movies!");
		lblFindMovies.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFindMovies.setBounds(20, 8, 182, 31);
		frame.getContentPane().add(lblFindMovies);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(223, 19, 660, 528);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.getContentPane().add(reviewPanel);
				frame.repaint();
				frame.revalidate();
				//reviewPanel.add(lblReview);
				int rowIndex = table.getSelectedRow();
				int movieId = (int) table.getValueAt(rowIndex, 0);
				String movieName = (String) table.getValueAt(rowIndex, 1);
				movieName = movieId + " - " + movieName;
				lblMovieName.setText(movieName);
				      
				};
		});
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnExit.setBounds(119, 349, 89, 23);
		frame.getContentPane().add(btnExit);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTitle.setBounds(20, 53, 57, 20);
		frame.getContentPane().add(lblTitle);
		
		textTitle = new JTextField();
		textTitle.setBounds(74, 53, 98, 20);
		frame.getContentPane().add(textTitle);
		textTitle.setColumns(10);
		
		textDirector = new JTextField();
		textDirector.setColumns(10);
		textDirector.setBounds(74, 84, 98, 20);
		frame.getContentPane().add(textDirector);
		
		JLabel lblDirector = new JLabel("Director");
		lblDirector.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDirector.setBounds(10, 82, 57, 20);
		frame.getContentPane().add(lblDirector);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(74, 115, 98, 20);
		frame.getContentPane().add(textField_2);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblYear.setBounds(20, 115, 57, 20);
		frame.getContentPane().add(lblYear);
		
		genre = new JTextField();
		genre.setColumns(10);
		genre.setBounds(74, 146, 98, 20);
		frame.getContentPane().add(genre);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGenre.setBounds(20, 146, 57, 20);
		frame.getContentPane().add(lblGenre);
		
		actor = new JTextField();
		actor.setColumns(10);
		actor.setBounds(74, 177, 98, 20);
		frame.getContentPane().add(actor);
		
		JLabel lblActor = new JLabel("Actor");
		lblActor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblActor.setBounds(20, 177, 57, 20);
		frame.getContentPane().add(lblActor);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String qry = buildQueryString();
				
				try {
					statement = connection.createStatement();
		    		resultSet = statement.executeQuery(qry);
					table.setModel(DbUtils.resultSetToTableModel(resultSet));
					
				}catch(Exception e1) {
					//handle bad data
					JOptionPane.showMessageDialog(null, e1);
				}
				
				Connect.runQuery(qry);
			}
		});
		btnSearch.setBounds(20, 349, 89, 23);
		frame.getContentPane().add(btnSearch);
		
		JLabel lblAverageRating = new JLabel("Average Rating:");
		lblAverageRating.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAverageRating.setBounds(20, 208, 115, 23);
		frame.getContentPane().add(lblAverageRating);
		
		JLabel lblAllCritics = new JLabel("All Critics");
		lblAllCritics.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAllCritics.setBounds(20, 236, 57, 26);
		frame.getContentPane().add(lblAllCritics);
		
		JLabel lblTopCritics = new JLabel("Top Critics");
		lblTopCritics.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTopCritics.setBounds(10, 270, 57, 23);
		frame.getContentPane().add(lblTopCritics);
		
		JLabel lblAudience = new JLabel("Audience");
		lblAudience.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAudience.setBounds(10, 304, 57, 20);
		frame.getContentPane().add(lblAudience);
		
		JSlider slider = new JSlider();
		slider.setMaximum(10);
		slider.setBounds(74, 236, 98, 26);
		frame.getContentPane().add(slider);
		
		JSlider slider_1 = new JSlider();
		slider_1.setMaximum(10);
		slider_1.setBounds(74, 267, 98, 26);
		frame.getContentPane().add(slider_1);
		
		JSlider slider_2 = new JSlider();
		slider_2.setMaximum(10);
		slider_2.setBounds(74, 301, 98, 26);
		frame.getContentPane().add(slider_2);
		
		JPanel THISONE = new JPanel();
		THISONE.setBounds(147, 8, 45, 31);
		
		

		

		
	}

	protected String buildQueryString() {
		//build query string systematically using all possible input data. 
		String qry = "";
		
		// getText();
		//pw = passwordField.getText();
		//TODO Update Query for user ID
		
		qry = "SELECT id,title,year,rtAllCriticsRating,rtTopCriticsRating,rtAudienceRating from movies";
		
		return qry;
	}
}
