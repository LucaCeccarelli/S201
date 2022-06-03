package fr.univ_amu.iut.contenu.reseaux;

import fr.univ_amu.iut.components.ListTemplateControl;
import fr.univ_amu.iut.contenu.usages.UsagesOnglet;
import fr.univ_amu.iut.view.map.AcademiePath;
import fr.univ_amu.iut.view.map.France;
import fr.univ_amu.iut.view.map.FranceBuilder;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;

import java.io.IOException;

public class ReseauxContenuControl extends BorderPane {
    private Tab parentTab;
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
        France france = FranceBuilder.create()
                //.backgroundColor(Color.web("#4aa9d7"))
                //.fillColor(Color.web("#dcb36c"))
                //.strokeColor(Color.web("#987028"))
                //.hoverColor(Color.web("#fec47e"))
                //.pressedColor(Color.web("#6cee85"))
                //.selectedColor(Color.MAGENTA)
                .mousePressHandler(evt -> {
                    AcademiePath academiePath = (AcademiePath) evt.getSource();
                    System.out.println("On vient de cliquer sur l'"+academiePath.getAcademie().getNom());

                    TabPane tabPane = this.parentTab.getTabPane();
                    tabPane.getTabs().add(new Tab(academiePath.getAcademie().getNom(),new ListTemplateControl(new String[]{"Intitule","Usages","Discipline","Type de Ressource"})));

                })
                .selectionEnabled(true)
                .build();
        getChildren().add(france);
        setBackground(new Background(new BackgroundFill(france.getBackgroundColor(), CornerRadii.EMPTY, Insets.EMPTY)));
    }
}
