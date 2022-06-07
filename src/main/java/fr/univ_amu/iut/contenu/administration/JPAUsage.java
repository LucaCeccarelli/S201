package fr.univ_amu.iut.contenu.administration;

import fr.univ_amu.iut.LaunchApp;
import fr.univ_amu.iut.components.BoutonThematique;
import fr.univ_amu.iut.dao.DAOActeur;
import fr.univ_amu.iut.dao.DAOUsage;
import fr.univ_amu.iut.dao.factory.DAOFactoryProducer;
import fr.univ_amu.iut.dao.factory.DAOType;
import fr.univ_amu.iut.model.Academie;
import fr.univ_amu.iut.model.Acteur;
import fr.univ_amu.iut.model.Usage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.util.List;

public class JPAUsage extends Tab {
    private static final DAOUsage daoUsage = DAOFactoryProducer.getFactory(DAOType.JPA).createDAOUsage();
    private TableView<Usage> table;
    private TableColumn<Usage, String> nom;
    private TableColumn<Usage, Integer> id;
    private TableColumn<Usage, String> description;
    private TableColumn<Usage, String> niveau;
    private TableColumn<Usage, Academie> academie;
    private ObservableList<Usage> data;
    private HBox boutons;
    private BoutonThematique ajouter;
    private BoutonThematique supprimer;
    private VBox racine;

    public JPAUsage(){
        setText("Administration Usage");
        setClosable(false);
        initialiserTable();
        initialiserBoutons();
        initialiserRacine();
        setContent(racine);
    }

    private static TableColumn<Usage, Integer> initialiserColonneId() {
        TableColumn<Usage, Integer> code = new TableColumn<>("Identifiant");
        code.setCellValueFactory(new PropertyValueFactory<>("id"));
        return code;
    }

    private static TableColumn<Usage, String> initialiserColonneNom() {
        TableColumn<Usage, String> nom = new TableColumn<>("Nom Usage");
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        nom.setCellFactory(TextFieldTableCell.forTableColumn());
        nom.setOnEditCommit(event -> {
            int index = event.getTablePosition().getRow();
            Usage usage = event.getTableView().getItems().get(index);
            usage.setNom(event.getNewValue());
            daoUsage.update(usage);
        });
        return nom;
    }

    private static TableColumn<Usage, String> initialiserColonneDescription() {
        TableColumn<Usage, String> description = new TableColumn<>("Description");
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        description.setCellFactory(TextFieldTableCell.forTableColumn());

        description.setOnEditCommit(event -> {
            int index = event.getTablePosition().getRow();
            Usage usage = event.getTableView().getItems().get(index);
            usage.setDescription(event.getNewValue());
            daoUsage.update(usage);
        });

        return description;
    }

    private static TableColumn<Usage, String> initialiserColonneNiveau() {
        TableColumn<Usage, String> niveau = new TableColumn<>("Niveau");
        niveau.setCellValueFactory(new PropertyValueFactory<>("niveau"));
        niveau.setCellFactory(TextFieldTableCell.forTableColumn());
        niveau.setOnEditCommit(event -> {
            int index = event.getTablePosition().getRow();
            Usage usage = event.getTableView().getItems().get(index);
            usage.setNiveau(event.getNewValue());
            daoUsage.update(usage);
        });
        return niveau;
    }
    
    private void initialiserRacine() {
        racine = new VBox();
        racine.setPadding(new Insets(10));
        racine.getChildren().addAll(table, boutons);
    }

    private void initialiserBoutons() {
        boutons = new HBox(10);
        boutons.setPadding(new Insets(10));
        boutons.setAlignment(Pos.CENTER);
        initialiserBoutonAjouter();
        initialiserBoutonSupprimer();
        boutons.getChildren().addAll(ajouter, supprimer);
    }

    private void initialiserBoutonSupprimer() {
        supprimer = new BoutonThematique("Supprimer");
        supprimer.setOnAction(this::supprimerActeur);
    }

    private void initialiserBoutonAjouter() {
        ajouter = new BoutonThematique("Ajouter");
        ajouter.setOnAction(this::ajouterActeur);
    }

    private void initialiserTable() {
        table = new TableView<>();
        table.setEditable(true);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.getSelectionModel().select(0);

        initialiserColonnes();
        insererColonnes();
        remplirDonnees();

        VBox.setVgrow(table, Priority.ALWAYS);
    }

    private TableColumn<Usage, Academie> initialiserColonneCodeAca() {
        TableColumn<Usage, Academie> academie = new TableColumn<>("Code Academique");
        academie.setCellValueFactory(new PropertyValueFactory<>("academie"));
        academie.setOnEditCommit(event -> {
            int index = event.getTablePosition().getRow();
            Usage usage = event.getTableView().getItems().get(index);
            usage.setAcademie(event.getNewValue());
            daoUsage.update(usage);
        });
        return academie;
    }

    private void initialiserColonnes() {
        id = initialiserColonneId();
        nom = initialiserColonneNom();
        description = initialiserColonneDescription();
        niveau = initialiserColonneNiveau();
        academie = initialiserColonneCodeAca();
    }

    private void insererColonnes() {
        table.getColumns().addAll(List.of(id, nom, description, niveau, academie));
    }

    private void remplirDonnees() {
        data = listerActeurs();
        table.setItems(data);
    }

    private ObservableList<Usage> listerActeurs() {
        return FXCollections.observableList(daoUsage.findAll());
    }

    private void ajouterActeur(ActionEvent event) {
        Usage usage = new Usage();
        daoUsage.insert(usage);
        data.add(usage);

        int rowIndex = data.size() - 1;
        table.requestFocus();
        table.scrollTo(rowIndex);
        table.getSelectionModel().select(rowIndex);
        table.getFocusModel().focus(rowIndex);
    }

    private void supprimerActeur(ActionEvent event) {
        if (table.getItems().size() == 0) return;

        daoUsage.delete(table.getSelectionModel().getSelectedItem());

        int selectedRowIndex = table.getSelectionModel().getSelectedIndex();

        data.remove(selectedRowIndex);

        if (selectedRowIndex != 0) {
            selectedRowIndex = selectedRowIndex - 1;
        }

        table.requestFocus();
        table.scrollTo(selectedRowIndex);
        table.getSelectionModel().select(selectedRowIndex);
        table.getFocusModel().focus(selectedRowIndex);
    }

}
