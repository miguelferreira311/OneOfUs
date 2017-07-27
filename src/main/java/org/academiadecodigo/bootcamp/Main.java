package org.academiadecodigo.bootcamp;

/**
 * Created by codecadet on 27/07/2017.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Navigation.getInstance().setStage(primaryStage);
        Navigation.getInstance().loadScreen("QuestionView");
    }


    public static void main(String[] args) {
        launch(args);
    }


}

