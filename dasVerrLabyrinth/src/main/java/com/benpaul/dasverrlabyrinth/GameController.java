package com.benpaul.dasverrlabyrinth;

import static com.benpaul.dasverrlabyrinth.App.boardTiles;
import static com.benpaul.dasverrlabyrinth.App.offBoardTile;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author benbartel
 */
public class GameController extends GameControllerVar implements Initializable {
    
    
    
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        playerTurn = 0;
        //Die Spielfiguren werden an die richtigen Startpositionen gesetzt
        player_red.setX(315);
        player_red.setY(662);
        player_yellow.setX(313);
        player_yellow.setY(141);
        player_blue.setX(828);
        player_blue.setY(143);
        player_green.setX(830);
        player_green.setY(660);
        imgBackgr.setRotate(270);

        //Die Tiles werden auf das Board gesetzt
        makeBoard();

        //Die Spieler werden erstellt.
        playerModel playerRed = new playerModel("Red");
        playerRed.setName("Roter Spieler");
        playerModel playerBlue = new playerModel("Blue");
        playerBlue.setName("Blauer Spieler");
        playerModel playerYellow = new playerModel("Yellow");
        playerYellow.setName("Gelber Spieler");
        playerModel playerGreen = new playerModel("Green");
        playerGreen.setName("Gruener Spieler");

        //Die Spieler werden in App.players gespeichert.
        App.players[0] = playerRed;
        App.players[1] = playerBlue;
        App.players[2] = playerYellow;
        App.players[3] = playerGreen;

        //Den Spielern werden zufälllige Items/Objectives zugeteilt
        for (int i = 0; i < 4; i++) {
            App.players[i].items[0] = App.getRndmItem();
            App.players[i].items[1] = App.getRndmItem();
            App.players[i].items[2] = App.getRndmItem();

            System.out.println("Player " + i + " " + App.players[i].items[0].item);
            System.out.println("Player " + i + " " + App.players[i].items[1].item);
            System.out.println("Player " + i + " " + App.players[i].items[2].item);
        }
        //Die Positionen der Spieler werden gesetzt
        playerYellow.pos[0] = 0;
        playerYellow.pos[1] = 0;

        playerBlue.pos[0] = 0;
        playerBlue.pos[1] = 6;

        playerRed.pos[0] = 6;
        playerRed.pos[1] = 0;

        playerGreen.pos[0] = 6;
        playerGreen.pos[1] = 6;

        //Die Scores der Spieler werden gesetzt
        playerRed.score = 0;

        playerBlue.score = 0;

        playerYellow.score = 0;

        playerGreen.score = 0;

        //Die Positionen der Tiles wird gespeichert
        tileXCoor[0] = 120;
        tileXCoor[1] = 205;
        tileXCoor[2] = 290;
        tileXCoor[3] = 375;
        tileXCoor[4] = 460;
        tileXCoor[5] = 560;
        tileXCoor[6] = 630;

        tileYCoor[0] = 290;
        tileYCoor[1] = 375;
        tileYCoor[2] = 460;
        tileYCoor[3] = 545;
        tileYCoor[4] = 630;
        tileYCoor[5] = 715;
        tileYCoor[6] = 800;

        try {
            //startet das Spiel
            runGame();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    //GAME
    //--------------
    public void runGame() throws Exception {
        labelCardsLeft.setText(App.allItems.size() + "");
        
        if (playerTurn == 4) {
            playerTurn = 0;
        }

        Image cardbackRed;
        File cardbackRedFile = new File("src/main/resources/img/cardbackRed.png");
        cardbackRed = new Image(cardbackRedFile.toURI().toString());
        Image cardbackBlue;
        File cardbackBlueFile = new File("src/main/resources/img/cardbackBlue.png");
        cardbackBlue = new Image(cardbackBlueFile.toURI().toString());
        Image cardbackYellow;
        File cardbackYellowFile = new File("src/main/resources/img/cardbackYellow.png");
        cardbackYellow = new Image(cardbackYellowFile.toURI().toString());
        Image cardbackGreen;
        File cardbackGreenFile = new File("src/main/resources/img/cardbackGreen.png");
        cardbackGreen = new Image(cardbackGreenFile.toURI().toString());

        switch (playerTurn) {
            case 0:
                imgObjRed1.setImage(App.players[0].items[0].img);
                imgObjRed2.setImage(App.players[0].items[1].img);
                imgObjRed3.setImage(App.players[0].items[2].img);
                imgObjBlue1.setImage(cardbackBlue);
                imgObjBlue2.setImage(cardbackBlue);
                imgObjBlue3.setImage(cardbackBlue);
                imgObjYellow1.setImage(cardbackYellow);
                imgObjYellow2.setImage(cardbackYellow);
                imgObjYellow3.setImage(cardbackYellow);
                imgObjGreen1.setImage(cardbackGreen);
                imgObjGreen2.setImage(cardbackGreen);
                imgObjGreen3.setImage(cardbackGreen);
                break;

            case 1:
                imgObjRed1.setImage(cardbackRed);
                imgObjRed2.setImage(cardbackRed);
                imgObjRed3.setImage(cardbackRed);
                imgObjBlue1.setImage(App.players[1].items[0].img);
                imgObjBlue2.setImage(App.players[1].items[1].img);
                imgObjBlue3.setImage(App.players[1].items[2].img);
                imgObjYellow1.setImage(cardbackYellow);
                imgObjYellow2.setImage(cardbackYellow);
                imgObjYellow3.setImage(cardbackYellow);
                imgObjGreen1.setImage(cardbackGreen);
                imgObjGreen2.setImage(cardbackGreen);
                imgObjGreen3.setImage(cardbackGreen);
                break;

            case 2:
                imgObjRed1.setImage(cardbackRed);
                imgObjRed2.setImage(cardbackRed);
                imgObjRed3.setImage(cardbackRed);
                imgObjBlue1.setImage(cardbackBlue);
                imgObjBlue2.setImage(cardbackBlue);
                imgObjBlue3.setImage(cardbackBlue);
                imgObjYellow1.setImage(App.players[2].items[0].img);
                imgObjYellow2.setImage(App.players[2].items[1].img);
                imgObjYellow3.setImage(App.players[2].items[2].img);
                imgObjGreen1.setImage(cardbackGreen);
                imgObjGreen2.setImage(cardbackGreen);
                imgObjGreen3.setImage(cardbackGreen);
                break;

            case 3:
                imgObjRed1.setImage(cardbackRed);
                imgObjRed2.setImage(cardbackRed);
                imgObjRed3.setImage(cardbackRed);
                imgObjBlue1.setImage(cardbackBlue);
                imgObjBlue2.setImage(cardbackBlue);
                imgObjBlue3.setImage(cardbackBlue);
                imgObjYellow1.setImage(cardbackYellow);
                imgObjYellow2.setImage(cardbackYellow);
                imgObjYellow3.setImage(cardbackYellow);
                imgObjGreen1.setImage(App.players[3].items[0].img);
                imgObjGreen2.setImage(App.players[3].items[1].img);
                imgObjGreen3.setImage(App.players[3].items[2].img);
                break;
        }

        if (App.players[playerTurn].isBot) {
            System.out.println("Start Comp Turn");
            startCompTurn();
        } else {
            if (!(tilePhaseOver)) {
                enableTilePhase();
            } else if (!(movingPhaseOver)) {
                enableMovingPhase();
            } else if (tilePhaseOver && movingPhaseOver) {
                for (int i = 0; i < 3; i++) {
                    if (App.players[playerTurn].items[i].equals(App.boardTiles[App.players[playerTurn].pos[0]][App.players[playerTurn].pos[1]].collectable)) {
                        App.players[playerTurn].score = App.players[playerTurn].score + 1;
                        System.out.println("Tile youre looking for found.");
                        if (App.allItems.isEmpty()) {
                            System.out.println("Game is Over");
                            App.setRoot("finishView");
                        } else {
                            App.players[playerTurn].items[i] = App.getRndmItem();
                        }
                    }
                }
                playerTurn++;
                movingPhaseOver = false;
                tilePhaseOver = false;
                botEvalPhaseOver = false;
                botMovingPhaseOver = false;
                botTilePhaseOver = false;
                runGame();
            }
        }
    }

    public void startCompTurn() throws Exception {
        //Started den Zug des Bots. Er überprüft ob bestimmte Phasen des Zuges schon Fertig ist, wenn nicht wird dieser Zug gemacht der Zugteil wird als fertig erklärt 
        //und startCompTurn wird solange ausgeführt bis alle teile des Zuges fertig sind.
        System.out.println("-------------Player: " + App.players[playerTurn].name);
        
        ArrayList<int[]> perfectMoveLoc = new ArrayList();
        
        if (!(botEvalPhaseOver)) {
            //Die Phase in der der Bot sich einen guten Zug sucht.
            //Es werden alle Variablen zurückgesetzt
            botBestPos[0] = null;
            botBestPos[1] = null;
            botBestPosDist = null;
            botCurrObjective[0] = null;
            botCurrObjective[1] = null;
            botBestTileSide = null;
            botBestTileRot = null;
            currTileSide = null;
            
            botTileOptCoor.clear();
            botTileOptConf.clear();
            
            System.out.println("Start Eval Phase");
            //Sucht und findet alle Tiles zu welchen der Bot gehen könnte.
            botFindTiles();
            //Such aus den tiles, von der Methode zuvor.
            //Diese Methode ist das Herz des Bots da man hier genau bestimmen kann auf welchen Parameter der Bot sich den Besten Zug aussucht.
            //Ich hatte jedoch nicht die Zeit hier zu viel zu schreiben.
            findBestTile();
            //Diese Phase ist jetzt vorbei.
            botEvalPhaseOver = true;
            //Es wird mit der nächsten Phase weitergemacht.
            startCompTurn();
            } 
        else if (!(botTilePhaseOver)) {
            //Dies ist die Phase in der der Bot ein Tile in das Board einschiebt.
            enableTilePhase();
            System.out.println("Bot Start Tile Phase");
            System.out.println(botBestTileSide);
            
            App.offBoardTile = botRotateOffTile(App.offBoardTile, botBestTileRot);

            switch (botBestTileSide) {
                case 0: moveColumn(1, 1);   break;
                case 1: moveColumn(3, 1);   break;
                case 2: moveColumn(5, 1);   break;
                case 3: moveRow(1, 0);      break;
                case 4: moveRow(3, 0);      break;
                case 5: moveRow(5, 0);      break;
                case 6: moveColumn(5, 0);   break;
                case 7: moveColumn(3, 0);   break;
                case 8: moveColumn(1, 0);   break;
                case 9: moveRow(5, 1);      break;
                case 10: moveRow(3, 1);     break;
                case 11: moveRow(1, 1);     break;
            }
            botTilePhaseOver = true;
            PauseTransition p = new PauseTransition(Duration.millis(1000));
            p.play();
            p.setOnFinished(e -> {
                try {
                    startCompTurn();
                } catch (Exception ex) {
                }
            });
        } else if (!(botMovingPhaseOver)) {
            enableMovingPhase();
            System.out.println("Bot Moving phase reached");
            
            
            System.out.println("Move to:");
            System.out.println("X: " + botBestPos[0]);
            System.out.println("Y: " + botBestPos[1]);
            moveBot(botBestPos[1], botBestPos[0]);

            PauseTransition p = new PauseTransition(Duration.millis(1000));
            p.play();
            p.setOnFinished(e -> {
                try {
                    startCompTurn();
                } catch (Exception ex) {
                }
            });
            //startCompTurn();
        } else {
            for (int i = 0; i < 3; i++) {
                if (App.players[playerTurn].items[i].equals(App.boardTiles[App.players[playerTurn].pos[0]][App.players[playerTurn].pos[1]].collectable)) {
                    App.players[playerTurn].score = App.players[playerTurn].score + 1;
                    System.out.println("Tile youre looking for found.");
                    if (App.allItems.isEmpty()) {
                        System.out.println("Game is Over");
                        App.setRoot("finishView");
                    } else {
                        App.players[playerTurn].items[i] = App.getRndmItem();
                    }
                }
            }
            System.out.println("PlayerTurn ++");
            playerTurn++;
            botEvalPhaseOver = false;
            botMovingPhaseOver = false;
            botTilePhaseOver = false;
            runGame();
        }
    }
    
    
    public void findBestTile() throws Exception{
        
        boolean goodMoveFound = false;
        
        //Wenn es überhaupt keine Ergebnisse, keine Züge für den Bot gibt, dann wird einfach die Position des Spielers als zug hinzugefügt.
        //Das heist der Spieler bewegt sich nicht.
        if(botTileOptCoor.isEmpty()){
            Integer[] coor = {App.players[playerTurn].pos[0], App.players[playerTurn].pos[1]};
            botTileOptCoor.add(coor);
            Integer[] ld = {0, 0};
            //Es wird auch eingestellt das ganz oben links das tile eingeschoben wird. Dieser Punkt ist random gewählt von mir.
            botTileOptConf.add(ld);
        }
        
        
        ArrayList<Integer[]> goodCoords = new ArrayList();
        ArrayList<Integer[]> goodConf = new ArrayList();
        /*boolean anyExit = false;
        for(int i = 0; i < 4; i++){
            tileModel toBeObs = App.boardTiles[App.players[playerTurn].pos[0]][App.players[playerTurn].pos[1]];
            if(toBeObs.ableToExit[i] && checkNextTileInput(toBeObs, i)){
                anyExit = true;
            }
        }
        
        ArrayList<Integer> rowsToBeMov = new ArrayList();
        ArrayList<Integer> colToBeMov = new ArrayList();
        
        if(!(anyExit)){
            switch(App.players[playerTurn].pos[0]){
                case 0: rowsToBeMov.add(1); break;
                case 1: rowsToBeMov.add(1); break;
                case 2: rowsToBeMov.add(1); rowsToBeMov.add(3); break;
                case 3: rowsToBeMov.add(3); break;
                case 4: rowsToBeMov.add(3); rowsToBeMov.add(5); break;
                case 5: rowsToBeMov.add(5); break;
                case 6: rowsToBeMov.add(5); break;
            }
            switch(App.players[playerTurn].pos[1]){
                case 0: colToBeMov.add(1); break;
                case 1: colToBeMov.add(1); break;
                case 2: colToBeMov.add(1); colToBeMov.add(3); break;
                case 3: colToBeMov.add(3); break;
                case 4: colToBeMov.add(3); colToBeMov.add(5); break;
                case 5: colToBeMov.add(5); break;
                case 6: colToBeMov.add(5); break;
            }
        }
        */
        for(int i = 0; i < botTileOptCoor.size(); i++){
            if (startCheckAlgo(App.players[playerTurn].pos[0], App.players[playerTurn].pos[1], botTileOptCoor.get(i)[0], botTileOptCoor.get(i)[1])) {
                goodCoords.add(botTileOptCoor.get(i));
                goodConf.add(botTileOptConf.get(i));
            }
        }
        
        System.out.println("Print all Possible Tiles:");
        tileFound:
        for(int i = 0; i < goodCoords.size(); i++){
            for(int o = 0; o < 3; o++){
                tileModel tempTile = App.boardTiles[goodCoords.get(i)[0]][goodCoords.get(i)[1]];
                if(tempTile.collectableOnTile){
                    if(tempTile.collectable.equals(App.players[playerTurn].items[o])){
                        botBestPos[0] = goodCoords.get(i)[0];
                        botBestPos[1] = goodCoords.get(i)[1];
                        botBestTileRot = goodConf.get(i)[1];
                        botBestTileSide = goodConf.get(i)[0];
                        goodMoveFound = true;
                        break tileFound;
                    }
                }
            }
            System.out.println(goodCoords.get(i)[0] + " " + goodCoords.get(i)[1]);
        }
        int rndmMove = (int) (Math.random() * goodCoords.size());
        if(!(goodMoveFound)){
            botBestPos[0] = goodCoords.get(rndmMove)[0];
            botBestPos[1] = goodCoords.get(rndmMove)[1];
            botBestTileRot = goodConf.get(rndmMove)[1];
            botBestTileSide = goodConf.get(rndmMove)[0];
        }
        
    }
    
    //Two Temporary ArrLists for Storing all Possible Combinations of Tiles the Bot can Move to, 
    //The Tile Coordinates are Stored in ...Coor and the Configuration in ...Conf.
    //The Configuration consists of two integers, the First indicating the Point where the tile is put into, and the Second, the Rotation of the tile to put into.
    ArrayList<Integer[]> botTileOptCoor = new ArrayList();
    ArrayList<Integer[]> botTileOptConf = new ArrayList();
    //Done
    @SuppressWarnings("ManualArrayToCollectionCopy")
    public void botFindTiles() throws Exception {

        //We Loop through all the Rotations of the OffBoard Tile.
        for (int d = 0; d < 4; d++) {
            //Then we loop through all the Locations where the Tile could be placed.
            //We do this, to make sure to simulate all possible Turns the Bot could make.
            for (int l = 0; l < 12; l++) {
                //Es wird ein tileModel erstellt, welches eine Copy des offBoardTiles ist, die Simulierte Rotation erhällt.
                tileModel tempOffTile = botRotateOffTile(App.offBoardTile, d);
                //Kopiert das Array mit dem gerade benutzten Board auf dieses Temporäre Board
                tileModel[][] tempBoard = new tileModel[7][7];
                for (int x = 0; x < 7; x++) {
                    for (int y = 0; y < 7; y++) {
                        tempBoard[x][y] = App.boardTiles[x][y];
                    }
                }
                //Es wird ein 2.Board erstellt mit welchem wir gleich dann arbeiten können.
                tileModel[][] board;
                //Das tempBoard wird benutztz und es wird an einer stelle das OffBoardTile eingefügt.
                //Dieses wird dann in board gespeichert.
                board = botInsertTileBoard(l, tempBoard, tempOffTile).clone();
                //Nun wird das Board an Funktion weitergegeben, welche alle Tiles in einer ArrayList speichert, zu der der Spieler dann gehen könnte.
                //Es wird dann in der ArrayList botDoneTiles gespeichert.
                startCheckAlgoBot(App.players[playerTurn].pos[0], App.players[playerTurn].pos[1], board);
                
                //Es werden alle Tiles, welcher dem Bot zugänglich sind, durchgegangen.
                for(int i = 0; i < botDoneTiles.size(); i++){
                    if(!(botDoneTiles.isEmpty()) && !(botTileOptCoor.isEmpty())){
                        //Falls dieses tile schon in der neuen Liste eingetragen ist, dann wird dieses übersprungen
                        //Durch diese Methode können Duplicate vermieden werden.
                        boolean duplicate = false;
                        for(int r = 0; r < botTileOptCoor.size(); r++){
                            if(Objects.equals(botTileOptCoor.get(r)[0], botDoneTiles.get(i)[0]) && Objects.equals(botTileOptCoor.get(r)[1], botDoneTiles.get(i)[1])){
                                duplicate = true;
                            }
                        }
                        if(!(duplicate)){
                            botTileOptCoor.add(botDoneTiles.get(i).clone());
                            Integer[] ld = {l, d};
                            botTileOptConf.add(ld);
                        }
                    }
                    else if(botDoneTiles.isEmpty()){
                        //Wenn der Algorithmus keine Ergebnisse hervorbringt.
                    }
                    else if(botTileOptCoor.isEmpty()){
                        //Wenn es noch keine Einträge in dem Neuen Array gibt, dann wird es auf jeden fall hinzugefügt.
                        botTileOptCoor.add(botDoneTiles.get(i).clone());
                        Integer[] ld = {l, d};
                        botTileOptConf.add(ld);
                    }
                }
            }
        }
        
        //Printed alle Werte in die Konsole. Zum Debugging
        for (int i = 0; i < botTileOptCoor.size(); i++) {
            System.out.println("Available Tiles for Player:");
            System.out.println("Coor: " + botTileOptCoor.get(i)[0] + " " + botTileOptCoor.get(i)[1]);
            System.out.println("Conf: " + botTileOptConf.get(i)[0] + " " + botTileOptConf.get(i)[1]);
        }
    }
    //Done
    public tileModel[][] botInsertTileBoard(int l, tileModel[][] tempBoard, tileModel offTempTile) {
        //Das mitgegebene tile wird an der Seite l in das mitgegebene board geschoben.
        //offTemp ist ein ZwischenSpeicher für das OffBoardTile
        tileModel offTemp;
        //Switch für welche seite es eingelegt wird
        switch (l) {
            //Von OBEN nach Unten
            case 0:
                //Es werden alle Tiles einfach in die Bestimmte richtung verschoben
                offTemp = tempBoard[6][1];
                tempBoard[6][1] = tempBoard[5][1];
                tempBoard[5][1] = tempBoard[4][1];
                tempBoard[4][1] = tempBoard[3][1];
                tempBoard[3][1] = tempBoard[2][1];
                tempBoard[2][1] = tempBoard[1][1];
                tempBoard[1][1] = tempBoard[0][1];
                tempBoard[0][1] = offTempTile;
                break;
            case 1:
                offTemp = tempBoard[6][3];
                tempBoard[6][3] = tempBoard[5][3];
                tempBoard[5][3] = tempBoard[4][3];
                tempBoard[4][3] = tempBoard[3][3];
                tempBoard[3][3] = tempBoard[2][3];
                tempBoard[2][3] = tempBoard[1][3];
                tempBoard[1][3] = tempBoard[0][3];
                tempBoard[0][3] = offTempTile;
                break;
            case 2:
                offTemp = tempBoard[6][5];
                tempBoard[6][5] = tempBoard[5][5];
                tempBoard[5][5] = tempBoard[4][5];
                tempBoard[4][5] = tempBoard[3][5];
                tempBoard[3][5] = tempBoard[2][5];
                tempBoard[2][5] = tempBoard[1][5];
                tempBoard[1][5] = tempBoard[0][5];
                tempBoard[0][5] = offTempTile;
                break;
            //Von RECHTS nach links
            case 3:
                offTemp = tempBoard[1][0];
                tempBoard[1][0] = tempBoard[1][1];
                tempBoard[1][1] = tempBoard[1][2];
                tempBoard[1][2] = tempBoard[1][3];
                tempBoard[1][3] = tempBoard[1][4];
                tempBoard[1][4] = tempBoard[1][5];
                tempBoard[1][5] = tempBoard[1][6];
                tempBoard[1][6] = offTempTile;
                break;
            case 4:
                offTemp = tempBoard[3][0];
                tempBoard[3][0] = tempBoard[3][1];
                tempBoard[3][1] = tempBoard[3][2];
                tempBoard[3][2] = tempBoard[3][3];
                tempBoard[3][3] = tempBoard[3][4];
                tempBoard[3][4] = tempBoard[3][5];
                tempBoard[3][5] = tempBoard[3][6];
                tempBoard[3][6] = offTempTile;
                break;
            case 5:
                offTemp = tempBoard[5][0];
                tempBoard[5][0] = tempBoard[5][1];
                tempBoard[5][1] = tempBoard[5][2];
                tempBoard[5][2] = tempBoard[5][3];
                tempBoard[5][3] = tempBoard[5][4];
                tempBoard[5][4] = tempBoard[5][5];
                tempBoard[5][5] = tempBoard[5][6];
                tempBoard[5][6] = offTempTile;
                break;
            //Von UNTEN Nach Oben
            case 6:
                offTemp = tempBoard[0][5];
                tempBoard[0][5] = tempBoard[1][5];
                tempBoard[1][5] = tempBoard[2][5];
                tempBoard[2][5] = tempBoard[3][5];
                tempBoard[3][5] = tempBoard[4][5];
                tempBoard[4][5] = tempBoard[5][5];
                tempBoard[5][5] = tempBoard[6][5];
                tempBoard[6][5] = offTempTile;
                break;
            case 7:
                offTemp = tempBoard[0][2];
                tempBoard[0][3] = tempBoard[1][3];
                tempBoard[1][3] = tempBoard[2][3];
                tempBoard[2][3] = tempBoard[3][3];
                tempBoard[3][3] = tempBoard[4][3];
                tempBoard[4][3] = tempBoard[5][3];
                tempBoard[5][3] = tempBoard[6][3];
                tempBoard[6][3] = offTempTile;
                break;
            case 8:
                offTemp = tempBoard[0][1];
                tempBoard[0][1] = tempBoard[1][1];
                tempBoard[1][1] = tempBoard[2][1];
                tempBoard[2][1] = tempBoard[3][1];
                tempBoard[3][1] = tempBoard[4][1];
                tempBoard[4][1] = tempBoard[5][1];
                tempBoard[5][1] = tempBoard[6][1];
                tempBoard[6][1] = offTempTile;
                break;
            //Von Links nach rechts
            case 9:
                offTemp = tempBoard[5][6];
                tempBoard[5][6] = tempBoard[5][5];
                tempBoard[5][5] = tempBoard[5][4];
                tempBoard[5][4] = tempBoard[5][3];
                tempBoard[5][3] = tempBoard[5][2];
                tempBoard[5][2] = tempBoard[5][1];
                tempBoard[5][1] = tempBoard[5][0];
                tempBoard[5][0] = offTempTile;
                break;
            case 10:
                offTemp = tempBoard[3][6];
                tempBoard[3][6] = tempBoard[3][5];
                tempBoard[3][5] = tempBoard[3][4];
                tempBoard[3][4] = tempBoard[3][3];
                tempBoard[3][3] = tempBoard[3][2];
                tempBoard[3][2] = tempBoard[3][1];
                tempBoard[3][1] = tempBoard[3][0];
                tempBoard[3][0] = offTempTile;
                break;
            case 11:
                offTemp = tempBoard[1][6];
                tempBoard[1][6] = tempBoard[1][5];
                tempBoard[1][5] = tempBoard[1][4];
                tempBoard[1][4] = tempBoard[1][3];
                tempBoard[1][3] = tempBoard[1][2];
                tempBoard[1][2] = tempBoard[1][1];
                tempBoard[1][1] = tempBoard[1][0];
                tempBoard[1][0] = offTempTile;
                break;
        }
        //Es werden die in den tileModels gespeicherten Coordinates neu erneuert.
        for (int x = 0; x < 7; x++) {
            for (int y = 0; y < 7; y++) {
                tempBoard[x][y].location.setxCoor(x);
                tempBoard[x][y].location.setyCoor(y);
            }
        }
        tileModel[][] newBoard = tempBoard.clone();
        return newBoard;
    }
    //Done
    public tileModel botRotateOffTile(tileModel tile, int d) {
        //Es werden die rotations in dem tileModel gesetzt
        switch (d) {
            case 0:
                tile.location.setRotation(0);
                break;
            case 1:
                tile.location.setRotation(90);
                break;
            case 2:
                tile.location.setRotation(180);
                break;
            case 3:
                tile.location.setRotation(270);
                break;
        }
        //Überprüft alle Exits des Tiles, da es gedreht wurde.
        tile.checkExit();
        System.out.println(" ");
        System.out.println("Rotate Bot OffBoard Tile to: " + App.offBoardTile.location.rotation);
        System.out.println(" ");
        return tile;
    }
    //Done
    public void botAnimateOffTile(int d) {
        //Creates new Animation welche das offTile Dreht.
        //Ich habe die Animationszeit auf 0 gesetzt, da es fehler verursacht hat.
        RotateTransition newTrans = new RotateTransition();
        newTrans.setDuration(Duration.millis(0));
        newTrans.setNode(currTile);
        //Je nachdem welche Rotation mitgegeben wurde, wird es zu diesem Angle gedreht.
        switch (d) {
            case 0:
                newTrans.setToAngle(0);
                break;
            case 1:
                newTrans.setToAngle(90);
                break;
            case 2:
                newTrans.setToAngle(180);
                break;
            case 3:
                newTrans.setToAngle(270);
                break;
        }

        newTrans.setCycleCount(1);
        newTrans.setAutoReverse(false);
        newTrans.play();
    }
    //Done
    public void moveBot(int x, int y) {
        //Bewegt den Spieler und dessen Imageview zu den gegebenen Koordinaten.
        switch (playerTurn) {
            case 0:
                //Es werden die Koordinaten der ImageViews geändert.
                player_red.setX(tileYCoor[x]);
                player_red.setY(tileXCoor[y]);
                break;
            case 1:
                player_blue.setX(tileYCoor[x]);
                player_blue.setY(tileXCoor[y]);
                break;
            case 2:
                player_yellow.setX(tileYCoor[x]);
                player_yellow.setY(tileXCoor[y]);
                break;
            case 3:
                player_green.setX(tileYCoor[x]);
                player_green.setY(tileXCoor[y]);
                break;
        }
        //Dann werden die Koordinaten im Objekt des Spielers gspeichert.
        App.players[playerTurn].pos[1] = x;
        App.players[playerTurn].pos[0] = y;

        botMovingPhaseOver = true;

    }
    //Done
    public void checkItemFound() {
        //Überprüft alle Spieler ob diese auf Tiles stehen, mit Items welche die Spieler
        //gerade suchen.
        //o ist der gerade überprüfte Spieler
        for (int o = 0; o < 4; o++) {
            //i ist das Item welches gerade überprüft wird
            for (int i = 0; i < 3; i++) {
                //wenn der Spieler auf dem richtigem Item steht
                if (App.players[o].items[i].equals(App.boardTiles[App.players[o].pos[0]][App.players[o].pos[1]].collectable)) {
                    System.out.println("Tile youre looking for found. Player: " + o);
                    //Es wird dem Spieler ein neues Random Item gegeben.
                    App.players[o].items[i] = App.getRndmItem();
                }
            }
        }
    }
    //Done
    public void enableTilePhase() {
        //Updates das Label mit Instructions
        updateLabel();
        //Setzt alle player ImageViews auf halb-durchsichtig
        player_red.setOpacity(0.5);
        player_blue.setOpacity(0.5);
        player_yellow.setOpacity(0.5);
        player_green.setOpacity(0.5);
        //Disabled alle player imageViews, damit diese nicht verschoben werden können
        player_red.setDisable(true);
        player_blue.setDisable(true);
        player_yellow.setDisable(true);
        player_green.setDisable(true);
        //Das Tile außerhalb des Feldes wird enabled, damit man es bewegen kann.
        currTile.setDisable(false);
        //Und es wird sichtbar gemacht.
        currTile.setOpacity(1);
    }
    //Done
    public void enableMovingPhase() {
        //Updates das Label mit Instructions
        updateLabel();
        //Das tile außerhalb des Feldes wird disabled, damit man es nicht bewegen kann
        currTile.setDisable(true);
        currTile.setOpacity(0.5);
        //Setzt alle player ImageViews auf halb-durchsichtig
        player_red.setOpacity(0.5);
        player_blue.setOpacity(0.5);
        player_yellow.setOpacity(0.5);
        player_green.setOpacity(0.5);
        //Disabled alle imageViews der Spieler
        player_red.setDisable(true);
        player_blue.setDisable(true);
        player_yellow.setDisable(true);
        player_green.setDisable(true);
        //Henachdem welcher Spieler am Zug ist, wird dessen ImageView enabled und sichtbar gemacht
        switch (playerTurn) {
            case 0:
                player_red.setDisable(false);
                player_red.setOpacity(1);
                break;
            case 1:
                player_blue.setDisable(false);
                player_blue.setOpacity(1);
                break;
            case 2:
                player_yellow.setDisable(false);
                player_yellow.setOpacity(1);
                break;
            case 3:
                player_green.setDisable(false);
                player_green.setOpacity(1);
                break;
        }
    }
    //Done
    public void updateLabel() {
        //Updates das Label mit Erklärung für die Spieler
        String player = null;
        String instr = null;
        //Jenachdem wer dran ist, ist der Name verschieden.
        switch (playerTurn) {
            case 0:
                player = "Rot ";
                break;
            case 1:
                player = "Blau ";
                break;
            case 2:
                player = "Gelb ";
                break;
            case 3:
                player = "Grün ";
                break;
        }
        //Jenachdem welche Phase Fertig ist, sind die Anweisungen verschieden.
        if (!(tilePhaseOver)) {
            instr = "eine Karte an das Feld anlegen.";
        } else if (!(movingPhaseOver)) {
            instr = "seine Figur bewegen.";
        }
        //Setzt den Text.
        lblInstr.setText("Der Spieler " + player + "ist am Zug und muss " + instr);
    }
    //Done
    public void startMoveRow(int row, int direction) throws Exception {
        //Es wird überprüft ob der Input Valide ist.
        //Dies ist zur Fehlervermeidung
        if (row == 1 || row == 3 || row == 5) {
            moveRow(row, direction);
        } else {
            throw new Exception("Diese Reihe kann nicht bewegt werden.");
        }
    }
    //Done
    public void moveRow(int row, int direction) throws InterruptedException, Exception {
        //Von rechts schiebend
        if (direction == 0) {
            //Es werden alle Vier Spieler durchgegangen
            for (int i = 0; i < 4; i++) {
                //Wenn die Reihe, auf der der Spieler Steht, die Reihe ist die Bewegt wird, dann True
                if (App.players[i].pos[0] == row) {
                    //Wenn der Spieler am Linken Rand Steht
                    if (App.players[i].pos[1] == 0) {
                        //Dann Wird er nach Rechts ganz an den Rand gesetzt
                        App.players[i].pos[1] = 6;
                        //Jenachdem welcher Spieler es ist, wird auch die richige ImageView verschoben
                        switch (i) {
                            case 0:
                                player_red.setX(tileYCoor[6]);
                                break;
                            case 1:
                                player_blue.setX(tileYCoor[6]);
                                break;
                            case 2:
                                player_yellow.setX(tileYCoor[6]);
                                break;
                            case 3:
                                player_green.setX(tileYCoor[6]);
                                break;
                        }
                    } else {
                        //wenn der Spieler nicht links am Rand steht, dann wird er nach links verschoben, seine ImageView auch
                        switch (i) {
                            case 0:
                                player_red.setX(tileYCoor[App.players[i].pos[1] - 1]);
                                break;
                            case 1:
                                player_blue.setX(tileYCoor[App.players[i].pos[1] - 1]);
                                break;
                            case 2:
                                player_yellow.setX(tileYCoor[App.players[i].pos[1] - 1]);
                                break;
                            case 3:
                                player_green.setX(tileYCoor[App.players[i].pos[1] - 1]);
                                break;
                        }
                        App.players[i].pos[1] -= 1;
                    }
                }
            }
            //Es wird eine Kopie des OffBoardTiles erstellt.
            tileModel offBoardTemp = offBoardTile;
            //Alle tileModels werden in dem Array in App verschoben
            offBoardTile = boardTiles[row][0];
            boardTiles[row][0] = boardTiles[row][1];
            boardTiles[row][1] = boardTiles[row][2];
            boardTiles[row][2] = boardTiles[row][3];
            boardTiles[row][3] = boardTiles[row][4];
            boardTiles[row][4] = boardTiles[row][5];
            boardTiles[row][5] = boardTiles[row][6];
            boardTiles[row][6] = offBoardTemp;
            //Und Das OffBoardTile wird reingeschoben
            //Es wird eine Animation gestarted
            switch (row) {
                case 1:
                    //Der Animation wird mitgegeben wieviele Pixel das Tile sich bewegen muss, welches aus dem Feld geschoben wird.
                    //Alle imageViews beteiligt werden auch als Argumente mitgegeben
                    ImageView[] imgs = {i16, i15, i14, i13, i12, i11, i10};
                    int[] offSetNode = {275, -220};
                    startAnimation(imgs, offSetNode, 2, 1);
                    break;
                case 3:
                    ImageView[] imgs1 = {i36, i35, i34, i33, i32, i31, i30};
                    int[] offSetNode1 = {105, -220};
                    startAnimation(imgs1, offSetNode1, 2, 1);
                    break;
                case 5:
                    ImageView[] imgs2 = {i56, i55, i54, i53, i52, i51, i50};
                    int[] offSetNode2 = {-65, -220};
                    startAnimation(imgs2, offSetNode2, 2, 1);
                    break;
            }
        } //von links schiebend
        else if (direction == 1) {
            //Es werden alle Vier Spieler durchgegangen
            for (int i = 0; i < 4; i++) {
                //Wenn die Reihe, auf der der Spieler Steht, die Reihe ist die Bewegt wird, dann True
                if (App.players[i].pos[0] == row) {
                    //Wenn der Spieler am Linken Rand Steht
                    if (App.players[i].pos[1] == 6) {
                        //Dann Wird er nach Rechts ganz an den Rand gesetzt
                        App.players[i].pos[1] = 0;
                        //Jenachdem welcher Spieler es ist, wird auch die richige ImageView verschoben
                        switch (i) {
                            case 0:
                                player_red.setX(tileYCoor[0]);
                                break;
                            case 1:
                                player_blue.setX(tileYCoor[0]);
                                break;
                            case 2:
                                player_yellow.setX(tileYCoor[0]);
                                break;
                            case 3:
                                player_green.setX(tileYCoor[0]);
                                break;
                        }
                    } else {
                        //wenn der Spieler nicht links am Rand steht, dann wird er nach links verschoben, seine ImageView auch
                        switch (i) {
                            case 0:
                                player_red.setX(tileYCoor[App.players[i].pos[1] + 1]);
                                break;
                            case 1:
                                player_blue.setX(tileYCoor[App.players[i].pos[1] + 1]);
                                break;
                            case 2:
                                player_yellow.setX(tileYCoor[App.players[i].pos[1] + 1]);
                                break;
                            case 3:
                                player_green.setX(tileYCoor[App.players[i].pos[1] + 1]);
                                break;
                        }
                        App.players[i].pos[1] += 1;
                    }
                }
            }
            //Es wird eine Kopie des OffBoardTiles erstellt.
            tileModel offBoardTemp = offBoardTile;
            //Alle tileModels werden in dem Array in App verschoben
            offBoardTile = boardTiles[row][6];
            boardTiles[row][6] = boardTiles[row][5];
            boardTiles[row][5] = boardTiles[row][4];
            boardTiles[row][4] = boardTiles[row][3];
            boardTiles[row][3] = boardTiles[row][2];
            boardTiles[row][2] = boardTiles[row][1];
            boardTiles[row][1] = boardTiles[row][0];
            boardTiles[row][0] = offBoardTemp;
            //Und Das OffBoardTile wird reingeschoben
            //Es wird eine Animation gestarted
            switch (row) {
                case 1:
                    //Der Animation wird mitgegeben wieviele Pixel das Tile sich bewegen muss, welches aus dem Feld geschoben wird.
                    //Alle imageViews beteiligt werden auch als Argumente mitgegeben
                    ImageView[] imgs = {i15, i14, i13, i12, i11, i10, i16};
                    int[] offSetNode = {275, -730};
                    startAnimation(imgs, offSetNode, 1, 1);
                    break;
                case 3:
                    ImageView[] imgs1 = {i35, i34, i33, i32, i31, i30, i36};
                    int[] offSetNode1 = {105, -730};
                    startAnimation(imgs1, offSetNode1, 1, 1);
                    break;
                case 5:
                    ImageView[] imgs2 = {i55, i54, i53, i52, i51, i50, i56};
                    int[] offSetNode2 = {-65, -730};
                    startAnimation(imgs2, offSetNode2, 1, 1);
                    break;
            }
        }
        //Es wird überprüft, ob ein Spieler nach einer Reihenbewegung auf einem seiner 
        //Items steht, welche er sucht.
        checkItemFound();
        //Falls diese Bewegung durch einen Bot gemacht wurde, wird die entsprechende 
        //Phase des Zuges des Bots als beendet erklärt
        if (App.players[playerTurn].isBot) {
            botTilePhaseOver = true;
        }
    }
    //Done
    public void startMoveColumn(int column, int direction) throws Exception {
        //Es wird überprüft ob der Input Valide ist.
        //Dies ist zur Fehlervermeidung
        if (column == 1 || column == 3 || column == 5) {
            moveColumn(column, direction);
        } else {
            throw new Exception("Diese Zeile kann nicht bewegt werden.");
        }
    }
    //Done
    public void moveColumn(int column, int direction) throws Exception {
        //Von unten schiebend
        if (direction == 0) {
            for (int i = 0; i < 4; i++) {
                //Wenn die Reihe, auf der der Spieler Steht, die Reihe ist die Bewegt wird, dann True
                if (App.players[i].pos[1] == column) {
                    //Wenn der Spieler am Linken Rand Steht
                    if (App.players[i].pos[0] == 0) {
                        //Dann Wird er nach Rechts ganz an den Rand gesetzt
                        App.players[i].pos[0] = 6;
                        //Jenachdem welcher Spieler es ist, wird auch die richige ImageView verschoben
                        switch (i) {
                            case 0:
                                player_red.setY(tileXCoor[6]);
                                break;
                            case 1:
                                player_blue.setY(tileXCoor[6]);
                                break;
                            case 2:
                                player_yellow.setY(tileXCoor[6]);
                                break;
                            case 3:
                                player_green.setY(tileXCoor[6]);
                                break;
                        }
                    } else {
                        //wenn der Spieler nicht links am Rand steht, dann wird er nach oben verschoben, seine ImageView auch
                        switch (i) {
                            case 0:
                                player_red.setY(tileXCoor[App.players[i].pos[0] - 1]);
                                break;
                            case 1:
                                player_blue.setY(tileXCoor[App.players[i].pos[0] - 1]);
                                break;
                            case 2:
                                player_yellow.setY(tileXCoor[App.players[i].pos[0] - 1]);
                                break;
                            case 3:
                                player_green.setY(tileXCoor[App.players[i].pos[0] - 1]);
                                break;
                        }
                        App.players[i].pos[0] -= 1;
                    }
                }
            }
            //Es wird eine Kopie des OffBoardTiles erstellt.
            tileModel offBoardTemp = offBoardTile;
            //Alle tileModels werden in dem Array in App verschoben
            offBoardTile = boardTiles[0][column];
            boardTiles[0][column] = boardTiles[1][column];
            boardTiles[1][column] = boardTiles[2][column];
            boardTiles[2][column] = boardTiles[3][column];
            boardTiles[3][column] = boardTiles[4][column];
            boardTiles[4][column] = boardTiles[5][column];
            boardTiles[5][column] = boardTiles[6][column];
            boardTiles[6][column] = offBoardTemp;
            //Und Das OffBoardTile wird reingeschoben
            //Es wird eine Animation gestarted
            switch (column) {
                //Der Animation wird mitgegeben wieviele Pixel das Tile sich bewegen muss, welches aus dem Feld geschoben wird.
                //Alle imageViews beteiligt werden auch als Argumente mitgegeben
                case 1:
                    ImageView[] imgs = {i11, i21, i31, i41, i51, i61, i01};
                    int[] offSetNode = {360, -305};
                    startAnimation(imgs, offSetNode, 2, 2);
                    break;
                case 3:
                    ImageView[] imgs1 = {i13, i23, i33, i43, i53, i63, i03};
                    int[] offSetNode1 = {360, -475};
                    startAnimation(imgs1, offSetNode1, 2, 2);
                    break;
                case 5:
                    ImageView[] imgs2 = {i15, i25, i35, i45, i55, i65, i05};
                    int[] offSetNode2 = {360, -645};
                    startAnimation(imgs2, offSetNode2, 2, 2);
                    break;
            }
        } //von oben schiebend
        else if (direction == 1) {
            for (int i = 0; i < 4; i++) {
                //Wenn die Reihe, auf der der Spieler Steht, die Reihe ist die Bewegt wird, dann True
                if (App.players[i].pos[1] == column) {
                    //Wenn der Spieler am Linken Rand Steht
                    if (App.players[i].pos[0] == 6) {
                        //Dann Wird er nach Rechts ganz an den Rand gesetzt
                        App.players[i].pos[0] = 0;
                        //Jenachdem welcher Spieler es ist, wird auch die richige ImageView verschoben
                        switch (i) {
                            case 0:
                                player_red.setY(tileXCoor[0]);
                                break;
                            case 1:
                                player_blue.setY(tileXCoor[0]);
                                break;
                            case 2:
                                player_yellow.setY(tileXCoor[0]);
                                break;
                            case 3:
                                player_green.setY(tileXCoor[0]);
                                break;
                        }
                    } else {
                        //wenn der Spieler nicht links am Rand steht, dann wird er nach links verschoben, seine ImageView auch
                        switch (i) {
                            case 0:
                                player_red.setY(tileXCoor[App.players[i].pos[0] + 1]);
                                break;
                            case 1:
                                player_blue.setY(tileXCoor[App.players[i].pos[0] + 1]);
                                break;
                            case 2:
                                player_yellow.setY(tileXCoor[App.players[i].pos[0] + 1]);
                                break;
                            case 3:
                                player_green.setY(tileXCoor[App.players[i].pos[0] + 1]);
                                break;
                        }
                        App.players[i].pos[0] += 1;
                    }
                }
            }
            //Es wird eine Kopie des OffBoardTiles erstellt.
            tileModel offBoardTemp = offBoardTile;
            //Alle tileModels werden in dem Array in App verschoben
            offBoardTile = boardTiles[6][column];
            boardTiles[6][column] = boardTiles[5][column];
            boardTiles[5][column] = boardTiles[4][column];
            boardTiles[4][column] = boardTiles[3][column];
            boardTiles[3][column] = boardTiles[2][column];
            boardTiles[2][column] = boardTiles[1][column];
            boardTiles[1][column] = boardTiles[0][column];
            boardTiles[0][column] = offBoardTemp;
            //Und Das OffBoardTile wird reingeschoben
            //Es wird eine Animation gestarted
            switch (column) {
                case 1:
                    //Der Animation wird mitgegeben wieviele Pixel das Tile sich bewegen muss, welches aus dem Feld geschoben wird.
                    //Alle imageViews beteiligt werden auch als Argumente mitgegeben
                    ImageView[] imgs = {i01, i11, i21, i31, i41, i51, i61};
                    int[] offSetNode = {-150, -305};
                    startAnimation(imgs, offSetNode, 1, 2);
                    break;
                case 3:
                    ImageView[] imgs1 = {i03, i13, i23, i33, i43, i53, i63};
                    int[] offSetNode1 = {-150, -475};
                    startAnimation(imgs1, offSetNode1, 1, 2);
                    break;
                case 5:
                    ImageView[] imgs2 = {i05, i15, i25, i35, i45, i55, i65};
                    int[] offSetNode2 = {-150, -645};
                    startAnimation(imgs2, offSetNode2, 1, 2);
                    break;
            }
        }
        //Es wird überprüft, ob ein Spieler nach einer Reihenbewegung auf einem seiner 
        //Items steht, welche er sucht.
        checkItemFound();
        //Falls diese Bewegung durch einen Bot gemacht wurde, wird die entsprechende 
        //Phase des Zuges des Bots als beendet erklärt
        if (App.players[playerTurn].isBot) {
            botTilePhaseOver = true;
        }
    }

    public void startAnimation(ImageView[] images, int[] offsetNode7, int dir, int mode) {

        TranslateTransition rowTranslate1 = new TranslateTransition();
        TranslateTransition rowTranslate2 = new TranslateTransition();
        TranslateTransition rowTranslate3 = new TranslateTransition();
        TranslateTransition rowTranslate4 = new TranslateTransition();
        TranslateTransition rowTranslate5 = new TranslateTransition();
        TranslateTransition rowTranslate6 = new TranslateTransition();
        TranslateTransition rowTranslate7 = new TranslateTransition();

        rowTranslate1.setDuration(Duration.millis(500));
        rowTranslate1.setCycleCount(1);
        rowTranslate1.setAutoReverse(false);
        rowTranslate1.setNode(images[0]);

        rowTranslate2.setDuration(Duration.millis(500));
        rowTranslate2.setCycleCount(1);
        rowTranslate2.setAutoReverse(false);
        rowTranslate2.setNode(images[1]);

        rowTranslate3.setDuration(Duration.millis(500));
        rowTranslate3.setCycleCount(1);
        rowTranslate3.setAutoReverse(false);
        rowTranslate3.setNode(images[2]);

        rowTranslate4.setDuration(Duration.millis(500));
        rowTranslate4.setCycleCount(1);
        rowTranslate4.setAutoReverse(false);
        rowTranslate4.setNode(images[3]);

        rowTranslate5.setDuration(Duration.millis(500));
        rowTranslate5.setCycleCount(1);
        rowTranslate5.setAutoReverse(false);
        rowTranslate5.setNode(images[4]);

        rowTranslate6.setDuration(Duration.millis(500));
        rowTranslate6.setCycleCount(1);
        rowTranslate6.setAutoReverse(false);
        rowTranslate6.setNode(images[5]);

        rowTranslate7.setDuration(Duration.millis(500));
        rowTranslate7.setCycleCount(1);
        rowTranslate7.setAutoReverse(false);
        rowTranslate7.setNode(images[6]);
        rowTranslate7.setByX(offsetNode7[1]);
        rowTranslate7.setByY(offsetNode7[0]);

        if (mode == 1) {
            if (dir == 1) {
                rowTranslate1.setByX(85);
                rowTranslate2.setByX(85);
                rowTranslate3.setByX(85);
                rowTranslate4.setByX(85);
                rowTranslate5.setByX(85);
                rowTranslate6.setByX(85);
            } else if (dir == 2) {
                rowTranslate1.setByX(-85);
                rowTranslate2.setByX(-85);
                rowTranslate3.setByX(-85);
                rowTranslate4.setByX(-85);
                rowTranslate5.setByX(-85);
                rowTranslate6.setByX(-85);
            }
        } else if (mode == 2) {
            if (dir == 1) {
                rowTranslate1.setByY(85);
                rowTranslate2.setByY(85);
                rowTranslate3.setByY(85);
                rowTranslate4.setByY(85);
                rowTranslate5.setByY(85);
                rowTranslate6.setByY(85);
            } else if (dir == 2) {
                rowTranslate1.setByY(-85);
                rowTranslate2.setByY(-85);
                rowTranslate3.setByY(-85);
                rowTranslate4.setByY(-85);
                rowTranslate5.setByY(-85);
                rowTranslate6.setByY(-85);
            }
        }

        rowTranslate1.play();
        rowTranslate2.play();
        rowTranslate3.play();
        rowTranslate4.play();
        rowTranslate5.play();
        rowTranslate6.play();
        rowTranslate7.play();

        rowTranslate7.setOnFinished((ActionEvent event) -> {
            if (mode == 1) {
                if (dir == 1) {
                    images[0].setX(images[0].getX() - 85);
                    images[1].setX(images[1].getX() - 85);
                    images[2].setX(images[2].getX() - 85);
                    images[3].setX(images[3].getX() - 85);
                    images[4].setX(images[4].getX() - 85);
                    images[5].setX(images[5].getX() - 85);
                } else if (dir == 2) {
                    images[0].setX(images[0].getX() + 85);
                    images[1].setX(images[1].getX() + 85);
                    images[2].setX(images[2].getX() + 85);
                    images[3].setX(images[3].getX() + 85);
                    images[4].setX(images[4].getX() + 85);
                    images[5].setX(images[5].getX() + 85);
                }
            } else if (mode == 2) {
                if (dir == 1) {
                    images[0].setY(images[0].getY() - 85);
                    images[1].setY(images[1].getY() - 85);
                    images[2].setY(images[2].getY() - 85);
                    images[3].setY(images[3].getY() - 85);
                    images[4].setY(images[4].getY() - 85);
                    images[5].setY(images[5].getY() - 85);
                } else if (dir == 2) {
                    images[0].setY(images[0].getY() + 85);
                    images[1].setY(images[1].getY() + 85);
                    images[2].setY(images[2].getY() + 85);
                    images[3].setY(images[3].getY() + 85);
                    images[4].setY(images[4].getY() + 85);
                    images[5].setY(images[5].getY() + 85);
                }
            }

            images[6].setX(images[6].getX() - offsetNode7[1]);
            images[6].setY(images[6].getY() - offsetNode7[0]);

            makeBoard();
        });
    }
    //Done
    public void updateTileLoc() {
        //Updates die Location aller Tiles in dem tileModel
        int x, y;
        for (x = 0; x < 7; x++) {
            for (y = 0; y < 7; y++) {
                App.boardTiles[x][y].location.setxCoor(x);
                App.boardTiles[x][y].location.setyCoor(y);
            }
        }
    }
    //Done
    public void makeBoard() {
        //Es werden alle ImageVies mit den Richtigen Images besetzt.
        //Die Images sind alle im board in App gespeichert.
        i01.setImage(App.boardTiles[0][1].tileImage);
        i03.setImage(App.boardTiles[0][3].tileImage);
        i05.setImage(App.boardTiles[0][5].tileImage);
        i10.setImage(App.boardTiles[1][0].tileImage);
        i11.setImage(App.boardTiles[1][1].tileImage);
        i12.setImage(App.boardTiles[1][2].tileImage);
        i13.setImage(App.boardTiles[1][3].tileImage);
        i14.setImage(App.boardTiles[1][4].tileImage);
        i15.setImage(App.boardTiles[1][5].tileImage);
        i16.setImage(App.boardTiles[1][6].tileImage);
        i21.setImage(App.boardTiles[2][1].tileImage);
        i23.setImage(App.boardTiles[2][3].tileImage);
        i25.setImage(App.boardTiles[2][5].tileImage);
        i30.setImage(App.boardTiles[3][0].tileImage);
        i31.setImage(App.boardTiles[3][1].tileImage);
        i32.setImage(App.boardTiles[3][2].tileImage);
        i33.setImage(App.boardTiles[3][3].tileImage);
        i34.setImage(App.boardTiles[3][4].tileImage);
        i35.setImage(App.boardTiles[3][5].tileImage);
        i36.setImage(App.boardTiles[3][6].tileImage);
        i41.setImage(App.boardTiles[4][1].tileImage);
        i43.setImage(App.boardTiles[4][3].tileImage);
        i45.setImage(App.boardTiles[4][5].tileImage);
        i50.setImage(App.boardTiles[5][0].tileImage);
        i51.setImage(App.boardTiles[5][1].tileImage);
        i52.setImage(App.boardTiles[5][2].tileImage);
        i53.setImage(App.boardTiles[5][3].tileImage);
        i54.setImage(App.boardTiles[5][4].tileImage);
        i55.setImage(App.boardTiles[5][5].tileImage);
        i56.setImage(App.boardTiles[5][6].tileImage);
        i61.setImage(App.boardTiles[6][1].tileImage);
        i63.setImage(App.boardTiles[6][3].tileImage);
        i65.setImage(App.boardTiles[6][5].tileImage);
        //Es wird auch das Offboardtile mit dem richtigen Image gesetzt
        currTile.setImage(App.offBoardTile.tileImage);
        //Dreht alle ImageViews richitg rum
        rotateImages();
    }
    //Done
    public void checkExits() {
        //Es werden alle Tiles auf dem Board durchgegangen
        int x, y;
        for (x = 0; x < 7; x++) {
            for (y = 0; y < 7; y++) {
                //Es wird nur zur sicherheit alle Koordinaten erneut gesetzt 
                //Und die Exits aller Tiles werden noch einmal überprüft.
                App.boardTiles[x][y].getLocation().setxCoor(x);
                App.boardTiles[x][y].getLocation().setyCoor(y);
                App.boardTiles[x][y].checkExit();
            }
        }
        //Dies wird außerdem für das Offboardtile gemacht.
        App.offBoardTile.checkExit();
    }
    //Done
    public void rotateImages() {
        //Dreht alle ImageViews auf die richtige weise.
        i01.setRotate(App.boardTiles[0][1].location.rotation);
        App.boardTiles[0][1].getLocation().setRotation((int) i01.getRotate());
        i03.setRotate(App.boardTiles[0][3].location.rotation);
        App.boardTiles[0][3].getLocation().setRotation((int) i03.getRotate());
        i05.setRotate(App.boardTiles[0][5].location.rotation);
        App.boardTiles[0][5].getLocation().setRotation((int) i05.getRotate());
        i10.setRotate(App.boardTiles[1][0].location.rotation);
        App.boardTiles[1][0].getLocation().setRotation((int) i10.getRotate());
        i11.setRotate(App.boardTiles[1][1].location.rotation);
        App.boardTiles[1][1].getLocation().setRotation((int) i11.getRotate());
        i12.setRotate(App.boardTiles[1][2].location.rotation);
        App.boardTiles[1][2].getLocation().setRotation((int) i12.getRotate());
        i13.setRotate(App.boardTiles[1][3].location.rotation);
        App.boardTiles[1][3].getLocation().setRotation((int) i13.getRotate());
        i14.setRotate(App.boardTiles[1][4].location.rotation);
        App.boardTiles[1][4].getLocation().setRotation((int) i14.getRotate());
        i15.setRotate(App.boardTiles[1][5].location.rotation);
        App.boardTiles[1][5].getLocation().setRotation((int) i15.getRotate());
        i16.setRotate(App.boardTiles[1][6].location.rotation);
        App.boardTiles[1][6].getLocation().setRotation((int) i16.getRotate());
        i21.setRotate(App.boardTiles[2][1].location.rotation);
        App.boardTiles[2][1].getLocation().setRotation((int) i21.getRotate());
        i23.setRotate(App.boardTiles[2][3].location.rotation);
        App.boardTiles[2][3].getLocation().setRotation((int) i23.getRotate());
        i25.setRotate(App.boardTiles[2][5].location.rotation);
        App.boardTiles[2][5].getLocation().setRotation((int) i25.getRotate());
        i30.setRotate(App.boardTiles[3][0].location.rotation);
        App.boardTiles[3][0].getLocation().setRotation((int) i30.getRotate());
        i31.setRotate(App.boardTiles[3][1].location.rotation);
        App.boardTiles[3][1].getLocation().setRotation((int) i31.getRotate());
        i32.setRotate(App.boardTiles[3][2].location.rotation);
        App.boardTiles[3][2].getLocation().setRotation((int) i32.getRotate());
        i33.setRotate(App.boardTiles[3][3].location.rotation);
        App.boardTiles[3][3].getLocation().setRotation((int) i33.getRotate());
        i34.setRotate(App.boardTiles[3][4].location.rotation);
        App.boardTiles[3][4].getLocation().setRotation((int) i34.getRotate());
        i35.setRotate(App.boardTiles[3][5].location.rotation);
        App.boardTiles[3][5].getLocation().setRotation((int) i35.getRotate());
        i36.setRotate(App.boardTiles[3][6].location.rotation);
        App.boardTiles[3][6].getLocation().setRotation((int) i36.getRotate());
        i41.setRotate(App.boardTiles[4][1].location.rotation);
        App.boardTiles[4][1].getLocation().setRotation((int) i41.getRotate());
        i43.setRotate(App.boardTiles[4][3].location.rotation);
        App.boardTiles[4][3].getLocation().setRotation((int) i43.getRotate());
        i45.setRotate(App.boardTiles[4][5].location.rotation);
        App.boardTiles[4][5].getLocation().setRotation((int) i45.getRotate());
        i50.setRotate(App.boardTiles[5][0].location.rotation);
        App.boardTiles[5][0].getLocation().setRotation((int) i50.getRotate());
        i51.setRotate(App.boardTiles[5][1].location.rotation);
        App.boardTiles[5][1].getLocation().setRotation((int) i51.getRotate());
        i52.setRotate(App.boardTiles[5][2].location.rotation);
        App.boardTiles[5][2].getLocation().setRotation((int) i52.getRotate());
        i53.setRotate(App.boardTiles[5][3].location.rotation);
        App.boardTiles[5][3].getLocation().setRotation((int) i53.getRotate());
        i54.setRotate(App.boardTiles[5][4].location.rotation);
        App.boardTiles[5][4].getLocation().setRotation((int) i54.getRotate());
        i55.setRotate(App.boardTiles[5][5].location.rotation);
        App.boardTiles[5][5].getLocation().setRotation((int) i55.getRotate());
        i56.setRotate(App.boardTiles[5][6].location.rotation);
        App.boardTiles[5][6].getLocation().setRotation((int) i56.getRotate());
        i61.setRotate(App.boardTiles[6][1].location.rotation);
        App.boardTiles[6][1].getLocation().setRotation((int) i61.getRotate());
        i63.setRotate(App.boardTiles[6][3].location.rotation);
        App.boardTiles[6][3].getLocation().setRotation((int) i63.getRotate());
        i65.setRotate(App.boardTiles[6][5].location.rotation);
        App.boardTiles[6][5].getLocation().setRotation((int) i65.getRotate());
        //Dreht auch das OffBoardTile auf die richtige rotation.
        currTile.setRotate(App.offBoardTile.location.rotation);
        App.offBoardTile.location.setRotation((int) (currTile.getRotate()));
        //Wenn ein Tie gedreht wird, müssen die Exits neu überprüft werden.
        checkExits();
    }
    
    
    //ALGORITHM for evaluating if walking is possible for a Player
    //---------------
    //Done
    public boolean startCheckAlgo(int startX, int startY, int endX, int endY) throws Exception {
        boolean erfolgreich = false;
        //Clearing everything and resetting it.
        //Die Variablen der Ausgänge aller Tiles werden zurückgesetzt
        for (int x = 0; x < 7; x++) {
            for (int y = 0; y < 7; y++) {
                App.boardTiles[x][y].ableToExit[0] = false;
                App.boardTiles[x][y].ableToExit[1] = false;
                App.boardTiles[x][y].ableToExit[2] = false;
                App.boardTiles[x][y].ableToExit[3] = false;
            }
        }
        //Und die Variablen der Ausgänge werden neu geladen. Dies wird zur Fehlervorbeugung getan.
        checkExits();
        //Alle Variablen werden zurückgesetzt damit die Methode ohne Fehler laufen kann.
        //Dies ist die Liste mit allen Tiles, welche noch überprüft werden müssen
        currObsTile.clear();
        //Alle Tiles welche schon überprüft wurden
        alrObsTiles.clear();
        //Ob das gesuchte Objekt schon gefunden wurde
        objecFound = false;
        //Das Start und Endtile wird erstellt damit man einfach damit arbeiten kann.
        tileModel startTile;
        tileModel endTile;

        //Die Koordinaten müssen sich im Spielbaren Feld befinden
        if (startX < 0 || startX > 6 || startY < 0 || startY > 6 || endX < 0 || endX > 6 || endY < 0 || endY > 6) {
            throw new Exception("Die Koordinaten sind ungültig.");
        } else {
            //Setzt Start und Endtile mit den mitgegebenen Koordinaten
            startTile = App.boardTiles[startX][startY];
            endTile = App.boardTiles[endX][endY];
        }
        //Falls der Spieler schon auf dem gesuchten Tile steht wird die Methode schnell beendet.
        if (startX == endX && startY == endY) {
            //Dies überspringt die while-schleife
            objecFound = true;
            System.out.println("Der Spieler ist schon auf dem Richtigen Tile!");
        } else {
            System.out.println("EndX: " + endTile.location.xCoor);
            System.out.println("EndY: " + endTile.location.yCoor);

            System.out.println("Exits of StartTile :");
            System.out.println("Oben" + startTile.ableToExit[0]);
            System.out.println("Rechts" + startTile.ableToExit[1]);
            System.out.println("Unten" + startTile.ableToExit[2]);
            System.out.println("Links" + startTile.ableToExit[3]);
            System.out.println(" ");
            //Es wird ein Object von der Klasse AlgoTile erstellt, welches das tileModel und eine Richtung aus der der Algorithmus gekommen ist beinhalted.
            //Da dies das Starttile ist, wird die Richtung auf Null gesetzt
            algoTile startAlgoTile = new algoTile(null, startTile);
            //Dieses Tile wird zu der "zu überprüfen" Liste hinzugefügt
            currObsTile.add(startAlgoTile);
            //Die Methode startTile überprüft ein bestimmtes tile und sucht nach grenzenden tiles in den der Algorithmus gehen kann
            //Hier wird das Starttile überprüft
            startTile(startAlgoTile, 0);
        }
        //Diese Variable wird erhöht, wenn es kein tile zum überprüfen gibt. Bei der Value 10, wird die Schleife beendet und das EndTile als nicht gefunden erklärt.
        int fCount = 0;
        //Break Flag für die While Loop
        breakWhile:
        //Es wird geloopt so lange das Ziel noch nicht gefunden wurde
        while (!(objecFound)) {
            //Falls öfter als 10mal es keine tiles zum überprüfen gibt, wird die Methode gestoppt
            if (fCount >= 10) {
                System.out.println("---fbreak");
                break;
            } 
            //Falls es nichts zum überprüfen gibt, dann wird der Counter um eins erhöht.
            else if (currObsTile.isEmpty()) {
                fCount++;
                System.out.println("F: " + fCount);
            }

            //continue flag für die For Loop
            breakFor:
            //Geht alle zum überprüfenden tiles durch
            for (int i = 0; i < currObsTile.size(); i++) {
                //Geht alle currently Observed Tiles durch und checkt ob diese das Endtile sind
                //CompareTiles überprüft ob zwei tiles dasselbe sind.
                if (compareTiles(currObsTile.get(i).tile, endTile)) {
                    objecFound = true;
                    System.out.println("--Found EndTile!");
                    //Also, breaks to stop the whole thing immediatly, and not to wait for everything to finish first
                    //Better performance
                    break breakWhile;
                }
                //Wenn dieses Tile schon in der alreadyObservedList ist, dann wird beim nächsten weitergemacht
                for (int o = 0; o < alrObsTiles.size(); o++) {
                    //CompareTiles überprüft ob zwei tiles dasselbe sind.
                    if (compareTiles(alrObsTiles.get(o), (currObsTile.get(i).tile))) {
                        //Dieses Tile wird dann auch aus der "zum überprüfen" liste removed.
                        currObsTile.remove(i);
                        //Es wird beim nächsten tile weitergemacht.
                        continue breakFor;
                    }
                }
                
                System.out.println("-----------------");
                System.out.println("     Check Tile at: " + currObsTile.get(i).tile.location.xCoor + currObsTile.get(i).tile.location.yCoor);
                System.out.println("Tile: " + currObsTile.get(i).tile.tileKind + currObsTile.get(i).tile.collectable + currObsTile.get(i).tile.location.rotation);
                //started eine Überprüfung des tiles.
                //Die Funktion sucht nun tiles, welche neben dem tile sind und erreichbar sind.
                startTile(currObsTile.get(i), i);
            }
        }
        //Nachdem keine Tiles mehr zum überprüfen geben, dann wird nocheinmal geschaut ob das endtile als gefunden erklärt wurde
        if (objecFound) {
            System.out.println("--Algorithmus erfolgreich!");
            erfolgreich = true;
        } else {
            System.out.println("|--Der Spieler kann dort nicht hinlaufen!--|");
        }
        //Es wird zurückgegeben ob der Spieler zu dem EndTile gehen kann.
        return erfolgreich;
    }
    //Done
    public algoTile startTile(algoTile tile, int index) {
        //Alle Seiten aus denen ein Weg geht
        System.out.println("Oben Ausgang: " + tile.tile.ableToExit[0]);
        System.out.println("Rechts Ausgang: " + tile.tile.ableToExit[1]);
        System.out.println("Unten Ausgang: " + tile.tile.ableToExit[2]);
        System.out.println("Links Ausgang: " + tile.tile.ableToExit[3]);
        //Die Seite aus der der Algorithmus gekommen ist wird als false gesetzt
        //Damit er nicht in eine Loop verfällt
        if (!(tile.fromDir == null)) {
            tile.tile.ableToExit[tile.fromDir] = false;
        }

        //Geht alle Seiten des Tiles durch
        for (int i = 0; i < 4; i++) {
            //Wenn die Seite einen Ausgang hat, und das Angrenzende Tile auch, dann true
            if (tile.tile.ableToExit[i] && checkNextTileInput(tile.tile, i)) {
                System.out.println("Hit at Exit Nr.: " + i);
                //o ist die Seite aus der der Algorithmus gekommen ist.
                //Dieser ist das Gegenteil von i, also dem Ausgang, bei dem das currentlyObsTile angeschlagen hat.
                /*
                In diesem beispiel ist die linke Karte das Tile welches gerade überprüft wird, also dieser Methode als Argument gegeben wurde
                Die rechte Karte ist die Karte welche einen Eingang bei der Seite hat, bei welcher die linke karte einen ausgang hat.
                Gleich wird o auf das gegenteil von i gesetzt und die Rechte Karte wird in Schlange zum überprüfen gesetzt.
                der Karte wird o als Direction, aus welcher der Algorithmus gekommen ist, als Argument mitgegeben, damit dieser nicht dahin zurückgeht, wo er schon war.
                |-----|         |------| 
                |     |i=1      |      | 
                |     |      o=3|      | 
                |-----|         |------|
                
                */
                int o = 5;
                switch (i) {
                    case 0: o = 2; break;
                    case 1: o = 3; break;
                    case 2: o = 0; break;
                    case 3: o = 1; break;
                }
                switch (i) {//HIER--------------------
                    //jenachdem auf welcher seite des tiles das passende tile ist, wird dieses der arrList hinzugefügt
                    case 0:
                        currObsTile.add(new algoTile(o, App.boardTiles[tile.tile.location.xCoor - 1][tile.tile.location.yCoor]));
                        System.out.println("up");
                        break;
                    case 1:
                        currObsTile.add(new algoTile(o, App.boardTiles[tile.tile.location.xCoor][tile.tile.location.yCoor + 1]));
                        System.out.println("right");
                        break;
                    case 2:
                        currObsTile.add(new algoTile(o, App.boardTiles[tile.tile.location.xCoor + 1][tile.tile.location.yCoor]));
                        System.out.println("down");
                        break;
                    case 3:
                        currObsTile.add(new algoTile(o, App.boardTiles[tile.tile.location.xCoor][tile.tile.location.yCoor - 1]));
                        System.out.println("left");
                        break;
                }
            }
        }
        //Das fertig überprüfte Tile wird der "Fertige Tiles" liste hinzugefügt.
        currObsTile.remove(index);
        alrObsTiles.add(tile.tile);
        return tile;
    }
    //Done
    public boolean compareTiles(tileModel tile1, tileModel tile2) {
        //Eine HelperFunktion, welche Zwei tiles überprüft ob diese auf der selben Position ist, also das selbe tile ist.
        int x1, y1, x2, y2;
        x1 = tile1.location.xCoor;
        y1 = tile1.location.yCoor;
        x2 = tile2.location.xCoor;
        y2 = tile2.location.yCoor;

        boolean match = false;

        if (x1 == x2 && y1 == y2) {
            match = true;
        }
        return match;
    }
    //Done
    public boolean checkNextTileInput(tileModel currTile, int dir) {
        //Diese Methode überprüft ob das angrenzende tile einen Eingang hat, wo überprüft werden soll.
        boolean w = false;
        //Jenachdem welche Seite als Argument mitgegeben wurde, wird geschaut ob es dort einen Eingang gibt.
        try{
        switch (dir) {
            case 0:
                //Falls ableToExit auf der Richtigen seite true ist, dann gibt es einen Eingang und es ist true
                System.out.println("-Oberes Tile: " + App.boardTiles[currTile.location.xCoor - 1][currTile.location.yCoor].tileKind);
                if (App.boardTiles[currTile.location.xCoor - 1][currTile.location.yCoor].ableToExit[2]) {
                    w = true;
                }
                break;
            case 1:
                System.out.println("-Rechtes Tile: " + App.boardTiles[currTile.location.xCoor][currTile.location.yCoor + 1].tileKind);
                if (App.boardTiles[currTile.location.xCoor][currTile.location.yCoor + 1].ableToExit[3]) {
                    w = true;
                }
                break;
            case 2:
                System.out.println("-Unteres Tile: " + App.boardTiles[currTile.location.xCoor + 1][currTile.location.yCoor].tileKind);
                if (App.boardTiles[currTile.location.xCoor + 1][currTile.location.yCoor].ableToExit[0]) {
                    w = true;
                }
                break;
            case 3:
                System.out.println("-Linkes Tile: " + App.boardTiles[currTile.location.xCoor][currTile.location.yCoor - 1].tileKind);
                if (App.boardTiles[currTile.location.xCoor][currTile.location.yCoor - 1].ableToExit[1]) {
                    w = true;
                }
                break;
        }}
        catch(Exception e){
            w = false;
        }
        return w;
    }
    //Done    
    public class algoTile {
        //Eine Helfer Klasse welche ein tileModel und die Richtung aus der der Algorithmus gekommen ist beinhalted. 
        //Dies ist benötigt, da man so ein Paar von Variablen einfach zusammen in einer ArrayList speicher kann.
        Integer fromDir;
        tileModel tile;

        public algoTile(Integer fromDir, tileModel tile) {
            this.fromDir = fromDir;
            this.tile = tile;
        }
    }

    //--------------
    //Algorithm Done
    //BOT Algorithm START
    //----------------------------
    ArrayList<Integer[]> botDoneTiles = new ArrayList();

    public void startCheckAlgoBot(int startX, int startY, tileModel[][] compBoard) throws Exception {
        //Clearing everything and resetting it.

        for (int x = 0; x < 7; x++) {
            for (int y = 0; y < 7; y++) {
                compBoard[x][y].ableToExit[0] = false;
                compBoard[x][y].ableToExit[1] = false;
                compBoard[x][y].ableToExit[2] = false;
                compBoard[x][y].ableToExit[3] = false;
                compBoard[x][y].getLocation().setxCoor(x);
                compBoard[x][y].getLocation().setyCoor(y);
                compBoard[x][y].checkExit();
            }
        }

        botDoneTiles.clear();
        currObsTile.clear();
        boolean goodTileFound = false;

        tileModel startTile = compBoard[startX][startY];

        algoTile startAlgoTile = new algoTile(null, startTile);
        currObsTile.add(startAlgoTile);

        startTile(startAlgoTile, 0);

        int fCount = 0;
        //Break Flag für die While Loop
        breakWhile:
        //wird ausgeführt während das Ziel noch nicht gefunden wurde
        while (!(goodTileFound)) {
            if (fCount >= 10) {
                System.out.println("---fbreak");
                break;
            } else if (currObsTile.isEmpty()) {
                fCount++;
                System.out.println("F: " + fCount);
            }

            //continue flag für die 'For Loop'
            breakFor:
            //Geht alle currently observed tiles durch
            for (int i = 0; i < currObsTile.size(); i++) {
                //Wenn dieses Tile schon in der alreadyObservedList ist, dann wird beim nächsten weitergemacht
                for (int o = 0; o < botDoneTiles.size(); o++) {
                    if (botDoneTiles.get(o).equals(currObsTile.get(i))) {
                        currObsTile.remove(i);
                        continue breakFor;
                    }
                }

                //System.out.println("-----------------");
                //System.out.println("     Check Tile at: " + currObsTile.get(i).tile.location.xCoor + currObsTile.get(i).tile.location.yCoor);
                //System.out.println("Tile: " + currObsTile.get(i).tile.tileKind + currObsTile.get(i).tile.collectable + currObsTile.get(i).tile.location.rotation);

                startTileBot(currObsTile.get(i), i, compBoard);
            }
        }
        
        System.out.println("Tiles From This Algo: -------------------------------------");
        for (Integer[] tileCoor : botDoneTiles) {
            System.out.println(" ");
            System.out.println(tileCoor[0] + " " + tileCoor[1]);
        }
    }

    public algoTile startTileBot(algoTile tile, int index, tileModel[][] compBoard) {
        //Die Seite aus der der Algorithmus gekommen ist wird als false gesetzt
        //Damit er nicht in eine Loop verfällt
        if (!(tile.fromDir == null)) {
            tile.tile.ableToExit[tile.fromDir] = false;
        }

        //Geht alle Seiten des Tiles durch
        for (int i = 0; i < 4; i++) {
            //Wenn die Seite einen Ausgang hat, und das Angrenzende Tile auch, dann true
            if (tile.tile.ableToExit[i] && checkNextTileInputBot(tile.tile, i, compBoard)) {
                int o = 5;
                switch (i) {
                    case 0:
                        o = 2;
                        break;
                    case 1:
                        o = 3;
                        break;
                    case 2:
                        o = 0;
                        break;
                    case 3:
                        o = 1;
                        break;
                }
                switch (i) {//HIER--------------------
                    //jenachdem auf welcher seite des tiles das passende tile ist, wird dieses der arrList hinzugefügt
                    case 0:
                        currObsTile.add(new algoTile(o, compBoard[tile.tile.location.xCoor - 1][tile.tile.location.yCoor]));
                        break;
                    case 1:
                        currObsTile.add(new algoTile(o, compBoard[tile.tile.location.xCoor][tile.tile.location.yCoor + 1]));
                        break;
                    case 2:
                        currObsTile.add(new algoTile(o, compBoard[tile.tile.location.xCoor + 1][tile.tile.location.yCoor]));
                        break;
                    case 3:
                        currObsTile.add(new algoTile(o, compBoard[tile.tile.location.xCoor][tile.tile.location.yCoor - 1]));
                        break;
                }
            }
        }
        currObsTile.remove(index);
        Integer[] coorTile = {tile.tile.location.xCoor, tile.tile.location.yCoor};
        botDoneTiles.add(coorTile);
        return tile;
    }

    public boolean checkNextTileInputBot(tileModel currTile, int dir, tileModel[][] compBoard) {
        boolean w = false;
        try {
            switch (dir) {//HIER--------------------
                case 0:
                    //System.out.println("-Oberes Tile: " + compBoard[currTile.location.xCoor - 1][currTile.location.yCoor].tileKind);
                    if (compBoard[currTile.location.xCoor - 1][currTile.location.yCoor].ableToExit[2]) {
                        w = true;
                    }
                    break;
                case 1:
                    //System.out.println("-Rechtes Tile: " + compBoard[currTile.location.xCoor][currTile.location.yCoor + 1].tileKind);
                    if (compBoard[currTile.location.xCoor][currTile.location.yCoor + 1].ableToExit[3]) {
                        w = true;
                    }
                    break;
                case 2:
                    //System.out.println("-Unteres Tile: " + compBoard[currTile.location.xCoor + 1][currTile.location.yCoor].tileKind);
                    if (compBoard[currTile.location.xCoor + 1][currTile.location.yCoor].ableToExit[0]) {
                        w = true;
                    }
                    break;
                case 3:
                    //System.out.println("-Linkes Tile: " + compBoard[currTile.location.xCoor][currTile.location.yCoor - 1].tileKind);
                    if (compBoard[currTile.location.xCoor][currTile.location.yCoor - 1].ableToExit[1]) {
                        w = true;
                    }
                    break;
            }
        } catch (Exception e) {
            w = false;
        }
        return w;
    }

    public void checkDistance(tileModel currTile) {
        //botCurrObjective
        System.out.println("------------------------------------------------------->");
        System.out.println("Start Check Distance");
        System.out.println("Side: " + currTileSide);
        int xDist, yDist;
        if (currTile.location.xCoor > botCurrObjective[0]) {
            xDist = currTile.location.xCoor - botCurrObjective[0];
        } else if (currTile.location.xCoor < botCurrObjective[0]) {
            xDist = botCurrObjective[0] - currTile.location.xCoor;
        } else {
            xDist = 0;
        }

        if (currTile.location.yCoor > botCurrObjective[1]) {
            yDist = currTile.location.yCoor - botCurrObjective[1];
        } else if (currTile.location.yCoor < botCurrObjective[1]) {
            yDist = botCurrObjective[1] - currTile.location.yCoor;
        } else {
            yDist = 0;
        }
        System.out.println("XDist: " + xDist);
        System.out.println("YDist: " + yDist);

        if (botBestPosDist > (xDist + yDist)) {
            botBestPosDist = xDist + yDist;
            botBestPos[0] = currTile.location.xCoor;
            botBestPos[1] = currTile.location.yCoor;
            botBestTileSide = currTileSide;
            System.out.println("New Best Tile, Dist: " + botBestPosDist + " Location: " + botBestPos[0] + botBestPos[1]);
        }
        System.out.println("------------------------------------------------------->");
    }

    //Rotates the Off-Board Tile
    @FXML
    private void currTileRight(ActionEvent event) {
        
        RotateTransition newTrans = new RotateTransition();
        newTrans.setDuration(Duration.millis(200));
        newTrans.setNode(currTile);
        newTrans.setByAngle(90);
        newTrans.setCycleCount(1);
        newTrans.setAutoReverse(false);
        newTrans.play();

        btnDrehen.setDisable(true);

        newTrans.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btnDrehen.setDisable(false);
            }
        });

        if (App.offBoardTile.location.rotation == 270) {
            App.offBoardTile.location.setRotation(0);
        } else {
            App.offBoardTile.location.setRotation(App.offBoardTile.location.rotation + 90);
        }
        System.out.println("Rotate OffBoard Tile to: " + App.offBoardTile.location.rotation);
    }

    //-------------------------------
    //Drag 'n Drop --> OffBoard Tile
    
    
    //-------------------------------ALLES HIER UNTER DONE--------------------------------------------------------
    @FXML
    private void tileDrag(MouseEvent event) {
        
        //setzt die Variable dragDetect in event auf true, d.h. dass erkannt wird, dass die Maus gedragt wird
        event.setDragDetect(true);
    }

    @FXML
    private void tileDragDetec(MouseEvent event) {
        
        //gibt in der Konsole aus, dass ein Drag geschieht
        System.out.println("Source Img drag detected");

        //erstellt ein Dragboard mit der Node des aktuellen Tiles
        Dragboard db = currTile.startDragAndDrop(TransferMode.ANY);
        
        //erstellt ein neues Clipboard mit dem Content "ImageView source text"
        ClipboardContent content = new ClipboardContent();
        content.putString("ImageView source text");

        //legt die Einstellungen für den Screenshot fest
        SnapshotParameters param = new SnapshotParameters();
        param.setFill(Color.TRANSPARENT);
        
        //erstellt einen Screenshot der ImageView currTile
        Image temp = currTile.snapshot(param, null);

        //packt das Bild in des Content des Clipboards
        content.putImage(temp);
        //packt den Content in das Dragboard
        db.setContent(content);
    }

    
    //---------------------------------------------------------------------------------------------------
    @FXML
    private void redPlayerDrag(MouseEvent event) {
        
        //setzt die Variable dragDetect in event auf true, d.h. dass erkannt wird, dass die Maus gedragt wird
        event.setDragDetect(true);
    }

    @FXML
    private void redPlayerDragDetec(MouseEvent event) {
        
        //gibt in der Konsole aus, dass ein Drag geschieht
        System.out.println("Source Img drag detected");

        //erstellt ein Dragboard mit der Node des roten Spielers
        Dragboard db = player_red.startDragAndDrop(TransferMode.ANY);

        //erstellt ein neues Clipboard mit dem Content "player"
        ClipboardContent content = new ClipboardContent();
        content.putString("player");

        //stellt ein, dass man wenn man dragt ein Bild des Spielers unter der Maus hat (fügt dem Content ein Bild hinzu)
        File red = new File("src/main/resources/all_tiles/red_player.png");
        content.putImage(new Image(red.toURI().toString()));
        db.setContent(content);
    }
    //---------------------------------------------------------------------------------------------------
    //Dieser Bereich wird für alle Farben wiederholt 

    @FXML
    private void yellowPlayerDrag(MouseEvent event) {
        event.setDragDetect(true);
    }

    @FXML
    private void yellowPlayerDragDetec(MouseEvent event) {
        System.out.println("Source Img drag detected");

        Dragboard db = player_yellow.startDragAndDrop(TransferMode.ANY);

        ClipboardContent content = new ClipboardContent();
        content.putString("player");

        File yellow = new File("src/main/resources/all_tiles/yellow_player.png");
        content.putImage(new Image(yellow.toURI().toString()));
        db.setContent(content);
    }

    @FXML
    private void bluePlayerDrag(MouseEvent event) {
        event.setDragDetect(true);
    }

    @FXML
    private void bluePlayerDragDetec(MouseEvent event) {
        System.out.println("Source Img drag detected");

        Dragboard db = player_blue.startDragAndDrop(TransferMode.ANY);

        ClipboardContent content = new ClipboardContent();
        content.putString("player");

        File blue = new File("src/main/resources/all_tiles/blue_player.png");
        content.putImage(new Image(blue.toURI().toString()));
        db.setContent(content);
    }

    @FXML
    private void greenPlayerDrag(MouseEvent event) {
        event.setDragDetect(true);
    }

    @FXML
    private void greenPlayerDragDetec(MouseEvent event) {
        System.out.println("Source Img drag detected");

        Dragboard db = player_green.startDragAndDrop(TransferMode.ANY);

        ClipboardContent content = new ClipboardContent();
        content.putString("player");

        File green = new File("src/main/resources/all_tiles/green_player.png");
        content.putImage(new Image(green.toURI().toString()));
        db.setContent(content);
    }

    
    
    //TARGETs FOR DROPPING
    //---------------------------------------------------------------------------------------------------
    @FXML
    private void dp1DragOver(DragEvent event) {
        
        //überprüft, ob der Inhalt des Strings im Dragboard "ImageView source text" ist
        if (event.getDragboard().getString().equals("ImageView source text")) {
            
            //bestätigt, dass man das Dragboard hier droppen kann
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        //bewirkt, dass das Event nicht an spätere event-listener gesendet wird
        event.consume();
    }

    @FXML
    private void dp1DragDrop(DragEvent event) throws Exception {
        
        //definiert das Dragboard db, mit dem Inhalt des Dragboards des Events
        //ein Dragboard ist das, was man mit dem Mauszeiger bewegt bzw. aufnimmt
        Dragboard db = event.getDragboard();
        
        //überprüft, ob sich im Dragboard db ein String befindet
        if (db.hasString()) {
            
            //gibt in der Konsole aus, wo das Tile gedroppt wurde
            System.out.println("Dropped at DropPoint 1");
            
            //setzt die Variable TilePhaseOver auf true, sagt also, dass die Tile-legephase vorbei ist
            tilePhaseOver = true;
            //managed den Zug (Zentrale Kontrolle des Spiels)
            runGame();
            //Bewegt die Column 1 in Richtung 1
            moveColumn(1, 1);
            //beendet den "Dropmodus" der Maus
            event.setDropCompleted(true);
            //wenn sich im Dragboard kein String befindet, wird der "Dropmodus" nicht beendet
        } else {
            event.setDropCompleted(false);
        }
        //bewirkt, dass das Event nicht an spätere event-listener gesendet wird
        event.consume();
    }
    //---------------------------------------------------------------------------------------------------
    //Dieser Bereich wird für alle Droppoints an denen man Tiles droppen kann wiederholt
    
    @FXML
    private void dp2DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("ImageView source text")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void dp2DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 2");
            tilePhaseOver = true;
            runGame();
            moveColumn(3, 1);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void dp3DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("ImageView source text")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void dp3DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 3");
            tilePhaseOver = true;
            runGame();
            moveColumn(5, 1);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void dp4DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("ImageView source text")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void dp4DragDrop(DragEvent event) throws InterruptedException, Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 4");
            tilePhaseOver = true;
            runGame();
            moveRow(1, 0);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void dp5DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("ImageView source text")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void dp5DragDrop(DragEvent event) throws InterruptedException, Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 5");
            tilePhaseOver = true;
            runGame();
            moveRow(3, 0);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void dp6DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("ImageView source text")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void dp6DragDrop(DragEvent event) throws InterruptedException, Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 6");
            tilePhaseOver = true;
            runGame();
            moveRow(5, 0);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void dp7DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("ImageView source text")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void dp7DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 7");
            tilePhaseOver = true;
            runGame();
            moveColumn(5, 0);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void dp8DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("ImageView source text")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void dp8DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 8");
            tilePhaseOver = true;
            runGame();
            moveColumn(3, 0);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void dp9DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("ImageView source text")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void dp9DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 9");
            tilePhaseOver = true;
            runGame();
            moveColumn(1, 0);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void dp10DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("ImageView source text")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void dp10DragDrop(DragEvent event) throws InterruptedException, Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 10");
            tilePhaseOver = true;
            runGame();
            moveRow(5, 1);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void dp11DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("ImageView source text")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void dp11DragDrop(DragEvent event) throws InterruptedException, Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 11");
            tilePhaseOver = true;
            runGame();
            moveRow(3, 1);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void dp12DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("ImageView source text")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void dp12DragDrop(DragEvent event) throws InterruptedException, Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 12");
            tilePhaseOver = true;
            runGame();
            moveRow(1, 1);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    private void movePlayer(double mouseX, double mouseY, int x, int y) throws Exception {

        //für genauen Droppoint mit der Maus, sodass auf der Spitze des Mauzeigers gedroppt wird
        mouseX -= 30;
        mouseY -= 30;

        //erstellt neues Array aus zwei Integern für die alten Positionen der Spieler auf den Tiles
        int[] oldRedTilePos = new int[2];
        int[] oldBlueTilePos = new int[2];
        int[] oldYellowTilePos = new int[2];
        int[] oldGreenTilePos = new int[2];

        //setzt beide Integer in den Arrays, abhängig von der nicht aktualisierten Position des Spielers
        oldRedTilePos[0] = App.players[0].pos[0];
        oldRedTilePos[1] = App.players[0].pos[1];

        oldBlueTilePos[0] = App.players[1].pos[0];
        oldBlueTilePos[1] = App.players[1].pos[1];

        oldYellowTilePos[0] = App.players[2].pos[0];
        oldYellowTilePos[1] = App.players[2].pos[1];

        oldGreenTilePos[0] = App.players[3].pos[0];
        oldGreenTilePos[1] = App.players[3].pos[1];

        //überprüft, welcher Spieler am Zug ist
        switch (playerTurn) {
            
            //------------------------------------------------------------------------------------------------------------------------------
            //falls der rote Spieler am Zug ist:
            case 0:
                
                //gibt in der Konsole die alte Position des roten Spielers aus
                System.out.println("Alte Spielerposition: " + oldRedTilePos[0] + " " + oldRedTilePos[1]);
                
                //gibt in der Konsole die Mausposition aus
                System.out.println("Mausposition: " + x + " " + y);
                
                //überprüft, ob der Algorithmus erfolgreich war
                if (startCheckAlgo(oldRedTilePos[0], oldRedTilePos[1], x, y)) {
                    
                    //setzt die Position des roten Spielers auf mouseX und mouseY
                    player_red.setX(mouseX);
                    player_red.setY(mouseY);
                    //ändert die position des roten Spielers in der ArrayList
                    App.players[0].pos[0] = x;
                    App.players[0].pos[1] = y;
                    //gibt in der Konsole die Neue Spielerposition von rot aus
                    System.out.println("Spielerposition (red): " + App.players[0].pos[0] + " " + App.players[0].pos[1]);
                    
                    //setzt die Variable movingPhaseOver auf true, d.h. dass die Phase, in der der Spieler bewegt wird, vorbei ist
                    movingPhaseOver = true;
                    //managed den Zug (Zentrale Kontrolle des Spiels)
                    runGame();
                //gibt einen Fehlercode in der Konsole aus falls der Algorithmus nicht erfolgreich war, der Spieler also nicht zu der gewünschten Position ziehen kann
                } else {
                    throw new Exception("Der Weg des Spielers ist versperrt");
                }
                break;
                //------------------------------------------------------------------------------------------------------------------------------
                //Dieser Bereich wird für die anderen Spieler mit anderen Farben wiederholt

            case 1:
                System.out.println("Alte Spielerposition: " + oldBlueTilePos[0] + " " + oldBlueTilePos[1]);
                System.out.println("Mausposition: " + x + " " + y);
                if (startCheckAlgo(oldBlueTilePos[0], oldBlueTilePos[1], x, y)) {
                    player_blue.setX(mouseX);
                    player_blue.setY(mouseY);
                    App.players[1].pos[0] = x;
                    App.players[1].pos[1] = y;
                    System.out.println("Spielerposition (blue): " + App.players[1].pos[0] + " " + App.players[1].pos[1]);
                    movingPhaseOver = true;
                    runGame();
                } else {
                    throw new Exception("Der Weg des Spielers ist versperrt");
                }
                break;

            case 2:
                System.out.println("Alte Spielerposition: " + oldYellowTilePos[0] + " " + oldYellowTilePos[1]);
                System.out.println("Mausposition: " + x + " " + y);
                if (startCheckAlgo(oldYellowTilePos[0], oldYellowTilePos[1], x, y)) {
                    player_yellow.setX(mouseX);
                    player_yellow.setY(mouseY);
                    App.players[2].pos[0] = x;
                    App.players[2].pos[1] = y;
                    System.out.println("Spielerposition (yellow): " + App.players[2].pos[0] + " " + App.players[2].pos[1]);
                    movingPhaseOver = true;
                    runGame();
                } else {
                    throw new Exception("Der Weg des Spielers ist versperrt");
                }
                break;

            case 3:
                System.out.println("Alte Spielerposition: " + oldGreenTilePos[0] + " " + oldGreenTilePos[1]);
                System.out.println("Mausposition: " + x + " " + y);
                if (startCheckAlgo(oldGreenTilePos[0], oldGreenTilePos[1], x, y)) {
                    player_green.setX(mouseX);
                    player_green.setY(mouseY);
                    App.players[3].pos[0] = x;
                    App.players[3].pos[1] = y;
                    System.out.println("Spielerposition (green): " + App.players[3].pos[0] + " " + App.players[3].pos[1]);
                    movingPhaseOver = true;
                    runGame();
                } else {
                    throw new Exception("Der Weg des Spielers ist versperrt");
                }
                break;
        }

        //App.players[0].setPos(mouseX mouseY);
    }

    //DRAG AND DROP
    
    //---------------------------------------------------------------------------------------------------------------------
    @FXML
    private void Ti00DragOver(DragEvent event) {
        
        //überprüft, ob das bewegte Objekt ein Spieler ist, indem er sich das Dragboard holt
        if (event.getDragboard().getString().equals("player")) {
            
            //bestätigt, dass man das Dragboard hier droppen kann
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        //bewirkt, dass das Event nicht an spätere event-listener gesendet wird
        event.consume();
    }

    @FXML
    private void Ti00DragDrop(DragEvent event) throws Exception {
        
        //definiert das Dragboard db, mit dem Inhalt des Dragboards des Events
        //ein Dragboard ist das, was man mit dem Mauszeiger bewegt bzw. aufnimmt
        Dragboard db = event.getDragboard();
        
        //überprüft, ob sich im Dragboard db ein String befindet
        if (db.hasString()) {
            
            //gibt in der Konsole aus, wo der Spieler gedroppt wurde
            System.out.println("Dropped at DropPoint 00");

            //speichert die Mausposition (eventSceneX und eventSceneY) in mouseX und mouseY
            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            
            //führt die Methode movePlayer() mit den Angaben der Mausposition und der Tileposition aus
            movePlayer(mouseX, mouseY, 0, 0);
            
            //beendet den "Dropmodus" der Maus
            event.setDropCompleted(true);
        //wenn sich im Dragboard kein String befindet, wird der "Dropmodus" nicht beendet
        } else {
            event.setDropCompleted(false);
        }
        //bewirkt, dass das Event nicht an spätere event-listener gesendet wird
        event.consume();
    }
    //---------------------------------------------------------------------------------------------------------------------
    //dieser Bereich wird für alle Tiles, d.h. alle Droppoints für Player wiederholt
    
    
    @FXML
    private void Ti01DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti01DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 01");

            double mouseX = event.getSceneX();

            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 0, 1);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti02DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti02DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 02");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 0, 2);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti03DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti03DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 03");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 0, 3);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti04DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti04DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 04");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 0, 4);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti05DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti05DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 05");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 0, 5);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti06DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti06DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 06");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 0, 6);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti10DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti10DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 10");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 1, 0);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti11DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti11DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 11");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 1, 1);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti12DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti12DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 12");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 1, 2);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti13DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti13DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 13");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 1, 3);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti14DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti14DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 14");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 1, 4);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti15DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti15DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 15");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 1, 5);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti16DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti16DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 16");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 1, 6);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti20DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti20DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 20");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 2, 0);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti21DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti21DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 21");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 2, 1);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti22DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti22DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 22");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 2, 2);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti23DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti23DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 23");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 2, 3);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti24DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti24DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 24");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 2, 4);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti25DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti25DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 25");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 2, 5);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti26DragOver(DragEvent event) throws Exception {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti26DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 26");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 2, 6);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti30DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti30DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 30");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 3, 0);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti31DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti31DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 31");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 3, 1);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti32DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti32DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 32");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 3, 2);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti33DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti33DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 33");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 3, 3);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti34DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti34DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 34");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 3, 4);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti35DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti35DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 35");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 3, 5);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti36DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti36DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 36");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 3, 6);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti40DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti40DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 40");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 4, 0);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti41DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti41DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 41");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 4, 1);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti42DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti42DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 42");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 4, 2);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti43DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti43DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 43");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 4, 3);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti44DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti44DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 44");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 4, 4);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti45DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti45DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 45");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 4, 5);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti46DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti46DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 46");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 4, 6);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti50DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti50DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 50");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 5, 0);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti51DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti51DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 51");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 5, 1);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti52DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti52DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 52");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 5, 2);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti53DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti53DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 53");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 5, 3);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti54DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti54DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 54");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 5, 4);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti55DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti55DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 55");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 5, 5);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti56DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti56DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 56");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 5, 6);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti60DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti60DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 60");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 6, 0);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti61DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti61DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 61");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 6, 1);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti62DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti62DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 62");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 6, 2);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti63DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti63DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 63");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 6, 3);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti64DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti64DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 64");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 6, 4);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti65DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti65DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 65");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 6, 5);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @FXML
    private void Ti66DragOver(DragEvent event) {
        if (event.getDragboard().getString().equals("player")) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void Ti66DragDrop(DragEvent event) throws Exception {
        Dragboard db = event.getDragboard();
        if (db.hasString()) {
            System.out.println("Dropped at DropPoint 66");

            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            movePlayer(mouseX, mouseY, 6, 6);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

}
