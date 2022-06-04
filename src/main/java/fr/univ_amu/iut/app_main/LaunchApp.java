package fr.univ_amu.iut.app_main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class LaunchApp extends Application {

    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestionUsagesPU");
    public static final EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        TabPane root = new LaunchAppControl();
        Scene scene = new Scene(root,1080,720);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
