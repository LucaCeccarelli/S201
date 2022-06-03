package fr.univ_amu.iut.contenu.thematique;

import fr.univ_amu.iut.contenu.academie.AcademieContenuControl;
import fr.univ_amu.iut.model.Thematique;
import javafx.scene.control.Tab;

public class ThematiqueOnglet extends Tab {

    public ThematiqueOnglet(Thematique thematique){
        setText(thematique.getNom());
        setContent(new ThematiqueContenuControl(this, thematique));
    }

}
