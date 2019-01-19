package userinterface;

import connection.SqlConnection;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class UserInterfaceHandler {
    private SqlConnection sqlConnection;
    private UserInterface userInterface;
    private JTextArea textArea;

    private JTable table;
    private DefaultTableModel model;

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
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new LineBorder(Color.black));

        JComboBox comboBox = new JComboBox();
        comboBox.setPreferredSize(new Dimension(200, 30));

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(new JLabel("Film name", SwingConstants.CENTER));
        topPanel.add(comboBox);

        table = new JTable();
        model = new DefaultTableModel();
        table.setModel(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(1200, 350));

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(scrollPane);


        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        return mainPanel;
    }

    private static JButton createMenuButton(String text) {
        JButton button = new JButton(text);
        button.setForeground(Color.BLACK);
        button.setBackground(Color.LIGHT_GRAY);
        button.setFont(new Font("TimesRoman", Font.PLAIN, 16));
        return button;
    }

    public JTable getTable(){
        return table;
    }

}

