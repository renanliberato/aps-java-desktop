package com.unip.aps.app.alert;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

/**
 * @author Renan Liberato Sant'Ana <renan.libsantana@gmail.com>
 */
public class ConnectionDialog extends Alert {

    public ConnectionDialog() {
        super(AlertType.CONFIRMATION);

        initialize();
    }

    private void initialize() {
        setTitle("Incoming connection");
        //@TODO Dinamic IP.
        setContentText("Connection from 192.168.0.100:7000");

        ButtonType acceptButton  = new ButtonType("Accept");
        ButtonType declineButton = new ButtonType("Decline");

        getButtonTypes().setAll(acceptButton, declineButton);

        Optional<ButtonType> result = showAndWait();

        if (result.get() == acceptButton) {
            // @TODO Accepted action.
        } else {
            // @TODO Not accepted action.
        }
    }
}
