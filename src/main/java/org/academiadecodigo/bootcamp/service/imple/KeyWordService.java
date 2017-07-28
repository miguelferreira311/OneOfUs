package org.academiadecodigo.bootcamp.service.imple;

import org.academiadecodigo.bootcamp.model.KeyWord;
import org.academiadecodigo.bootcamp.model.dao.KeyWordDao;
import org.academiadecodigo.bootcamp.persistence.TransactionException;
import org.academiadecodigo.bootcamp.persistence.TransactionManager;
import org.academiadecodigo.bootcamp.service.Service;

import java.util.List;

/**
 * Created by codecadet on 27/07/2017.
 */
public class KeyWordService implements Service{

    private KeyWordDao keyWordDao;
    private TransactionManager transactionManager;


    public KeyWordService(KeyWordDao keyWordDao, TransactionManager transactionManager) {
        this.keyWordDao = keyWordDao;
        this.transactionManager = transactionManager;
    }


    public void addKeyWord(KeyWord word) {

        try {

            transactionManager.beginTransaction();

            if (keyWordDao.findByWord(word.getWord()) != null) {
                transactionManager.commitTransaction();
                return;
            }

            keyWordDao.save(word);

            transactionManager.commitTransaction();

        } catch (TransactionException ex) {

            System.out.println(ex.getMessage());
            transactionManager.rollbackTransaction();
        }


    }


    public void removeKeyWord(KeyWord word) {

        try {

            transactionManager.beginTransaction();

            if (keyWordDao.findByWord(word.getWord()) == null) {
                transactionManager.commitTransaction();
                return;
            }

            keyWordDao.remove(word);

            transactionManager.commitTransaction();

        } catch (TransactionException ex) {

            System.out.println(ex.getMessage());
            transactionManager.rollbackTransaction();
        }

    }


    public List<KeyWord> findAll() {


        try {

            transactionManager.beginTransaction();

            List<KeyWord> list = keyWordDao.findAll();

            transactionManager.commitTransaction();

            return list;

        } catch (TransactionException ex) {

            System.out.println(ex.getMessage());
            transactionManager.rollbackTransaction();
        }

        return null;
    }


    @Override
    public String getServiceName() {
        return KeyWordService.class.getSimpleName();
    }
}
