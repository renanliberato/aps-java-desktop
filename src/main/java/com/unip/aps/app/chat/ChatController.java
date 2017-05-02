package com.unip.aps.app.chat;

import com.unip.aps.app.chat.model.Message;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;

import java.net.URL;
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
    private ListView<Message> chatListView;

    private ObservableList<Message> messageList = FXCollections.observableArrayList();

    @FXML
    private TextField messageField;

    @FXML
    private Button sendButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        chatListView.setItems(messageList);
        chatListView.setCellFactory((ListView<Message> messageListView) -> new ListCell<Message>(){
            @Override
            protected void updateItem(Message message, boolean empty) {
                super.updateItem(message, empty);

                getStyleClass().remove("partner-message");
                getStyleClass().remove("self-message");

                if (empty) {
                    setText(null);
                    return;
                }

                setText(message.getText());
                if(message.isSelf()) {
                    getStyleClass().add("self-message");
                    setAlignment(Pos.CENTER_RIGHT);
                } else {
                    getStyleClass().add("partner-message");
                    setAlignment(Pos.CENTER_LEFT);
                }
            }
        });


    }

    @FXML
    public void disconnectButtonAction(ActionEvent event) {

    }

    @FXML
    public void sendButtonAction(ActionEvent event) {
        String message = messageField.getText();
        messageList.add(new Message(message, true));
    }
}
