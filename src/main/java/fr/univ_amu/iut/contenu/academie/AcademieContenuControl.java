package fr.univ_amu.iut.contenu.academie;

import fr.univ_amu.iut.app_main.LaunchApp;
import fr.univ_amu.iut.model.*;
import jakarta.persistence.TypedQuery;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.List;

public class AcademieContenuControl extends TableView<Usage> {

    private Tab parentTab;

    public AcademieContenuControl(Tab parentTab, Academie academie){
        this.parentTab = parentTab;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AcademieContenuView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        remplirTable(academie);
    }

    private void remplirTable(Academie academie) {
        TableColumn<Usage, String> nom = new TableColumn<>("Intitulé");
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));

        TableColumn<Usage, Discipline> discipline = new TableColumn<>("Discipline");
        discipline.setCellValueFactory(new PropertyValueFactory<>("discipline"));

        TableColumn<Usage, Thematique> thematique = new TableColumn<>("Thématique");
        thematique.setCellValueFactory(new PropertyValueFactory<>("thematique"));

        TableColumn<Usage, String> niveau = new TableColumn<>("Niveau");
        niveau.setCellValueFactory(new PropertyValueFactory<>("niveau"));

        // TODO colonne bouton et peut être favoris

        getColumns().addAll(List.of(nom, discipline, thematique, niveau));

        TypedQuery<Usage> query = LaunchApp.em.createNamedQuery("Usage.findByAcademie", Usage.class);
        query.setParameter("academie", academie);
        setItems(FXCollections.observableList(query.getResultList()));

    }

}
