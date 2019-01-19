package repository;

import connection.SqlConnection;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EpisodeRepository {
    private SqlConnection sqlConnection;

    public EpisodeRepository(SqlConnection sqlConnection){
        this.sqlConnection = sqlConnection;
    }

    /*
     *
     * Returns an ArrayList of Episode objects
     */
    public ArrayList<Episode> readAll() {
        ArrayList<Episode> episodeList = new ArrayList<>();
        try {
            ResultSet rs = sqlConnection.executeSql("SELECT * FROM Aflevering");
            while(rs.next()) {
                episodeList.add(new Episode(rs.getInt("AfleveringId"),
                        rs.getInt("ProgrammaId"),
                        rs.getString("Serie"),
                        rs.getString("Titel"),
                        rs.getInt("Tijdsduur")));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return episodeList;
    }

    public DefaultTableModel arrayListToModel(ArrayList<Episode> list){
        String[] columnNames = {"Episode Id", "Programme Id", "Serie", "Title", "Minutes"};


        DefaultTableModel model = new DefaultTableModel(null, columnNames);
        model.setColumnCount(5);

        Object data[] = new Object[5];
        for(int i = 0; i < list.size(); i++){
            Episode episode = list.get(i);
            data[0] = episode.getEpisodeId();
            data[1] = episode.getProgrammeId();
            data[2] = episode.getSerie();
            data[3] = episode.getTitle();
            data[4] = episode.getMinutes();
            model.addRow(data);
        }

        return model;

    }
}
