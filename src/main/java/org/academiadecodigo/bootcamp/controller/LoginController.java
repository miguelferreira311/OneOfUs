package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import org.academiadecodigo.bootcamp.Navigation;
import org.academiadecodigo.bootcamp.model.Role;
import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.service.ServiceRegistry;
import org.academiadecodigo.bootcamp.service.answer.RoleService;
import org.academiadecodigo.bootcamp.service.answer.UserService;
import org.academiadecodigo.bootcamp.utils.Security;

public class LoginController implements Controller {

    @FXML
    private ImageView imageView;

    @FXML
    private Label emailLb;

    @FXML
    private TextField nameText;

    @FXML
    private TextField emailText;

    @FXML
    private PasswordField passText;

    @FXML
    private Button btn;

    @FXML
    private Hyperlink hyper;

    @FXML
    private Label errLabel;

    private UserService userService;
    private RoleService roleService;
    private boolean isLogin = true;


    @FXML
    void hyperPressed(ActionEvent event) {
        if (isLogin) {
            registerView();
            isLogin = false;
        } else {
            loginView();
            isLogin = true;
        }
    }

    @FXML
    void loginPressed(ActionEvent event) {
        if (isLogin) {
            login();
        } else {
            register();
        }
    }

    public void initialize() {
        Image image = new Image("logo_banner_lateral.png");
        imageView.setImage(image);
        roleService = (RoleService) ServiceRegistry.getInstance().getService("RoleService");
        userService = (UserService) ServiceRegistry.getInstance().getService("UserService");
        loginView();
    }

    private void loginView() {
        clearText();
        emailText.setVisible(false);
        emailLb.setVisible(false);
    }

    private void clearText() {
        errLabel.setText("");
        errLabel.setVisible(false);
        emailText.setText("");
        nameText.setText("");
        passText.setText("");
    }

    private void registerView() {
        clearText();
        emailText.setVisible(true);
        emailLb.setVisible(true);
    }

    private void login() {

        if (!checkUserAndPass()) {
            return;
        }

        if (userService.autenticate(nameText.getText(), Security.getHash(passText.getText()))) {
            Navigation.getInstance().loadScreen("MainView");
        } else {
            errLabel.setTextFill(Paint.valueOf(Color.RED.toString()));
            errLabel.setText("Username or Password Invalid!");
            errLabel.setVisible(true);
        }

    }

    private boolean checkUserAndPass() {

        if (nameText.getText().isEmpty() || nameText.getText().matches("[ ]")) {
            errLabel.setTextFill(Paint.valueOf(Color.RED.toString()));
            errLabel.setText("Fill the name fild!");
            errLabel.setVisible(true);
            return false;
        }

        if (passText.getText().isEmpty() || passText.getText().matches("[ ]")) {
            errLabel.setTextFill(Paint.valueOf(Color.RED.toString()));
            errLabel.setText("Fill the password fild!");
            errLabel.setVisible(true);
            return false;
        }

        return true;
    }

    private void register() {

        if (!checkUserAndPass()) {
            return;
        }

        if (emailText.getText().isEmpty() || emailText.getText().matches("[ ]")) {
            errLabel.setTextFill(Paint.valueOf(Color.RED.toString()));
            errLabel.setText("Fill the email fild!");
            errLabel.setVisible(true);
            return;
        }

        if (userService.findByName(nameText.getText()) != null) {
            errLabel.setTextFill(Paint.valueOf(Color.RED.toString()));
            errLabel.setText("Username taken");
            errLabel.setVisible(true);
            return;
        }

        Role role = roleService.findById(1);
        System.out.println(role);

        userService.saveOrUpdateUser(new User(nameText.getText(), Security.getHash(passText.getText()), emailText.getText(), role));
        errLabel.setTextFill(Paint.valueOf(Color.GREEN.toString()));
        errLabel.setText("Registo completo");
        errLabel.setVisible(true);
    }
}

