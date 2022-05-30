package OngletList;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.List;

public class ListTemplate {
    private GridPane root;

    public ListTemplate(String[] nomsColonnes) {
        GridPane root = new GridPane();
        for (int i = 0; i < nomsColonnes.length; ++i) {
            root.add(new Label(nomsColonnes[i]), i, 0);
        }
    }

    public List<List<String>> getContenuLignes(String nomOnglet) {
        throw new RuntimeException("Pas fait");
    }

    public void remplirLignes(){
        List<List<String>> contenuLignes = getContenuLignes("Contenu");

        for(int i = 0; i<contenuLignes.size(); ++i){
            for(int j = 0; j<contenuLignes.get(i).size(); ++j){
                root.add(new Label(contenuLignes.get(i).get(j)),i+1,j);
            }
        }
    }

    public GridPane getGridPane(){
        return root;
    }
}


