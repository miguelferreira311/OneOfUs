package org.academiadecodigo.bootcamp;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.academiadecodigo.bootcamp.controller.SplashController;

import javax.print.attribute.standard.MediaSize;

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

    }

    @Override
    public void stop() {
        servicesInjections.stop();
    }


}

