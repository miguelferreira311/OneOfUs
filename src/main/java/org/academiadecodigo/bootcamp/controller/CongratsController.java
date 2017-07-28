package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.academiadecodigo.bootcamp.Navigation;
import org.academiadecodigo.bootcamp.service.ServiceRegistry;
import org.academiadecodigo.bootcamp.service.imple.UserService;


/**
 * Created by codecadet on 28/07/17.
 */
public class CongratsController implements Controller {

    @FXML
    private Label question;

    public void backPress(ActionEvent actionEvent) {
        Navigation.getInstance().loadScreen("MainView");
    }

    public void initialize(){
        UserService userService = (UserService) ServiceRegistry.getInstance().getService("UserService");

        userService.makeAdmin(Navigation.getInstance().getUser());
        question.setText("Felicitações, alcançaste o nível do supremo conhecimento \n És agora um admin!");
    }
}
