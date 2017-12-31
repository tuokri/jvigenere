package com.github.client.view;

import com.github.client.model.Model;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class View implements Observer {

    private Model model;
    private JFrame frame;

    private boolean showInitialHelpAgain = true;

    private MainMenu mainMenu;

    public View(Model model, String label) {

        this.model = model;
        model.addObserver(this);
        mainMenu = new MainMenu();

        frame = new JFrame(label);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(mainMenu.getContentPane());
        frame.pack();
        frame.setLocationRelativeTo(null); // Center of primary monitor.
        frame.setResizable(false);
        frame.setVisible(true);
        showInitialHelpDialog();
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    // TODO: Make a new class out of this method.
    private void showInitialHelpDialog() {

        JRadioButton dontShowAgainButton = new JRadioButton(
            "Always show this help on program start.", true);
        JTextField helpText1 = new JTextField(
            "This program uses Vigenère cipher to translate plain text to cipher text and vice versa.");
        JTextField helpText2 = new JTextField(
            "You may choose from pre-defined alphabets or enter a custom one.");

        dontShowAgainButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        helpText1.setEditable(false);
        helpText2.setEditable(false);
        helpText1.setBackground(null);
        helpText2.setBackground(null);
        helpText1.setBorder(null);
        helpText2.setBorder(null);

        dontShowAgainButton.addActionListener(e -> {
            showInitialHelpAgain = dontShowAgainButton.isSelected();
            System.out.println("showInitialHelpAgain = " + showInitialHelpAgain);
            // TODO: Save state on disk.
        });

        JPanel messagePane = new JPanel();
        messagePane.setLayout(new BoxLayout(messagePane, BoxLayout.Y_AXIS));
        messagePane.add(helpText1);
        messagePane.add(helpText2);
        messagePane.add(dontShowAgainButton);

        JOptionPane pane = new JOptionPane(messagePane);
        JDialog dialog = pane.createDialog("How to use Vigenècryptor");
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.pack();
        dialog.setVisible(true);
    }
}
