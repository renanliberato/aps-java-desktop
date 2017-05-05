package com.unip.aps.app.connection.model;

/**
 * Created on 3/5/2017.
 *
 * @author Renan Liberato Sant'Ana <renan.libsantana@gmail.com>
 */
public class User {

    /**
     * Username do usuário que deve ficar disponível para uso pelo recurso de chat.
     */
    private static String username;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        User.username = username;
    }
}
