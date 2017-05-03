package com.unip.aps.app.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created on 3/5/2017.
 *
 * @author Renan Liberato Sant'Ana <renan.libsantana@gmail.com>
 */
public class ConnectionHandler {

    private static Socket connection;
    private static PrintStream requestStream;
    private static InputStream responseStream;


    /**
     * Encerra a conexão com o servidor e os Streams relacionados.
     * @throws IOException
     */
    public static void closeConnection() throws IOException {
        requestStream.close();
        responseStream.close();
        connection.close();
    }

    /**
     * Inicializa uma nova conexão com o servidor e inicia uma nova Thread para recebimento de mensagens.
     *
     * @param host String com o IP do host
     * @param port Integer com a porta para se conectar no servidor.
     *
     * @throws IOException
     */
    public static void newConnection(String host, Integer port) throws IOException {
        connection = new Socket(host, port);

        requestStream = new PrintStream(connection.getOutputStream());
        responseStream = connection.getInputStream();

        // thread para receber mensagens do servidor
        Recebedor r = new Recebedor(responseStream);
        new Thread(r).start();

    }

    public static Socket getConnection() {
        return connection;
    }

    public static PrintStream getRequestStream() {
        return requestStream;
    }
}
