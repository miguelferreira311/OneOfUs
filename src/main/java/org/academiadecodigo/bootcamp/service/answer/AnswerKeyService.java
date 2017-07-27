package org.academiadecodigo.bootcamp.service.answer;

import org.academiadecodigo.bootcamp.model.KeyWord;
import org.academiadecodigo.bootcamp.model.dao.AnswerDao;
import org.academiadecodigo.bootcamp.model.dao.KeyWordDao;

/**
 * Created by codecadet on 27/07/2017.
 */
public class AnswerKeyService {

    private KeyWordDao keyDao;
    private AnswerDao answerDao;

    public AnswerKeyService(KeyWordDao keyDao, AnswerDao answerDao) {
        this.keyDao = keyDao;
        this.answerDao = answerDao;
    }

    public String getAnswer(String question){


        String[] words = question.split("[ ,.?!'\";:\\-+*/()$£@\n\r]");

        KeyWord keyWord = null;

        for (String word : words) {

            keyWord = keyDao.findByWord(word);



        }


        return null;
    }
}
