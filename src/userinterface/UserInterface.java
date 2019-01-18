package userinterface;

import connection.SqlConnection;
import repository.Film;

import javax.swing.*;
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
        frame.setMinimumSize(new Dimension(500, 400));
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

    public void setOverview(ArrayList<Film> list){
        JTextArea textArea = userInterfaceHandler.getTextArea();
        textArea.setText("");
        for(Film film : list){
            textArea.append(film.toString() + "\n");
        }

    }

    public void update(){
        frame.repaint();
    }
}
