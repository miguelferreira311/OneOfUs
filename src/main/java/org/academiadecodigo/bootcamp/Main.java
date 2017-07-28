package org.academiadecodigo.bootcamp;


import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.academiadecodigo.bootcamp.controller.SplashController;

import java.io.File;

public class Main extends Application {

    private ServiceInjections servicesInjections;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {
        servicesInjections = new ServiceInjections();
        //servicesInjections.start();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setResizable(false);
        primaryStage.setTitle("OneOfUs");

        primaryStage.setWidth(676);
        primaryStage.setHeight(427);

        Navigation.getInstance().setStage(primaryStage);
        Navigation.getInstance().loadScreen("SplashView");

        ((SplashController)Navigation.getInstance().getController()).load();

        String musicFile = "SpaBells.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();

    }

    @Override
    public void stop() {
        servicesInjections.stop();
    }


}

