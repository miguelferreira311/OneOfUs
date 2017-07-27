package org.academiadecodigo.bootcamp.model;

/**
 * Created by codecadet on 27/07/2017.
 */
public class Answer {


    private int id;
    private String sentence;
    private KeyWord keyWordId;

    public Answer() {
    }

    public Answer(String sentence, KeyWord keyWordId) {
        this.sentence = sentence;
        this.keyWordId = keyWordId;
    }

    public KeyWord getKeyWordId() {
        return keyWordId;
    }

    public void setKeyWordId(KeyWord keyWordId) {
        this.keyWordId = keyWordId;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
