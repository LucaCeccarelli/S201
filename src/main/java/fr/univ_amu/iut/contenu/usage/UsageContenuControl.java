package fr.univ_amu.iut.contenu.usage;


import fr.univ_amu.iut.components.LabelUsageControl;
import fr.univ_amu.iut.model.Usage;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class UsageContenuControl extends GridPane {
    private Tab parentTab;
    public UsageContenuControl(Tab parentTab, Usage usage) {
        this.parentTab = parentTab;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UsageOngletView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        initialiserGridPane(usage);
    }
//LabelUsageControl
    private void initialiserGridPane(Usage usage) {
        add(new LabelUsageControl("Intitulé"),0,0);
        add(new LabelUsageControl(usage.getNom()),1,0);

        add(new LabelUsageControl("Description"),0,1);
        add(new LabelUsageControl(usage.getDescription()),1,1);

        add(new LabelUsageControl("Discipline"),0,2);
        add(new LabelUsageControl(usage.getDiscipline().getNom()),1,2);

        add(new LabelUsageControl("Thematique"),0,3);
        add(new LabelUsageControl(usage.getThematique().getNom()),1,3);

        add(new LabelUsageControl("Niveau"),0,4);
        add(new LabelUsageControl(usage.getNiveau()),1,4);

        add(new LabelUsageControl("Academie"),0,5);
        add(new LabelUsageControl(usage.getAcademie().getRegionAcademique().getNom()),1,5);

        add(new LabelUsageControl("Ressource"),0,6);
        add(new LabelUsageControl(usage.getRessource().getLienRessource()),1,6);

        add(new LabelUsageControl("Acteur"),0,7);
        add(new LabelUsageControl(usage.getActeur().toString()),1,7);

        add(new LabelUsageControl("Type Acteur"),0,8);
        add(new LabelUsageControl(usage.getActeur().getTypeActeur()),1,8);
    }

}
