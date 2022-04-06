/**
 * Tickets.Ticket Object
 *
 * <p>Represents a ticket to a flight that can be bought by a client</p>
 * @see Flight
 * @see Client
 * @version 1.0
 * @author Nelson Jeanrenaud
 */
public abstract class Ticket {
    private String name;
    private final int priceCoefficient;
    private final int milesCoefficient;
    private Flight flight;

    protected Ticket(String name, int priceCoefficient, int milesCoefficient, Flight flight) {
        this.name = name;
        this.priceCoefficient = priceCoefficient;
        this.milesCoefficient = milesCoefficient;
        this.flight = flight;
    }

    public double getPriceCash() {
        return flight.getPrice() * priceCoefficient;
    }

    public double getPriceMiles() {
        return flight.getPrice() * milesCoefficient;
    }

    @Override
    public String toString() {
        return name + " " + getPriceCash() + "$";
    }
}
