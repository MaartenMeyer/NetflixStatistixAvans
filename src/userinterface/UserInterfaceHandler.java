package userinterface;

import javax.swing.*;
import java.awt.*;

public class UserInterfaceHandler {

    public UserInterfaceHandler(){

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

        JButton item1 = createMenuButton("Overzicht 1");
        JButton item2 = createMenuButton("Overzicht 2");
        JButton item3 = createMenuButton("Overzicht 3");
        JButton item4 = createMenuButton("Overzicht 4");
        JButton item5 = createMenuButton("Overzicht 5");
        JButton item6 = createMenuButton("Overzicht 6");

        menuPanel.add(item1);
        menuPanel.add(item2);
        menuPanel.add(item3);
        menuPanel.add(item4);
        menuPanel.add(item5);
        menuPanel.add(item6);

        return menuPanel;
    }

    public JPanel createMainPanel(){
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        mainPanel.setPreferredSize(new Dimension(500, 700));

        return mainPanel;
    }

    private static JButton createMenuButton(String text) {
        JButton button = new JButton(text);
        button.setForeground(Color.BLACK);
        button.setBackground(Color.LIGHT_GRAY);
        button.setFont(new Font("TimesRoman", Font.PLAIN, 16));
        return button;
    }

}

