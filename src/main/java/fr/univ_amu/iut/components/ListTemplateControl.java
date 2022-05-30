package fr.univ_amu.iut.components;

import javafx.scene.control.Label;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.List;

public class ListTemplateControl extends GridPane {

    private String[] nomsColonnes;

    public ListTemplateControl(String[] nomsColonnes) {
        this.nomsColonnes = nomsColonnes;
        initIntitules();
        initLignes();
    }

    private void initIntitules() {
        for (int i=0; i<nomsColonnes.length; ++i)
            add(new Label(nomsColonnes[i]), i, 0);
    }

    private List<List<String>> getContenuLignes() {
        // TODO: lire les valeurs dans la base de données
        List<List<String>> outerArrayList = new ArrayList<>();
        List<String> inner1 = new ArrayList<>();
        inner1.add("String One");
        inner1.add("String Two");
        inner1.add("String Three");
        outerArrayList.add(inner1);
        List<String> inner2 = new ArrayList<>();
        inner2.add("String One.2");
        inner2.add("String Two.2");
        inner2.add("String Three.2");
        outerArrayList.add(inner2);
        return outerArrayList;
    }

    private void initLignes(){
        List<List<String>> contenuLignes = getContenuLignes();
        for(int i=0; i<contenuLignes.size(); ++i)
            for(int j=0; j<contenuLignes.get(i).size(); ++j)
                add(new Label(contenuLignes.get(i).get(j)),j,i+1);
    }

    private void initGraphique() {
        getChildren().get(1);
        getChildren().size();
        for(int i = 0; i<getChildren().size(); ++i){
            getChildren().get(i).setStyle("-fx-border-style: solid inside;"+
                                            "-fx-border-width: 2;" +
                                            "-fx-border-insets: 5;" +
                                            "-fx-border-radius: 5;" +
                                            "-fx-border-color: blue;");
        }

    }

}


