package org.academiadecodigo.bootcamp.model.dao;

import org.academiadecodigo.bootcamp.model.Answer;

/**
 * Created by codecadet on 27/07/2017.
 */
public interface AnswerDao extends Dao<Answer> {

    public Answer findByName(String name);


}
