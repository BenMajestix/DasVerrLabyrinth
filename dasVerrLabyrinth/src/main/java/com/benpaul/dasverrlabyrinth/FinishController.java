/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benpaul.dasverrlabyrinth;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Paul
 */
public class FinishController implements Initializable {

    @FXML
    private ImageView firstPlace;
    @FXML
    private ImageView secondPlace;
    @FXML
    private ImageView thirdPlace;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image firstPlaceImg;
        File firstPlaceFile = new File("src/main/resources/img/cardbackRed.png");
        firstPlaceImg = new Image(firstPlaceFile.toURI().toString());
    }    

    @FXML
    private void btnRestart(ActionEvent event) {
    }
    
}