package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Main class starting the FX Application.
 */
///CLOVER:OFF
public class Main extends Application {

    @Override
    public void start(Stage mainStage) throws Exception{

        Image icon = new Image("/images/icon.png");

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));

        mainStage.getIcons().add(icon);
        mainStage.setTitle("");
        mainStage.setScene(new Scene(root, 600, 400));
        mainStage.setResizable(false);
        mainStage.show();
    }

    /**
     * Main method.
     * @param args arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
///CLOVER:ON
