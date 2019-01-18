import connection.SqlConnection;
import repository.Film;
import repository.FilmRepository;
import userinterface.UserInterface;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //SwingUtilities.invokeLater(new UserInterface());
        SqlConnection connection = new SqlConnection();
        connection.connectDatabase("jdbc:sqlserver://ASUSTEK;databaseName=NetflixStatistix;integratedSecurity=true;");

        FilmRepository filmRepository = new FilmRepository(connection);

        ArrayList<Film> list = filmRepository.readAll();
        for(Film f : list){
            System.out.println(f.toString());
        }



    }
}
