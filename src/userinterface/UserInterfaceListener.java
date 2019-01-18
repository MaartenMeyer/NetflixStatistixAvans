package userinterface;

import connection.SqlConnection;
import repository.FilmRepository;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterfaceListener implements ActionListener {
    private SqlConnection sqlConnection;
    private UserInterface userInterface;

    private FilmRepository filmRepository;

    public UserInterfaceListener(SqlConnection sqlConnection, UserInterface userInterface){
        this.sqlConnection = sqlConnection;
        this.userInterface = userInterface;
        this.filmRepository = new FilmRepository(sqlConnection);
    }


    /*
     * Overview 1: all films
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command){
            case "overview1":
                    userInterface.setOverview(filmRepository.readAll());
                break;
            case "overview2":
                
                break;
            case "overview3":

                break;
            case "overview4":

                break;
            case "overview5":

                break;
            case "overview6":

                break;
        }

        userInterface.update();
    }
}
