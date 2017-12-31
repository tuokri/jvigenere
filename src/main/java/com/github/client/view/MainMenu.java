package com.github.client.view;

import javax.swing.*;
import java.awt.*;

public class MainMenu {

    private JPanel mainPanel;

    private JPanel alphaBetInfoPanel;
    private JLabel alphabetSelectionText;
    private JButton alphabetInfoButton;

    private JPanel alphabetButtonPanel;
    private ButtonGroup alphabetButtonGroup;
    private JButton latinAButton;
    private JButton scandinavianAButton;
    private JButton customAButton;

    private JPanel keyPanel;
    private JButton keyInfoButton;
    private JLabel keyTextLabel;
    private JTextField keyInputField;

    private JPanel navigationPanel;
    private JButton nextButton;
    private JButton exitButton;
    private JButton helpButton;

    public MainMenu() {

        mainPanel = new JPanel();
        initComponents(mainPanel);
    }

    public Container getContentPane() {

        return mainPanel;
    }

    // TODO: Refactor hard-coded grid constraints.
    // TODO: Refactor this long-ass abomination of a method.
    private void initComponents(Container pane) {

        pane.setLayout(new GridBagLayout());


        GridBagConstraints alphabetInfoPanelGbc = new GridBagConstraints();
        alphabetInfoPanelGbc.gridwidth = 2;
        alphabetInfoPanelGbc.gridy = 0;
        alphaBetInfoPanel = new JPanel();
        alphaBetInfoPanel.setLayout(new GridBagLayout());

        GridBagConstraints alphabetSelectionTextGbc = new GridBagConstraints();
        alphabetSelectionTextGbc.insets = new Insets(10, 10, 10, 5);
        alphabetSelectionTextGbc.gridy = 0;
        alphabetSelectionTextGbc.gridx = 0;
        alphabetSelectionText = new JLabel("Choose the alphabet");
        alphaBetInfoPanel.add(alphabetSelectionText, alphabetSelectionTextGbc);

        alphabetSelectionTextGbc.gridx = 1;
        alphabetSelectionTextGbc.insets = new Insets(0, 0, 0, 0);
        alphabetInfoButton = createQuestionMarkButton();
        alphaBetInfoPanel.add(alphabetInfoButton, alphabetSelectionTextGbc);

        pane.add(alphaBetInfoPanel, alphabetInfoPanelGbc);




        GridBagConstraints alphabetButtonPanelGbc = new GridBagConstraints();
        alphabetButtonPanelGbc.gridy = 1;
        alphabetButtonPanel = new JPanel();
        alphabetButtonPanel.setLayout(new GridBagLayout());

        Dimension alphabetButtonSize = new Dimension(100, 30);
        latinAButton = new JButton("Latin");
        latinAButton.setPreferredSize(alphabetButtonSize);
        scandinavianAButton = new JButton("Scandinavian");
        scandinavianAButton.setPreferredSize(alphabetButtonSize);
        customAButton = new JButton("Custom...");
        customAButton.setPreferredSize(alphabetButtonSize);

        alphabetButtonGroup = new ButtonGroup();
        alphabetButtonGroup.add(latinAButton);
        alphabetButtonGroup.add(scandinavianAButton);
        alphabetButtonGroup.add(customAButton);

        GridBagConstraints alphabetButtonConstraints = new GridBagConstraints();
        alphabetButtonConstraints.ipadx = 35;
        alphabetButtonConstraints.ipady = 35;
        alphabetButtonConstraints.weighty = 0.0;
        alphabetButtonConstraints.weighty = 0.0;
        alphabetButtonConstraints.fill = GridBagConstraints.NONE;
        alphabetButtonConstraints.insets = new Insets(5, 5, 5, 5);

        alphabetButtonPanel.add(latinAButton, alphabetButtonConstraints);
        alphabetButtonPanel.add(scandinavianAButton, alphabetButtonConstraints);
        alphabetButtonPanel.add(customAButton, alphabetButtonConstraints);

        pane.add(alphabetButtonPanel, alphabetButtonPanelGbc);




        GridBagConstraints keyPanelGbc = new GridBagConstraints();
        keyPanelGbc.insets = new Insets(10, 10, 10, 10);
        keyPanelGbc.gridy = 2;
        keyPanel = new JPanel();
        pane.add(keyPanel, keyPanelGbc);

        GridBagConstraints keyTextLabelGbc = new GridBagConstraints();
        keyTextLabelGbc.insets = new Insets(0, 0, 0, 5);
        keyTextLabel = new JLabel("Enter key:");
        keyPanel.add(keyTextLabel, keyTextLabelGbc);

        GridBagConstraints keyInputFieldGbc = new GridBagConstraints();
        keyInputFieldGbc.insets = new Insets(0, 0, 0, 5);
        keyInputField = new JTextField();
        keyInputField.setColumns(15);
        keyPanel.add(keyInputField, keyInputFieldGbc);

        keyInfoButton = createQuestionMarkButton();
        keyPanel.add(keyInfoButton);







        GridBagConstraints navigationPanelGbc = new GridBagConstraints();
        navigationPanelGbc.insets = new Insets(5, 5, 5, 5);
        navigationPanelGbc.gridy = 3;
        navigationPanelGbc.fill = GridBagConstraints.PAGE_END;
        navigationPanel = new JPanel();
        navigationPanel.setLayout(new GridBagLayout());

        exitButton = new JButton("Exit");
        helpButton = new JButton("Help");
        nextButton = new JButton("Next");

        GridBagConstraints navigationButtonGbc = new GridBagConstraints();

        navigationButtonGbc.insets = new Insets(5, 5, 5, 75);
        navigationPanel.add(exitButton, navigationButtonGbc);
        navigationButtonGbc.insets = new Insets(5, 0, 5, 0);
        navigationPanel.add(helpButton, navigationButtonGbc);
        navigationButtonGbc.insets = new Insets(5, 0, 5, 5);
        navigationPanel.add(nextButton, navigationButtonGbc);

        pane.add(navigationPanel, navigationPanelGbc);

        System.out.println(this + ": initComponents on : " + pane);
    }

    private JButton createQuestionMarkButton() {

        ImageIcon icon;
        JButton button = new JButton();
        icon = new ImageIcon(getClass().getResource("/icons/button_question_mark_default_18x18.png"));
        button.setIcon(icon);
        icon = new ImageIcon(getClass().getResource("/icons/button_question_mark_rollover_18x18.png"));
        button.setRolloverIcon(icon);
        icon = new ImageIcon(getClass().getResource("/icons/button_question_mark_pressed_18x18.png"));
        button.setPressedIcon(icon);
        return button;
    }
}
