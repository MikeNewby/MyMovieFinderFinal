package myMovieFinder.Views;

import myMovieFinder.Context;
import myMovieFinder.ViewControllers.AddGenreController;

import javax.swing.*;
import java.awt.*;

public class AddGenre {
    public JFrame getFrame() {
        return frame;
    }

    private JFrame frame;

    public static void runAddGenre(Context context) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddGenre window = new AddGenre(context);
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public AddGenre(Context context) {
        AddGenreController controller = new AddGenreController(context, this);

        int width = 600;
        int height = 600;

        frame = new JFrame();
        frame.setBounds(100, 100, width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel genreLabel = new JLabel("Pick 3 Genres");
        genreLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        genreLabel.setBounds((width - 107) / 2, height / 12, 107, height / 6);
        frame.getContentPane().add(genreLabel);

        JList<String> genreList = new JList(controller.getGenres());
        genreList.setBounds( (width - 200) / 2, height / 4, 200, height / 2);
        ListSelectionModel listSelectionModel = genreList.getSelectionModel();
        listSelectionModel.addListSelectionListener(controller);
        frame.getContentPane().add(genreList);
        java.util.List<String> selected_values = genreList.getSelectedValuesList();    

        JButton addReviewButton = new JButton("Select");
        addReviewButton.addActionListener(controller);
        addReviewButton.setBounds((width - 200) / 2, height - 100, 200, 50);
        frame.getContentPane().add(addReviewButton);
    }
}
