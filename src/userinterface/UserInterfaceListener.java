package userinterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterfaceListener implements ActionListener {
    private JButton button;

    public UserInterfaceListener(JButton button){
        this.button = button;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command){
            case "overview1":

                break;
            case "overview2":

                break;
            case "overview3":

                break;
            case "overview4":

                break;
            case "overview5":

                break;
            case "overview6":

                break;
        }
    }
}
