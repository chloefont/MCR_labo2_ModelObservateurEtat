package Account;

import Observables.Observable;
import ui.IAccountState;
import ui.IClient;

/**
 * Account.Client Object
 *
 * <p>Represents a client of the flight compagny manager</p>
 * @version 1.0
 * @author Nelson Jeanrenaud
 */
public class Client extends Observable implements IClient {

    /**
     * Auto-incremented counter to generate unique IDs for the clients
     */
    private static int idCounter;
    private final int id = idCounter++;

    private String firstname;
    private String lastname;

    // TOOO a chier ?
    public Boolean hasAccount() {
        return account != null;
    }

    /**
     * Account owned by this client
     */
    private AccountState account;

    /**
     * Change the account state of this client
     */
    void setAccountState(AccountState account) {
        this.account = account;
    }

    /**
     * Creates a new client with a silver account
     * @param firstname first name of this client
     * @param lastname last name of this client
     */
    public Client(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.account = new SilverState(this);
    }

    @Override
    public String toString() {
        return lastname + " " + firstname;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getLastName() {
        return lastname;
    }

    @Override
    public String getFirstName() {
        return firstname;
    }

    @Override
    public IAccountState getAccountState() {
        return account;
    }
}
