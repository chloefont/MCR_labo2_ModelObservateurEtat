package account;

import java.awt.Color;

/**
 * Golden state of an account
 *
 * <p>Represents one of the multiple states (State design pattern) in which a client account can be in.</p>
 * @see AccountState
 * @version 1.0
 * @author Nelson Jeanrenaud
 */
public class GoldenState extends AccountState {
    // Minimum requirement of miles to get a gold account
    private static final int MIN_MILES = 1000;
    // Maximum requirement of miles to get a gold account
    private static final int MAX_MILES = 10000;

    /**
     * Creates a new gold account from an old one. Use it to change the state of an account
     * @param oldState The old state of the account
     */
    public GoldenState(AccountState oldState) {
        super(oldState);
    }

    @Override
    protected void stateChangeCheck() {
        if(getMiles() < MIN_MILES)
            getOwner().setAccountState(new SilverState(this));
        else if(getMiles() >= MAX_MILES)
            getOwner().setAccountState(new PlatiniumState(this));
    }

    @Override
    double getMilesCoefficient() {
        return 0.5;
    }

    @Override
    public String getStatus() {
        return "Gold";
    }

    @Override
    public Color getStatusColor() {
        return Color.orange;
    }
}
