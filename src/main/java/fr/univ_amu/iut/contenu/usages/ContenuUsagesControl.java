package fr.univ_amu.iut.contenu.usages;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class ContenuUsagesControl extends GridPane {

    public ContenuUsagesControl() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fr/univ_amu/iut/contenu/usages/contenuUsagesView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

}
