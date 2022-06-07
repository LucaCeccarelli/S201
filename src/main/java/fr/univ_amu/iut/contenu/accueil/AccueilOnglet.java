package fr.univ_amu.iut.contenu.accueil;

import javafx.scene.control.Tab;

public class AccueilOnglet extends Tab {

    public AccueilOnglet() {
        setText("Onglet Accueil");
        setClosable(false);
        setContent(new AccueilContenuControl(this));
        setId("ongletAccueil");
    }

}
