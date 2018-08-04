package myMovieFinder;

import javax.swing.event.ListSelectionListener;

import net.proteanit.sql.DbUtils;

import javax.swing.event.ListSelectionEvent;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddGenreController implements ActionListener, ListSelectionListener {
    private String[] genres;
    private AddGenre view;
    private Context context;
    private List<Integer> selected;
    private int count;
	private Connection connection = null;
	private static Statement statement = null;
    private static ResultSet resultSet = null;

    public AddGenreController(Context context, AddGenre view) {
        super();
        genres = Query.getSuggestedGenres();
        this.context = context;
        this.view = view;
        count = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // save selected user - genre relationship on select
        for (Integer selection: selected) {
        		Query.likeGenre(context.userId, genres[selection]);
        		String qry = "Insert Into likedGenre (userID, genre) values (" + 
                		context.userId + ", '" + genres[selection] + "')";
        		try {
            		Connect.update(qry);
    			} catch(Exception e1) {
        			//handle bad data
      			JOptionPane.showMessageDialog(null, e1);
        		}
            count++;
        }
        if (count > 2) {
            context.movie = Query.getSuggestedMovie(context.userId);
            AddReview.run(context);
            view.getFrame().dispose();;
        }
    }
    @Override
    public void valueChanged(ListSelectionEvent e) {
        ListSelectionModel lsm = (ListSelectionModel)e.getSource();
        List<Integer> selected = new ArrayList<>();

        if (!lsm.isSelectionEmpty()) {
            // Find out which indexes are selected.
            int minIndex = lsm.getMinSelectionIndex();
            int maxIndex = lsm.getMaxSelectionIndex();
            for (int i = minIndex; i <= maxIndex; i++) {
                if (lsm.isSelectedIndex(i)) {
                    selected.add(i);
                }
            }
        }

        this.selected = selected;
    }

    public String[] getGenres() {
        return genres;
    }
}
