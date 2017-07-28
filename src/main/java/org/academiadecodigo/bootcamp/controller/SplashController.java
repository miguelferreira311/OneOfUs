package org.academiadecodigo.bootcamp.controller;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;
import org.academiadecodigo.bootcamp.Navigation;
import org.academiadecodigo.bootcamp.ServiceInjections;
import org.academiadecodigo.bootcamp.service.ServiceRegistry;
import org.academiadecodigo.bootcamp.service.imple.QuoteService;

import java.util.Timer;
import java.util.TimerTask;


public class SplashController implements Controller {

    private ServiceInjections servicesInjections;
    private QuoteService quoteService;


    @FXML
    private Label label;

    @FXML
    private ProgressBar progressBarr;

    @FXML
    private ImageView imageView;

    public void startPush() {
        Navigation.getInstance().setDefaultSize();
        Navigation.getInstance().loadScreen("loginView");

    }

    public void initialize(){

        Image image = new Image("banner_main.png");
        imageView.setImage(image);
        imageView.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());

        label.setText("");
        servicesInjections = new ServiceInjections();
        servicesInjections.start();
        progressBarr.setProgress(0.6);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        load();
                    }
                });
            }
        }, 2000);

    }


    public void load(){
        servicesInjections.load();
        quoteService = (QuoteService) ServiceRegistry.getInstance().getService("QuoteService");
        String string =quoteService.findQuote().getSentence();
        label.setText(string);
        progressBarr.setProgress(1.0);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        startPush();
                    }
                });
            }
        }, 5*1000);


    }


}
