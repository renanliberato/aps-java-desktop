package com.unip.aps.app.alert;

import javafx.scene.control.Alert;

/**
 * Flexible message dialog that can be used to communicate with the user.
 *
 * @author Renan Liberato Sant'Ana <renan.libsantana@gmail.com>
 */
public class LostConnectionDialog extends Alert {

    public LostConnectionDialog() {
        super(AlertType.INFORMATION);

        setTitle("Connection lost.");
        setHeaderText("The application lost connection with the server.");
        setContentText("Please, try to connect again and contact the system administrator for more information if the error persists.");
        show();
    }

    public static void fire() {
        new LostConnectionDialog();
    }
}
