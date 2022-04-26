package Account;

import ui.IAccountState;
import ui.ITicket;

import java.awt.Color;

/**
 * Abstract State Object of the State Pattern
 *
 * <p>Represents the state of an account</p>
 * @see Client
 * @version 1.0
 * @author Nelson Jeanrenaud
 */
public abstract class AccountState implements IAccountState {

    enum Action {
        Deposit, BookMiles, BookCash
    }

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

    /**
     * Owner of this account
     */
    private final Client owner;

    private Action lastAction;

    /**
     * Create an account for a client
     * @param owner Account.Client who wons this account
     */
    public AccountState(Client owner) {
        if(owner == null)
            throw new IllegalArgumentException("Accounts must owned by a client");
        if(owner.hasAccount())
            throw new IllegalArgumentException("Clients can't have two accounts");
        this.owner = owner;
    }

    AccountState(AccountState oldState) {
        this.balance = oldState.balance;
        this.miles = oldState.miles;
        this.owner = oldState.owner;
    }

    /**
     * Implement the conditions under which the state of the account is changed
     */
    protected abstract void stateChangeCheck();

    // TODO c'est a chier ou ça va ?
    private double getTicketPriceCash(ITicket t){
        double tPrice = t.getPriceCash();
        if(tPrice < 0)
            throw new IllegalArgumentException("Flights.Ticket price must be positive");
        return tPrice;
    }

    private double getTicketPriceMiles(ITicket t){
        double tMiles = t.getPriceMiles();
        if(tMiles < 0)
            throw new IllegalArgumentException("Flights.Ticket miles must be positive");
        return tMiles;
    }

    /**
     * Book a ticket using the miles on the account
     * @param t the ticket the client is trying to buy
     * @return returns true if the ticket has been booked
     */
    public boolean bookMiles(ITicket t) {
        double tMiles = getTicketPriceMiles(t);
        if(miles >= tMiles) {
            // TODO doit être crédité du nombre de miles du vol?
            miles -= tMiles;
            stateChangeCheck();
            lastAction = Action.BookMiles;

            owner.notifyObservers();
            return true;
        }
        return false;
    }

    /**
     * Book a ticket using the money on the account
     * @param t the ticket the client is trying to buy
     * @return returns true if the ticket has been booked
     */
    public boolean bookCash(ITicket t){
        double tPrice = getTicketPriceCash(t);
        if(balance >= tPrice) {
            balance -= tPrice;
            miles += t.getFlight().getDistance() * getMilesCoefficient();
            stateChangeCheck();
            lastAction = Action.BookCash;

            owner.notifyObservers();
            return true;
        }
        return false;
    }

    /**
     * Adds money to this account
     * @param amount amount of money to be deposited on this account
     */
    public void deposit(double amount) {
        if(amount <= 0)
            throw new IllegalArgumentException("Deposit must be strictly positive");
        balance += amount;
        stateChangeCheck();
        lastAction = Action.Deposit;

        owner.notifyObservers();
    }

    /**
     * Returns the coefficient by which the number of miles is multiplied to get
     * amount of miles added to the balance
     */
    abstract double getMilesCoefficient();

    public abstract String getStatus();

    public abstract Color getStatusColor();

    public double getBalance(){
        return balance;
    }

    public double getMiles() {
        return miles;
    }

    public String getLastAction() {
        if (lastAction == null)
            return "";
        return lastAction.toString();
    }

    //TODO faire copie ou pas?
    protected Client getOwner() {
        return owner;
    }
}
