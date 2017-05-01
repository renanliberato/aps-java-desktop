package com.unip.aps.chat;

import java.io.IOException;

/**
 * Created by gabri on 01/05/2017.
 */
public class ServidorApp {
    public static void main(String[] args) throws IOException {
        new Servidor(666).executa();
    }
}
