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

public class Main extends Application {

    private static final int SPLASH_WIDTH = 676;
    private static final int SPLASH_HEIGHT = 227;
    private ServiceInjections servicesInjections;
    private Pane splashLayout;
    private ProgressBar loadProgress;
    private Label progressText;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {
        servicesInjections = new ServiceInjections();
        servicesInjections.start();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setResizable(false);
        primaryStage.setTitle("OneOfUs");


        Navigation.getInstance().setStage(primaryStage);
        Navigation.getInstance().loadScreen("QuestionView");
    }

    @Override
    public void stop() {
        servicesInjections.stop();
    }

    private void showSplash(Stage initStage) {

        ImageView splash = new ImageView(new Image("http://fxexperience.com/wp-content/uploads/2010/06/logo.png"));
        loadProgress = new ProgressBar();
        loadProgress.setPrefWidth(SPLASH_WIDTH - 20);
        progressText = new Label("Loading . . .");
        splashLayout = new VBox();
        splashLayout.getChildren().addAll(splash, loadProgress, progressText);
        progressText.setAlignment(Pos.CENTER);
        splashLayout.setStyle("-fx-padding: 5; -fx-background-color: cornsilk; -fx-border-width:5; -fx-border-color: linear-gradient(to bottom, chocolate, derive(chocolate, 50%));");
        splashLayout.setEffect(new DropShadow());

        Scene splashScene = new Scene(splashLayout);
        initStage.initStyle(StageStyle.UNDECORATED);
        final Rectangle2D bounds = Screen.getPrimary().getBounds();
        initStage.setScene(splashScene);
        initStage.setX(bounds.getMinX() + bounds.getWidth() / 2 - SPLASH_WIDTH / 2);
        initStage.setY(bounds.getMinY() + bounds.getHeight() / 2 - SPLASH_HEIGHT / 2);
        initStage.show();
    }
}

