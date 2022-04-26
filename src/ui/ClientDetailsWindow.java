package ui;

import observables.Observable;
import observables.Observer;

import javax.swing.*;
import java.awt.*;

/**
 * Window that displays the details of a client.
 * @author Luca Coduri
 * @author Chloé Fontaine
 * @version 1.0
 */
public class ClientDetailsWindow extends InformationWindow implements Observer {
    // Client to display
    private final IClient client;

    /**
     * Creates a new ClientDetailsWindow.
     * @param client the client to display
     */
    ClientDetailsWindow(Frame owner, IClient client) {
        super(owner);

        if (client == null)
            throw new IllegalArgumentException("Client must not be null");

        setWindowTitle("Details of client #" + client.getId());
        this.client = client;
        buildUI(createComponents(client));
        client.attach(this);
    }

    @Override
    public void update(Observable obj) {
        getContentPane().removeAll();

        if (obj instanceof IClient) {
            buildUI(createComponents((IClient) obj));
        }

        validate();

    }

    /**
     * Creates the components of the window.
     * @param client the client to display
     * @return the components of the window
     */
    static private JLabel[] createComponents(IClient client) {
        return new JLabel[]{
                new JLabel("Last name: " + client.getLastName()),
                new JLabel("First name: " + client.getFirstName()),
                new JLabel("Credit: " + client.getAccountState().getBalance()),
                new JLabel("Nb miles: " + client.getAccountState().getMiles()),
                new JLabel("Status: " + client.getAccountState().getStatus()),
                new JLabel("Last action: " + client.getAccountState().getLastAction())
        };
    }

    @Override
    public void dispose() {
        super.dispose();

        client.detach(this);
    }
}
