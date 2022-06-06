package fr.univ_amu.iut.contenu.academie;

import fr.univ_amu.iut.LaunchApp;
import fr.univ_amu.iut.contenu.usage.UsageOnglet;
import fr.univ_amu.iut.model.*;
import jakarta.persistence.TypedQuery;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
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
        //Bouton pour acceder au detail
        TableColumn<Usage, String> detail = new TableColumn<>("Detail du Projet");
        detail.setCellValueFactory(p -> new ReadOnlyObjectWrapper("Cliquez Ici !"));
        detail.setOnEditStart(usageStringCellEditEvent -> {
            System.out.println(usageStringCellEditEvent.getRowValue().getNom() + " as été selectionné");
            TabPane tabPane = parentTab.getTabPane();
            tabPane.getTabs().add(new UsageOnglet(usageStringCellEditEvent.getRowValue()));
            tabPane.getSelectionModel().select(tabPane.getTabs().size()-1);
        });
        //Fin bouton acceder aux details

        getColumns().addAll(List.of(nom, discipline, thematique, niveau,detail));

        TypedQuery<Usage> query = LaunchApp.em.createNamedQuery("Usage.findByAcademie", Usage.class);
        query.setParameter("academie", academie);

        //DAOUsage dao = DAOFactoryProducer.getFactory(DAOType.JPA).createDAOUsage();
        // TODO Utiliser DAO plutôt que query

        setItems(FXCollections.observableList(query.getResultList()));

    }

}
