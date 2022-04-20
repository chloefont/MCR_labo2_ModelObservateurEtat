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
                .map(cl -> {
                    final String labelContent = cl.getLastName() + " " +
                                                cl.getFirstName() + " " +
                                                cl.getAccountState().getStatus();
                    final JLabel label = new JLabel(labelContent);
                    label.setForeground(cl.getAccountState().getStatusColor());
                    return label;
                }).toArray(JLabel[]::new);
    }
}
