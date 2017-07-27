package org.academiadecodigo.bootcamp.model.dao.hibernate;

import org.academiadecodigo.bootcamp.model.Answer;
import org.academiadecodigo.bootcamp.model.DefaultAnswer;
import org.academiadecodigo.bootcamp.model.dao.Dao;
import org.academiadecodigo.bootcamp.persistence.TransactionException;
import org.academiadecodigo.bootcamp.persistence.hibernate.HibernateSessionManager;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by codecadet on 27/07/2017.
 */
public class HibernateDefaultAnswerDao extends HibernateDao<DefaultAnswer> implements Dao<DefaultAnswer> {

    public HibernateDefaultAnswerDao() {
        super(DefaultAnswer.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<DefaultAnswer> findAll() {

        try {
            Session session = HibernateSessionManager.getSession();

            Query query = session.createQuery("from default");

            return query.list();

        } catch (HibernateException ex) {
            throw new TransactionException(ex);
        }
    }
}
