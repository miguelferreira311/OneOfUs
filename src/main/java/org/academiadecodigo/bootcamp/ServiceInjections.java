package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.model.dao.hibernate.HibernateAnswerDao;
import org.academiadecodigo.bootcamp.model.dao.hibernate.HibernateKeyWordDao;
import org.academiadecodigo.bootcamp.persistence.hibernate.HibernateSessionManager;
import org.academiadecodigo.bootcamp.persistence.hibernate.HibernateTransactionManager;
import org.academiadecodigo.bootcamp.service.ServiceRegistry;
import org.academiadecodigo.bootcamp.service.answer.AnswerKeyService;

public class ServiceInjections {

    public void start(){

        ServiceRegistry serviceRegistry = ServiceRegistry.getInstance();
        serviceRegistry.addService(new AnswerKeyService(
                 new HibernateKeyWordDao()
                ,new HibernateAnswerDao()
                ,new HibernateTransactionManager()));

    }

    public void stop(){
        HibernateSessionManager.close();
    }

}
