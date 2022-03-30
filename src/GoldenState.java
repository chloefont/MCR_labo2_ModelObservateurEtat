/**
 * Golden state of an account
 *
 * <p>Represents one of the multiple states (State design pattern) in which a client account can be in.</p>
 * @see AccountState
 * @version 1.0
 * @author Nelson Jeanrenaud
 */
public class GoldenState extends AccountState {
    /**
     * Create an account for a client
     *
     * @param owner Client who wons this account
     */
    public GoldenState(Client owner) {
        super(owner);
    }

    @Override
    protected void stateChangeCheck() {

    }

    @Override
    public boolean bookMiles(Ticket t) {
        return false;
    }

    @Override
    public boolean bookCash(Ticket t) {
        return false;
    }

    @Override
    public void deposit(double amount) {

    }
}
