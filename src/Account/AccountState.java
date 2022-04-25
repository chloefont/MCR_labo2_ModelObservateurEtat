package Account;

import Flights.Ticket;
import ui.IAccountState;
import ui.ITicket;

import java.awt.*;

/**
 * Abstract State Object of the State Pattern
 *
 * <p>Represents the state of an account</p>
 * @see Client
 * @version 1.0
 * @author Nelson Jeanrenaud
 */
public abstract class AccountState implements IAccountState {
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
    private double getTicketPrice(ITicket t){
        double tPrice = t.getPriceCash();
        if(tPrice < 0)
            throw new IllegalArgumentException("Flights.Ticket price must be positive");
        return tPrice;
    }

    private double getTicketMiles(ITicket t){
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
        double tMiles = getTicketMiles(t);
        if(miles >= tMiles) {
            miles -= tMiles;
            stateChangeCheck();
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
        double tPrice = getTicketPrice(t);
        double tMiles = getTicketMiles(t);
        if(balance >= tPrice) {
            balance -= tPrice;
            miles += tMiles * getMilesCoefficient();
            stateChangeCheck();
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
    }

    /**
     * Returns the coefficient by which the number of miles is multiplied to get
     * amount of miles added to the balance
     */
    abstract double getMilesCoefficient();
    public abstract String getStatus();
    public abstract Color getStatusColor();

    // TODO améliorer l'implémentation du code ci-dessous
    public double getBalance(){
        return balance;
    }
    public double getMiles(){
        return miles;
    }
    public String getLastAction(){
        return "";
    }
    protected Client getOwner() {
        return owner;
    }
}
