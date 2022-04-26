package ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class StatusesWindow extends InformationWindow {
    static final String WINDOW_TITLE = "Statuses";
    private final ArrayList<ClientLabel> labels = new ArrayList<>();

    StatusesWindow(Frame owner, IClient[] clients) {
        super(owner);

        if (clients == null)
            throw new IllegalArgumentException("clients must not be null");

        setWindowTitle(WINDOW_TITLE);
        buildUI(createLabels(clients));

    }

    private JLabel[] createLabels(IClient[] clients){
        if (clients == null)
            throw new IllegalArgumentException("clients must not be null");

        return (JLabel[]) Arrays.stream(clients)
                .map(this::createLabel).toArray(JLabel[]::new);
    }

    private JLabel createLabel(IClient client){
        ClientLabel label = new ClientLabel(client);
        labels.add(label);
        return label;
    }

    @Override
    public void dispose() {
        super.dispose();
        for (ClientLabel label : labels)
            label.dispose();
    }
}
