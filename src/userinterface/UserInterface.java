package userinterface;

import javax.swing.*;
import java.awt.*;

public class UserInterface implements Runnable{
    private UserInterfaceHandler userInterfaceHandler = new UserInterfaceHandler();

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Netflix Statistix");
        frame.setPreferredSize(new Dimension(1000, 800));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container){
        container.setLayout(new BorderLayout());

        container.add(userInterfaceHandler.createInformationPanel(), BorderLayout.SOUTH);
    }
}
