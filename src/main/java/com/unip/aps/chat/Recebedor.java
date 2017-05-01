package com.unip.aps.chat;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by gabri on 01/05/2017.
 */
public class Recebedor implements Runnable {

    private InputStream servidor;

    public Recebedor(InputStream servidor) {
        this.servidor = servidor;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        Scanner s = new Scanner(this.servidor);

        while (s.hasNextLine()) {
            System.out.println(s.nextLine());
        }
    }
}
