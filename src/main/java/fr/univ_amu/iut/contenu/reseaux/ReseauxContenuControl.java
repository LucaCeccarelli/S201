package fr.univ_amu.iut.contenu.reseaux;

import fr.univ_amu.iut.LaunchApp;
import fr.univ_amu.iut.components.LabelUsageControl;
import fr.univ_amu.iut.contenu.academie.AcademieOnglet;
import fr.univ_amu.iut.dao.factory.DAOFactoryProducer;
import fr.univ_amu.iut.dao.factory.DAOType;
import fr.univ_amu.iut.dao.jpa.DAOUsageJPA;
import fr.univ_amu.iut.model.Academie;
import fr.univ_amu.iut.model.Thematique;
import fr.univ_amu.iut.model.Usage;
import fr.univ_amu.iut.view.map.AcademiePath;
import fr.univ_amu.iut.view.map.France;
import fr.univ_amu.iut.view.map.FranceBuilder;
import jakarta.persistence.TypedQuery;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ReseauxContenuControl extends BorderPane {

    private Tab parentTab;
    private France france;
    private FlowPane flowPane;
    private Label academieActuelle;
    private HashMap<String, List<Usage>> usageParAcademie;
    private HashMap<String, Button> btParTheme;

    public ReseauxContenuControl(Tab parentTab){
        this.parentTab = parentTab;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ReseauxContenuView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        initHashMap();
        initFrance();
        initDispButtons();

    }

    private void initHashMap(){
        usageParAcademie= new HashMap<String, List<Usage>>();
        for(Academie academie : FXCollections.observableList(DAOFactoryProducer.getFactory(DAOType.JPA).createDAOAcademie().findAll())){
            usageParAcademie.put(academie.getNom(),DAOFactoryProducer.getFactory(DAOType.JPA).createDAOUsage().findByAcademie(academie));
        }
    }

    private void initFrance(){
         france = FranceBuilder.create()
                .backgroundColor(Color.web("#a3d7f7"))
                .fillColor(Color.web("#dcb36c"))
                .strokeColor(Color.web("#987028"))
                .hoverColor(Color.web("#fec47e"))
                .pressedColor(Color.web("#6cee85"))
                .selectedColor(Color.YELLOW)
                .prefSize(700,800)
                .mousePressHandler(evt -> {
                    AcademiePath academiePath = (AcademiePath) evt.getSource();
                    System.out.println("On vient de cliquer sur l'"+academiePath.getAcademie().getNom());

                    TabPane tabPane = this.parentTab.getTabPane();
                    tabPane.getTabs().add(new AcademieOnglet(academiePath.getAcademie()));
                    tabPane.getSelectionModel().select(tabPane.getTabs().size()-1);
                })
                .mouseEnterHandler(evt -> {
                    AcademiePath academiePath = (AcademiePath) evt.getSource();
                    System.out.println("On vient de passer sur l'"+academiePath.getAcademie().getNom());
                    academieActuelle.setText("Liste des thématiques disponibles dans l'"+academiePath.getAcademie().getNom());
                    if(usageParAcademie.get(academiePath.getAcademie().getNom()) != null){
                        for(Usage usage : usageParAcademie.get(academiePath.getAcademie().getNom())){
                            btParTheme.get(usage.getThematique().getNom()).setBackground(Background.fill(Color.web("#62b4bf")));
                        }
                    }
                })
                .mouseExitHandler(evt -> {
                    AcademiePath academiePath = (AcademiePath) evt.getSource();
                    System.out.println("On vient de quitter l'"+academiePath.getAcademie().getNom());
                    if(usageParAcademie.get(academiePath.getAcademie().getNom()) != null) {
                        for (Usage usage : usageParAcademie.get(academiePath.getAcademie().getNom())) {
                            btParTheme.get(usage.getThematique().getNom()).setBackground(Background.fill(Color.web("#c8f4fa")));
                        }
                    }
                })
                .selectionEnabled(true)
                .build();
        ScrollPane pane = new ScrollPane();
        pane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        pane.setContent(france);
        setLeft(pane);

        setBackground(new Background(new BackgroundFill(Color.web("#a3d7f7"), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    private void initDispButtons(){
        flowPane = new FlowPane();
        btParTheme = new HashMap<String, Button>();
        for (Thematique thematique : FXCollections.observableList(DAOFactoryProducer.getFactory(DAOType.JPA).createDAOThematique().findAll())) {
            Button bt = new Button(thematique.getNom());
            bt.setPrefSize(125, 60);
            bt.setBackground(Background.fill(Color.web("#c8f4fa")));
            bt.setWrapText(true);
            flowPane.getChildren().add(bt);
            btParTheme.put(thematique.getNom(),bt);
        }
        flowPane.setHgap(10);
        flowPane.setVgap(10);
        flowPane.setPrefSize(500,600);
        BorderPane themesParAca = new BorderPane();
        themesParAca.setCenter(flowPane);
        themesParAca.setTop(academieActuelle =new LabelUsageControl("Liste des thématiques disponible dans l'Academie de"));
        academieActuelle.setWrapText(true);
        academieActuelle.setFont(new Font(15));
        themesParAca.prefWidth(700);
        academieActuelle.setPrefSize(550,80);

        setRight(themesParAca);
    }
}
