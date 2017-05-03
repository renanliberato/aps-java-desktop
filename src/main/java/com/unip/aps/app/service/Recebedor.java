package com.unip.aps.app.service;

import com.unip.aps.app.chat.ChatController;
import com.unip.aps.app.chat.model.Message;
import javafx.application.Platform;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by gabri on 01/05/2017.
 */
public class Recebedor implements Runnable {

    /**
     * InputStream que receberá as mensagens enviadas para o cliente.
     */
    private InputStream responseStream;

    public Recebedor(InputStream responseStream) {
        this.responseStream = responseStream;
    }

    /**
     * Inicia um loop pelo 'hasNextLine' aguardando por novas mensagens para o cliente. Ao chegar
     * executa o método ChatController.addMessage na Thread do JavaFX (Thread da view).
     */
    @Override
    public void run() {
        // TODO Auto-generated method stub
        Scanner s = new Scanner(this.responseStream);

        while (s.hasNextLine()) {
            String message = s.nextLine();
            Platform.runLater(() -> ChatController.addMessage(
                new Message(message)
            ));
        }
    }
}
