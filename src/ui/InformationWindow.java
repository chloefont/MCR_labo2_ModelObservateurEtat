package ui;

import Observables.Observer;

import javax.swing.*;
import java.awt.*;

public abstract class InformationWindow extends JFrame implements Observer {

    //JComponent[] components;

    InformationWindow(String windowTitle){
        super();
        assert windowTitle != null;

        setTitle(windowTitle);


        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    protected void buildUI(JComponent[] components){
        assert components != null;

        final JPanel gridPanel = new JPanel(new GridLayout(components.length,1));

        for (JComponent component : components) {
            final JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
            panel.add(component);
            gridPanel.add(panel);
        }
        add(gridPanel);
    }



}
