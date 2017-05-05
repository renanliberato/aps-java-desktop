package com.unip.aps.app.service;

import com.unip.aps.app.chat.ChatController;
import com.unip.aps.app.chat.model.Message;
import com.unip.aps.app.connection.model.Request;
import javafx.application.Platform;

/**
 * Created on 5/5/2017.
 *
 * @author Renan Liberato Sant'Ana <renan.libsantana@gmail.com>
 */
public class MessageRequestHandler {

    /**
     * Adiciona a mensagem à lista da view.
     *
     * @param request
     */
    public void execute(Request request) {

        Platform.runLater(() -> ChatController.addMessage(
                Message.fromJson(request.getPayload())
        ));
    }
}
