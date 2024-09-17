package br.com.suzintech.pokeclick.api.response;

import java.io.Serializable;
import java.util.List;

public class Ataque implements Serializable {

    private List<String> cost;
    private String name;
    private String text;
    private int convertedEnergyCost;

    public List<String> getCost() {
        return cost;
    }

    public void setCost(List<String> cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getConvertedEnergyCost() {
        return convertedEnergyCost;
    }

    public void setConvertedEnergyCost(int convertedEnergyCost) {
        this.convertedEnergyCost = convertedEnergyCost;
    }
}
