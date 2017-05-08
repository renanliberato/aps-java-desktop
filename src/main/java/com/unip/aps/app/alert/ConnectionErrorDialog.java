package com.unip.aps.app.alert;

import javafx.scene.control.Alert;

/**
 * Flexible message dialog that can be used to communicate with the user.
 *
 * @author Renan Liberato Sant'Ana <renan.libsantana@gmail.com>
 */
public class ConnectionErrorDialog extends Alert {

    public ConnectionErrorDialog() {
        super(AlertType.ERROR);

        setTitle("Connection failed.");
        setHeaderText("The application could not connect to the server.");
        setContentText("Please, try to connect again later or contact the system administrator for more information.");
        show();
    }

    public static void fire() {
        new ConnectionErrorDialog();
    }
}
