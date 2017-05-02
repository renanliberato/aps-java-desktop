package com.unip.aps.app.alert;

import javafx.scene.control.Alert;

/**
 * Error dialog that can be used to communicate the user something went wrong.
 *
 * @author Renan Liberato Sant'Ana <renan.libsantana@gmail.com>
 */
public class ErrorDialog extends Alert {

    public ErrorDialog() {
        super(Alert.AlertType.ERROR);

        setTitle("Operation failed.");
        setHeaderText("The application stopped working.");
        setContentText("Please, contact the system administrator for more information.");
        show();
    }
}
