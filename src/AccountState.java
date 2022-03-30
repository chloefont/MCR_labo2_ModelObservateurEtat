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

    /**
     * Book a ticket using the miles on the account
     * @param t the ticket the client is trying to buy
     * @return returns true if the ticket has been booked
     */
    public abstract boolean bookMiles(Ticket t);

    /**
     * Book a ticket using the money on the account
     * @param t the ticket the client is trying to buy
     * @return returns true if the ticket has been booked
     */
    public abstract boolean bookCash(Ticket t);

    /**
     * Adds money to this account
     * @param amount amount of money to be deposited on this account
     */
    public abstract void deposit(double amount);
}
