package org.academiadecodigo.bootcamp.model;

/**
 * Created by codecadet on 27/07/2017.
 */
public class Answer {


    private int id;
    private String sentence;
    private KeyWord keyWord;
    private String soundFile;


    public Answer() {
    }

    public Answer(String sentence, KeyWord keyWord) {
        this.sentence = sentence;
        this.keyWord = keyWord;
    }

    public Answer(String sentence, KeyWord keyWord, String soundFile) {
        this.sentence = sentence;
        this.keyWord = keyWord;
        this.soundFile = soundFile;
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

    public KeyWord getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(KeyWord keyWordId) {
        this.keyWord = keyWordId;
    }

    public String getSoundFile() {
        return soundFile;
    }

    public void setSoundFile(String soundFile) {
        this.soundFile = soundFile;
    }



}

