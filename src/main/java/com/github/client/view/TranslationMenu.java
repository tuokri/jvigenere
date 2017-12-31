package com.github.client.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static com.github.client.view.ButtonFactory.createNavigationButton;
import static com.github.client.view.ButtonFactory.createQuestionMarkButton;

public class TranslationMenu {

    private JPanel mainPanel;
    private JPanel contentPanel;

    private JPanel infoPanel;
    private JTextField chosenAlphabetTextField;
    private JTextField chosenKeyTextField;
    private ButtonGroup visualizationRadioButtons;
    private JRadioButton visualizationOnButton;
    private JRadioButton visualizationOffButton;
    private JButton visualizationInfoButton;

    private JPanel translationPanel;
    private JTextArea plainTextArea;
    private JTextArea cipherTextArea;
    private JButton encryptButton;
    private JButton decryptButton;
    private JLabel plainTextLabel;
    private JLabel ciperTextLabel;

    private JPanel navigationPanel;
    private JButton exitButton;
    private JButton previousButton;

    public TranslationMenu(Dimension dim) {

        mainPanel = new JPanel();
        mainPanel.setPreferredSize(dim);
        initComponents(mainPanel);
        System.out.println("Init TranslationMenu");
    }

    public Container getContentPane() {

        return mainPanel;
    }

    public void addExitButtonListener(ActionListener a) {

        exitButton.addActionListener(a);
    }

    public void addPreviousButtonListener(ActionListener a) {

        previousButton.addActionListener(a);
    }

    public void setChosenAlphabetText(String text) {

        chosenAlphabetTextField.setText(text);
    }

    public void addVisualizationInfoButtonListener(ActionListener a) {

        visualizationInfoButton.addActionListener(a);
    }

    private void initComponents(Container pane) {

        pane.setLayout(new BorderLayout());

        contentPanel = new JPanel();
        navigationPanel = new JPanel();

        pane.add(contentPanel);
        pane.add(navigationPanel, BorderLayout.SOUTH);


        contentPanel.setLayout(new GridBagLayout());
        GridBagConstraints contentPanelGbc = new GridBagConstraints();
        infoPanel = new JPanel();
        contentPanelGbc.gridy = 0;
        contentPanel.add(infoPanel, contentPanelGbc);

        GridBagConstraints infoPanelGbc = new GridBagConstraints();
        infoPanel.setLayout(new GridBagLayout());
        infoPanelGbc.anchor = GridBagConstraints.WEST;
        infoPanelGbc.fill = GridBagConstraints.HORIZONTAL;

        infoPanelGbc.gridy = 0;
        infoPanelGbc.gridx = 0;
        infoPanel.add(new JLabel("Chosen alphabet: "), infoPanelGbc);
        chosenAlphabetTextField = new JTextField("NOT CHOSEN YET");
        chosenAlphabetTextField.setEditable(false);
        chosenAlphabetTextField.setBackground(null);
        infoPanelGbc.gridx = 1;
        infoPanel.add(chosenAlphabetTextField, infoPanelGbc);

        infoPanelGbc.gridy = 1;
        infoPanelGbc.gridx = 0;
        infoPanel.add(new JLabel("Chosen key: "), infoPanelGbc);
        chosenKeyTextField = new JTextField("NOT CHOSEN YET");
        chosenKeyTextField.setEditable(false);
        chosenKeyTextField.setBackground(null);
        infoPanelGbc.gridx = 1;
        infoPanel.add(chosenKeyTextField, infoPanelGbc);

        JPanel visualizationSettingPanel = new JPanel();
        infoPanelGbc.gridy = 2;
        infoPanelGbc.gridx = 0;
        contentPanel.add(visualizationSettingPanel, infoPanelGbc);

        visualizationSettingPanel.add(new JLabel("Visualization: "), infoPanelGbc);
        visualizationOnButton = new JRadioButton("On");
        visualizationOffButton = new JRadioButton("Off");
        visualizationOffButton.setSelected(true);
        visualizationRadioButtons = new ButtonGroup();
        visualizationRadioButtons.add(visualizationOnButton);
        visualizationRadioButtons.add(visualizationOffButton);
        infoPanelGbc.gridx = 1;
        visualizationSettingPanel.add(visualizationOnButton, infoPanelGbc);
        infoPanelGbc.gridx = 2;
        visualizationSettingPanel.add(visualizationOffButton, infoPanelGbc);

        visualizationInfoButton = createQuestionMarkButton();
        infoPanelGbc.gridx = 3;
        visualizationSettingPanel.add(visualizationInfoButton, infoPanelGbc);

        translationPanel = new JPanel();
        contentPanelGbc.gridy = 3;
        contentPanel.add(translationPanel, contentPanelGbc);

        plainTextArea = new JTextArea("Enter plain text...", 5, 20);
        cipherTextArea = new JTextArea("Enter cipher text...", 5, 20);
        encryptButton = new JButton("ENCRYPT >");
        decryptButton = new JButton("< DECRYPT");
        JScrollPane plainTextScrollPane = new JScrollPane(plainTextArea);
        JScrollPane cipherTextScrollPane = new JScrollPane(cipherTextArea);

        GridBagConstraints translationPanelGbc = new GridBagConstraints();
        translationPanelGbc.gridy = 0;
        translationPanelGbc.gridx = 0;
        translationPanel.add(plainTextScrollPane, translationPanelGbc);

        translationPanelGbc.gridy = 0;
        translationPanelGbc.gridx = 2;
        translationPanel.add(cipherTextScrollPane, translationPanelGbc);

        exitButton = createNavigationButton("Exit");
        previousButton = createNavigationButton("Previous");

        navigationPanel.setLayout(new GridLayout(1, 4));
        navigationPanel.add(exitButton);
        navigationPanel.add(new JLabel());
        navigationPanel.add(new JLabel());
        navigationPanel.add(previousButton);
    }
}
