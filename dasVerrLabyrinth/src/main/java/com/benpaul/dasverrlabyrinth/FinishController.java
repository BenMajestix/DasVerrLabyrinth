/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benpaul.dasverrlabyrinth;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Paul
 */
public class FinishController implements Initializable {

    ArrayList<playerModel> scores;
    
    @FXML
    private Label lbl1stPl;
    @FXML
    private Label lbl2ndPl;
    @FXML
    private Label lbl3rdPl;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(App.players[0] != null){
            //erstellt und füllt die ArrayList scores
            scores = new ArrayList();
            scores.add(App.players[0]);
            scores.add(App.players[1]);
            scores.add(App.players[2]);
            scores.add(App.players[3]);

            determinWinner();
            //gibt die Gewinner in der Konsole aus
            System.out.println("Winner: " + scores.get(3).name + " " + scores.get(3).score);
            System.out.println("Second: " + scores.get(2).score);
            System.out.println("Third: " + scores.get(1).score);
            System.out.println("Last: " + scores.get(0).score);

            lbl1stPl.setText(scores.get(3).name);
            lbl2ndPl.setText(scores.get(2).name);
            lbl3rdPl.setText(scores.get(1).name);
        }
    }    

    @FXML
    private void btnRestart(ActionEvent event) throws IOException {
        App.setRoot("homeView");
        App.resetGame();
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
