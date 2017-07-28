package org.academiadecodigo.bootcamp.service.imple;

import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.model.dao.RoleDao;
import org.academiadecodigo.bootcamp.model.dao.UserDao;
import org.academiadecodigo.bootcamp.persistence.TransactionException;
import org.academiadecodigo.bootcamp.persistence.TransactionManager;
import org.academiadecodigo.bootcamp.service.Service;

public class UserService implements Service {

    private UserDao userDao;
    private RoleDao roleDao;
    private TransactionManager manager;

    public UserService(UserDao userDao, RoleDao roleDao, TransactionManager manager) {
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.manager = manager;
    }

    @Override
    public String getServiceName() {
        return UserService.class.getSimpleName();
    }

    public User findByName(String name) {

        try {

            manager.beginTransaction();

            User user = userDao.findByName(name);

            manager.commitTransaction();

            return user;

        } catch (TransactionException ex) {

            System.out.println(ex.getMessage());
            manager.rollbackTransaction();
        }

        return null;
    }

    public void saveOrUpdateUser(User user) {

        try {

            manager.beginTransaction();

            userDao.save(user);

            manager.commitTransaction();

        } catch (TransactionException ex) {

            System.out.println(ex.getMessage());
            manager.rollbackTransaction();
        }
    }


    public boolean autenticate(String name, String password) {

        try {

            manager.beginTransaction();

            User user = userDao.findByName(name);

            manager.commitTransaction();

            if (user == null) {
                return false;
            }

            if (user.getPassword().equals(password)) {
                return true;
            }

        } catch (TransactionException ex) {

            System.out.println(ex.getMessage());
            manager.rollbackTransaction();
        }

        return false;
    }


}
