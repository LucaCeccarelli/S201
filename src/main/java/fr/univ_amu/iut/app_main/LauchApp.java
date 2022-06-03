package fr.univ_amu.iut.app_main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LauchApp extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        TabPane root = new LaunchAppControl();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
