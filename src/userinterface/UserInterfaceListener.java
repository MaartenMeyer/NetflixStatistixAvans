package userinterface;

import connection.SqlConnection;
import repository.EpisodeRepository;
import repository.FilmRepository;
import repository.SubscriptionRepository;
import repository.ViewedProgrammeRepository;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterfaceListener implements ActionListener {
    private SqlConnection sqlConnection;
    private UserInterface userInterface;

    private FilmRepository filmRepository;
    private EpisodeRepository episodeRepository;
    private SubscriptionRepository subscriptionRepository;
    private ViewedProgrammeRepository viewedProgrammeRepository;

    public UserInterfaceListener(SqlConnection sqlConnection, UserInterface userInterface){
        this.sqlConnection = sqlConnection;
        this.userInterface = userInterface;
        this.filmRepository = new FilmRepository(sqlConnection);
        this.episodeRepository = new EpisodeRepository(sqlConnection);
        this.subscriptionRepository = new SubscriptionRepository(sqlConnection);
        this.viewedProgrammeRepository = new ViewedProgrammeRepository(sqlConnection);
    }


    /*
     * Overview 4: Geeft de film met de langste Tijdsduur van alle films met Leeftijdsindicatie < 16
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command){
            case "overview1":


                break;
            case "overview2":

                break;
            case "overview3":
                    userInterface.setModel(filmRepository.arrayListToModel(filmRepository.filmsWatchedBySelectedSubscription("1")));
                break;
            case "overview4":
                    userInterface.setModel(filmRepository.arrayListToModel(filmRepository.longestFilmUnder16()));
                break;
            case "overview5":
                    userInterface.setModel(subscriptionRepository.arrayListToModel(subscriptionRepository.subscriptionsWithOnly1Profile()));

                break;
            case "overview6":
                    userInterface.setModel(viewedProgrammeRepository.arrayListToModel(viewedProgrammeRepository.numberOfUsersSeenFor100Percent()));
                break;
        }

        userInterface.update();
    }
}
