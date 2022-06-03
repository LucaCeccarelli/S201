package fr.univ_amu.iut.app_main;

import fr.univ_amu.iut.contenu.accueil.AccueilOnglet;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TabPane;

import java.io.IOException;

public class LaunchAppControl extends TabPane {

    public LaunchAppControl(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LaunchAppView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
//        ListTemplateControl borderPane = new ListTemplateControl(new String[]{"Aa","bbb","ccc"});
//        root.getTabs().add(new Tab("Contenu aaa borderPane ",borderPane));

//        ThematiquesContenuControl flowPane = new ThematiquesContenuControl();
        getTabs().add(new AccueilOnglet());

    }

}
