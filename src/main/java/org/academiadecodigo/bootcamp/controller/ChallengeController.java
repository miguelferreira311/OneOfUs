package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import org.academiadecodigo.bootcamp.Navigation;

import java.util.Map;

public class ChallengeController implements Controller {

    private int counter = 1;
    private Map<Integer, RadioButton> solutionsMap;
    private Map<String, String[]> questionsMap;
    private boolean isCorrect;


    @FXML
    private Button backBtn;

    @FXML
    private Label question;

    @FXML
    private RadioButton a;

    @FXML
    private RadioButton b;

    @FXML
    private RadioButton c;

    @FXML
    private RadioButton d;

    @FXML
    private RadioButton e;

    @FXML
    private Button sendBtn;

    @FXML
    void aClicked(ActionEvent event) {
        if (counter == 1) {
            isCorrect = true;

        } else {
            isCorrect = false;
        }

    }


    @FXML
    void bClicked(ActionEvent event) {
        if (counter == 2 || counter == 3 || counter == 4 || counter == 5) {
            isCorrect = true;

        } else {
            isCorrect = false;
        }

    }

    @FXML
    void backPress(ActionEvent event) {
        Navigation.getInstance().loadScreen("MainView");
    }

    @FXML
    void cClicked(ActionEvent event) {
        if (counter == 6) {
            isCorrect = true;

        } else {
            isCorrect = false;
        }

    }

    @FXML
    void dClicked(ActionEvent event) {
        isCorrect = false;
    }

    @FXML
    void eClicked(ActionEvent event) {
        if (counter == 7) {
            isCorrect = true;

        } else {
            isCorrect = false;
        }
    }

    @FXML
    void sendPress(ActionEvent event) {


        if (isCorrect) {

            switch (counter) {
                case 1:
                    question2();
                    isCorrect = false;
                    counter++;
                    break;
                case 2:
                    question3();
                    isCorrect = false;
                    counter++;
                    break;
                case 3:
                    question4();
                    isCorrect = false;
                    counter++;
                    break;
                case 4:
                    question5();
                    isCorrect = false;
                    counter++;
                    break;
                case 5:
                    question6();
                    isCorrect = false;
                    counter++;
                    break;
                case 6:
                    question7();
                    isCorrect = false;
                    counter++;
                    break;
                case 7:
                    victory();
                    break;
                default:
                    System.exit(1);
            }
        } else {

            Navigation.getInstance().loadScreen("GameOverView");

        }
    }

    private void victory() {

        Navigation.getInstance().loadScreen("CongratsView");

    }

    private void question7() {
        setRadioButtons(false);

        question.setText("7 - Qual das seguintes opções completa de forma correcta a seguinte frase:\n Em Java, os construtores...");
        a.setText("não podem lançar exceções");
        b.setText("não têm acesso aos atributos da classe base");
        c.setText("não podem alterar os valores dos atributos do objecto a criar");
        d.setText("nunca podem ser privados");
        e.setText("podem chamar outros construtores da mesma classe");
    }

    private void question6() {
        setRadioButtons(false);

        question.setText("6 - A definição de uma classe por agregação de objectos de outras classes \n ou suas colecções designa-se por:");
        a.setText("upcasting");
        b.setText("abstracção");
        c.setText("composição");
        d.setText("herança");
        e.setText("extensão");
    }

    private void question5() {
        setRadioButtons(false);

        question.setText("5 - O padrão de desenho Observer...");
        a.setText("representa uma operação a ser realizada sobre os elementos de uma estrutura de objectos");
        b.setText("gerir as dependências de outros objectos relativamente ao estado de um objecto");
        c.setText("permite abstrair a criação de famílias de objectos para uma aplicação");
        d.setText("permite tratar famílias de objectos e seus grupos indiscriminadamente");
        e.setText("permite que o comportamento de um objeto mude quando o seu estado muda");
    }

    private void question4() {
        setRadioButtons(false);

        question.setText("4 - Em Java, um método declarado private…");
        a.setText("não pode chamar outros métodos");
        b.setText("não pode ser overridden");
        c.setText("não pode ser declarado static");
        d.setText("não pode ser usado por construtores");
        e.setText("pode ser acedido por classes da mesma package");
    }

    private void question3() {
        setRadioButtons(false);

        question.setText("3 - Uma função recursiva distingue-se por ser: ");
        a.setText("Uma função com recursos de memória ilimitados");
        b.setText("Uma função definida por um caso base e uma chamada a si própria");
        c.setText("Uma função com um número variável de argumentos de entrada");
        d.setText("Uma função que executa uma tarefa iterativamente");
        e.setText("Nenhuma das anteriores.");
    }

    private void question2() {
        setRadioButtons(false);
        question.setText("2 - Em Java, uma interface...");
        a.setText("implementa métodos");
        b.setText("tem apenas membros públicos");
        c.setText("pode definir construtores, desde que sejam públicos");
        d.setText("não pode ser privada");
        e.setText("não pode conter classes internas");
    }

    private void setRadioButtons(boolean set) {
        a.setSelected(set);
        b.setSelected(set);
        c.setSelected(set);
        d.setSelected(set);
        e.setSelected(set);
    }

    public void initialize() {

        question1();

    }


    private void question1() {

        question.setText("1 - Em Java, qual das seguintes frases está correcta?");
        a.setText("Uma classe pode estender uma única classe");
        b.setText("Uma classe pode estender várias classes");
        c.setText("Uma classe só pode implementar uma única interface");
        d.setText("Uma classe não pode estender de uma classe e implementar uma interface");
        e.setText("Uma classe não pode estender de uma classe e implementar múltiplas interface");
    }
}



