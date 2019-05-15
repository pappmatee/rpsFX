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
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Class controlling the Main scene.
 */
///CLOVER:OFF
public class MainController {

    Logger logger = LoggerFactory.getLogger(MainController.class);

    @FXML
    TextField nickname;
    @FXML
    Button pvcButton;
    @FXML
    Button pvpButton;
    @FXML
    Label conStatus;

    /**
     * The name of the player.
     */
    public static String playerName;

    /**
     * Method handling the PVC scene.
     * @param event ActionEvent.
     */
    @FXML
    private void handlePvcButton(ActionEvent event) {

        try {
            if (checkUsernameText()) {
                playerName = nickname.getText();

                Parent pvcParent = FXMLLoader.load(getClass().getResource("/fxml/pvc.fxml"));
                Scene pvcScene = new Scene(pvcParent);

                Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                window.setScene(pvcScene);
                window.show();
            }
        } catch (IOException ex) {
            logger.error("Exception: " + ex);
        }
    }

    /**
     * Method handling the PVP scene.
     * @param event ActionEvent.
     */
    @FXML
    private void handlePvpButton(ActionEvent event) {

        try {
            if (checkUsernameText()) {
                playerName = nickname.getText();

                conStatus.setText("");
                Parent pvpParent = FXMLLoader.load(getClass().getResource("/fxml/pvp.fxml"));
                Scene pvpScene = new Scene(pvpParent);

                Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                window.setScene(pvpScene);
                window.show();
            }
        } catch (IOException ex) {
            logger.error("Exception: " + ex);
        }

    }

    /**
     * Checks the Username textfield on the Main scene.
     * The textfield cannot be empty.
     * @return false if the textfield is empty, true otherwise
     */
    private boolean checkUsernameText() {
        if (nickname.getText().isEmpty()) {
            logger.error("Username cannot be empty!");
            return false;
        }
        else {
            playerName = nickname.getText();
            return true;
        }
    }

}
///CLOVER:ON
