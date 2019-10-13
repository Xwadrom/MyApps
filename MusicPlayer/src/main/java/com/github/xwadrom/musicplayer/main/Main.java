package com.github.xwadrom.musicplayer.main;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
    stage.setTitle("Music Player");
    stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
