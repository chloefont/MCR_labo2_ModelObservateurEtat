package ui;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class MainWindow extends JFrame {

    private final IClient[] clients;
    private final IFlight[] flights;

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
        panel1.add(new JLabel("Client"));
        final JComboBox<IClient> clientComboBox = new JComboBox<>(clients);
        panel1.add(clientComboBox);

        final JButton detailsButton = new JButton("Details");
        detailsButton.addActionListener(e -> {
            new ClientDetailsWindow((IClient) clientComboBox.getSelectedItem());
        } );
        panel1.add(detailsButton);

        panel2.setSize(panel2.getWidth(), 10);
        panel2.add(new JLabel("Credits"));
        JFormattedTextField amountField = new JFormattedTextField(10);
        amountField.setColumns(7);

        // source : https://stackoverflow.com/questions/33348481/restrict-input-of-jtextfield-to-double-numbers
        amountField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                Runnable format = new Runnable() {
                    @Override
                    public void run() {
                        String text = amountField.getText();
                        if(!text.matches("\\d*(\\.\\d{0,2})?")){
                            amountField.setText(text.substring(0,text.length()-1));
                        }
                    }
                };
                SwingUtilities.invokeLater(format);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {}
            @Override
            public void changedUpdate(DocumentEvent e) {}
        });

        panel2.add(amountField);
        JButton addButton = new JButton("Add");

        addButton.addActionListener(e -> {
            IClient selectedClient = (IClient) clientComboBox.getSelectedItem();
            selectedClient.getAccountState().deposit(Double.parseDouble(amountField.getText()));
        });
        panel2.add(addButton);

        panel3.setSize(panel3.getWidth(), 10);
        panel3.add(new JLabel("Flight"));
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

        panel3.add(flightCatComboBox);

        JButton bookCashButton = new JButton("Book (Cash)");
        JButton bookMilesButton = new JButton("Book (Miles)");

        bookCashButton.addActionListener(e -> {
            ITicket selectedTicket = (ITicket) flightCatComboBox.getSelectedItem();
            IClient selectedClient = (IClient) clientComboBox.getSelectedItem();

            if (!selectedClient.getAccountState().bookCash(selectedTicket))
                JOptionPane.showMessageDialog(null, "Not enough money");

        });

        bookMilesButton.addActionListener(e -> {
            ITicket selectedTicket = (ITicket) flightCatComboBox.getSelectedItem();
            IClient selectedClient = (IClient) clientComboBox.getSelectedItem();

            if (!selectedClient.getAccountState().bookMiles(selectedTicket))
                JOptionPane.showMessageDialog(null, "Not enough miles");
        });

        panel3.add(bookCashButton);
        panel3.add(bookMilesButton);

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
