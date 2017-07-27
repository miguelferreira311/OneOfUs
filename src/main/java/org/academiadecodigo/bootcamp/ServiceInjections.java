package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.model.Answer;
import org.academiadecodigo.bootcamp.model.KeyWord;
import org.academiadecodigo.bootcamp.model.dao.AnswerDao;
import org.academiadecodigo.bootcamp.model.dao.KeyWordDao;
import org.academiadecodigo.bootcamp.model.dao.hibernate.HibernateAnswerDao;
import org.academiadecodigo.bootcamp.model.dao.hibernate.HibernateKeyWordDao;
import org.academiadecodigo.bootcamp.persistence.TransactionManager;
import org.academiadecodigo.bootcamp.persistence.hibernate.HibernateSessionManager;
import org.academiadecodigo.bootcamp.persistence.hibernate.HibernateTransactionManager;
import org.academiadecodigo.bootcamp.service.ServiceRegistry;
import org.academiadecodigo.bootcamp.service.answer.AnswerKeyService;
import org.academiadecodigo.bootcamp.service.answer.AnswerService;
import org.academiadecodigo.bootcamp.service.answer.KeyWordService;

public class ServiceInjections {


    public void start(){

        AnswerDao answerDao = new HibernateAnswerDao();
        KeyWordDao keyWordDao = new HibernateKeyWordDao();
        TransactionManager transactionManager = new HibernateTransactionManager();


        ServiceRegistry serviceRegistry = ServiceRegistry.getInstance();
        serviceRegistry.addService(new AnswerKeyService(keyWordDao,answerDao,transactionManager));

        KeyWordService keyWordService = new KeyWordService(keyWordDao,transactionManager);
        keyWordService.addKeyWord(new KeyWord("hcgvbcg"));

        AnswerService answerService = new AnswerService(answerDao,transactionManager);
        answerService.addAnswer(new Answer("Isso são pormenores de implementação.", 1));
        answerService.addAnswer(new Answer("Abraça a mudança!", 1));
        answerService.addAnswer(new Answer("Come JAVAs com chouriço, que isso passa.", 1));
        answerService.addAnswer(new Answer("O que quer que tenhas perguntado...a resposta provavelmente é: referência", 1));
        answerService.addAnswer(new Answer("Uma coisa é uma coisa, outra coisa é outra coisa", 1));
        answerService.addAnswer(new Answer("", 1));
        answerService.addAnswer(new Answer("Isso são pormenores de implementação.", 1));
        answerService.addAnswer(new Answer("Isso são pormenores de implementação.", 1));
        answerService.addAnswer(new Answer("Isso são pormenores de implementação.", 1));
        answerService.addAnswer(new Answer("Isso são pormenores de implementação.", 1));
    }

    public void load(){

    }

    public void stop(){
        HibernateSessionManager.close();
    }

}
