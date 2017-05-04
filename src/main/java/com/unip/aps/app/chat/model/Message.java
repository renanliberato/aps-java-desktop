package com.unip.aps.app.chat.model;

import com.google.gson.Gson;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created on 12/4/2017.
 *
 * @author Renan Liberato Sant'Ana <renan.libsantana@gmail.com>
 */
@Entity
public class Message {

    @Id
    @GeneratedValue
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
     * @return Uma string json com as propriedades do objeto que possuem valor.
     * Ex: {text : "Olá", username : "josecouves"}
     */
    public String toJson() {
        return new Gson().toJson(this);
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
