package ui;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public MainWindow(){
        super();
        build();
    }

    private void build() {
        JPanel gridPanel = new JPanel(new GridLayout(4,1));
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5,5));
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5,5));
        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5,5));
        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5,5));

        gridPanel.add(panel1);
        gridPanel.add(panel2);
        gridPanel.add(panel3);
        gridPanel.add(panel4);

        panel1.setSize(panel1.getWidth(), 10);
        panel1.add(new JLabel("Client"));
        panel1.add(createComboBox());
        panel1.add(new JButton("Details"));

        panel2.setSize(panel2.getWidth(), 10);
        panel2.add(new JLabel("Credits"));
        panel2.add(new JTextField(10));
        panel2.add(new JButton("Add"));

        panel3.setSize(panel3.getWidth(), 10);
        panel3.add(new JLabel("Flight"));
        panel3.add(createComboBox());
        panel3.add(createComboBox());
        panel3.add(new JButton("Book (Cash)"));
        panel3.add(new JButton("Book (Miles)"));

        panel4.add(new JButton("Statuses"));
        panel4.add(new JButton("Quit"));

        add(gridPanel);
        pack();
        setSize(350, 250);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static JComboBox<?> createComboBox(){
        final JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("Test1");
        comboBox.addItem("Test2");
        comboBox.addItem("Test3");
        comboBox.addItem("Test4");
        comboBox.addItem("Test5");
        comboBox.setSize(100,50);

        return comboBox;
    }
}
