package org.academiadecodigo.bootcamp.service.answer;

import org.academiadecodigo.bootcamp.model.Answer;
import org.academiadecodigo.bootcamp.model.dao.AnswerDao;
import org.academiadecodigo.bootcamp.persistence.TransactionException;
import org.academiadecodigo.bootcamp.persistence.TransactionManager;

import java.util.List;

/**
 * Created by codecadet on 27/07/2017.
 */
public class AnswerService {

    private AnswerDao answerDao;
    private TransactionManager transactionManager;


    public AnswerService(AnswerDao answerDao, TransactionManager transactionManager) {
        this.answerDao = answerDao;
        this.transactionManager = transactionManager;
    }


    public void addAnswer(Answer answer) {

        try {

            transactionManager.beginTransaction();

            if (answerDao.findById(answer.getId()) != null) {
                transactionManager.commitTransaction();
                return;
            }

            answerDao.add(answer);

            transactionManager.commitTransaction();

        } catch (TransactionException ex) {

            System.out.println(ex.getMessage());
            transactionManager.rollbackTransaction();
        }
    }


    public void removeAnswer(Answer answer) {

        try {

            transactionManager.beginTransaction();

            if (answerDao.findById(answer.getId()) == null) {
                transactionManager.commitTransaction();
                return;
            }

            answerDao.remove(answer);

            transactionManager.commitTransaction();

        } catch (TransactionException ex) {

            System.out.println(ex.getMessage());
            transactionManager.rollbackTransaction();
        }

    }

    public List<Answer> findAll() {

        try {

            transactionManager.beginTransaction();

            List<Answer> list = answerDao.findAll();

            transactionManager.commitTransaction();

            return list;

        } catch (TransactionException ex) {

            System.out.println(ex.getMessage());
            transactionManager.rollbackTransaction();
        }
        return null;
    }


}
