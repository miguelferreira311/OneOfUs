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

        KeyWord keyWord = new KeyWord("dasda");
        KeyWord keyWord1 = new KeyWord("preguiç");
        KeyWord keyWord2 = new KeyWord("oop");
        KeyWord keyWord3 = new KeyWord("abert");
        KeyWord keyWord4 = new KeyWord("objecto");
        KeyWord keyWord5 = new KeyWord("heap");
        KeyWord keyWord6 = new KeyWord("null");
        KeyWord keyWord7 = new KeyWord("problema");
        KeyWord keyWord8 = new KeyWord("itera");

        roleService.addRole(new Role("User"));
        roleService.addRole(new Role("Admin"));

        keyWordService.addKeyWord(keyWord);
        keyWordService.addKeyWord(keyWord1);

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



        quoteService.addQuote(new Quote("\"Falar é fácil. Mostra-me o código.\" - Linus Torvalds"));
        quoteService.addQuote(new Quote("\"Não te preocupes se não funcionar corretamente. Se tudo funcionasse ficarias sem emprego.\""));
        quoteService.addQuote(new Quote("\"Existem duas maneiras de construir um projeto de software. Uma maneira é tornar tão simples que, obviamente, não há deficiências. E o outro caminho é tornar tão complicado que não haja deficiências óbvias. \"- C.A.R. Hoare"));
        quoteService.addQuote(new Quote("\"A maioria dos programadores bons programa não porque esperam receber pagamento ou reconhecimento pelo público, mas porque é divertido programar.\"- Linus Torvalds"));
        quoteService.addQuote(new Quote("\"Iterar é humano, recursar é divino.\"- L. Peter Deutsch"));
        quoteService.addQuote(new Quote("\"Às vezes vale a pena ficar na cama na segunda-feira, ao invés de passar o resto da semana a corrigir o código de segunda-feira\" - Christopher Thompson"));
        quoteService.addQuote(new Quote("\"Em teoria, a teoria e a prática são a mesma coisa. Na prática não.\"- Yoggi Berra"));


    }


    public void stop() {
        HibernateSessionManager.close();
    }

}
