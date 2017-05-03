package com.unip.aps.app.chat;

import com.unip.aps.app.App;
import com.unip.aps.app.alert.ErrorDialog;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created on 21/3/2017.
 *
 * @author Renan Liberato Sant'Ana <renan.libsantana@gmail.com>
 */
public class Chat extends Application {

    /**
     * First screen exhibited in the application. Sets up the scene and stage settings.
     *
     * @param stage Application's stage
     */
    public void start(Stage stage) {
        try {
            //Loads xml layout file.
            Parent root = FXMLLoader.load(getClass().getResource("chat.fxml"));

            //Instantiate the scene
            Scene scene = new Scene(root);

            //Export the css file to string and load it inside the scene.
            String css = getClass().getResource("chat.css").toExternalForm();
            scene.getStylesheets().add(css);

            //Stage configuration.
            stage.setScene(scene);
            stage.setMinWidth(800);
            stage.setMinHeight(600);
            stage.setResizable(false);

            //Shows the stage to the user.
            stage.show();

        } catch (IOException e) {
            ErrorDialog.fire();
        }
    }
}
