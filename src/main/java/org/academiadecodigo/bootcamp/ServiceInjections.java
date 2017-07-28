package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.model.Answer;
import org.academiadecodigo.bootcamp.model.KeyWord;
import org.academiadecodigo.bootcamp.model.Quote;
import org.academiadecodigo.bootcamp.model.Role;
import org.academiadecodigo.bootcamp.model.dao.*;
import org.academiadecodigo.bootcamp.model.dao.hibernate.*;
import org.academiadecodigo.bootcamp.persistence.TransactionManager;
import org.academiadecodigo.bootcamp.persistence.hibernate.HibernateSessionManager;
import org.academiadecodigo.bootcamp.persistence.hibernate.HibernateTransactionManager;
import org.academiadecodigo.bootcamp.service.ServiceRegistry;
import org.academiadecodigo.bootcamp.service.imple.*;
import org.academiadecodigo.bootcamp.service.imple.AnswerKeyService;
import org.academiadecodigo.bootcamp.service.imple.AnswerService;
import org.academiadecodigo.bootcamp.service.imple.KeyWordService;
import org.academiadecodigo.bootcamp.service.imple.QuoteService;

public class ServiceInjections {

    private KeyWordService keyWordService;
    private AnswerService answerService;
    private QuoteService quoteService;
    RoleService roleService;

    public void start() {

        AnswerDao answerDao = new HibernateAnswerDao();
        KeyWordDao keyWordDao = new HibernateKeyWordDao();
        TransactionManager transactionManager = new HibernateTransactionManager();


        ServiceRegistry serviceRegistry = ServiceRegistry.getInstance();
        serviceRegistry.addService(new AnswerKeyService(keyWordDao, answerDao, transactionManager));

        keyWordService = new KeyWordService(keyWordDao, transactionManager);
        answerService = new AnswerService(answerDao, transactionManager);

        serviceRegistry.addService(keyWordService);
        serviceRegistry.addService(answerService);

        QuoteDao quoteDao = new HibernateQuoteDao();
        quoteService = new QuoteService(quoteDao,transactionManager);
        serviceRegistry.addService(quoteService);

        UserDao userDao = new HibernateUserDao();
        RoleDao roleDao = new HibernateRoleDao();
        UserService userService = new UserService(userDao, roleDao, transactionManager);
        roleService = new RoleService(roleDao,transactionManager);

        serviceRegistry.addService(userService);
        serviceRegistry.addService(roleService);
    }

    public void load() {
        HibernateSessionManager.getSession();
    }


    public void stop() {
        HibernateSessionManager.close();
    }

}
