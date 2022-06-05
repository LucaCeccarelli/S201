package fr.univ_amu.iut.contenu.thematique;

import fr.univ_amu.iut.contenu.academie.AcademieContenuControl;
import fr.univ_amu.iut.model.Thematique;
import javafx.geometry.Insets;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

public class ThematiqueOnglet extends Tab {

    public ThematiqueOnglet(Thematique thematique){
        setText(thematique.getNom());
        VBox racine = new VBox();
        racine.setPadding(new Insets(10));
        ThematiqueContenuControl table = new ThematiqueContenuControl(this, thematique);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.getSelectionModel().select(0);
        table.setEditable(true);
        racine.getChildren().addAll(table);
        setContent(racine);
    }

}
