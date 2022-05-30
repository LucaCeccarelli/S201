package fr.univ_amu.iut.app_main;

import fr.univ_amu.iut.components.ListTemplate;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class LaunchAppControl extends VBox {

    @FXML
    private TabPane root;
    public LaunchAppControl(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LaunchAppView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        ListTemplate grid = new ListTemplate(new String[]{"Aa","Ae"});
        root.getTabs().add(new Tab("Contenu aaa",grid));
    }
}
