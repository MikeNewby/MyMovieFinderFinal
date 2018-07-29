package myMovieFinder;
import java.util.Random;
import java.util.Date;

public class Query {
    public static int createUser(String email, String password) {
        Random rand = new Random();
        int userId = rand.nextInt(999999999);

        String query = "INSERT INTO User (userId, email, password) VALUES ("
                + userId + ", "
                + "'" + email + "'" + ", "
                + "'" + password + "'"
                + ");";

        Connect.Connection();
        int rowCount = Connect.update(query);

        if (rowCount != 1) {
            System.err.println("Error occurred while creating user.");
            return -1;
        }

        return userId;
    }


    public static void rateMovie(int userId, String rtId, int rating) {
        Date date = new Date();

        String query = "INSERT INTO RatedBy (userId, rtID, date, rating) VALUES ("
                + userId + ", "
                + "'" + rtId + "'" + ", "
                + "'" + date.toString() + "'" + ", "
                + rating
                + ");";

        Connect.Connection();
        int rowCount = Connect.update(query);

        if (rowCount != 1) {
            System.err.println("Error occurred while creating rating.");
        }
    }

    public static String[] getSuggestedGenres() {
        String[] genres = new String[10];

        //TODO: temp data until queries are finalized
        genres[0] = "Drama";
        genres[1] = "Comedy";
        genres[2] = "Action/Adventure";
        genres[3] = "Romance";
        genres[4] = "Western";


        return genres;
    }

    public static void likeGenre(int userId, String genreName) {
        System.out.println(userId + " likes " + genreName);
    }

    public static Movie getSuggestedMovie(int userId) {
        //TODO: add query
        Movie movie = new Movie("1234");
        movie.setTitle("Toy Story");
        movie.setImgUrl("http://content7.flixster.com/movie/10/93/63/10936393_det.jpg");

        return movie;
    }
}
