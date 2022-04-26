package ui;

import observables.Observer;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public abstract class InformationWindow extends JFrame implements Observer {
    public static final int FRAME_WIDTH = 500;
    public static final int FRAME_HEIGHT = 300;

    //JComponent[] components;

    InformationWindow(){
        super();


        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    protected void setWindowTitle(String title){
        setTitle(title);
    }

    protected void buildUI(JComponent[] components){
        if (components == null)
            throw new IllegalArgumentException("Components must not be null");

        final JPanel gridPanel = new JPanel(new GridLayout(components.length,1));

        for (JComponent component : components) {
            final JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
            panel.add(component);
            gridPanel.add(panel);
        }
        add(gridPanel);
    }



}
