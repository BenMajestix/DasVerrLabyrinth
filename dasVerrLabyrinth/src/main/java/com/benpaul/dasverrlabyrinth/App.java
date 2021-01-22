package com.benpaul.dasverrlabyrinth;

import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

/**
 * JavaFX App
 */

public class App extends Application {
    static ArrayList<tileModel> allTiles;
    static tileModel[][] boardTiles =  new tileModel[7][7];
    static tileModel offBoardTile;
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("homeView"), 1500, 1000);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Das Verrückte Labyrinth");
        
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        
        createTiles();
        createBoard();
        
        launch();
    }
    
    public static void createBoard(){
        //Erstellt das Board und setzt die Karten auf das Bord.
        //Die festen Karten werden festgesetzt, die anderen Slots werden Random mit anderen Karten besetzt
        //Die letzte Karte wird außerhalb des Spiels als Handkarte gespeichert
        int x;
        int y;
        //Es werden alle x-Koordinaten durchgegangen
        for(x = 0; x < 7; x++){
            //Für jede x-Koordinate wird noch jede Kombination mit y-Koordinaten abgefragt
            for(y = 0; y < 7; y++){
                //Reihe 1
                if(y == 0){
                    switch(x){
                        //Wenn ein Feld mit einer festen karte erreicht wird, dann wird dort die richtige Karte hingesetzt
                        case 0: boardTiles[x][y] = new tileModel(new locationModel(0, x, y, false), false, null, false, "turn", null); break;//oben links
                        //Wenn es ein Feld für eine Random Karte befüllt wird wird die getRandomTile Funktion aufgerufen
                        //Diese Funktion gibt ein Tile zurück, welches noch nicht benutzt ist.
                        case 1: boardTiles[x][y] = getRandomTile(); boardTiles[x][y].location.xCoor = x; boardTiles[x][y].location.yCoor = y; break;
                        case 2: boardTiles[x][y] = new tileModel(new locationModel(90, x, y, false), true, "coins", false, "t-crossing", null); break;
                        case 3: boardTiles[x][y] = getRandomTile(); boardTiles[x][y].location.xCoor = x; boardTiles[x][y].location.yCoor = y; break;
                        case 4: boardTiles[x][y] = new tileModel(new locationModel(90, x, y, false), true, "bible", false, "t-crossing", null); break;
                        case 5: boardTiles[x][y] = getRandomTile(); boardTiles[x][y].location.xCoor = x; boardTiles[x][y].location.yCoor = y; break;
                        case 6: boardTiles[x][y] = new tileModel(new locationModel(270, x, y, false), false, null, false, "turn", null); break;//Unten links
                    }
                }
                if(y == 2){
                    switch(x){
                        case 0: boardTiles[x][y] = new tileModel(new locationModel(180, x, y, false), true, "skull", false, "t-crossing", null); break;
                        case 1: boardTiles[x][y] = getRandomTile(); boardTiles[x][y].location.xCoor = x; boardTiles[x][y].location.yCoor = y; break;
                        case 2: boardTiles[x][y] = new tileModel(new locationModel(90, x, y, false), true, "keys", false, "t-crossing", null); break;
                        case 3: boardTiles[x][y] = getRandomTile(); boardTiles[x][y].location.xCoor = x; boardTiles[x][y].location.yCoor = y; break;
                        case 4: boardTiles[x][y] = new tileModel(new locationModel(0, x, y, false), true, "crown", false, "t-crossing", null); break;
                        case 5: boardTiles[x][y] = getRandomTile(); boardTiles[x][y].location.xCoor = x; boardTiles[x][y].location.yCoor = y; break;
                        case 6: boardTiles[x][y] = new tileModel(new locationModel(0, x, y, false), true, "map", false, "t-crossing", null); break;
                    }
                }
                if(y == 4){
                    switch(x){
                        case 0: boardTiles[x][y] = new tileModel(new locationModel(180, x, y, false), true, "sword", false, "t-crossing", null); break;
                        case 1: boardTiles[x][y] = getRandomTile(); boardTiles[x][y].location.xCoor = x; boardTiles[x][y].location.yCoor = y; break;
                        case 2: boardTiles[x][y] = new tileModel(new locationModel(180, x, y, false), true, "emerald", false, "t-crossing", null); break;
                        case 3: boardTiles[x][y] = getRandomTile(); boardTiles[x][y].location.xCoor = x; boardTiles[x][y].location.yCoor = y; break;
                        case 4: boardTiles[x][y] = new tileModel(new locationModel(270, x, y, false), true, "chest", false, "t-crossing", null); break;
                        case 5: boardTiles[x][y] = getRandomTile(); boardTiles[x][y].location.xCoor = x; boardTiles[x][y].location.yCoor = y; break;
                        case 6: boardTiles[x][y] = new tileModel(new locationModel(0, x, y, false), true, "ring", false, "t-crossing", null); break;
                    }
                }
                if(y == 6){
                    switch(x){
                        case 0: boardTiles[x][y] = new tileModel(new locationModel(90, x, y, false), false, null, false, "turn", null); break;//Oben rechts
                        case 1: boardTiles[x][y] = getRandomTile(); boardTiles[x][y].location.xCoor = x; boardTiles[x][y].location.yCoor = y; break;
                        case 2: boardTiles[x][y] = new tileModel(new locationModel(270, x, y, false), true, "helmet", false, "t-crossing", null); break;
                        case 3: boardTiles[x][y] = getRandomTile(); boardTiles[x][y].location.xCoor = x; boardTiles[x][y].location.yCoor = y; break;
                        case 4: boardTiles[x][y] = new tileModel(new locationModel(270, x, y, false), true, "candleHolder", false, "t-crossing", null); break;
                        case 5: boardTiles[x][y] = getRandomTile(); boardTiles[x][y].location.xCoor = x; boardTiles[x][y].location.yCoor = y; break;
                        case 6: boardTiles[x][y] = new tileModel(new locationModel(180, x, y, false), false, null, false, "turn", null); break;//unten rechts
                    }
                }
                //Alle Plätze in den Spalten 1, 3 und 5 werden immer mit Random Tiles besetzt.
                if(y == 1 || y == 3 || y == 5){
                    boardTiles[x][y] = getRandomTile(); 
                    boardTiles[x][y].location.xCoor = x; 
                    boardTiles[x][y].location.yCoor = y; 
                }
            }
        }
        //Das letzte übrige Tile wird auserhalb des Spiels platziert
        offBoardTile = getRandomTile();
    }
    
    
    public static tileModel getRandomTile(){
        int i = (int) (Math.random() * allTiles.size());
        tileModel tile = allTiles.get(i);
        allTiles.remove(i);
        return tile;
    }
    
    public static int randomRotation(){
        int rotation;
        rotation = (int) (Math.random() * 4);
        switch(rotation){
            case 0: rotation = 0; break;
            case 1: rotation = 90; break;
            case 2: rotation = 180; break;
            case 3: rotation = 270; break;
        
        }
        return rotation;
    }
    
    public static void createTiles(){
        allTiles = new ArrayList();
        
        File file = new File("src/main/resources/all_tiles/straight.png");
        File fileT = new File("src/main/resources/all_tiles/turn.png");
        File file1 = new File("src/main/resources/all_tiles/bat.png");
        File file2 = new File("src/main/resources/all_tiles/dragon.png");
        File file3 = new File("src/main/resources/all_tiles/ghost.png");
        File file4 = new File("src/main/resources/all_tiles/gnome.png");
        File file5 = new File("src/main/resources/all_tiles/moth.png");
        File file6 = new File("src/main/resources/all_tiles/mouse.png");
        File file7 = new File("src/main/resources/all_tiles/owl.png");
        File file8 = new File("src/main/resources/all_tiles/poltergeist.png");
        File file9 = new File("src/main/resources/all_tiles/salamander.png");
        File file0 = new File("src/main/resources/all_tiles/scarab.png");
        File file10 = new File("src/main/resources/all_tiles/spider.png");
        File file11 = new File("src/main/resources/all_tiles/witch.png");
        
        
        
        //CORNERS
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "turn", new Image(fileT.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "turn", new Image(fileT.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "turn", new Image(fileT.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "turn", new Image(fileT.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "turn", new Image(fileT.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "turn", new Image(fileT.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "turn", new Image(fileT.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "turn", new Image(fileT.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "turn", new Image(fileT.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "turn", new Image(fileT.toURI().toString())));
        //turns with tiles
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "owl", false, "turn", new Image(file7.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "moth", false, "turn", new Image(file5.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "mouse", false, "turn", new Image(file6.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "spider", false, "turn", new Image(file10.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "scarab", false, "turn", new Image(file0.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "salamander", false, "turn", new Image(file9.toURI().toString())));
        
        //STRAIGHTS
        //all empty
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight", new Image(file.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight", new Image(file.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight", new Image(file.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight", new Image(file.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight", new Image(file.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight", new Image(file.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight", new Image(file.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight", new Image(file.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight", new Image(file.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight", new Image(file.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight", new Image(file.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), false, null, false, "straight", new Image(file.toURI().toString())));
        
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "witch", false, "t-crossing", new Image(file11.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "dragon", false, "t-crossing", new Image(file2.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "poltergeist", false, "t-crossing", new Image(file8.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "ghost", false, "t-crossing", new Image(file3.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "bat", false, "t-crossing", new Image(file1.toURI().toString())));
        allTiles.add(new tileModel(new locationModel(randomRotation(), 0, 0, false), true, "gnome", false, "t-crossing", new Image(file4.toURI().toString())));
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