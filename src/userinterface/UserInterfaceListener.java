package userinterface;

import connection.SqlConnection;
import repository.EpisodeRepository;
import repository.FilmRepository;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterfaceListener implements ActionListener {
    private SqlConnection sqlConnection;
    private UserInterface userInterface;

    private FilmRepository filmRepository;
    private EpisodeRepository episodeRepository;

    public UserInterfaceListener(SqlConnection sqlConnection, UserInterface userInterface){
        this.sqlConnection = sqlConnection;
        this.userInterface = userInterface;
        this.filmRepository = new FilmRepository(sqlConnection);
        this.episodeRepository = new EpisodeRepository(sqlConnection);
    }


    /*
     * Overview 4: Geeft de film met de langste Tijdsduur van alle films met Leeftijdsindicatie < 16
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command){
            case "overview1":
                    userInterface.setModel(filmRepository.arrayListToModel(filmRepository.readAll()));
                break;
            case "overview2":
                userInterface.setModel(episodeRepository.arrayListToModel(episodeRepository.readAll()));
                break;
            case "overview3":

                break;
            case "overview4":
                    userInterface.setModel(filmRepository.arrayListToModel(filmRepository.longestFilmUnder16()));
                break;
            case "overview5":

                break;
            case "overview6":

                break;
        }

        userInterface.update();
    }
}
