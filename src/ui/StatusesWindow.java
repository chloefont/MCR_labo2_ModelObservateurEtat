package ui;

import javax.swing.*;
import java.util.Arrays;

public class StatusesWindow extends InformationWindow{
    static final String WINDOW_TITLE = "Statuses";

    StatusesWindow(IClient[] clients) {
        super(createLabels(clients), WINDOW_TITLE);
    }

    private static JLabel[] createLabels(IClient[] clients){
        return (JLabel[]) Arrays.stream(clients)
                .map(iClient -> {
                    final JLabel label = new JLabel(iClient.getLastName() + " " +
                            iClient.getFirstName() + " " +
                            iClient.getAccountState().getStatus());
                    label.setForeground(iClient.getAccountState().getStatusColor());
                    return label;
                }).toArray();
    }
}
