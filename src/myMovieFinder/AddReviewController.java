package myMovieFinder;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddReviewController implements ActionListener, ChangeListener {
    private Context context;
    private Add_Review view;
    private int rating;

    public AddReviewController(Context context, Add_Review view) {
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
            Find_Movies.main(context);
            return;
        }

        context.movie = Query.getSuggestedMovie(context.userId);
        Add_Review.main(context);
    }
}
