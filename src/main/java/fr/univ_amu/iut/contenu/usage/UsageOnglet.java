package fr.univ_amu.iut.contenu.usage;

import fr.univ_amu.iut.model.Usage;
import javafx.geometry.Insets;
import javafx.scene.control.Tab;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class UsageOnglet extends Tab {
    public UsageOnglet(Usage usage){
        setText(usage.getNom());
        setContent(new UsageContenuControl(this, usage));
        setText(usage.getNom());
        BorderPane racine = new BorderPane();
        racine.setPadding(new Insets(10));
        UsageContenuControl contenu = new UsageContenuControl(this, usage);
        racine.setCenter(contenu);
        racine.setBackground(new Background(new BackgroundFill(Color.web("#a3d7f7"), new CornerRadii(0), Insets.EMPTY)));
        setContent(racine);
    }
}
