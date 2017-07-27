package org.academiadecodigo.bootcamp.model;

/**
 * Created by codecadet on 27/07/2017.
 */
public class Answer {


    private int id;
    private String sentence;
    private Integer keyWordId;
    private String soundFile;


    public Answer() {
    }

    public Answer(String sentence, Integer keyWordId) {
        this.sentence = sentence;
        this.keyWordId = keyWordId;
    }

    public Answer(String sentence, Integer keyWordId, String soundFile) {
        this.sentence = sentence;
        this.keyWordId = keyWordId;
        this.soundFile = soundFile;
    }



    public Integer getKeyWordId() {
        return keyWordId;
    }

    public void setKeyWordId(Integer keyWordId) {
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

    public String getSoundFile() {
        return soundFile;
    }

    public void setSoundFile(String soundFile) {
        this.soundFile = soundFile;
    }
}
