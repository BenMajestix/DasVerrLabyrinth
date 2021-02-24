/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benpaul.dasverrlabyrinth;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
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

    ArrayList<playerModel> scores;
    @FXML
    private ImageView firstPlace;
    @FXML
    private ImageView secondPlace;
    @FXML
    private ImageView thirdPlace;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(App.players[0] != null){
            scores = new ArrayList();
            scores.add(App.players[0]);
            scores.add(App.players[1]);
            scores.add(App.players[2]);
            scores.add(App.players[3]);

            determinWinner();
            System.out.println("Winner: " + scores.get(3).name + " " + scores.get(3).score);
            System.out.println("Second: " + scores.get(2).score);
            System.out.println("Third: " + scores.get(1).score);
            System.out.println("Last: " + scores.get(0).score);

            Image firstPlaceImg;
            File firstPlaceFile = new File("src/main/resources/img/cardbackRed.png");
            firstPlaceImg = new Image(firstPlaceFile.toURI().toString());
    }
    }    

    @FXML
    private void btnRestart(ActionEvent event) throws IOException {
        App.setRoot("homeView");
    }
    
    private void determinWinner(){
        boolean sorted = false;
        playerModel temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < scores.size() - 1; i++) {
                if (scores.get(i).score > scores.get(i+1).score) {
                    temp = scores.get(i);
                    scores.set(i, scores.get(i+1));
                    scores.set(i+1, temp);
                    sorted = false;
                }
            }
        }
    }

    
    
}
