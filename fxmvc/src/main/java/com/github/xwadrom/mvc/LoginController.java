package com.github.xwadrom.mvc;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController {

    @FXML
    private VBox VBoxPane;

    @FXML
    private Label label1;

    @FXML
    private Button loginButton1;

    @FXML
    private Label label2;

    @FXML
    private Button loginButton2;


    public void initialize() {

        label1.setText("Etykieta 1");
        label2.setText("Etykieta 2");
        loginButton1.setText("Przycisk 1");
        loginButton2.setText("Przycisk 2");
    }
}


//    public void initialize(){
////        String labelText = usernameLabel.getText();
////        System.out.println(labelText);
////        usernameTextField.setText("Tekst z kontrolera");
//    }


