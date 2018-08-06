package myMovieFinder.ViewControllers;

import myMovieFinder.Context;
import myMovieFinder.Views.LogIn;
import myMovieFinder.Views.MainGUI;
import myMovieFinder.Views.CreateUser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUIController implements ActionListener {
    private MainGUI view;
    private Context context;

    public MainGUIController(Context context, MainGUI view) {
        this.view = view;
        this.context = context;
    }

    public void actionPerformed(ActionEvent e) {
        view.getFrame().dispose();

        if (e.getActionCommand() == "Log In") {
            LogIn.run(context);
        }

        if (e.getActionCommand() == "Create User") {
            CreateUser.run(context);
        }
    }
}
