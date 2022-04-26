package ui;

import observables.Observable;
import observables.Observer;

import javax.swing.*;

public class ClientLabel extends JLabel implements Observer {
    private IClient client;

    public ClientLabel(IClient client) {
        super();
        setClientText(client);

        this.client = client;
        client.attach(this);
    }

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
