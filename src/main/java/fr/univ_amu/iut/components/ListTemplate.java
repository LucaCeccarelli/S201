package fr.univ_amu.iut.components;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.List;

public class ListTemplate extends BorderPane {
    private String[] nomsColonnes;

    public ListTemplate(String[] nomsColonnes) {
        this.nomsColonnes = nomsColonnes;
        initTop();
        initBottom();
    }

    private void initTop() {
        HBox conteneurIntitules = new HBox();
        for (String nomColonne : nomsColonnes) {
            conteneurIntitules.getChildren().add(new Label(nomColonne));
        }
        setTop(conteneurIntitules);
    }

    private List<List<String>> getContenuLignes() {
        throw new RuntimeException("Pas fait");
    }

    private void initBottom(){
        List<List<String>> contenuLignes = getContenuLignes();
        GridPane contenu = new GridPane();

        for(int i = 0; i<contenuLignes.size(); ++i){
            for(int j = 0; j<contenuLignes.get(i).size(); ++j){
                contenu.add(new Label(contenuLignes.get(i).get(j)),i,j);
            }
        }
        setBottom(contenu);
    }

}


