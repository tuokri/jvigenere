package com.github.client.view;

import com.github.client.model.Model;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class View implements Observer {

    private Model model;
    private JFrame frame;

    private void addComponentsToPane(Container pane) {

        pane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        JLabel keyLabel;
        JTextField keyInputField;
        JButton button;

        pane.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        keyLabel = new JLabel("Enter key:");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        pane.add(keyLabel, constraints);

        keyInputField = new JTextField();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        pane.add(keyInputField, constraints);
        constraints.gridwidth = 1;

        button = new JButton();
        ImageIcon icon = new ImageIcon(getClass().getResource("/button_question_mark_default.png"));
        button.setIcon(icon);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 5;
        constraints.gridy = 0;
        constraints.insets = new Insets(0,10,0,0);
        pane.add(button, constraints);

        button = new JButton("Exit");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.insets = new Insets(10,0,0,0);
        constraints.anchor = GridBagConstraints.PAGE_END;
        pane.add(button, constraints);

        button = new JButton("Help");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.insets = new Insets(10,50,0,0);
        constraints.anchor = GridBagConstraints.PAGE_END;
        pane.add(button, constraints);

        button = new JButton("Next");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.insets = new Insets(10,0,0,0);
        constraints.anchor = GridBagConstraints.PAGE_END;
        pane.add(button, constraints);
    }

    public View(Model model, String label) {

        this.model = model;
        model.addObserver(this);

        frame = new JFrame(label);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addComponentsToPane(frame.getContentPane());
        frame.pack();
        frame.setLocationRelativeTo(null); // Center of primary monitor.
        frame.setResizable(false);
        frame.setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
