package org.academiadecodigo.bootcamp.model.dao.hibernate;

import org.academiadecodigo.bootcamp.model.KeyWord;
import org.academiadecodigo.bootcamp.model.Quote;
import org.academiadecodigo.bootcamp.persistence.TransactionException;
import org.academiadecodigo.bootcamp.persistence.hibernate.HibernateSessionManager;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by codecadet on 27/07/17.
 */
public class HibernateQuoteDao extends HibernateDao<Quote> {


    public HibernateQuoteDao() {
        super(Quote.class);
    }

    @Override
    public List<Quote> findAll() {

        try {
            Session session = HibernateSessionManager.getSession();

            Query query = session.createQuery("from quotes");

            return query.list();

        } catch (HibernateException ex) {
            throw new TransactionException(ex);
        }

    }
}
