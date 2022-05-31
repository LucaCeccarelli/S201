package fr.univ_amu.iut.contenu;

import fr.univ_amu.iut.model.Thematique;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

public class Usages extends FlowPane {

    String[] listeThematiques;

    public Usages(){
        listeThematiques = Thematique.getListeThematiques();
        initButtons();
    }

    public void initButtons(){
        for(String thematique : listeThematiques){
            getChildren().add(new Button(thematique));
        }
    }
}
