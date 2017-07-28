package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import org.academiadecodigo.bootcamp.Navigation;

/**
 * Created by codecadet on 28/07/17.
 */
public class GameOverController implements Controller {


    public void backPress(ActionEvent actionEvent) {
        Navigation.getInstance().loadScreen("MainView");
    }
}
