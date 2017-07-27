package org.academiadecodigo.bootcamp.model.dao;

import org.academiadecodigo.bootcamp.model.KeyWord;

/**
 * Created by codecadet on 27/07/2017.
 */
public interface KeyWordDao extends Dao<KeyWord> {



    public KeyWord findByName(String name);
}
