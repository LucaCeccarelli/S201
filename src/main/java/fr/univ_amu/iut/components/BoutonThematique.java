package fr.univ_amu.iut.components;

import fr.univ_amu.iut.model.Thematique;
import javafx.scene.control.Button;

public class BoutonThematique extends Button {

    private Thematique thematique;

    public BoutonThematique(Thematique thematique) {
        super(thematique.getNom());
        this.thematique = thematique;
        super.setWrapText(true);
        super.setId("boutonThematique");
    }

    public BoutonThematique(String nom) {
        super(nom);
        super.setWrapText(true);
    }

    public Thematique getThematique() {
        return thematique;
    }

}
