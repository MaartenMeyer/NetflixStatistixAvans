package repository;

import connection.SqlConnection;

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
                        rs.getTime("Tijdsduur"),
                        rs.getString("Genre")));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return filmList;
    }

}
