import ui.IAccountState;

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
    protected double balance;
    /**
     * Number of miles traveled by the owner of this account
     * Can be used as a currency to book flights
     */
    protected double miles;

    /**
     * Owner of this account
     */
    protected final Client owner;

    /**
     * Create an account for a client
     * @param owner Client who wons this account
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

    /**
     * Book a ticket using the miles on the account
     * @param t the ticket the client is trying to buy
     * @return returns true if the ticket has been booked
     */
    public boolean bookMiles(Ticket t) {
        if(miles >= t.getPriceMiles()) {
            miles -= t.getPriceMiles();
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
    public boolean bookCash(Ticket t){
        if(balance >= t.getPriceCash()) {
            balance -= t.getPriceCash();
            // TODO décommenter --> miles += t.getMiles() * getMilesCoeffificent();
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
        balance += amount;
        stateChangeCheck();
    }

    /**
     * Returns the coefficient by which the number of miles is multiplied to get
     * amount of miles added to the balance
     */
    abstract double getMilesCoefficient();

    // TODO améliorer l'implémentation du code ci-dessous
    public double getBalance(){
        return balance;
    }
    public double getMiles(){
        return miles;
    }
    public String getStatus(){
        return "";
    }
    public String getLastAction(){
        return "";
    }
    public Color getStatusColor(){
        return Color.GREEN;
    }
}
