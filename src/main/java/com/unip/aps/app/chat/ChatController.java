package com.unip.aps.app.chat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created on 21/3/2017.
 *
 * @author Renan Liberato Sant'Ana <renan.libsantana@gmail.com>
 */
public class ChatController implements Initializable {

    @FXML
    private Button disconnectButton;

    @FXML
    private Label connectionLabel;

    @FXML
    private ListView chatListView;

    private ObservableList<String> messageList = FXCollections.observableArrayList();

    @FXML
    private TextField messageField;

    @FXML
    private Button sendButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        chatListView.setItems(messageList);
    }

    @FXML
    public void disconnectButtonAction(ActionEvent event) {
    }

    @FXML
    public void sendButtonAction(ActionEvent event) {
        String message = messageField.getText();
        messageList.add(message);
    }
}
