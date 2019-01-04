package userinterface;

import javax.swing.*;
import java.awt.*;

public class UserInterfaceHandler {

    public UserInterfaceHandler(){

    }

    public JPanel createInformationPanel(){
        JPanel informationPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 150, 3));
        informationPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel title = new JLabel("Netflix Statistix");
        JLabel information = new JLabel("Informatica 23IVT1B - Naam Naam Naam");
        title.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        information.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        informationPanel.add(title);
        informationPanel.add(information);

        return informationPanel;
    }
}

