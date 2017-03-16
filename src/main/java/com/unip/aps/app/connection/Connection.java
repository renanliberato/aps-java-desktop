package com.unip.aps.app.connection;

import com.unip.aps.app.App;
import com.unip.aps.app.alert.ErrorDialog;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Connection screen class.
 *
 * @author Renan Liberato Sant'Ana <renan.libsantana@gmail.com>
 */
public class Connection extends Application {

    /**
     * First screen exhibited in the application. Sets up the scene and stage settings.
     *
     * @param stage Application's stage
     * @throws Exception Exception throwed if something goes wrong wit
     */
    public void start(Stage stage) {
        try {
            // Set the stage to the application static property, making it available to all system classes.
            App.setStage(stage);

            //Loads xml layout file.
            Parent root = FXMLLoader.load(getClass().getResource("connection.fxml"));

            //Instantiate the scene
            Scene scene = new Scene(root);

            //Export the css file to string and load it inside the scene.
            String css = this.getClass().getResource("connection.css").toExternalForm();
            scene.getStylesheets().add(css);

            //Stage configuration.
            stage.setScene(scene);
            stage.setMinWidth(800);
            stage.setMinHeight(600);
            stage.setResizable(false);

            //Shows the stage to the user.
            stage.show();
        } catch (IOException e) {
            new ErrorDialog();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
