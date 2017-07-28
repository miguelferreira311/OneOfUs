package org.academiadecodigo.bootcamp.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.academiadecodigo.bootcamp.Navigation;
import org.academiadecodigo.bootcamp.ServiceInjections;
import org.academiadecodigo.bootcamp.service.ServiceRegistry;
import org.academiadecodigo.bootcamp.service.imple.QuoteService;


public class SplashController implements Controller {

    private ServiceInjections servicesInjections;
    private QuoteService quoteService;

    @FXML
    public ImageView imageView;

    @FXML
    public Label label;

    @FXML
    public Button btn;


    public void startPush(ActionEvent event) {
        btn.setDisable(true);

        Navigation.getInstance().setDefaultSize();
        Navigation.getInstance().loadScreen("loginView");

    }

    public void initialize(){


        servicesInjections = new ServiceInjections();
        servicesInjections.start();
        Image image = new Image("ball8_logo.png");
        imageView.setImage(image);
        imageView.setFitWidth(500);
        imageView.setFitHeight(350);
    }


    public void load(){
        servicesInjections.load();
        quoteService = (QuoteService) ServiceRegistry.getInstance().getService("QuoteService");
        System.out.println(quoteService);
        label.setText(quoteService.findQuote().getSentence());

    }
}
