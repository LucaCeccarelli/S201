package fr.univ_amu.iut.contenu.thematiques;

import fr.univ_amu.iut.model.Thematique;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.FlowPane;

import java.io.IOException;

public class ThematiquesContenuControl extends FlowPane {

    private Tab parentTab;

    EventHandler<ActionEvent> ecouteur = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            //Code de l'écouteur d'événement
            TabPane tabPane = parentTab.getTabPane();
            tabPane.getTabs().add(new Tab(((Control)event.getSource()).getId(),new ListTemplateControl(new String[]{"aa"})));
        }
    };

    public ThematiquesContenuControl(Tab parentTab){
        this.parentTab = parentTab;
        initButtons();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ThematiquesContenuView.fxml"));
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
            bt.setId(thematique.getNom());
            bt.setOnAction(ecouteur);
            getChildren().add(bt);
        }
    }
}
