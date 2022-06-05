package fr.univ_amu.iut.contenu.reseaux;

import javafx.scene.control.Tab;

public class ReseauxOnglet extends Tab {
    public ReseauxOnglet(){
        setText("Reseaux");
        setClosable(false);
        setContent(new ReseauxContenuControl(this));

    }
}
