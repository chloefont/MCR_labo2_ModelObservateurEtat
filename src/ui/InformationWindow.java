package ui;

import javax.swing.*;
import java.awt.*;

public abstract class InformationWindow extends JFrame {

    JComponent[] components;

    InformationWindow(JComponent[] components, String windowTitle){
        super();
        assert components != null;
        assert windowTitle != null;

        this.components = components;
        setTitle(windowTitle);
        buildUI();

        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void buildUI(){

        final JPanel gridPanel = new JPanel(new GridLayout(components.length,1));

        for (JComponent component : components) {
            final JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
            panel.add(component);
            gridPanel.add(panel);
        }
        add(gridPanel);
    }

}