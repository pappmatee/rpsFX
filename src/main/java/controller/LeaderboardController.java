package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rpsFX.database.Database;
import rpsFX.state.Leaderboard;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Class controlling the Leaderboard scene.
 */
///CLOVER:OFF
public class LeaderboardController implements Initializable {

    Logger logger = LoggerFactory.getLogger(LeaderboardController.class);

    @FXML
    Button backButton;

    @FXML
    TableView<Leaderboard> leaderboardTable;

    @FXML
    TableColumn<Leaderboard, String> player;

    @FXML
    TableColumn<Leaderboard, Integer> victories;


    /**
     * Method handling the Back button.
     * @param event ActionEvent.
     */
    @FXML
    public void handleBackButton(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/gameover.fxml"));
            Scene resultScene = new Scene(root);

            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(resultScene);
            window.show();
        } catch (IOException ex) {
            logger.error("Exception: " + ex);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        leaderboardTable.getItems().clear();
        player.setCellValueFactory(new PropertyValueFactory<>("Nickname"));
        victories.setCellValueFactory(new PropertyValueFactory<>("Score"));
        leaderboardTable.setItems(Database.data);
        victories.setComparator(victories.getComparator().reversed());
        leaderboardTable.getSortOrder().add(victories);
    }
}
///CLOVER:ON
