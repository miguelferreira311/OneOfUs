package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;

public class MainController implements Controller {

        @FXML
        private ImageView mainView;

        @FXML
        private Button btnMain;

        @FXML
        private Label mainLabel;

        @FXML
        void btnPress(ActionEvent event) {

        }

    public void initialize(){

        Image image = new Image("banner_main.png");
        mainView.setFitWidth(Screen.getPrimary().getBounds().getWidth());
        mainView.setFitHeight(300);
        mainView.setImage(image);

    }

}


