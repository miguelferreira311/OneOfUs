package org.academiadecodigo.bootcamp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.academiadecodigo.bootcamp.controller.Controller;
import org.academiadecodigo.bootcamp.model.User;

import java.io.IOException;
import java.util.LinkedList;

public final class Navigation {

    private static final String VIEW_PATH = "/View";
    // static instance of this class
    private static Navigation instance = null;

    // ... singleton stuff...

    private final int MIN_WIDTH = 1024; // window width
    private final int MIN_HEIGHT = 768; // window height

    private LinkedList<Scene> scenes = new LinkedList<Scene>(); // Navigation History
    private Controller controller;
    private Stage stage; // reference to the application window
    private User user;

    // ... navigation stuff ...

    // private constructor so it's not possible to instantiate from outside
    private Navigation() {
    }

    // static method that returns the instance
    public static synchronized Navigation getInstance() {

        // the instance is created only the first time this method is called
        if (instance == null) {
            instance = new Navigation();
        }

        // it always returns the same instance, there is no way to have another one
        return instance;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void loadScreen(String view) {
        try {

            // Instantiate the view and the controller
            FXMLLoader fxmlLoader;
            fxmlLoader = new FXMLLoader(getClass().getResource(VIEW_PATH + "/" + view + ".fxml"));
            Parent root = fxmlLoader.load();
            controller = fxmlLoader.getController();
            // Create a new scene and save it to the stack
            Scene scene = new Scene(root, MIN_WIDTH, MIN_HEIGHT);
            scenes.push(scene);

            // Put the scene on the stage
            setScene(scene);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failure to load view " + view + " : " + e.getMessage());
        }
    }

    private void setScene(Scene scene) {

        // set the scene
        stage.setScene(scene);

        // show the stage to reload
        stage.show();
    }

    public void back() {

        if (scenes.isEmpty()) {
            return;
        }

        // remove the current scene from the stack
        scenes.pop();


        // load the scene at the top of the stack
        setScene(scenes.peek());
    }

    public Node getNode(String view) {

        FXMLLoader fxmlLoader;
        fxmlLoader = new FXMLLoader(getClass().getResource(VIEW_PATH + "/" + view + ".fxml"));


        try {

            Node node = fxmlLoader.load();

            controller = fxmlLoader.getController();

            return node;
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
        return null;
    }

    public void setDefaultSize(){
        stage.setHeight(757);
        stage.setWidth(1077);
    }

    public void saveUser(User user){
        this.user = user;
    }

    public User getUser(){
        return user;
    }

    public Controller getController() {
        return controller;
    }
}
