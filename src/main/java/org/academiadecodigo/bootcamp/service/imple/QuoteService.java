package org.academiadecodigo.bootcamp.service.imple;

import org.academiadecodigo.bootcamp.model.Quote;
import org.academiadecodigo.bootcamp.model.dao.QuoteDao;
import org.academiadecodigo.bootcamp.persistence.TransactionException;
import org.academiadecodigo.bootcamp.persistence.TransactionManager;
import org.academiadecodigo.bootcamp.service.Service;
import org.academiadecodigo.bootcamp.utils.Random;

import java.util.List;

/**
 * Created by codecadet on 28/07/17.
 */
public class QuoteService implements Service {

    private QuoteDao quoteDao;
    private TransactionManager transactionManager;

    public QuoteService(QuoteDao quoteDao, TransactionManager transactionManager) {
        this.quoteDao = quoteDao;
        this.transactionManager = transactionManager;
    }


    public void addQuote(Quote quote) {

        try {

            transactionManager.beginTransaction();

            if (quoteDao.findById(quote.getId()) != null) {
                transactionManager.commitTransaction();
                return;
            }

            quoteDao.save(quote);

            transactionManager.commitTransaction();

        } catch (TransactionException ex) {

            System.out.println(ex.getMessage());
            transactionManager.rollbackTransaction();
        }
    }

    public Quote findQuote() {

        Quote quote = null;

        try {
            transactionManager.beginTransaction();

            quote = quoteDao.findById(Random.MathRandom(1, 7));

            transactionManager.commitTransaction();

        } catch (TransactionException ex) {

            System.out.println(ex.getMessage());
            transactionManager.rollbackTransaction();
        }
        return quote;
    }


    public void removeQuote(Quote quote) {

        try {

            transactionManager.beginTransaction();

            if (quoteDao.findById(quote.getId()) == null) {
                transactionManager.commitTransaction();
                return;
            }

            quoteDao.remove(quote);

            transactionManager.commitTransaction();

        } catch (TransactionException ex) {

            System.out.println(ex.getMessage());
            transactionManager.rollbackTransaction();
        }
    }

    public List<Quote> findAll() {

        try {

            transactionManager.beginTransaction();

            List<Quote> list = quoteDao.findAll();

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
        return QuoteService.class.getSimpleName();
    }
}
