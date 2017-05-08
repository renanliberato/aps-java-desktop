package com.unip.aps.app.alert;

import javafx.scene.control.Alert;

/**
 * Error dialog that can be used to communicate the user something went wrong.
 *
 * @author Renan Liberato Sant'Ana <renan.libsantana@gmail.com>
 */
public class FieldDialog extends Alert {

    public static String EMPTY = "is empty.";
    public static String INVALID = "is invalid.";

    public FieldDialog(String field, String condition) {
        super(AlertType.ERROR);

        setTitle("Empty field");
        setHeaderText("The field " + field + " " + condition);
        setContentText("Please, fill the " + field + " field correctly to continue.");

        show();
    }

    public static void fire(String field, String condition) {
        new FieldDialog(field, condition);
    }
}
