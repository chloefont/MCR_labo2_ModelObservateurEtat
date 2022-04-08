import ui.MainWindow;

import javax.swing.*;
import java.awt.*;

public class App implements Runnable{

    @Override
    public void run() {
        new MainWindow();
    }

    public static void main(String[] args) {
        new App().run();
    }
}
