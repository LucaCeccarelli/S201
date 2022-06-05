package fr.univ_amu.iut.contenu.thematiques;

import javafx.scene.control.Tab;

public class ThematiquesOnglet extends Tab {

    public ThematiquesOnglet() {
        setText("Thématiques");
        setClosable(false);
        setContent(new ThematiquesContenuControl(this));
    }

}
