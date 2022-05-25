package fr.univ_amu.iut.onglets;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public abstract class Onglet {

    private Button btAfficher;
    private GridPane contenu;

    //Constructor
    public Onglet(String titre){
        btAfficher = new Button(titre);
    }

    //Getters
    public Button getBtAfficher(){
        return btAfficher;
    }
    public GridPane getContenu(){
        return contenu;
    }
    public List<Button> getButtons() {
        List<Button> buttons = new ArrayList<>(1);
        buttons.set(0,btAfficher);
        return buttons;
    }
    public abstract void initialiserContenu();

}
