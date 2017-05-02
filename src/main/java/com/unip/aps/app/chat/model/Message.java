package com.unip.aps.app.chat.model;

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

    private Boolean self = false;

    public Message(String text) {
        this.text = text;
    }

    public Message(String text, Boolean self) {
        this.text = text;
        this.self = self;
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

    public Boolean isSelf() {
        return self;
    }

    public void setSelf(Boolean self) {
        this.self = self;
    }
}
