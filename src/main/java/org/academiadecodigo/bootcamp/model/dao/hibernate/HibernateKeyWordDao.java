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

    @Override
    public KeyWord findByWord(String name) {


        return null;
    }

    @Override
    public List<KeyWord> findAll(long min, long max) {

        try {
            Session session = HibernateSessionManager.getSession();

            Query query = session.createQuery("from " + KeyWord);
            objects = query.list();


        }catch (HibernateException ex){
            throw new TransactionException(ex);
        }
        return null;
    }
}
