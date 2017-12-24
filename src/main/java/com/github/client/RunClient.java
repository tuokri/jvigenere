package com.github.client;

import com.github.client.model.Model;
import com.github.client.view.View;

import javax.swing.*;

public class RunClient {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                Model model = new Model();
                View view = new View(model, "Vigenecryptor");
            }
        });
    }
}
