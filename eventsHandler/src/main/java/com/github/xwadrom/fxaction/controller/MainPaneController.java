package com.github.xwadrom.fxaction.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

public class MainPaneController {

    @FXML
    private Button clearButton;

    @FXML
    private TextArea textRight;

    @FXML
    private TextArea textLeft;


    public void initialize(){
        textLeft.addEventFilter(KeyEvent.KEY_RELEASED,
                x -> textRight
                .setText(new StringBuilder(textLeft.getText()).reverse()                    .toString()));
                textRight.addEventFilter(KeyEvent.KEY_RELEASED, x -> textLeft
                .setText(new StringBuilder(textRight.getText()).reverse()                   .toString()));
    }

//        clearButton.setOnAction(event -> {
//            textLeft.clear();
//            textRight.clear();
//        });
//
//    }
}

//public void initialize() {
//    lowerCaseButton.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
//        @Override
//        public void handle(ActionEvent event) {
//            System.out.println("Wciśnięto przycisk");
//            System.out.println(event.getEventType());
//            String originalText = mainTextArea.getText();
//            String lowerText = originalText.toLowerCase();
//            mainTextArea.setText(lowerText);
//        }
//    });
//} Drugi sposób obsługi zdarzeń polega na wykorzystaniu jednej z dwóch poniższych metod:
//
//addEventFilter(),
//addEventHandler().
