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
    protected static int MAX_MILES = 1000;
    /**
     * Create an account for a client
     *
     * @param owner Client who wons this account
     */
    public SilverState(Client owner) {
        super(owner);
    }

    SilverState(AccountState oldState) {
        super(oldState);
    }

    @Override
    protected void stateChangeCheck() {
        if(miles > MAX_MILES)
            owner.setAccountState(new GoldenState(this));
    }

    @Override
    double getMilesCoeffificent() {
        return 0.1;
    }
}
