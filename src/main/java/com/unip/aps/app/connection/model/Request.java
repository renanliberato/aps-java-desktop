package com.unip.aps.app.connection.model;

import com.google.gson.Gson;
import com.unip.aps.app.core.AbstractEntity;

/**
 * Created on 4/5/2017.
 *
 * @author Renan Liberato Sant'Ana <renan.libsantana@gmail.com>
 */
public class Request extends AbstractEntity {

    /**
     * Representação ordinal do Enum RequestCode
     */
    private Integer code;

    /**
     * Corpo da requisição contendo o conteúdo a ser utilizado pela aplicação.
     */
    private String payload;

    public Request() {
    }

    public Request(RequestCode code, String payload) {
        this.code = code.ordinal();
        this.payload = payload;
    }

    public Request(RequestCode code) {
        this.code = code.ordinal();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getPayload() {
        return payload;
    }

    /**
     * Cria uma mensagem de uma string json
     *
     * @param json
     *
     * @return
     */
    public static Request fromJson(String json) {
        return new Gson().fromJson(json, Request.class);
    }
}
