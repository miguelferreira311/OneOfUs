package org.academiadecodigo.bootcamp.model.dao.hibernate;

import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.model.dao.UserDao;

public class HibernateUserDao extends HibernateDao<User> implements UserDao{

    public HibernateUserDao() {
        super(User.class);
    }

    @Override
    public User findByName(String name) {
        return null;
    }

    @Override
    public void setAdmin(User user) {


    }
}
