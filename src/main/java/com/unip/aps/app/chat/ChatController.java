package com.unip.aps.app.chat;

import com.unip.aps.app.App;
import com.unip.aps.app.alert.ErrorDialog;
import com.unip.aps.app.chat.model.Message;
import com.unip.aps.app.connection.model.Request;
import com.unip.aps.app.connection.model.RequestCode;
import com.unip.aps.app.connection.model.User;
import com.unip.aps.app.connection.Connection;
import com.unip.aps.app.service.ConnectionHandler;
import com.unip.aps.app.service.Enviador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.List;
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

    private static ObservableList<Message> messageList = FXCollections.observableArrayList();

    @FXML
    private TextField messageField;

    @FXML
    private Button sendButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Request request = new Request(RequestCode.MESSAGE_LIST);
        Enviador.send(request);

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
                if(message.getUsername().equals(User.getUsername())) {
                    getStyleClass().add("self-message");
                    setAlignment(Pos.CENTER_RIGHT);
                } else {
                    getStyleClass().add("partner-message");
                    setAlignment(Pos.CENTER_LEFT);
                }
            }
        });

        connectionLabel.setText("Connection with " + ConnectionHandler.getConnection().getInetAddress());
    }

    @FXML
    public void disconnectButtonAction(ActionEvent event) {
        try {
            ConnectionHandler.closeConnection();
            new Connection().start(App.getStage());
        } catch (IOException e) {
            ErrorDialog.fire();
        }
    }

    @FXML
    public void sendButtonAction(ActionEvent event) {
        String message = messageField.getText();
        Enviador.send(new Message(message));
    }

    /**
     * Adiciona a mensagem passada na ObservableList.
     *
     * @param message
     */
    public static void addMessage(Message message) {
        messageList.add(message);
    }

    /**
     * Limpa a lista de mensagens e popula o chat com uma nova lista.
     *
     * @param newList
     */
    public static void populateMessageList(List<Message> newList) {
        messageList.clear();
        messageList.addAll(newList);
    }
}
