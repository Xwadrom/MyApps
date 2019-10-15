module fxmvc {
        requires javafx.graphics;
        requires javafx.controls;
        requires javafx.fxml;

        exports com.github.xwadrom.mvc to javafx.graphics;
        opens com.github.xwadrom.mvc to javafx.fxml;
        }