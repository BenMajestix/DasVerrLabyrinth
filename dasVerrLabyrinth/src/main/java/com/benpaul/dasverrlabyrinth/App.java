package com.benpaul.dasverrlabyrinth;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application {
    ArrayList<tileModel> allTiles;
    tileModel[][] boardTiles =  new tileModel[7][7];
    tileModel offBoardTile;
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("homeView"), 640, 480);
        stage.setScene(scene);
        stage.show();
        
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    public int randomRotation(){
        int rotation;
        rotation = (int) (Math.random() * 4);
        return rotation;
    }
    
    
    public void createTiles(){
        allTiles = new ArrayList();
        //CORNERS
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "corner"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "corner"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "corner"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "corner"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "corner"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "corner"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "corner"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "corner"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "corner"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "corner"));
        //corners with tiles
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "owl", false, "corner"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "moth", false, "corner"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "mouse", false, "corner"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "spider", false, "corner"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "scarab", false, "corner"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "salamander", false, "corner"));
        //Feste Corners
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "corner"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "corner"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "corner"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "corner"));
        
        //STRAIGHTS
        //all empty
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight"));
        
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "helmet", false, "t-crossing"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "candleHolder", false, "t-crossing"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "witch", false, "t-crossing"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "ring", false, "t-crossing"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "dragon", false, "t-crossing"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "emerald", false, "t-crossing"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "ghost", false, "t-crossing"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "map", false, "t-crossing"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "crown", false, "t-crossing"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "bible", false, "t-crossing"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "ghost2", false, "t-crossing"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "coins", false, "t-crossing"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "skull", false, "t-crossing"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "bat", false, "t-crossing"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "keys", false, "t-crossing"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "sword", false, "t-crossing"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "gnome", false, "t-crossing"));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "chest", false, "t-crossing"));
    }
    
    
    
    
    
    
    
    
    
    
    
    public tileModel[][] getBoardTiles() {
        return boardTiles;
    }

    public void setBoardTiles(tileModel[][] boardTiles) {
        this.boardTiles = boardTiles;
    }

    public tileModel getTileOutOfGame() {
        return offBoardTile;
    }

    public void setTileOutOfGame(tileModel tileOutOfGame) {
        this.offBoardTile = tileOutOfGame;
    }

    
    
}