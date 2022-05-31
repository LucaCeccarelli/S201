package fr.univ_amu.iut.contenu.usages;

import fr.univ_amu.iut.model.Thematique;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

import java.io.IOException;

public class UsagesContenuControl extends FlowPane {

    public UsagesContenuControl(){

        initButtons();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UsagesContenuView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void initButtons(){
        for (Thematique thematique : Thematique.listeThematiques) {
            Button bt = new Button(thematique.getNom());
            bt.setPrefSize(120, 60);
            getChildren().add(bt);
        }
    }
}
