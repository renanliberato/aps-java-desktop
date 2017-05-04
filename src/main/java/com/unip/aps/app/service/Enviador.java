package com.unip.aps.app.service;

import com.unip.aps.app.chat.model.Message;

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

        stream.println(message.toJson());
    }
}
