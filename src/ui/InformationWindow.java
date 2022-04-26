package ui;

import javax.swing.*;
import java.awt.*;

/**
 * Windows that holds divserse information
 * @author Luca Coduri
 * @author Chloé Fontaine
 * @version 1.0
 */
public abstract class InformationWindow extends JDialog {
    public static final int FRAME_WIDTH = 500;
    public static final int FRAME_HEIGHT = 300;

    /**
     * Creates a new InformationWindow.
     */
    InformationWindow(Frame owner){
        super(owner, true);

        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(new GridLayout());
        setResizable(false);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

    }

    protected void setWindowTitle(String title){
        setTitle(title);
    }

    /**
     * Builds the UI of the window and filling it with components
     * @param components the components to add to the window
     */
    protected void buildUI(JComponent[] components){
        if (components == null)
            throw new IllegalArgumentException("Components must not be null");

        final JPanel gridPanel = new JPanel(new GridLayout(components.length,1));

        for (JComponent component : components) {
            final JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
            panel.add(component);
            gridPanel.add(panel);
        }
        getContentPane().add(gridPanel);
    }
}
