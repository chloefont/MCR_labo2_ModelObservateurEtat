package Account;

import java.awt.Color;

/**
 * Silver state of an account
 *
 * <p>Represents one of the multiple states (State design pattern) in which a client account can be in.</p>
 * <p>This is the base state of a new client account</p>
 * @see AccountState
 * @version 1.0
 * @author Nelson Jeanrenaud
 */
public class SilverState extends AccountState {
    private static final int MAX_MILES = 1000;
    /**
     * Create an account for a client
     *
     * @param owner Account.Client who wons this account
     */
    public SilverState(Client owner) {
        super(owner);
    }

    SilverState(AccountState oldState) {
        super(oldState);
    }

    @Override
    protected void stateChangeCheck() {
        if(getMiles() >= MAX_MILES)
            getOwner().setAccountState(new GoldenState(this));
    }

    @Override
    double getMilesCoefficient() {
        return 0.1;
    }

    @Override
    public String getStatus() {
        return "Silver";
    }

    @Override
    public Color getStatusColor() {
        return Color.gray;
    }
}
