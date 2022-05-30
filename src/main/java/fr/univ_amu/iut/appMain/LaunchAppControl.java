package fr.univ_amu.iut.appMain;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class LaunchAppControl extends VBox {

    public LaunchAppControl(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LaunchAppView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
