package org.academiadecodigo.bootcamp.model.dao;

import java.util.List;

/**
 * Created by codecadet on 27/07/2017.
 */
public interface Dao<T> {


    void add(T element);

    void remove(T element);

    T findById(int id);

    List<T> findAll(long min, long max);

    long count();


}
