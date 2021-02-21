/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benpaul.dasverrlabyrinth;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;

/**
 * FXML Controller class
 *
 * @author benbartel
 */
public class HomeController implements Initializable {

    @FXML
    private CheckBox checkRedBot;
    @FXML
    private CheckBox checkBlueBot;
    @FXML
    private CheckBox checkYellowBot;
    @FXML
    private CheckBox checkGreenBot;
    //static int colorType;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //colorType = 0;
    }    

    @FXML
    private void btnStartGame(ActionEvent event) throws IOException {
        App.setRoot("gameView");
        App.players[0].setIsBot(checkRedBot.isSelected());
        App.players[1].setIsBot(checkBlueBot.isSelected());
        App.players[2].setIsBot(checkYellowBot.isSelected());
        App.players[3].setIsBot(checkGreenBot.isSelected());
    }

    @FXML
    private void btnColors(ActionEvent event) {
        //colorType = 1;
    }

}
