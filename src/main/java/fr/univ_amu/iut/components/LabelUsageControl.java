package fr.univ_amu.iut.components;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;

import java.io.IOException;

public class LabelUsageControl extends Label {
    public LabelUsageControl(String nom){
        super(nom);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LabelUsageView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
