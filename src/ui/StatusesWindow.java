package ui;

import observables.Observable;
import observables.Observer;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;

public class StatusesWindow extends InformationWindow {
    static final String WINDOW_TITLE = "Statuses";

    private HashMap<IClient, JLabel> idToLabelMap = new HashMap();

    StatusesWindow(IClient[] clients) {
        super();

        if (clients == null)
            throw new IllegalArgumentException("clients must not be null");

        setWindowTitle(WINDOW_TITLE);
        buildUI(createLabels(clients));

        for (IClient client : clients) {
            client.attach(this);
        }
    }

    private JLabel[] createLabels(IClient[] clients){
        if (clients == null)
            throw new IllegalArgumentException("clients must not be null");

        return (JLabel[]) Arrays.stream(clients)
                .map(this::createLabel).toArray(JLabel[]::new);
    }

    private JLabel createLabel(IClient client){
        final String labelContent = client.getLastName() + " " +
                                    client.getFirstName() + " " +
                                    client.getAccountState().getStatus();
        final JLabel label = new JLabel(labelContent);
        label.setForeground(client.getAccountState().getStatusColor());
        idToLabelMap.put(client, label);
        return label;
    }

    @Override
    public void update(Observable obj) {
        getContentPane().removeAll();

        if (obj instanceof IClient) {
            idToLabelMap.put((IClient) obj, createLabel((IClient) obj));
            buildUI(idToLabelMap.values().toArray(new JLabel[0]));
        }

        validate();
    }

    @Override
    public void dispose() {
        super.dispose();
        for (IClient client : idToLabelMap.keySet()) {
            client.detach(this);
        }
    }
}
