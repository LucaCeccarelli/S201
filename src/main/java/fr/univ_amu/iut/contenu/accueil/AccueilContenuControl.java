package fr.univ_amu.iut.contenu.accueil;

import fr.univ_amu.iut.contenu.reseaux.ReseauxOnglet;
import fr.univ_amu.iut.contenu.usages.UsagesOnglet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class AccueilContenuControl extends BorderPane {

    private Tab parentTab;

    @FXML
    private ImageView imageView;

    public AccueilContenuControl(Tab parentTab) {
        this.parentTab = parentTab;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AccueilContenuView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        //imageView.setImage(new Image(""));
    }

    @FXML
    public void startupTabs(ActionEvent actionEvent) {
        TabPane tabPane = parentTab.getTabPane();
        tabPane.getTabs().add(new UsagesOnglet());
        // TODO open reseaux tab
        tabPane.getTabs().add(new ReseauxOnglet());
        tabPane.getTabs().remove(parentTab);
    }

}
