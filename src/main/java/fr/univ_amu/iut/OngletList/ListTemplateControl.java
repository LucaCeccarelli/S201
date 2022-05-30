package OngletList;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class ListTemplateControl extends GridPane {

    public ListTemplateControl(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "ListTemplateView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
