package org.academiadecodigo.bootcamp.model.dao;

/**
 * Created by codecadet on 27/07/2017.
 */
public interface Dao <T> {


    void add(T element);

    void remove(T element);

    T findById(int id);

    int count();


}
