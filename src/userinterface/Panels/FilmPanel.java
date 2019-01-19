package userinterface.Panels;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FilmPanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;

    public FilmPanel(){
        setLayout(new BorderLayout());
        setBorder(new LineBorder(Color.black));

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

        add(topPanel, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.SOUTH);
    }
}
