package com.github.client.view;

import javax.swing.*;

/**
 * ButtonFactory class helps construct uniform buttons.
 */
public class ButtonFactory {

    private static final String QMARK_DEFAULT = "/icons/button_question_mark_default_18x18.png";
    private static final String QMARK_ROLLOVER = "/icons/button_question_mark_rollover_18x18.png";
    private static final String QMARK_PRESSED = "/icons/button_question_mark_pressed_18x18.png";

    private ButtonFactory() {

    }

    public static JButton createQuestionMarkButton() {

        ImageIcon icon;
        JButton button = new JButton();
        icon = findImage(QMARK_DEFAULT);
        button.setIcon(icon);
        icon = findImage(QMARK_ROLLOVER);
        button.setRolloverIcon(icon);
        icon = findImage(QMARK_PRESSED);
        button.setPressedIcon(icon);
        return button;
    }

    private static ImageIcon findImage(String path) {

        ImageIcon icon = null;

        try {

            icon = new ImageIcon(ButtonFactory.class.getResource(path));

        } catch(Exception e) {

            System.out.println(
                "Error finding image on path " + "'" + path + "'" + ": " + e.getMessage());
        }

        return icon;
    }
}
