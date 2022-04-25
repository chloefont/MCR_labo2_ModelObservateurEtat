package ui;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    IClient[] clients;
    IFlight[] flights;

    public MainWindow(IClient[] clients, IFlight[] flights) {
        super();
        assert clients != null;
        assert flights != null;
        this.clients = clients;
        this.flights = flights;

        buildUI();
        pack();
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void buildUI() {
        final JPanel gridPanel = new JPanel(new GridLayout(4,1));
        final JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5,5));
        final JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5,5));
        final JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5,5));
        final JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5,5));

        gridPanel.add(panel1);
        gridPanel.add(panel2);
        gridPanel.add(panel3);
        gridPanel.add(panel4);

        panel1.setSize(panel1.getWidth(), 10);
        panel1.add(new JLabel("Account.Client"));
        final JComboBox<IClient> clientComboBox = new JComboBox<>(clients);
        panel1.add(clientComboBox);

        final JButton detailsButton = new JButton("Details");
        detailsButton.addActionListener(e -> {
            new ClientDetailsWindow((IClient) clientComboBox.getSelectedItem());
        } );
        panel1.add(detailsButton);

        panel2.setSize(panel2.getWidth(), 10);
        panel2.add(new JLabel("Credits"));
        panel2.add(new JTextField(10));
        panel2.add(new JButton("Add"));

        panel3.setSize(panel3.getWidth(), 10);
        panel3.add(new JLabel("Flights.Flight"));
        final JComboBox<IFlight> flighttComboBox = new JComboBox<>(flights);
        panel3.add(flighttComboBox);

        IFlight selectedFlight = (IFlight) flighttComboBox.getSelectedItem();
        JComboBox<ITicket> flightCatComboBox = new JComboBox<>(selectedFlight.getTickets());

        flighttComboBox.addActionListener(e -> {
            flightCatComboBox.removeAllItems();
            for(ITicket t : ((IFlight) flighttComboBox.getSelectedItem()).getTickets()) {
                flightCatComboBox.addItem(t);

            }

        });
        // TODO: dynamic

        panel3.add(flightCatComboBox);
        panel3.add(new JButton("Book (Cash)"));
        panel3.add(new JButton("Book (Miles)"));

        final JButton statuses = new JButton("Statuses");
        statuses.addActionListener(e ->{
            new StatusesWindow(clients);
        });

        panel4.add(statuses);
        final JButton exit = new JButton("Quit");
        exit.addActionListener(e -> System.exit(0));
        panel4.add(exit);

        add(gridPanel);
    }
}
