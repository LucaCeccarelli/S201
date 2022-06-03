package fr.univ_amu.iut.contenu.usage;

import fr.univ_amu.iut.contenu.academie.AcademieContenuControl;
import fr.univ_amu.iut.model.Usage;
import javafx.scene.control.Tab;

public class UsageOnglet extends Tab {
    public UsageOnglet(Usage usage){
        setText(usage.getNom());
        setContent(new UsageContenuControl(this, usage));
    }
}
