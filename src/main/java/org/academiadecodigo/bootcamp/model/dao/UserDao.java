package org.academiadecodigo.bootcamp.model.dao;


import org.academiadecodigo.bootcamp.model.User;

public interface UserDao extends Dao<User> {

    User findByName(String name);

}
