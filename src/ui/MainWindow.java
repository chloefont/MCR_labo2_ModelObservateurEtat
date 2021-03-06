package ui;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.util.Arrays;

/**
 * Main Window of the application
 */
public class MainWindow extends JFrame {

    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 300;
    private static final int LIMIT_CHARS_AMOUNT = 20;

    // Clients in the system
    private final IClient[] clients;
    // Flights in the system
    private final IFlight[] flights;

    /** 
     * Creates a new MainWindow
     * @param clients Clients in the system
     * @param flights Flights in the system
     */
    public MainWindow(IClient[] clients, IFlight[] flights) {
        super();
        assert clients != null;
        assert flights != null;
        this.clients = Arrays.stream(clients).sorted().toArray(IClient[]::new);
        this.flights = flights;

        buildUI();
        pack();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Builds the UI of the window and filling it with components
     */
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

        // Client selection
        panel1.setSize(panel1.getWidth(), 10);
        panel1.add(new JLabel("Client"));
        final JComboBox<IClient> clientComboBox = new JComboBox<>(clients);
        panel1.add(clientComboBox);

        final JButton detailsButton = new JButton("Details");
        detailsButton.addActionListener(e -> {
            new ClientDetailsWindow((IClient) clientComboBox.getSelectedItem());
        } );
        panel1.add(detailsButton);

        // Deposits
        panel2.setSize(panel2.getWidth(), 10);
        panel2.add(new JLabel("Credits"));
        JTextField amountField = new JTextField(10);
        // Limit the characters in the text field
        amountField.setDocument(new PlainDocument() {
            public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
                if (str == null)
                    return;
                if ((getLength() + str.length()) <= LIMIT_CHARS_AMOUNT) {
                    super.insertString(offset, str, attr);
                }
            }
        });

        panel2.add(amountField);
        JButton addButton = new JButton("Add");

        addButton.addActionListener(e -> {
            IClient selectedClient = (IClient) clientComboBox.getSelectedItem();
            try {
                selectedClient.getAccountState().deposit(Double.parseDouble(amountField.getText()));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid amount");
            }

        });
        panel2.add(addButton);

        // Book flights
        panel3.setSize(panel3.getWidth(), 10);
        panel3.add(new JLabel("Flight"));
        final JComboBox<IFlight> flightComboBox = new JComboBox<>(flights);
        panel3.add(flightComboBox);

        IFlight selectedFlight = (IFlight) flightComboBox.getSelectedItem();
        JComboBox<ITicket> flightCatComboBox = new JComboBox<>(selectedFlight.getTickets());

        flightComboBox.addActionListener(e -> {
            flightCatComboBox.removeAllItems();
            for(ITicket t : ((IFlight) flightComboBox.getSelectedItem()).getTickets()) {
                flightCatComboBox.addItem(t);

            }

        });

        panel3.add(flightCatComboBox);

        JButton bookCashButton = new JButton("Book (Cash)");
        JButton bookMilesButton = new JButton("Book (Miles)");

        bookCashButton.addActionListener(e -> {
            ITicket selectedTicket = (ITicket) flightCatComboBox.getSelectedItem();
            IClient selectedClient = (IClient) clientComboBox.getSelectedItem();

            selectedClient.getAccountState().bookCash(selectedTicket);

        });

        bookMilesButton.addActionListener(e -> {
            ITicket selectedTicket = (ITicket) flightCatComboBox.getSelectedItem();
            IClient selectedClient = (IClient) clientComboBox.getSelectedItem();

            selectedClient.getAccountState().bookMiles(selectedTicket);
        });

        panel3.add(bookCashButton);
        panel3.add(bookMilesButton);

        // Show account states
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
