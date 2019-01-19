package repository;

import connection.SqlConnection;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ViewedProgrammeRepository {
    private SqlConnection sqlConnection;

    public ViewedProgrammeRepository(connection.SqlConnection sqlConnection){
        this.sqlConnection = sqlConnection;
    }
    public ArrayList<ViewedProgramme> numberOfUsersSeenFor100Percent() {
        ArrayList<ViewedProgramme> viewedProgrammeList = new ArrayList<>();
        try {
            ResultSet rs = sqlConnection.executeSql("SELECT Film.Titel, COUNT(BekekenProgramma.Percentage) AS AantalGebruikers\n" +
                    "FROM Film\n" +
                    "INNER JOIN Programma\n" +
                    "ON Programma.ProgrammaId = Film.ProgrammaId\n" +
                    "INNER JOIN BekekenProgramma\n" +
                    "ON BekekenProgramma.ProgrammaId = Film.ProgrammaId\n" +
                    "WHERE Programma.Titel = 'Der Untergang'\n" +
                    "GROUP BY Film.Titel, BekekenProgramma.Percentage, Programma.Titel\n" +
                    "HAVING BekekenProgramma.Percentage = 100");
            while(rs.next()) {
                viewedProgrammeList.add(new ViewedProgramme(rs.getString("Titel"),
                        rs.getInt("AantalGebruikers")));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return viewedProgrammeList;
    }

    public DefaultTableModel arrayListToModel(ArrayList<ViewedProgramme> list){
        String[] columnNames = {"Film Id", "Number of users seen for 100%"};


        DefaultTableModel model = new DefaultTableModel(null, columnNames);
        model.setColumnCount(2);

        Object data[] = new Object[2];
        for(int i = 0; i < list.size(); i++){
            ViewedProgramme v = list.get(i);
            data[0] = v.getFilmId();
            data[1] = v.getNumberofUsersseen();
            model.addRow(data);
        }

        return model;
    }

}
