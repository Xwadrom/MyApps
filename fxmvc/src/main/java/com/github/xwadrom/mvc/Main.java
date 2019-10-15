package com.github.xwadrom.mvc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox mainPane = FXMLLoader.load(getClass().getResource("/mainPane.fxml"));
        Scene scene = new Scene (mainPane);
        stage.setScene(scene);
        stage.setTitle("Inicjalizator");
        stage.show();

    }
}
