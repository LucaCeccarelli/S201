
package fr.univ_amu.iut.components;

import fr.univ_amu.iut.model.Usage;
import javafx.scene.control.Button;

public class BoutonUsage extends Button {

    private Usage usage;

    public BoutonUsage(Usage usage) {
        super(usage.getNom());
        this.usage = usage;
    }

    public Usage getUsage() {
        return usage;
    }
}
