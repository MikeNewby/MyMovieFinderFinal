package myMovieFinder;
import myMovieFinder.Models.Movie;
import myMovieFinder.Models.Review;

import javax.swing.*;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.Random;
import java.util.Date;
import java.util.List;

public class Query {
    public static int createUser(String email, String password) {
        Random rand = new Random();
        int userId = rand.nextInt(999999999);

        String query = "Insert into users (uid, email, password) values ("  
                + userId + ", "
                + "'" + email + "'" + ", "
                + "'" + password + "'"
                + ");";

        Connect.getConnection();
        int rowCount = Connect.update(query);

        if (rowCount != 1) {
            System.err.println("Error occurred while creating user.");
            return -1;
        }

        return userId;
    }


    public static void rateMovie(int userId, int movieId, int rating) {
        Date date = new Date();

        String query = "INSERT INTO RatedBy (userId, rtID, date, rating) VALUES ("
                + userId + ", "
                + movieId + ", "
                + "'" + date.toString() + "'" + ", "
                + rating
                + ");";

        Connect.getConnection();
        int rowCount = Connect.update(query);

        if (rowCount != 1) {
            System.err.println("Error occurred while creating rating.");
        }
    }

    public static String[] getSuggestedGenres() {
        String[] genres = new String[20];

        //TODO: temp data until queries are finalized
        genres[0] = "Adventure";
        genres[1] = "Animation";
        genres[2] = "Children";
        genres[3] = "Comedy";
        genres[4] = "Fantasy";
        genres[5] = "Romance";
        genres[6] = "Drama";        
        genres[7] = "Action";
        genres[8] = "Crime";
        genres[9] = "Thriller";    
        genres[10] = "Horror";
        genres[11] = "Mystery"; 
        genres[12] = "Sci-Fi";      
        genres[13] = "IMAX";
        genres[14] = "Documentary";
        genres[15] = "War";
        genres[16] = "Musical";
        genres[17] = "Film-Noir";
        genres[18] = "Western";
        genres[19] = "Short";

        return genres;
    }

    public static void likeGenre(int userId, String genreName) {
        System.out.println(userId + " likes " + genreName);

        String qry = "Insert Into likedGenre (userID, genre) values (" +
                userId + ", '" + genreName + "')";
        try {
            Connect.update(qry);
        } catch(Exception e1) {
            //handle bad data
            JOptionPane.showMessageDialog(null, e1);
        }
    }

    public static Movie getSuggestedMovie(int userId) {
        //TODO: add query
        Random rand = new Random();
        Movie movie = getMovieById(rand.nextInt(1000));

        return movie;
    }

    public static Movie getMovieById(int movieId) {
        String qry = "Select title, rtPictureURL from movies where movieId = " + movieId;
        Movie movie = new Movie(movieId);

        Connection connection = Connect.getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(qry);

            while (resultSet.next()) {
                movie.setTitle(resultSet.getObject(1).toString());
                String url = resultSet.getObject(2).toString();
                movie.setImgUrl(url);
            }
        } catch(Exception e1) {
            //handle bad data
            JOptionPane.showMessageDialog(null, e1);
        }

        return movie;
    }

    public static List<Review> getReviewsByMovieId(int movieId) {
        String qry = "Select title, rtPictureURL from movies where movieId = " + movieId;

        return null;
    }
}
