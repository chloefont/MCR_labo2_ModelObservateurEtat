import Account.Client;
import Flights.Flight;
import ui.MainWindow;

public class App implements Runnable{

    @Override
    public void run() {
        Client[] clients = {
                new Client("Chloé", "Fontaine"),
                new Client("Nelson", "Jeanrenaud"),
                new Client("Luca", "Coduri"),
                new Client("Unmec", "Pasouf"),
                new Client("Unenana", "Pasouf")
        };

        Flight[] flights = {
                new Flight("Paris - Genève", 335, 115),
                new Flight("Amsterdam - Berlin", 407, 78),
                new Flight("Paris - Londres", 291, 120),
                new Flight("Monaco - Lisbonne", 1141, 149),
                new Flight("test", 40, 40)
        };

        new MainWindow(clients, flights);
    }

    public static void main(String[] args) {
        new App().run();
    }
}
