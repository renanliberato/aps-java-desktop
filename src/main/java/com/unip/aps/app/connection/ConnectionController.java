package com.unip.aps.app.connection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Connection controller.
 *
 * @author Renan Liberato Sant'Ana <renan.libsantana@gmail.com>
 */
public class ConnectionController implements Initializable {

    @FXML
    private TextField targetField;

    @FXML
    private Button connectButton;

    public void initialize(URL location, ResourceBundle resources) {

    }

    /**
     * Action performed when the user clicks the connect button.
     * Is responsible to send a connection request to the target.
     */
    @FXML
    private void connectButtonAction(ActionEvent event) {
    }
}
