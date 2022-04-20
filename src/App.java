import ui.MainWindow;

import javax.swing.*;
import java.awt.*;

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


        new MainWindow(clients);
    }

    public static void main(String[] args) {
        new App().run();
    }
}
