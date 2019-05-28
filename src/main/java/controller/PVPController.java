package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rpsFX.manager.GameManager;
import rpsFX.network.Client;
import rpsFX.state.Choice;
import rpsFX.state.Player;

import java.io.IOException;

/**
 * Class controlling the Player vs Player scene.
 */
///CLOVER:OFF
public class PVPController {

    static Logger logger = LoggerFactory.getLogger(PVPController.class);

    @FXML
    ImageView playerChoiceImg;
    @FXML
    ImageView enemyChoiceImg;
    @FXML
    Button backButton;
    @FXML
    TextField playerScore;
    @FXML
    TextField enemyScore;
    @FXML
    Label gameDesc;

    Image rockIcon = new Image("/images/rockicon.png");
    Image paperIcon = new Image("/images/papericon.png");
    Image scissorsIcon = new Image("/images/scissorsicon.png");
    Image giceupIcon = new Image("/images/giveupicon.png");
    Image noChoiceIcon = new Image("/images/choice.png");

    static Player player = new Player("user");
    Player enemy = new Player("enemy");

    GameManager gameManager = new GameManager();
    Client client = new Client();

    boolean isGameOver = false;

    /**
     * Method handling the Rock button.
     * @param event ActionEvent.
     */
    @FXML
    private void handleRockButton(ActionEvent event) {
        try {
            playerChoiceImg.setImage(rockIcon);
            player.setChoice(Choice.ROCK);

            client.connection("ROCK");

            switch (client.playerResult) {
                case "WIN": player.setScore(player.getScore() + 1); break;
                case "LOSE": enemy.setScore(enemy.getScore() + 1); break;
                case "DRAW": player.setScore(player.getScore() + 1); enemy.setScore(enemy.getScore() + 1); break;
                case "OVER": isGameOver = true; break;
            }

            if (isGameOver) {
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/gameover.fxml"));
                Scene resultScene = new Scene(root);

                Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                window.setScene(resultScene);
                window.show();

                playerScore.setText("0");
                enemyScore.setText("0");
                player.setScore(0);
                enemy.setScore(0);
            }

            playerScore.setText(Integer.toString(player.getScore()));
            enemyScore.setText(Integer.toString(enemy.getScore()));
        } catch (IOException ex) {
            logger.error("Exception: " + ex);
        }


    }

    /**
     * Method handling the Paper button.
     * @param event ActionEvent.
     */
    @FXML
    private void handlePaperButton(ActionEvent event) {
        try {
            playerChoiceImg.setImage(paperIcon);
            player.setChoice(Choice.PAPER);

            client.connection("PAPER");

            switch (client.playerResult) {
                case "WIN": player.setScore(player.getScore() + 1); break;
                case "LOSE": enemy.setScore(enemy.getScore() + 1); break;
                case "DRAW": player.setScore(player.getScore() + 1); enemy.setScore(enemy.getScore() + 1); break;
                case "OVER": isGameOver = true; break;
            }

            if (isGameOver) {
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/gameover.fxml"));
                Scene resultScene = new Scene(root);

                Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                window.setScene(resultScene);
                window.show();

                playerScore.setText("0");
                enemyScore.setText("0");
                player.setScore(0);
                enemy.setScore(0);
            }

            playerScore.setText(Integer.toString(player.getScore()));
            enemyScore.setText(Integer.toString(enemy.getScore()));
        } catch (IOException ex) {
            logger.error("Exception: " + ex);
        }
    }

    /**
     * Method handling the Scissors button.
     * @param event ActionEvent.
     */
    @FXML
    private void handleScissorsButton(ActionEvent event) {
        try {
            playerChoiceImg.setImage(scissorsIcon);
            player.setChoice(Choice.SCISSORS);

            client.connection("SCISSORS");

            switch (client.playerResult) {
                case "WIN": player.setScore(player.getScore() + 1); break;
                case "LOSE": enemy.setScore(enemy.getScore() + 1); break;
                case "DRAW": player.setScore(player.getScore() + 1); enemy.setScore(enemy.getScore() + 1); break;
                case "OVER": isGameOver = true; break;
            }

            if (isGameOver) {
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/gameover.fxml"));
                Scene resultScene = new Scene(root);

                Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                window.setScene(resultScene);
                window.show();

                playerScore.setText("0");
                enemyScore.setText("0");
                player.setScore(0);
                enemy.setScore(0);
            }

            playerScore.setText(Integer.toString(player.getScore()));
            enemyScore.setText(Integer.toString(enemy.getScore()));
        } catch (IOException ex) {
            logger.error("Exception: " + ex);
        }
    }

    /**
     * Method handling the GiveUp button.
     * @param event ActionEvent.
     */
    @FXML
    private void handleGiveupButton(ActionEvent event) {
        playerChoiceImg.setImage(giceupIcon);
        enemyChoiceImg.setImage(giceupIcon);

        client.connection("GIVEUP");

        player.setScore(0);
        enemy.setScore(0);
        playerScore.setText("0");
        enemyScore.setText("0");
    }

    /**
     * Method handling the Back button.
     * @param event ActionEvent.
     */
    @FXML
    public void handleBackButton(ActionEvent event) {
        try {
            Parent pvcParent = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
            Scene pvcScene = new Scene(pvcParent);

            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(pvcScene);
            window.show();
        } catch (IOException ex) {
            logger.error("Exception: " + ex);
        }

    }
}
///CLOVER:ON