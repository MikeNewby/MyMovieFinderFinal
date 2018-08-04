package myMovieFinder;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddReviewController implements ActionListener, ChangeListener {
    private Context context;
    private AddReview view;
    private int rating;

    public AddReviewController(Context context, AddReview view) {
        super();
        this.context = context;
        this.view = view;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        rating = view.getSlider().getValue() / 25 + 1; // convert to 1 - 5 scale
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Rate") {
            Query.rateMovie(context.userId, context.movie.getRtId(), rating);
            context.numMoviesReviewed++;
        }

        view.getFrame().dispose();

        if (context.numMoviesReviewed > 4) {
            FindMovies findMovies = new FindMovies(context);
            findMovies.run(context);
            return;
        }

        context.movie = Query.getSuggestedMovie(context.userId);
        AddReview.run(context);
    }
}
