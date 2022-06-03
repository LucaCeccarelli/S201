package fr.univ_amu.iut.contenu.reseaux;

import fr.univ_amu.iut.contenu.accueil.AccueilContenuControl;
import javafx.scene.control.Tab;

public class ReseauxOnglet extends Tab {
    public ReseauxOnglet(){
        setText("Reseaux");
        setClosable(false);
        setContent(new ReseauxContenuControl(this));

    }
}
