package fr.univ_amu.iut.appMain;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LauchApp extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new LaunchAppControl();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
