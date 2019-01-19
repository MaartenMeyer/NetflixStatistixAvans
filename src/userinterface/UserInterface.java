package userinterface;

import connection.SqlConnection;
import repository.Film;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class UserInterface implements Runnable{
    private UserInterfaceHandler userInterfaceHandler;
    private SqlConnection sqlConnection;

    private JFrame frame;

    public UserInterface(SqlConnection sqlConnection){
        this.sqlConnection = sqlConnection;
        userInterfaceHandler = new UserInterfaceHandler(sqlConnection, this);
    }

    @Override
    public void run() {
        frame = new JFrame("Netflix Statistix");
        frame.setPreferredSize(new Dimension(1400, 500));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container){
        container.setLayout(new BorderLayout());

        container.add(userInterfaceHandler.createInformationPanel(), BorderLayout.SOUTH);
        container.add(userInterfaceHandler.createMenuPanel(), BorderLayout.WEST);
        container.add(userInterfaceHandler.createMainPanel(), BorderLayout.CENTER);
    }

    public void setModel(DefaultTableModel m){
        DefaultTableModel model = (DefaultTableModel) userInterfaceHandler.getTable().getModel();
        model.setRowCount(0);

        userInterfaceHandler.getTable().setModel(m);
    }

    public void setComboBoxModel(DefaultComboBoxModel m){
        DefaultComboBoxModel model = (DefaultComboBoxModel) userInterfaceHandler.getComboBox().getModel();
        model.removeAllElements();

        userInterfaceHandler.getComboBox().setModel(m);
    }

    public void update(){
        frame.repaint();
    }
}
