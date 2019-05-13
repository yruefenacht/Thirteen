package controller;

import config.Settings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utility.AudioPlayer;
import utility.ViewChanger;

/**
 * MainMenuController.java
 * @author     Yannick Rüfenacht
 * @author     Mohammed Ali
 * @version    1.0
 * Defines click events of main menu screen.
 */
public class MainMenuController {

    @FXML
    private Button playButton;

    @FXML
    private Button soundButton;


    /**
     * Define main button click event.
     */
    @FXML
    private void showPlayfield() {

        ViewChanger.changeToPlayfield(false);
    }

    @FXML
    private void muteSound() {
        Settings.SOUND=!Settings.SOUND;
    }
}

