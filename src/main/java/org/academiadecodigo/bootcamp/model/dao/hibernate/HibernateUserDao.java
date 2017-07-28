package org.academiadecodigo.bootcamp.model.dao.hibernate;

import org.academiadecodigo.bootcamp.model.Role;
import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.model.dao.UserDao;
import org.academiadecodigo.bootcamp.persistence.TransactionException;
import org.academiadecodigo.bootcamp.persistence.hibernate.HibernateSessionManager;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class HibernateUserDao extends HibernateDao<User> implements UserDao{

    public HibernateUserDao() {
        super(User.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public User findByName(String name) {
        try {
            Session session = HibernateSessionManager.getSession();

            List<User> list = session.createCriteria(User.class)
                    .add(Restrictions.like("name", name)).list();

            return list.size() != 0 ? list.get(0) : null;

        } catch (HibernateException ex) {
            throw new TransactionException(ex);
        }
    }

}
