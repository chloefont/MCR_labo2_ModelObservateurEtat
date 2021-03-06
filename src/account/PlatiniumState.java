package account;

import java.awt.Color;

/**
 * Platinium state of an account
 *
 * <p>Represents one of the multiple states (State design pattern) in which a client account can be in.</p>
 * @see AccountState
 * @version 1.0
 * @author Nelson Jeanrenaud
 */
public class PlatiniumState extends AccountState {
    // Minimum requirement of miles to get a platinium account
    private static final int MIN_MILES = 10000;
    // Maximum requirement of miles to get a platinium account
    private static final int MAX_BALANCE = 100000;

    /**
     * Creates a new platinium account from an old one. Use it to change the state of an account
     * @param oldState The old state of the account
     */
    public PlatiniumState(AccountState oldState) {
        super(oldState);
    }

    @Override
    protected void stateChangeCheck() {
        if(getMiles() < MIN_MILES)
            getOwner().setAccountState(new GoldenState(this));
        else if(getBalance() >= MAX_BALANCE)
            getOwner().setAccountState(new PlatiniumStatePremium(this));
    }

    @Override
    double getMilesCoefficient() {
        return 1;
    }

    @Override
    public String getStatus() {
        return "Platinium";
    }

    @Override
    public Color getStatusColor() {
        return Color.cyan;
    }
}

/**
 * Premium platinium state of the account. Particular type of platinium account that can't be downgraded
 * even if they don't meet the requirements anymore.
 *
 * @version 1.0
 * @author Nelson Jeanrenaud
 */
class PlatiniumStatePremium extends PlatiniumState {

    /**
     * Creates a new premium platinium account from an old one. Use it to change the state of an account
     * @param oldState The old state of the account
     */
    public PlatiniumStatePremium(AccountState oldState) {
        super(oldState);
    }

    @Override
    protected void stateChangeCheck() {}

    @Override
    public String getStatus() {
        return super.getStatus() + " premium";
    }
}
