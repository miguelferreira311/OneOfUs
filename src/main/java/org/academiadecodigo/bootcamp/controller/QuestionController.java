package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;
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

    @FXML
    private ImageView image;

    private AnswerKeyService answerKeyService;

    @FXML
    void backPress(ActionEvent event) {
        Navigation.getInstance().back();
    }

    @FXML
    void sendPress(ActionEvent event) {

        if (textArea.getText().isEmpty() || textArea.getText().matches(" ")){
            errLabel.setText("Campo vazio!");
            return;
        }

        Answer answer = answerKeyService.getAnswer(textArea.getText());

        if (answer == null){
            errLabel.setText("Ocurreu um erro!");
            return;
        }

        Navigation.getInstance().loadScreen("AnswerView");
        ((AnswerController) Navigation.getInstance().getController()).initData(answer);
    }

    public void initialize(){
        answerKeyService = (AnswerKeyService) ServiceRegistry.getInstance().getService("AnswerKeyService");


    }

}