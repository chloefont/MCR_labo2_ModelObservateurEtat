/**
 * Platinium state of an account
 *
 * <p>Represents one of the multiple states (State design pattern) in which a client account can be in.</p>
 * @see AccountState
 * @version 1.0
 * @author Nelson Jeanrenaud
 */
public class PlatiniumState extends AccountState {
    protected static final int MIN_MILES = 10000;
    protected static final int MAX_BALANCE = 100000;

    PlatiniumState(AccountState oldState) {
        super(oldState);
    }

    @Override
    protected void stateChangeCheck() {
        if(miles < MIN_MILES)
            owner.setAccountState(new GoldenState(this));
        else if(balance > MAX_BALANCE)
            owner.setAccountState(new SilverState(this));
    }

    @Override
    double getMilesCoefficient() {
        return 1;
    }
}

class PlatiniumStatePremium extends PlatiniumState {

    PlatiniumStatePremium(AccountState oldState) {
        super(oldState);
    }

    @Override
    protected void stateChangeCheck() {}
}
