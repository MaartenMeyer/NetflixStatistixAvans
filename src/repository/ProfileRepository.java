package repository;

import connection.SqlConnection;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ProfileRepository {
    private SqlConnection sqlConnection;

    public ProfileRepository(SqlConnection sqlConnection){
        this.sqlConnection = sqlConnection;
    }

    public ArrayList<Profile> readAll() {
        ArrayList<Profile> profileList = new ArrayList<>();
        try {
            ResultSet rs = sqlConnection.executeSql("SELECT * FROM Film");
            while(rs.next()) {
                profileList.add(new Profile(rs.getInt("AbonnementId"),
                        rs.getString("Profielnaam"),
                        rs.getDate("Geboortedatum")));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return profileList;
    }
}
