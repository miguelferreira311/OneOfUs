package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import org.academiadecodigo.bootcamp.Navigation;
import org.academiadecodigo.bootcamp.model.Answer;
import org.academiadecodigo.bootcamp.model.KeyWord;
import org.academiadecodigo.bootcamp.service.ServiceRegistry;
import org.academiadecodigo.bootcamp.service.imple.AnswerService;
import org.academiadecodigo.bootcamp.service.imple.KeyWordService;

public class AdminController implements Controller {

    @FXML
    private TextField keywordText;

    @FXML
    private TextField answerText;

    @FXML
    private Button backBut;

    @FXML
    private Button but;

    @FXML
    private Label errLabel;

    private KeyWordService keyWordService;
    private AnswerService answerService;

    @FXML
    void butPressed(ActionEvent event) {

        if (keywordText.getText().isEmpty() || keywordText.getText().matches("[ ]")
                ||answerText.getText().isEmpty() || answerText.getText().matches("[ ]")){

            errLabel.setTextFill(Paint.valueOf(Color.RED.toString()));
            errLabel.setText("Preencha todos os campos.");
            errLabel.setVisible(true);
            return;
        }


        if (keywordText.getText().split(" ").length != 1){
            errLabel.setTextFill(Paint.valueOf(Color.RED.toString()));
            errLabel.setText("Por favor introduza apenas uma palavra.");
            errLabel.setVisible(true);
            return;
        }

        KeyWord keyWord = new KeyWord(keywordText.getText());
        keyWordService.addKeyWord(keyWord);
        Answer answer = new Answer(answerText.getText(),keyWord,null);
        answerService.addAnswer(answer);

        errLabel.setTextFill(Paint.valueOf(Color.GREEN.toString()));
        errLabel.setText("Resposta adicionada!");
        errLabel.setVisible(true);
    }

    @FXML
    void backPressed(ActionEvent event) {
        Navigation.getInstance().back();
    }

    public void initialize(){
        keyWordService = (KeyWordService) ServiceRegistry.getInstance().getService("KeyWordService");
        answerService = (AnswerService) ServiceRegistry.getInstance().getService("AnswerService");
    }

}

