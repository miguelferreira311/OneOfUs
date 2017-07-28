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


    public void start() {

        AnswerDao answerDao = new HibernateAnswerDao();
        KeyWordDao keyWordDao = new HibernateKeyWordDao();
        TransactionManager transactionManager = new HibernateTransactionManager();


        ServiceRegistry serviceRegistry = ServiceRegistry.getInstance();
        serviceRegistry.addService(new AnswerKeyService(keyWordDao, answerDao, transactionManager));

        KeyWordService keyWordService = new KeyWordService(keyWordDao, transactionManager);
        KeyWord keyWord = new KeyWord("dasda");
        KeyWord keyWord1 = new KeyWord("preguiç");
        KeyWord keyWord2 = new KeyWord("oop");
        KeyWord keyWord3 = new KeyWord("abert");
        KeyWord keyWord4 = new KeyWord("objecto");
        KeyWord keyWord5 = new KeyWord("heap");
        KeyWord keyWord6 = new KeyWord("null");
        KeyWord keyWord7 = new KeyWord("problema");
        KeyWord keyWord8 = new KeyWord("itera");



        keyWordService.addKeyWord(keyWord);


        AnswerService answerService = new AnswerService(answerDao, transactionManager);
        answerService.addAnswer(new Answer("Isso são pormenores de implementação.", keyWord));
        answerService.addAnswer(new Answer("Abraça a mudança!", keyWord));
        answerService.addAnswer(new Answer("Come JAVAs com chouriço, que isso passa.", keyWord));
        answerService.addAnswer(new Answer("O que quer que tenhas perguntado...a resposta provavelmente é: referência", keyWord));
        answerService.addAnswer(new Answer("Uma coisa é uma coisa, outra coisa é outra coisa", keyWord));
        answerService.addAnswer(new Answer("Se estiveres com dúvidas, desenha uma heap!", keyWord));
        answerService.addAnswer(new Answer("Não sei se estou a perceber bem a tua pergunta...", keyWord));
        answerService.addAnswer(new Answer("Importas-te de ser um bocadinho mais específico?", keyWord));
        answerService.addAnswer(new Answer("Não percebi nada do que disseste!!", keyWord));
        answerService.addAnswer(new Answer("Sabes o que é que era fixe...?", keyWord));

        answerService.addAnswer(new Answer("Um programador é um preguiçoso criativo", keyWord1));
        answerService.addAnswer(new Answer("Encara a tua vida como OOP, fica mais fácil de organizar", keyWord2));
        answerService.addAnswer(new Answer("Deves estar sempre aberto à expansão, mas fechado à modificação", keyWord3));
        answerService.addAnswer(new Answer("Esse objecto vive numa Heap de certeza...e tem uma referência para ele!", keyWord4));
        answerService.addAnswer(new Answer("[heap, heap]", keyWord5));
        answerService.addAnswer(new Answer("Com NullPointerException não ajudo...desculpa lá", keyWord6));
        answerService.addAnswer(new Answer("O essencial é entender bem o problema, só depois poderás definir o melhor design pattern para o resolver", keyWord7));
        answerService.addAnswer(new Answer("A vida é uma iteração só, aproveita-a bem", keyWord8));




        serviceRegistry.addService(keyWordService);
        serviceRegistry.addService(answerService);
    }

    public void load() {
        HibernateSessionManager.getSession();
    }

    public void stop() {
        HibernateSessionManager.close();
    }

}
