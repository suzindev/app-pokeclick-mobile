package br.com.suzintech.pokeclick.api.response;

import java.io.Serializable;

public class Fraqueza implements Serializable {

    private String type;
    private String value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
