/**
 * Golden state of an account
 *
 * <p>Represents one of the multiple states (State design pattern) in which a client account can be in.</p>
 * @see AccountState
 * @version 1.0
 * @author Nelson Jeanrenaud
 */
public class GoldenState extends AccountState {
    protected static int MIN_MILES = 1000;
    protected static int MAX_MILES = 10000;

    GoldenState(AccountState oldState) {
        super(oldState);
    }

    @Override
    protected void stateChangeCheck() {
        if(miles < MIN_MILES)
            owner.setAccountState(new SilverState(this));
        else if(miles > MAX_MILES)
            owner.setAccountState(new PlatiniumState(this));
    }

    @Override
    double getMilesCoefficient() {
        return 0.5;
    }
}
