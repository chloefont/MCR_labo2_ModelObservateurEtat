package ui;

import Observables.Observable;

import javax.swing.*;

public class ClientDetailsWindow extends InformationWindow{
    ClientDetailsWindow(IClient client) {
        super(createComponents(client), "Details of client #" + client.getId());
        client.attach(this);
    }

    @Override
    public void update(Observable obj, Object arg) {
        getContentPane().removeAll();

        if (obj instanceof IClient) {
            setComponents(createComponents((IClient) obj));
        }

        buildUI();
        validate();

    }

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
}
