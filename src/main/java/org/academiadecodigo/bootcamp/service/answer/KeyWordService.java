package org.academiadecodigo.bootcamp.service.answer;

import org.academiadecodigo.bootcamp.model.KeyWord;
import org.academiadecodigo.bootcamp.model.dao.KeyWordDao;
import org.academiadecodigo.bootcamp.persistence.TransactionException;
import org.academiadecodigo.bootcamp.persistence.TransactionManager;

import java.util.List;

/**
 * Created by codecadet on 27/07/2017.
 */
public class KeyWordService {

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

            keyWordDao.add(word);

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


}
