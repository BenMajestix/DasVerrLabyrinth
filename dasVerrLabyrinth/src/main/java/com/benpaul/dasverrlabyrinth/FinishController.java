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

    ArrayList<playerModel> scores;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        scores = new ArrayList();
        scores.add(App.players[0]);
        scores.add(App.players[1]);
        scores.add(App.players[2]);
        scores.add(App.players[3]);
        
        determinWinner();
        System.out.println("Winner: " + scores.get(0).score);
        System.out.println("Second: " + scores.get(1).score);
        System.out.println("Third: " + scores.get(2).score);
        System.out.println("Last: " + scores.get(3).score);
        
        Image firstPlaceImg;
        File firstPlaceFile = new File("src/main/resources/img/cardbackRed.png");
        firstPlaceImg = new Image(firstPlaceFile.toURI().toString());
    }    

    @FXML
    private void btnRestart(ActionEvent event) {
    }
    
    private void determinWinner(){
        boolean done = false;

        while(!(done)){
            for(int i = 0; i < 2; i++){
                boolean something = false;
                if(scores.get(i).score >= scores.get(i++).score){
                }
                else{
                    something = true;
                    playerModel temp1 = scores.get(i);
                    playerModel temp2 = scores.get(i + 1);
                    scores.remove(i);
                    scores.remove(i + 1);
                    scores.add(i, temp1);
                    scores.add(i + 1, temp2);
                }
                if(something == false){done = true;}
            }
        }
        
        
    }

    
    
}
