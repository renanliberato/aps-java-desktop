package com.unip.aps.app.service;

import com.unip.aps.app.chat.model.Message;
import com.unip.aps.app.connection.model.Request;
import com.unip.aps.app.connection.model.RequestCode;

import java.io.PrintStream;

/**
 * Created on 3/5/2017.
 *
 * @author Renan Liberato Sant'Ana <renan.libsantana@gmail.com>
 */
public class Enviador {

    /**
     * Utiliza do serviço para envio da mensagem para o servidor pelo PrintStream.
     *
     * @param message Mensagem que deve ser enviada para o servidor.
     */
    public static void send(Message message) {
        PrintStream stream = ConnectionHandler.getRequestStream();

        Request request = new Request(RequestCode.MESSAGE, message.toJson());

        stream.println(request.toJson());
    }

    /**
     * Envia o json da request para o servidor.
     *
     * @param request
     */
    public static void send(Request request) {
        PrintStream stream = ConnectionHandler.getRequestStream();
        stream.println(request.toJson());
    }
}
