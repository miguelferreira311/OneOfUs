package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import org.academiadecodigo.bootcamp.Navigation;

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
    void backPress(ActionEvent event) {
        //Navigation.getInstance().back();
    }

    @FXML
    void sendPress(ActionEvent event) {

        if (textArea.getText().isEmpty()){

            return;
        }

    }

}