/**
 * Flight Object
 *
 * <p>Represents a flight for which clients can buy a ticket</p>
 * @see Client
 * @version 1.0
 * @author Nelson Jeanrenaud
 */
public class Flight {
    private Client c;
    private String name;
    /**
     * Distance traveled during this flight
     */
    private double distance;
    /**
     * Base price of this flight
     */
    private double price;

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " (" + distance + " miles)";
    }
}
