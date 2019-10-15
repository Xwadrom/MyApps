module eventsHandler {
    requires javafx.controls;
    requires javafx.fxml;


    exports com.github.xwadrom.fxaction.main;
    opens com.github.xwadrom.fxaction.controller to javafx.fxml;
}