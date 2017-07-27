package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import org.academiadecodigo.bootcamp.Navigation;
import org.academiadecodigo.bootcamp.model.Answer;
import org.academiadecodigo.bootcamp.service.ServiceRegistry;
import org.academiadecodigo.bootcamp.service.answer.AnswerKeyService;

public class QuestionController implements Controller {

    @FXML
    private Button backBtn;

    @FXML
    private TextArea textArea;

    @FXML
    private Button sendBtn;

    @FXML
    private Label errLabel;

    private AnswerKeyService answerKeyService;

    @FXML
    void backPress(ActionEvent event) {
        //Navigation.getInstance().back();
    }

    @FXML
    void sendPress(ActionEvent event) {

        if (textArea.getText().isEmpty()){
            errLabel.setText("Campo vazio!");
            return;
        }

        Answer answer = answerKeyService.getAnswer(textArea.getText());

        if (answer == null){
            errLabel.setText("Ocurreu um erro!");
            return;
        }



    }

    public void initialize(){
        answerKeyService = (AnswerKeyService) ServiceRegistry.getInstance().getService("AnswerKeyService");
    }

}