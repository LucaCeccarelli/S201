package fr.univ_amu.iut.contenu.accueil;

import fr.univ_amu.iut.contenu.usages.UsagesOnglet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class AccueilContenuController extends BorderPane {

    private Tab parentTab;

    public AccueilContenuController(Tab parentTab) {
        this.parentTab = parentTab;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AccueilContenuView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @FXML
    public void startupTabs(ActionEvent actionEvent) {
        TabPane tabPane = (TabPane)parentTab.getTabPane();
        tabPane.getTabs().add(new UsagesOnglet());
        // TODO open reseaux tab
        tabPane.getTabs().remove(parentTab);
    }

}
