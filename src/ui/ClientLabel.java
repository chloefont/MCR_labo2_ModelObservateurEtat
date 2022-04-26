package ui;

import observables.Observable;
import observables.Observer;

import javax.swing.*;

/**
 * Label that displays the informations of a client.
 * @author Luca Coduri
 * @author Chloé Fontaine
 * @version 1.0
 */
public class ClientLabel extends JLabel implements Observer {
    // Client to display
    private IClient client;

    /**
     * Creates a new ClientLabel.
     * @param client the client to display
     */
    public ClientLabel(IClient client) {
        super();
        setClientText(client);

        this.client = client;
        client.attach(this);
    }

    /**
     * Sets the text of the label.
     * @param client the client to display
     */
    private void setClientText(IClient client) {
        final String labelContent = client + " " + client.getAccountState().getStatus();
        setText(labelContent);
        setForeground(client.getAccountState().getStatusColor());
    }

    @Override
    public void update(Observable obj) {

        if (obj instanceof IClient)
            setClientText((IClient) obj);
    }

    public void dispose() {
        client.detach(this);
    }
}
