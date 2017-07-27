package org.academiadecodigo.bootcamp.model.dao.hibernate;

import org.academiadecodigo.bootcamp.model.KeyWord;
import org.academiadecodigo.bootcamp.model.dao.KeyWordDao;
import org.academiadecodigo.bootcamp.persistence.TransactionException;
import org.academiadecodigo.bootcamp.persistence.hibernate.HibernateSessionManager;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by codecadet on 27/07/2017.
 */
public class HibernateKeyWordDao extends HibernateDao<KeyWord> implements KeyWordDao {

    public HibernateKeyWordDao() {
        super(KeyWord.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public KeyWord findByWord(String word) {

        try {
            Session session = HibernateSessionManager.getSession();

            List<KeyWord> list = session.createCriteria(KeyWord.class)
                    .add(Restrictions.eq("word", word)).list();

            return list.size() != 0 ? list.get(0) : null;

        } catch (HibernateException ex) {
            throw new TransactionException(ex);
        }

    }


    @SuppressWarnings("unchecked")
    @Override
    public List<KeyWord> findAll() {

        try {
            Session session = HibernateSessionManager.getSession();

            Query query = null ;//= session.createQuery("from keywords");

            return query.list();

        } catch (HibernateException ex) {
            throw new TransactionException(ex);
        }
    }
}
