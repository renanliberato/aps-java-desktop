package com.unip.aps.app.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.unip.aps.app.chat.ChatController;
import com.unip.aps.app.chat.model.Message;
import com.unip.aps.app.connection.model.Request;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created on 5/5/2017.
 *
 * @author Renan Liberato Sant'Ana <renan.libsantana@gmail.com>
 */
public class MessageListRequestHandler {

    /**
     * Recupera a lista de mensagens do corpo da requisição e popula a view.
     *
     * @param request
     */
    public void execute(Request request) {
        Type type = new TypeToken<List<Message>>(){}.getType();
        List<Message> messageList = new Gson().fromJson(request.getPayload(), type);

        ChatController.populateMessageList(messageList);
    }
}
