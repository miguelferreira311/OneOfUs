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
import org.hibernate.Hibernate;

public class ServiceInjections {


    public void start(){

        AnswerDao answerDao = new HibernateAnswerDao();
        KeyWordDao keyWordDao = new HibernateKeyWordDao();
        TransactionManager transactionManager = new HibernateTransactionManager();


        ServiceRegistry serviceRegistry = ServiceRegistry.getInstance();
        serviceRegistry.addService(new AnswerKeyService(keyWordDao,answerDao,transactionManager));

        KeyWordService keyWordService = new KeyWordService(keyWordDao,transactionManager);
        KeyWord keyWord = new KeyWord("dasda");
        keyWordService.addKeyWord(keyWord);

        AnswerService answerService = new AnswerService(answerDao,transactionManager);
        answerService.addAnswer(new Answer("Isso são pormenores de implementação.", keyWord));
        answerService.addAnswer(new Answer("Abraça a mudança!", keyWord));
        answerService.addAnswer(new Answer("Come JAVAs com chouriço, que isso passa.", keyWord));
        answerService.addAnswer(new Answer("O que quer que tenhas perguntado...a resposta provavelmente é: referência", keyWord));
        answerService.addAnswer(new Answer("Uma coisa é uma coisa, outra coisa é outra coisa", keyWord));
        answerService.addAnswer(new Answer("Queres ser meu amigo?", keyWord));
        answerService.addAnswer(new Answer("Não sei se estou a perceber bem a tua pergunta...", keyWord));
        answerService.addAnswer(new Answer("Importas-te de ser um bocadinho mais específico?", keyWord));
        answerService.addAnswer(new Answer("Steve Jobs, faz-me um filho", keyWord));
        answerService.addAnswer(new Answer("Sabes o que é que era fixe...?", keyWord));

        serviceRegistry.addService(keyWordService);
        serviceRegistry.addService(answerService);
    }

    public void load(){
        HibernateSessionManager.getSession();
    }

    public void stop(){
        HibernateSessionManager.close();
    }

}
