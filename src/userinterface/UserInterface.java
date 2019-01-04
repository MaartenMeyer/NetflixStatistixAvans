package userinterface;

import javax.swing.*;
import java.awt.*;

public class UserInterface implements Runnable{
    private UserInterfaceHandler userInterfaceHandler = new UserInterfaceHandler();

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Netflix Statistix");
        frame.setPreferredSize(new Dimension(600, 500));
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
}
