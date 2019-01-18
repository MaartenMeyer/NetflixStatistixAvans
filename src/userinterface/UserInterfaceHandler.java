package userinterface;

import connection.SqlConnection;

import javax.swing.*;
import java.awt.*;

public class UserInterfaceHandler {
    private SqlConnection sqlConnection;
    private UserInterface userInterface;
    private JTextArea textArea;

    public UserInterfaceHandler(SqlConnection sqlConnection, UserInterface userInterface){
        this.sqlConnection = sqlConnection;
        this.userInterface = userInterface;

    }

    public JPanel createInformationPanel(){
        JPanel informationPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 30, 3));
        informationPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel title = new JLabel("Netflix Statistix");
        JLabel information = new JLabel("Informatica 23IVT1B - Naam Naam Naam");
        title.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        information.setFont(new Font("TimesRoman", Font.PLAIN, 15));
        informationPanel.add(title);
        informationPanel.add(information);

        return informationPanel;
    }

    public JPanel createMenuPanel(){
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        menuPanel.setPreferredSize(new Dimension(113, 700));

        for(int i = 1; i <= 6; i++){
            JButton button = createMenuButton("Overzicht " +String.valueOf(i));
            button.setActionCommand("overview" +String.valueOf(i));
            button.addActionListener(new UserInterfaceListener(sqlConnection, userInterface));
            menuPanel.add(button);
        }

        return menuPanel;
    }

    public JPanel createMainPanel(){
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        mainPanel.setPreferredSize(new Dimension(500, 700));

        textArea = new JTextArea();
        textArea.setFont(new Font("TimesRoman", Font.PLAIN, 18));
        textArea.setBackground(Color.decode("#EEEEEE"));

        mainPanel.add(textArea);

        return mainPanel;
    }

    private static JButton createMenuButton(String text) {
        JButton button = new JButton(text);
        button.setForeground(Color.BLACK);
        button.setBackground(Color.LIGHT_GRAY);
        button.setFont(new Font("TimesRoman", Font.PLAIN, 16));
        return button;
    }

    public JTextArea getTextArea(){
        return textArea;
    }

}

