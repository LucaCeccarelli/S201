package fr.univ_amu.iut.contenu.academie;

import fr.univ_amu.iut.contenu.reseaux.ReseauxContenuControl;
import fr.univ_amu.iut.model.Academie;
import javafx.scene.control.Tab;

public class AcademieOnglet extends Tab {

    public AcademieOnglet(Academie academie){
        setText(academie.getNom());
        setContent(new AcademieContenuControl(this, academie));
    }

}
