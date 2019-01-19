package repository;

import connection.SqlConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SubscriptionRepository {
    private SqlConnection sqlConnection;

    public SubscriptionRepository(SqlConnection sqlConnection){
        this.sqlConnection = sqlConnection;
    }

    public ArrayList<Subscription> readAll() {
        ArrayList<Subscription> subscriptionList = new ArrayList<>();
        try {
            ResultSet rs = sqlConnection.executeSql("SELECT * FROM Abonnement");
            while(rs.next()) {
                subscriptionList.add(new Subscription(rs.getInt("AbonnementId"),
                        rs.getString("Naam"),
                        rs.getString("Straat"),
                        rs.getString("Huisnummer"),
                        rs.getString("Woonplaats")));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return subscriptionList;
    }

    public ArrayList<Subscription> subscriptionsWithOnly1Profile() {
        ArrayList<Subscription> subscriptionList = new ArrayList<>();
        try {
            ResultSet rs = sqlConnection.executeSql("SELECT * FROM Abonnement\n" +
                    "WHERE EXISTS \n" +
                    "\t(SELECT AbonnementId FROM profiel\n" +
                    "\tWHERE Profiel.AbonnementId = Abonnement.AbonnementId\n" +
                    "\tGROUP BY Profiel.AbonnementId\n" +
                    "\tHAVING COUNT(Profiel.Profielnaam) = 1)");
            while(rs.next()) {
                subscriptionList.add(new Subscription(rs.getInt("AbonnementId"),
                        rs.getString("Naam"),
                        rs.getString("Straat"),
                        rs.getString("Huisnummer"),
                        rs.getString("Woonplaats")));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return subscriptionList;
    }

    public DefaultTableModel arrayListToModel(ArrayList<Subscription> list){
        String[] columnNames = {"Subscription Id", "Name", "Street", "Number", "City"};


        DefaultTableModel model = new DefaultTableModel(null, columnNames);
        model.setColumnCount(5);

        Object data[] = new Object[5];
        for(int i = 0; i < list.size(); i++){
            Subscription s = list.get(i);
            data[0] = s.getSubscriptionId();
            data[1] = s.getName();
            data[2] = s.getStreet();
            data[3] = s.getNumber();
            data[4] = s.getCity();
            model.addRow(data);
        }

        return model;

    }

    public DefaultComboBoxModel arrayListToComboBoxModel(ArrayList<Subscription> list){
        DefaultComboBoxModel model = new DefaultComboBoxModel();

        for(int i = 0; i < list.size(); i++){
            model.addElement(list.get(i).getSubscriptionId());
        }

        return model;
    }
}
