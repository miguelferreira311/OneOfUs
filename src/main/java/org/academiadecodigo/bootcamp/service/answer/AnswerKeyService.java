package org.academiadecodigo.bootcamp.service.answer;

import org.academiadecodigo.bootcamp.model.Answer;
import org.academiadecodigo.bootcamp.model.KeyWord;
import org.academiadecodigo.bootcamp.model.dao.AnswerDao;
import org.academiadecodigo.bootcamp.model.dao.KeyWordDao;
import org.academiadecodigo.bootcamp.utils.Random;

import java.util.ArrayList;
import java.util.List;

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

    public String getAnswer(String question) {


        String[] words = question.split("[ ,.?!'\";:\\-+*/()$£@\n\r]");

        KeyWord keyWord = null;
        List<KeyWord> keyWords = new ArrayList<>();

        for (String word : words) {

            keyWord = keyDao.findByWord(word);

            if (keyWord != null) {
                keyWords.add(keyWord);
            }
        }

        if (keyWord == null) {
            //return default;
        }


        keyWord = keyWords.get(Random.MathRandom(0, keyWords.size()));
        List<Answer> answers = answerDao.findByKeyId(keyWord.getId());
        String answer = answers.get(Random.MathRandom(0, answers.size())).getSentence();

        return answer;
    }
}
