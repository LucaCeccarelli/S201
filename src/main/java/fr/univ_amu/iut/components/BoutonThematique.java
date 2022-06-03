package fr.univ_amu.iut.components;

import fr.univ_amu.iut.model.Thematique;
import javafx.scene.control.Button;

public class BoutonThematique extends Button {

    private Thematique thematique;

    public BoutonThematique(Thematique thematique) {
        super(thematique.getNom());
        this.thematique = thematique;
    }

    public Thematique getThematique() {
        return thematique;
    }

}
