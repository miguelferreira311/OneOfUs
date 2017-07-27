package org.academiadecodigo.bootcamp.model.dao;

import org.academiadecodigo.bootcamp.model.KeyWord;

public interface KeyWordDao extends Dao<KeyWord> {

    public KeyWord findByWord(String word);
}
