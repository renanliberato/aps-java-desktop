package com.unip.aps.app.connection;

import com.unip.aps.app.App;
import com.unip.aps.app.alert.ConnectionErrorDialog;
import com.unip.aps.app.alert.FieldDialog;
import com.unip.aps.app.chat.Chat;
import com.unip.aps.app.connection.model.User;
import com.unip.aps.app.service.ConnectionHandler;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
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
    private TextField usernameField;

    @FXML
    private Button connectButton;

    @FXML
    public void checkEnterPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            connectButton.fire();
        }
    }

    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> usernameField.requestFocus());
    }

    /**
     * Action performed when the user clicks the connect button.
     * Is responsible to send a connection request to the target.
     */
    @FXML
    private void connectButtonAction(ActionEvent event) {
        try {
            String username = usernameField.getText();

            if (username.equals("")) {
                FieldDialog.fire("Username", FieldDialog.EMPTY);
                return;
            }

            User.setUsername(username);

            String targetText = targetField.getText();
            String[] ipAndPort = targetText.split(":");

            if (ipAndPort.length != 2) {
                FieldDialog.fire("Connection Address", FieldDialog.INVALID);
                return;
            }

            ConnectionHandler.newConnection(ipAndPort[0], Integer.valueOf(ipAndPort[1]));
            new Chat().start(App.getStage());
        } catch (IOException e) {
            ConnectionErrorDialog.fire();
        }
    }
}
