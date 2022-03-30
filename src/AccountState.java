/**
 * Abstract State Object of the State Pattern
 *
 * <p>Represents the state of an account</p>
 * @see Client
 * @version 1.0
 * @author Nelson Jeanrenaud
 */
public abstract class AccountState {
    /**
     * Amount of dollars available on this account
     * This amount can't be negative
     */
    private double balance;
    /**
     * Number of miles traveled by the owner of this account
     * Can be used as a currency to book flights
     */
    private double miles;

    private final Client owner;

    /**
     * Create an account for a client
     * @param owner Client who wons this account
     */
    public AccountState(Client owner) {
        if(owner == null)
            throw new IllegalArgumentException("Accounts must owned by a client");
        if(owner.hasAccount())
            throw new IllegalArgumentException("Clients can't have two acconts");
        this.owner = owner;
    }

    /**
     * Implement the conditions under which the state of the account is changed
     */
    protected abstract void stateChangeCheck();

    public abstract void bookMiles(double price);

    public abstract void bookCash(double price);

    public abstract void deposit(double amount);
}
