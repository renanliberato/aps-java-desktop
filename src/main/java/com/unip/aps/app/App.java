package com.unip.aps.app;

import javafx.stage.Stage;

/**
 * Application's main class. Responsible to store the stage that is offered to the scenes.
 *
 * @author Renan Liberato Sant'Ana <renan.libsantana@gmail.com>
 */
public class App {
    /**
     * Application main stage. It's configured on application start at com.unip.aps.app.connection.Connection.start.
     */
    private static Stage stage;

    /**
     * stage property getter.
     *
     * @return Stage stage
     */
    public static Stage getStage() {
        return stage;
    }

    /**
     * stage property setter.
     *
     * @param stage Application's stage.
     */
    public static void setStage(Stage stage) {
        App.stage = stage;
    }
}
