package fr.univ_amu.iut.contenu.accueil;

import javafx.scene.control.Tab;

public class AccueilOnglet extends Tab {

    public AccueilOnglet() {
        setText("Onglet Accueil");
        setClosable(false);
        setContent(new AccueilContenuController(this));
        // TODO: ajouter une classe de style
    }

}
