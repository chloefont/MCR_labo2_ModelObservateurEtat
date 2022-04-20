package ui;

import javax.swing.*;

public class ClientDetailsWindow extends InformationWindow{
    ClientDetailsWindow(IClient client) {
        super(new JLabel[]{
                new JLabel("Last name: " + client.getLastName()),
                new JLabel("First name: " + client.getFirstName()),
                new JLabel("Credit: " + client.getAccountState().getBalance()),
                new JLabel("Nb miles: " + client.getAccountState().getMiles()),
                new JLabel("Status: " + client.getAccountState().getStatus()),
                new JLabel("Last action: " + client.getAccountState().getLastAction())
        }, "Details of client #" + client.getId());
    }
}
