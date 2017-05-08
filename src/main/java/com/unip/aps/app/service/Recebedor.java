package com.unip.aps.app.service;

import com.unip.aps.app.App;
import com.unip.aps.app.alert.LostConnectionDialog;
import com.unip.aps.app.connection.Connection;
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

        RequestFilter filter = new RequestFilter();

        while (s.hasNextLine()) {
            String requestBody = s.nextLine();

            filter.filter(requestBody);
        }

        Platform.runLater(() -> {
            LostConnectionDialog.fire();
            Connection  connection = new Connection();
            connection.start(App.getStage());
        });
    }
}
