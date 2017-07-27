package org.academiadecodigo.bootcamp.persistence;

/**
 * Created by codecadet on 27/07/2017.
 */
public interface TransactionManager {


    void beginTransaction();

    void commitTransaction();

    void rollbackTransaction();


}
