package com.unip.aps.app.chat.model;

import com.google.gson.Gson;
import com.unip.aps.app.connection.model.User;
import com.unip.aps.app.core.AbstractEntity;

/**
 * Created on 12/4/2017.
 *
 * @author Renan Liberato Sant'Ana <renan.libsantana@gmail.com>
 */
public class Message extends AbstractEntity {

    private Integer id;

    private String text;

    private String username;

    public Message(String text, String username) {
        this.text = text;
        this.username = username;
    }

    public Message(String text) {
        this.text = text;
        this.username = User.getUsername();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Cria uma mensagem de uma string json
     *
     * @param json
     *
     * @return
     */
    public static Message fromJson(String json) {
        return new Gson().fromJson(json, Message.class);
    }
}
