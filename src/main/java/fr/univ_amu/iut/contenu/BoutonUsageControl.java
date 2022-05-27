package fr.univ_amu.iut.contenu;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import java.io.IOException;

public class BoutonUsageControl extends Button {

    public BoutonUsageControl() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fr/univ_amu/iut/contenu/BoutonUsageView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

}
