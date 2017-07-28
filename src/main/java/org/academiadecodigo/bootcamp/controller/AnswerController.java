package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.academiadecodigo.bootcamp.Navigation;
import org.academiadecodigo.bootcamp.model.Answer;

public class AnswerController implements Controller {

    @FXML
    private Label awswerLabel;

    @FXML
    private Button backBtn;

    @FXML
    private ImageView imageView;

    @FXML
    void backPressed(ActionEvent event) {
        Navigation.getInstance().back();
    }

    public void initialize(){
        Image image = new Image("logo_banner_lateral.png");
        imageView.setImage(image);
    }

    public void initData(Answer answer){


        awswerLabel.setText(answer.getSentence());
    }

}

