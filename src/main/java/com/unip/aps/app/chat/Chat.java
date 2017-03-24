package com.unip.aps.app.chat;

import com.unip.aps.app.App;
import com.unip.aps.app.alert.ErrorDialog;
import com.unip.aps.app.service.Server;
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
     * @throws Exception Exception throwed if something goes wrong wit
     */
    public void start(Stage stage) {
        try {
            // Set the stage to the application static property, making it available to all system classes.
            App.setStage(stage);

            //Loads xml layout file.
            Parent root = FXMLLoader.load(getClass().getResource("chat.fxml"));

            //Instantiate the scene
            Scene scene = new Scene(root);

            //Export the css file to string and load it inside the scene.
//            String css = this.getClass().getResource("connection.css").toExternalForm();
//            scene.getStylesheets().add(css);

            //Stage configuration.
            stage.setScene(scene);
            stage.setMinWidth(800);
            stage.setMinHeight(600);
            stage.setResizable(false);

            //Shows the stage to the user.
            stage.show();

            Server server = new Server();
            server.listenToNewConnection();
        } catch (IOException e) {
            e.printStackTrace();
//            new ErrorDialog();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
