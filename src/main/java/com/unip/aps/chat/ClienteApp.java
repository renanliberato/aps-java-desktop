package com.unip.aps.chat;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by gabri on 01/05/2017.
 */
public class ClienteApp {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Scanner scanner = new Scanner(System.in);
        String ip = scanner.next();

        // dispara cliente
        new Cliente(ip, 666).executa();
    }
}