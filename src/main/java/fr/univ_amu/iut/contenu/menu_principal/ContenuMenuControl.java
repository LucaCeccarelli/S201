package fr.univ_amu.iut.contenu.menu_principal;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class ContenuMenuControl extends GridPane {

    public ContenuMenuControl() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fr/univ_amu/iut/contenu/menu_principal/contenuMenuView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

}
