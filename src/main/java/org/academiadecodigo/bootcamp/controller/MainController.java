package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;
import org.academiadecodigo.bootcamp.Navigation;

public class MainController implements Controller {

    @FXML
    private ImageView mainView;

    @FXML
    private Button btnMain1;

    @FXML
    private Button btnMain2;

    @FXML
    private Label mainLabel;


    public void initialize() {

        Image image = new Image("banner_main.png");
        mainView.setFitWidth(Screen.getPrimary().getBounds().getWidth());
        mainView.setFitHeight(300);
        mainView.setImage(image);

        btnMain1.setMinSize(170, 100);
        btnMain2.setMinSize(170,100);

    }

    public void quizPress(ActionEvent actionEvent) {

        Navigation.getInstance().loadScreen("QuestionView");

    }

    public void questionPress(ActionEvent actionEvent) {


    }
}


