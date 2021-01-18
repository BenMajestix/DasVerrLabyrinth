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
 * @author benbartel
 */
public class HomeController implements Initializable {

    @FXML
    private ImageView imgViewTest;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File file = new File("src/main/resources/all_tiles/straight.png");
        Image image = new Image(file.toURI().toString());
        imgViewTest.setImage(image);
        // TODO
    }    

    @FXML
    private void btnOof(ActionEvent event) {
        File file = new File("src/main/resources/all_tiles/corner.png");
        Image image = new Image(file.toURI().toString());
        imgViewTest.setImage(image);
    }
    
}
