package org.academiadecodigo.bootcamp.model;

/**
 * Created by codecadet on 27/07/2017.
 */
public class DefaultAnswer {

    private int id;

    private String sentence;


    public DefaultAnswer() {
    }

    public DefaultAnswer(String sentence) {
        this.sentence = sentence;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
}
