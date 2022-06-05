package fr.univ_amu.iut.contenu.academie;

import fr.univ_amu.iut.model.Academie;
import javafx.geometry.Insets;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

public class AcademieOnglet extends Tab {

    public AcademieOnglet(Academie academie){
        setText(academie.getNom());
        VBox racine = new VBox();
        racine.setPadding(new Insets(10));
        AcademieContenuControl table = new AcademieContenuControl(this, academie);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.getSelectionModel().select(0);
        table.setEditable(true);
        racine.getChildren().addAll(table);
        setContent(racine);
    }

}
