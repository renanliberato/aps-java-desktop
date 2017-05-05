package com.unip.aps.app.service;

import com.unip.aps.app.connection.model.Request;
import com.unip.aps.app.connection.model.RequestCode;

/**
 * Created on 4/5/2017.
 *
 * @author Renan Liberato Sant'Ana <renan.libsantana@gmail.com>
 */
public class RequestFilter {

    /**
     * Filtra a requisição vinda do servidor para o devido interpretador do cliente.
     *
     * @param requestBody
     */
    public void filter(String requestBody) {
        Request request = Request.fromJson(requestBody);
        RequestCode requestCode = RequestCode.fromInteger(request.getCode());
        switch (requestCode) {
            case MESSAGE:
                MessageRequestHandler messageRequestHandler = new MessageRequestHandler();
                messageRequestHandler.execute(request);
                break;
            case MESSAGE_LIST:
                MessageListRequestHandler messageListRequestHandler = new MessageListRequestHandler();
                messageListRequestHandler.execute(request);
                break;
        }
    }
}
