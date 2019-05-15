package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Class controlling the GameOver scene.
 */
///CLOVER:OFF
public class GameOverController {

    static Logger logger = LoggerFactory.getLogger(GameOverController.class);

    @FXML
    Label resultLabel;

    @FXML
    Button rematchButton;

    @FXML
    Button leaderboardButton;

    @FXML
    Button exitButton;

    /**
     * Method handling the Rematch button.
     * @param event ActionEvent.
     */
    @FXML
    public void handleRematchButton(ActionEvent event) {
        try {
            Parent pvcParent = FXMLLoader.load(getClass().getResource("/fxml/pvc.fxml"));
            Scene pvcScene = new Scene(pvcParent);

            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(pvcScene);
            window.show();
        } catch (IOException ex) {
            logger.error("Exception: " + ex);
        }

    }

    /**
     * Method handling the Leaderboard button.
     * @param event ActionEvent.
     */
    @FXML
    public void handleLeaderboardButton(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/leaderboard.fxml"));
            Scene lbScene = new Scene(root);

            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(lbScene);
            window.show();
        } catch (IOException ex) {
            logger.error("Exception: " + ex);
        }

    }

    /**
     * Method handling the Exit button.
     * @param event ActionEvent.
     */
    @FXML
    public void handleExitButton(ActionEvent event) {
        System.exit(0);
    }
}
///CLOVER:ON