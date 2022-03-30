/**
 * Client Object
 *
 * <p>Represents a client of the flight compagny manager</p>
 * @version 1.0
 * @author Nelson Jeanrenaud
 */
public class Client {

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
    private final AccountState account;

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
}
