package org.academiadecodigo.bootcamp.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;
import org.academiadecodigo.bootcamp.Navigation;
import org.academiadecodigo.bootcamp.ServiceInjections;


public class SplashController implements Controller {

    private ServiceInjections servicesInjections;

    @FXML
    public ImageView imageView;

    @FXML
    public Label label;

    @FXML
    public Button btn;


    public void startPush(ActionEvent event) {
        btn.setDisable(true);
        servicesInjections = new ServiceInjections();
        servicesInjections.start();
        Navigation.getInstance().setDefaultSize();
        Navigation.getInstance().loadScreen("MainView");

    }

    public void initialize(){

        Image image = new Image("ball8_logo.png");
        imageView.setImage(image);
        label.setText("Cenas");
        imageView.setFitWidth(500);
        imageView.setFitHeight(350);
    }


}
