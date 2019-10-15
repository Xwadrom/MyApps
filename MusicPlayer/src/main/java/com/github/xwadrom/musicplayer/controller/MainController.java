package com.github.xwadrom.musicplayer.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;

public class MainController {

    @FXML
    private MenuItem fileMenuItem;

    @FXML
    private MenuItem dirMenuItem;

    @FXML
    private MenuItem closeMenuItem;

    @FXML
    private MenuItem aboutMenuItem;

    @FXML
    private TableView<?> contentTable;

    @FXML
    private Button previousButton;

    @FXML
    private Button nextButton;

    @FXML
    private ToggleButton playButton;

    @FXML
    private Slider volumeSlider;

    @FXML
    private Slider progressSlider;

    public void initialize(){
        configureButtons();
        configureVolume();
    }

    private void configureVolume(){
        volumeSlider.addEventFilter(MouseEvent.MOUSE_PRESSED, event ->
                System.out.println("Wciśnięto przycik na suwaku głośności"));
    }

    private void configureButtons(){
        previousButton.setOnAction(event -> System.out.println("Poprzednia piosenka"));
        nextButton.setOnAction(event -> System.out.println("Następna piosenka"));
        playButton.setOnAction(event -> {
            if(playButton.isSelected()){
                System.out.println("Play");
            }else{
                System.out.println("Stop");
            }
        });
    }
}
