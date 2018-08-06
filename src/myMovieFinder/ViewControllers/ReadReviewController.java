package myMovieFinder.ViewControllers;

import myMovieFinder.Context;
import myMovieFinder.Views.ReadReview;

import java.net.MalformedURLException;
import java.net.URL;

public class ReadReviewController {
    private ReadReview view;
    private Context context;

    public ReadReviewController(Context context, ReadReview view) {
        this.context = context;
        this.view = view;

        URL imgPath = null;
        //show image from rotten tomatoes
        try {
            imgPath = new URL(context.movie.getImgUrl());
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        view.setMovieImageUrl(imgPath);
        view.setTitle("Review of " + context.movie.getTitle() + " by " + "");
    }
}
