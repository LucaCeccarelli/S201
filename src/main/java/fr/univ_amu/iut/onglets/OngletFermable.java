package fr.univ_amu.iut.onglets;

import javafx.scene.control.Button;

import java.util.List;

public abstract class OngletFermable extends Onglet{
    private Button btFermer;

    //Constructor
    public OngletFermable(String titre){
        super(titre);
    }
    //Getters

    public Button getBtFermer() {
        return btFermer;
    }
    @Override
    public List<Button> getButtons() {
        return super.getButtons();
    }
}
