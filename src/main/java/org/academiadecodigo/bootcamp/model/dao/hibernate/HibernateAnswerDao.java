package org.academiadecodigo.bootcamp.model.dao.hibernate;

import org.academiadecodigo.bootcamp.model.Answer;
import org.academiadecodigo.bootcamp.model.dao.AnswerDao;

import java.util.List;

/**
 * Created by codecadet on 27/07/2017.
 */
public class HibernateAnswerDao extends HibernateDao<Answer> implements AnswerDao {

    public HibernateAnswerDao() {
        super(Answer.class);
    }

    @Override
    public Answer findByName(String name) {


        return null;
    }

    @Override
    public Answer findByKeyId(Integer keyId) {
        return null;
    }

    @Override
    public List<Answer> findAll(long min, long max) {
        return null;
    }
}
