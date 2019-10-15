module musicplayer {
        requires javafx.graphics;
        requires javafx.controls;
        requires javafx.fxml;

        exports com.github.xwadrom.musicplayer.main to javafx.graphics;
        opens com.github.xwadrom.musicplayer.controller to javafx.fxml;
        }