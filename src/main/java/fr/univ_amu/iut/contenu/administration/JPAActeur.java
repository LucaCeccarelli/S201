package fr.univ_amu.iut.contenu.administration;

import fr.univ_amu.iut.LaunchApp;
import fr.univ_amu.iut.components.BoutonThematique;
import fr.univ_amu.iut.model.Acteur;
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

public class JPAActeur extends Tab {
    private static final EntityManagerFactory emf = LaunchApp.emf;
    private static final EntityManager em = LaunchApp.em;
    private TableView<Acteur> table;
    private TableColumn<Acteur, String> nom;
    private TableColumn<Acteur, Integer> id;
    private TableColumn<Acteur, String> prenom;
    private TableColumn<Acteur, String> typeActeur;
    private ObservableList<Acteur> data;
    private HBox boutons;
    private BoutonThematique ajouter;
    private BoutonThematique supprimer;
    private VBox racine;

    public JPAActeur(){
        setText("Administration Acteur");
        setClosable(false);
        initialiserTable();
        initialiserBoutons();
        initialiserRacine();
        setContent(racine);
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

    private static TableColumn<Acteur, Integer> initialiserColonneId() {
        TableColumn<Acteur, Integer> code = new TableColumn<>("Identifiant");
        code.setCellValueFactory(new PropertyValueFactory<>("id"));
        return code;
    }

    private static TableColumn<Acteur, String> initialiserColonneNom() {
        TableColumn<Acteur, String> nom = new TableColumn<>("Nom");
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        nom.setCellFactory(TextFieldTableCell.forTableColumn());
        nom.setOnEditCommit(event -> {
            int index = event.getTablePosition().getRow();
            Acteur acteur = event.getTableView().getItems().get(index);
            em.getTransaction().begin();
            acteur.setNom(event.getNewValue());
            em.getTransaction().commit();
        });
        return nom;
    }

    private static TableColumn<Acteur, String> initialiserColonnePrenom() {
        TableColumn<Acteur, String> prenom = new TableColumn<>("Prénom");
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        prenom.setCellFactory(TextFieldTableCell.forTableColumn());

        prenom.setOnEditCommit(event -> {
            int index = event.getTablePosition().getRow();
            Acteur acteur = event.getTableView().getItems().get(index);
            em.getTransaction().begin();
            acteur.setPrenom(event.getNewValue());
            em.getTransaction().commit();
        });

        return prenom;
    }

    private TableColumn<Acteur, String> initialiserColonneTypeActeur() {
        TableColumn<Acteur, String> typeActeur = new TableColumn<>("Type d'acteur");
        typeActeur.setCellValueFactory(new PropertyValueFactory<>("typeActeur"));
        typeActeur.setCellFactory(TextFieldTableCell.forTableColumn());
        typeActeur.setOnEditCommit(event -> {
            int index = event.getTablePosition().getRow();
            Acteur acteur = event.getTableView().getItems().get(index);
            em.getTransaction().begin();
            acteur.setTypeActeur(event.getNewValue());
            em.getTransaction().commit();
        });
        return typeActeur;
    }

    private void initialiserColonnes() {
        id = initialiserColonneId();
        nom = initialiserColonneNom();
        prenom = initialiserColonnePrenom();
        typeActeur = initialiserColonneTypeActeur();
    }

    private void insererColonnes() {
        table.getColumns().addAll(List.of(id, nom, prenom, typeActeur));
    }

    private void remplirDonnees() {
        data = listerActeurs();
        table.setItems(data);
    }

    private ObservableList<Acteur> listerActeurs() {
        TypedQuery<Acteur> query = em.createNamedQuery("Acteur.findAll", Acteur.class);
        return FXCollections.observableList(query.getResultList());
    }

    private void ajouterActeur(ActionEvent event) {
        Acteur acteur = new Acteur();
        em.getTransaction().begin();
        em.persist(acteur);
        em.getTransaction().commit();
        data.add(acteur);

        int rowIndex = data.size() - 1;
        table.requestFocus();
        table.scrollTo(rowIndex);
        table.getSelectionModel().select(rowIndex);
        table.getFocusModel().focus(rowIndex);
    }

    private void supprimerActeur(ActionEvent event) {
        if (table.getItems().size() == 0) return;

        em.getTransaction().begin();
        em.remove(table.getSelectionModel().getSelectedItem());
        em.getTransaction().commit();

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
