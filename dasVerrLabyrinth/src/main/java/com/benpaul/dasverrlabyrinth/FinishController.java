/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benpaul.dasverrlabyrinth;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
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
    
    ArrayList<Integer> scores;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        scores = new ArrayList();
        scores.add(App.players[0].score);
        scores.add(App.players[1].score);
        scores.add(App.players[2].score);
        scores.add(App.players[3].score);
        
        Image firstPlaceImg;
        File firstPlaceFile = new File("src/main/resources/img/cardbackRed.png");
        firstPlaceImg = new Image(firstPlaceFile.toURI().toString());
    }    

    @FXML
    private void btnRestart(ActionEvent event) {
    }
    
    private int determinWinner(){
        int largest = scores.get(0);
        for(int x=0; x<4; x++)
            if (scores.get(x) > largest)
                largest = scores.get(x);
        return largest;
    }

    
    
}
