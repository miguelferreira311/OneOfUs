package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.academiadecodigo.bootcamp.model.Answer;

public class AnswerController implements Controller {

    @FXML
    private Label awswerLabel;

    @FXML
    private Button backBtn;

    private Answer answer;

    @FXML
    void backPressed(ActionEvent event) {

    }

    public void initData(Answer answer){
        this.answer = answer;

        awswerLabel.setText(answer.getSentence());
    }

}

