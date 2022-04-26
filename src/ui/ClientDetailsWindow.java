package ui;

import Observables.Observable;

import javax.swing.JLabel;

public class ClientDetailsWindow extends InformationWindow{
    private IClient client;

    ClientDetailsWindow(IClient client) {
        super("Details of client #" + client.getId());
        this.client = client;
        buildUI(createComponents(client));
        client.attach(this);
    }

    @Override
    public void update(Observable obj, Object arg) {
        getContentPane().removeAll();

        if (obj instanceof IClient) {
            buildUI(createComponents((IClient) obj));
        }

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

    @Override
    public void dispose() {
        super.dispose();

        client.detach(this);
    }
}
