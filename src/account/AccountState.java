package account;

import ui.IAccountState;
import ui.ITicket;
import java.awt.Color;

/**
 * Abstract State Object of the State Pattern.
 *
 * <p>Represents the state of an account.</p>
 * @see Client
 * @version 1.0
 * @author Nelson Jeanrenaud
 * @author Chloé Fontaine
 * @author Luca Coduri
 */
public abstract class AccountState implements IAccountState {

    /**
     * Action performable by the account.
     */
    enum Action {
        Deposit, // Deposit money.
        BookMiles, // Book a ticket using miles.
        BookCash, // Book a ticket using cash.
        ErrorNotEnoughCash, // Error when booking a ticket using cash.
        ErrorNotEnoughMiles // Error when booking a ticket using miles.
    }

    /**
     * Amount of dollars available on this account.
     * This amount can't be negative.
     */
    private double balance;
    /**
     * Number of miles traveled by the owner of this account.
     * Can be used as a currency to book flights.
     */
    private double miles;

    /**
     * Owner of this account.
     */
    private final Client owner;

    /**
     * Last action performed by the account.
     */
    private Action lastAction;

    /**
     * Create an account for a client.
     * @param owner Account.Client who wons this account.
     */
    public AccountState(Client owner) {
        if(owner == null)
            throw new IllegalArgumentException("Accounts must owned by a client");

        if(owner.hasAccount())
            throw new IllegalArgumentException("Clients can't have two accounts");

        this.owner = owner;
    }

    /**
     * Creates a new account state from an old one.
     * Use it to change the state of an account.
     * @param oldState AccountState to copy.
     */
    public AccountState(AccountState oldState) {
        if (oldState == null)
            throw new IllegalArgumentException("AccountState must not be null");

        this.balance = oldState.balance;
        this.miles = oldState.miles;
        this.owner = oldState.owner;
    }

    /**
     * Implement the conditions under which the state of the account is changed.
     */
    protected abstract void stateChangeCheck();

    /**
     * Get the cash price price of a ticket.
     */
    private double getTicketPriceCash(ITicket ticket){
        if (ticket == null)
            throw new IllegalArgumentException("Ticket must not be null");

        double tPrice = ticket.getPriceCash();
        if(tPrice < 0)
            throw new IllegalArgumentException("Flights.Ticket price must be positive");
        return tPrice;
    }

    /**
     * Get the miles price of a ticket.
     */
    private double getTicketPriceMiles(ITicket ticket){
        if (ticket == null)
            throw new IllegalArgumentException("Ticket must not be null");

        double tMiles = ticket.getPriceMiles();
        if(tMiles < 0)
            throw new IllegalArgumentException("Flights.Ticket miles must be positive");
        return tMiles;
    }

    /**
     * Actions done when an action has been performed on the account.
     * @param action Action performed.
     */
    private void actionPerformed(Action action) {
        lastAction = action;
        stateChangeCheck();
        owner.notifyObservers();
    }

    /**
     * Book a ticket using the miles on the account.
     * Notify the observers of the account.
     * @param ticket the ticket the client is trying to buy.
     */
    public void bookMiles(ITicket ticket) {
        if (ticket == null)
            throw new IllegalArgumentException("Ticket must not be null");

        double tMiles = getTicketPriceMiles(ticket);
        if(miles >= tMiles) {
            miles -= tMiles;
            actionPerformed(Action.BookMiles);
        } else {
            actionPerformed(Action.ErrorNotEnoughMiles);
        }
    }

    /**
     * Book a ticket using the money on the account.
     * Notify the observers of the account.
     * @param ticket the ticket the client is trying to buy.
     * @return returns true if the ticket has been booked.
     */
    public void bookCash(ITicket ticket){
        if (ticket == null)
            throw new IllegalArgumentException("Ticket must not be null");

        double tPrice = getTicketPriceCash(ticket);
        if(balance >= tPrice) {
            balance -= tPrice;
            miles += ticket.getFlight().getDistance() * getMilesCoefficient();
            actionPerformed(Action.BookCash);
        } else {
            actionPerformed(Action.ErrorNotEnoughCash);
        }
    }

    /**
     * Adds money to this account.
     * @param amount amount of money to be deposited on this account.
     */
    public void deposit(double amount) {
        if(amount <= 0)
            throw new IllegalArgumentException("Deposit must be strictly positive");
        balance += amount;
        actionPerformed(Action.Deposit);
    }

    /**
     * Returns the coefficient by which the number of miles is multiplied to get
     * the amount of miles added to the balance.
     */
    abstract double getMilesCoefficient();

    /**
     * Get the current state of the account.
     */
    public abstract String getStatus();

    /**
     * Get the color representing the state of the account.
     */
    public abstract Color getStatusColor();

    /**
     * Get the balance of the account.
     * @return the balance of the account.
     */
    public double getBalance(){
        return balance;
    }

    /**
     * Get the number of miles of the account.
     * @return the number of miles of the account.
     */
    public double getMiles() {
        return miles;
    }

    /**
     * Get the last action performed on the account.
     * If the account has performed no actions, returns an empty string.
     * @return the last action performed on the account.
     */
    public String getLastAction() {
        if (lastAction == null)
            return "";
        return lastAction.toString();
    }

    /**
     * Get the owner of this account.
     * @return the owner of this account.
     */
    protected Client getOwner() {
        return owner;
    }
}
