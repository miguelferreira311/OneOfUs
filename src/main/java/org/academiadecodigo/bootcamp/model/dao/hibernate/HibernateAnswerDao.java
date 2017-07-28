package org.academiadecodigo.bootcamp.model.dao.hibernate;

import org.academiadecodigo.bootcamp.model.Answer;
import org.academiadecodigo.bootcamp.model.KeyWord;
import org.academiadecodigo.bootcamp.model.dao.AnswerDao;
import org.academiadecodigo.bootcamp.persistence.TransactionException;
import org.academiadecodigo.bootcamp.persistence.hibernate.HibernateSessionManager;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by codecadet on 27/07/2017.
 */
public class HibernateAnswerDao extends HibernateDao<Answer> implements AnswerDao {

    public HibernateAnswerDao() {
        super(Answer.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Answer> findByKeyId(KeyWord key) {

        try {
            Session session = HibernateSessionManager.getSession();

            List<Answer> list = session.createCriteria(Answer.class)
                    .add(Restrictions.eq("keyWord", key)).list();

            return list;

        } catch (HibernateException ex) {
            throw new TransactionException(ex);
        }

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Answer> findAll() {
        try {
            Session session = HibernateSessionManager.getSession();

            Query query = session.createQuery("from answers");

            return query.list();

        }catch (HibernateException ex){
            throw new TransactionException(ex);
        }
    }
}
