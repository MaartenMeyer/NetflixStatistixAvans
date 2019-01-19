package repository;

import connection.SqlConnection;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FilmRepository {
    private SqlConnection sqlConnection;

    public FilmRepository(SqlConnection sqlConnection){
        this.sqlConnection = sqlConnection;
    }

    /*
     *
     * Returns an ArrayList of Film objects
     */
    public ArrayList<Film> readAll() {
        ArrayList<Film> filmList = new ArrayList<>();
        try {
            ResultSet rs = sqlConnection.executeSql("SELECT * FROM Film");
            while(rs.next()) {
                filmList.add(new Film(rs.getInt("FilmId"),
                        rs.getInt("ProgrammaId"),
                        rs.getString("Titel"),
                        rs.getString("Taal"),
                        rs.getInt("LeeftijdsIndicatie"),
                        rs.getInt("Tijdsduur"),
                        rs.getString("Genre")));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return filmList;
    }

    /*
     * Geeft de film met de langste Tijdsduur van alle films met Leeftijdsindicatie < 16
     */
    public ArrayList<Film> longestFilmUnder16() {
        ArrayList<Film> filmList = new ArrayList<>();
        try {
            ResultSet rs = sqlConnection.executeSql("SELECT TOP 1 * FROM Film WHERE Leeftijdsindicatie < 16 ORDER BY Tijdsduur DESC;");
            while(rs.next()) {
                filmList.add(new Film(rs.getInt("FilmId"),
                        rs.getInt("ProgrammaId"),
                        rs.getString("Titel"),
                        rs.getString("Taal"),
                        rs.getInt("LeeftijdsIndicatie"),
                        rs.getInt("Tijdsduur"),
                        rs.getString("Genre")));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return filmList;
    }

    /*
     * Geeft de film met de langste Tijdsduur van alle films met Leeftijdsindicatie < 16
     */
    public ArrayList<Film> filmsWatchedBySelectedSubscription(String subscriptionId) {
        ArrayList<Film> filmList = new ArrayList<>();
        try {
            ResultSet rs = sqlConnection.executeSql("SELECT DISTINCT Film.*\n" +
                    "FROM Film\n" +
                    "INNER JOIN BekekenProgramma\n" +
                    "ON BekekenProgramma.ProgrammaId = Film.ProgrammaId\n" +
                    "INNER JOIN Abonnement\n" +
                    "ON Abonnement.AbonnementId = BekekenProgramma.AbonnementId\n" +
                    "INNER JOIN Profiel\n" +
                    "ON Profiel.AbonnementId = Abonnement.AbonnementId\n" +
                    "WHERE Abonnement.AbonnementId = '"+subscriptionId+"'");
            while(rs.next()) {
                filmList.add(new Film(rs.getInt("FilmId"),
                        rs.getInt("ProgrammaId"),
                        rs.getString("Titel"),
                        rs.getString("Taal"),
                        rs.getInt("LeeftijdsIndicatie"),
                        rs.getInt("Tijdsduur"),
                        rs.getString("Genre")));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return filmList;
    }

    public DefaultTableModel arrayListToModel(ArrayList<Film> list){
        String[] columnNames = {"Film Id", "Programme Id", "Title", "Language", "Age Indication", "Minutes", "Genre"};


        DefaultTableModel model = new DefaultTableModel(null, columnNames);
        model.setColumnCount(7);

        Object data[] = new Object[7];
        for(int i = 0; i < list.size(); i++){
            Film film = list.get(i);
            data[0] = film.getFilmId();
            data[1] = film.getProgrammeId();
            data[2] = film.getTitle();
            data[3] = film.getLanguage();
            data[4] = film.getAgeIndication();
            data[5] = film.getMinutes();
            data[6] = film.getGenre();
            model.addRow(data);
        }

        return model;
    }

    public DefaultTableModel arrayListToModel2(ArrayList<Film> list){
        String[] columnNames = {"Film Id", "Number of users seen for 100%"};


        DefaultTableModel model = new DefaultTableModel(null, columnNames);
        model.setColumnCount(2);

        Object data[] = new Object[2];
        for(int i = 0; i < list.size(); i++){
            Film film = list.get(i);
            data[0] = film.getFilmId();
            data[1] = film.getProgrammeId();
            model.addRow(data);
        }

        return model;
    }


}
