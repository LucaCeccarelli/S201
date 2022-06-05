package fr.univ_amu.iut.contenu.reseaux;

import fr.univ_amu.iut.app_main.LaunchApp;
import fr.univ_amu.iut.contenu.academie.AcademieOnglet;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ReseauxContenuControl extends BorderPane {
    private Tab parentTab;
    private France france;
    private FlowPane flowPane;
    private Label academieActuelle;
    private HashMap<String, List<Usage>> usageParAcademie;
    private HashMap<Thematique, Button> btParTheme;
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
        for(Academie academie : FXCollections.observableList(LaunchApp.em.createNamedQuery("Academie.findAll", Academie.class).getResultList())){
            usageParAcademie.put(academie.getNom(),new DAOUsageJPA(LaunchApp.em).findByAcademie(academie));
        }
    }

    private void initFrance(){
        France france = FranceBuilder.create()
                .backgroundColor(Color.web("#4aa9d7"))
                .fillColor(Color.web("#dcb36c"))
                .strokeColor(Color.web("#987028"))
                .hoverColor(Color.web("#fec47e"))
                .pressedColor(Color.web("#6cee85"))
                .selectedColor(Color.MAGENTA)
                .prefSize(400,400)
                .mousePressHandler(evt -> {
                    AcademiePath academiePath = (AcademiePath) evt.getSource();
                    System.out.println("On vient de cliquer sur l'"+academiePath.getAcademie().getNom());

                    TabPane tabPane = this.parentTab.getTabPane();
                    tabPane.getTabs().add(new AcademieOnglet(academiePath.getAcademie()));

                })
                .mouseEnterHandler(evt -> {
                    AcademiePath academiePath = (AcademiePath) evt.getSource();
                    System.out.println("On vient de passer sur l'"+academiePath.getAcademie().getNom());
                    academieActuelle.setText("Liste des thématiques disponibles\ndans l'"+academiePath.getAcademie().getNom());
                    if(usageParAcademie.get(academiePath.getAcademie().getNom()) != null){
                        for(Usage usage : usageParAcademie.get(academiePath.getAcademie().getNom())){
                            btParTheme.get(usage.getThematique()).setBackground(Background.fill(Color.LIGHTGREEN));
                        }
                    }
                })
                .mouseExitHandler(evt -> {
                    AcademiePath academiePath = (AcademiePath) evt.getSource();
                    System.out.println("On vient de quitter l'"+academiePath.getAcademie().getNom());
                    if(usageParAcademie.get(academiePath.getAcademie().getNom()) != null) {
                        for (Usage usage : usageParAcademie.get(academiePath.getAcademie().getNom())) {
                            btParTheme.get(usage.getThematique()).setBackground(Background.fill(Color.LIGHTBLUE));
                        }
                    }
                })
                .selectionEnabled(true)
                .build();

        Pane pane = new Pane(france);
        pane.setPrefSize(650,720);
        setLeft(pane);

        setBackground(new Background(new BackgroundFill(france.getBackgroundColor(), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    private void initDispButtons(){
        flowPane = new FlowPane();
        TypedQuery<Thematique> query = LaunchApp.em.createNamedQuery("Thematique.findAll", Thematique.class);
        btParTheme = new HashMap<Thematique, Button>();
        for (Thematique thematique : FXCollections.observableList(query.getResultList())) {
            Button bt = new Button(thematique.getNom());
            bt.setPrefSize(120, 60);
            bt.setBackground(Background.fill(Color.LIGHTBLUE));
            flowPane.getChildren().add(bt);
            btParTheme.put(thematique,bt);
        }
        flowPane.setHgap(10);
        flowPane.setVgap(10);
        BorderPane themesParAca = new BorderPane();
        themesParAca.setCenter(flowPane);
        themesParAca.setTop(academieActuelle =new Label("Liste des thématiques disponibles\ndans l'Academie de"));
        academieActuelle.setPrefSize(400,80);

        setRight(themesParAca);
    }
}
