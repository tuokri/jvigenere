package com.github.client.view;

import javax.swing.*;
import java.awt.*;

public class MainMenu {

    private JPanel panel;

    private JButton nextButton;
    private JButton exitButton;
    private JButton helpButton;
    private JButton latinAButton;
    private JButton scandinavianAButton;
    private JButton customAButton;
    private JButton keyInfoButton;

    public MainMenu() {

        panel = new JPanel();
        initComponents(panel);
    }

    public Container getContentPane() {

        return panel;
    }

    private void initComponents(Container pane) {

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

        ImageIcon icon;
        button = new JButton();
        icon = new ImageIcon(getClass().getResource("/icons/button_question_mark_default_18x18.png"));
        button.setIcon(icon);
        icon = new ImageIcon(getClass().getResource("/icons/button_question_mark_rollover_18x18.png"));
        button.setRolloverIcon(icon);
        icon = new ImageIcon(getClass().getResource("/icons/button_question_mark_pressed_18x18.png"));
        button.setPressedIcon(icon);
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

        System.out.println(this + ": initComponents on :" + pane);
    }
}
