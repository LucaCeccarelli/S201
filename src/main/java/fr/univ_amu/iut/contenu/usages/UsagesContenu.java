package fr.univ_amu.iut.contenu.usages;

import fr.univ_amu.iut.model.Thematique;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

public class UsagesContenu extends FlowPane {

    String[] listeThematiques;

    public UsagesContenu(){
        listeThematiques = Thematique.getListeThematiques();
        initButtons();
    }

    public void initButtons(){
        for(String thematique : listeThematiques){
            getChildren().add(new Button(thematique));
        }
    }
}
