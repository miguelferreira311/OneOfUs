package org.academiadecodigo.bootcamp.service.answer;

import org.academiadecodigo.bootcamp.model.Answer;
import org.academiadecodigo.bootcamp.model.KeyWord;
import org.academiadecodigo.bootcamp.model.dao.AnswerDao;
import org.academiadecodigo.bootcamp.model.dao.KeyWordDao;
import org.academiadecodigo.bootcamp.persistence.TransactionException;
import org.academiadecodigo.bootcamp.persistence.TransactionManager;
import org.academiadecodigo.bootcamp.service.Service;
import org.academiadecodigo.bootcamp.utils.Random;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by codecadet on 27/07/2017.
 */
public class AnswerKeyService implements Service {

    private KeyWordDao keyDao;
    private AnswerDao answerDao;
    private TransactionManager manager;

    public AnswerKeyService(KeyWordDao keyDao, AnswerDao answerDao, TransactionManager manager) {
        this.manager = manager;
        this.keyDao = keyDao;
        this.answerDao = answerDao;
    }

    public Answer getAnswer(String question) {

        try {


            manager.beginTransaction();

            String[] words = question.split("[ ,.?!'\";:\\-+*/()$£@\n\r]");

            KeyWord keyWord = null;
            List<KeyWord> keyWords = new ArrayList<>();
            List<KeyWord> keyDb = keyDao.findAll();

            for (String word : words) {

                for (KeyWord key : keyDb) {

                    if (word.contains(key.getWord())) {
                        keyWord = key;
                    }

                    if (keyWord != null) {
                        keyWords.add(keyWord);
                    }
                }
            }

            if (keyWord == null) {
                return answerDao.findById(Random.MathRandom(0, 10));
            }

            keyWord = keyWords.get(Random.MathRandom(0, keyWords.size() - 1));
            List<Answer> answers = answerDao.findByKeyId(keyWord);
            Answer answer = answers.get(Random.MathRandom(0, answers.size() - 1));

            manager.commitTransaction();

            return answer;

        } catch (TransactionException ex) {
            manager.rollbackTransaction();
            System.err.println("Error: " + ex.getMessage());
        }

        return null;
    }

    @Override
    public String getServiceName() {
        return AnswerKeyService.class.getSimpleName();
    }
}
