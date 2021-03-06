package org.academiadecodigo.bootcamp.model.dao.hibernate;

import org.academiadecodigo.bootcamp.model.dao.Dao;
import org.academiadecodigo.bootcamp.persistence.TransactionException;
import org.academiadecodigo.bootcamp.persistence.hibernate.HibernateSessionManager;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by codecadet on 25/07/2017.
 */
public abstract class HibernateDao<T> implements Dao<T> {

    Class<T> cls;

    public HibernateDao(Class<T> cls) {
        this.cls = cls;
    }

    @Override
    public void save(T element) {

        try {
            Session session = HibernateSessionManager.getSession();

            session.saveOrUpdate(element);

        }catch (HibernateException ex){
            throw new TransactionException(ex);
        }
    }


    @Override
    public void remove(T element) {

        try{
          Session session = HibernateSessionManager.getSession();

          session.delete(element);

        } catch (HibernateException ex){
            throw new TransactionException(ex);
        }

    }

    @Override
    public T findById(int id) {

        try {
            Session session = HibernateSessionManager.getSession();

            Criteria criteria = session.createCriteria(cls)
                    .add(Restrictions.eq("id", id));

            return (T) criteria.uniqueResult();

        }catch (HibernateException ex){
            throw new TransactionException(ex);
        }

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAll() {
        try {
            return HibernateSessionManager.getSession().createCriteria(cls).list();
        } catch (HibernateException ex) {
            throw new TransactionException(ex);
        }
    }

    @Override
    public long count() {
        try {
            Session session = HibernateSessionManager.getSession();

            Criteria criteria = session.createCriteria(cls)
                    .setProjection(Projections.rowCount());

            return (long) criteria.uniqueResult();

        }catch (HibernateException ex){
            throw new TransactionException(ex);
        }
    }

}
