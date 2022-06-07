package fr.univ_amu.iut;

import fr.univ_amu.iut.contenu.accueil.AccueilOnglet;
import fr.univ_amu.iut.contenu.reseaux.ReseauxOnglet;
import fr.univ_amu.iut.contenu.thematique.ThematiqueOnglet;
import fr.univ_amu.iut.contenu.thematiques.ThematiquesOnglet;
import javafx.application.Platform;
import javafx.scene.control.TabPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.control.ListViewMatchers;

import java.util.concurrent.TimeoutException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.util.NodeQueryUtils.hasText;

@ExtendWith(ApplicationExtension.class)
public class AppTest {

    Stage stage;

    @Start
    void onStart(Stage stage) {
        Platform.runLater(() -> {
            AppTest.this.stage = new Stage();
            try {
                FxToolkit.setupStage((sta) -> {
                    try {
                        new LaunchApp().start(AppTest.this.stage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        });
    }

    @AfterEach
    void afterEachTest(FxRobot robot) throws TimeoutException {
        FxToolkit.cleanupStages();
        robot.release(new KeyCode[]{});
        robot.release(new MouseButton[]{});
    }

    @Test
    public void test_should_never_fail() {
        assertThat(true).isTrue();
    }

    @Test
    public void test_app_title() {
        assertThat(stage.getTitle()).isEqualTo("Application DNE");
    }

    @Test
    public void test_stage_is_not_resizable() {
        assertThat(stage.isResizable()).isFalse();
    }

    @Test
    public void test_stage_is_showing() {
        assertThat(stage.isShowing()).isTrue();
    }

    @Test
    public void should_initialize_stage_with_height_of_720() {
        assertThat(stage.getScene().getHeight()).isEqualTo(720);
    }

    @Test
    public void should_initialize_stage_with_width_of_1280() {
        assertThat(stage.getScene().getWidth()).isEqualTo(1280);
    }

    @Test
    public void should_initialize_main_menu_buttons() {
        verifyThat("#accesApplication", hasText("Accéder à l'application"));
        verifyThat("#accesAdmin", hasText("Accéder au menu d'administration"));
    }

    @Test
    public void should_check_app_tabs_opened_correctly(FxRobot robot) {
        robot.clickOn("#accesApplication");
        TabPane tabPane = (TabPane)stage.getScene().lookup("#tabPane");
        assertThat(tabPane.getTabs().size()).isEqualTo(3);
        assertThat(tabPane.getTabs().get(0).getId()).isEqualTo("ongletAccueil");
        assertThat(tabPane.getTabs().get(1).getId()).isEqualTo("ongletThematiques");
        assertThat(tabPane.getTabs().get(2).getId()).isEqualTo("ongletReseaux");
    }

    @Test
    public void should_check_admin_tabs_opened_correctly(FxRobot robot) {
        robot.clickOn("#accesAdmin");
        TabPane tabPane = (TabPane)stage.getScene().lookup("#tabPane");
        assertThat(tabPane.getTabs().size()).isEqualTo(3);
        assertThat(tabPane.getTabs().get(0).getId()).isEqualTo("ongletAccueil");
        assertThat(tabPane.getTabs().get(1).getId()).isEqualTo("jpaActeur");
        assertThat(tabPane.getTabs().get(2).getId()).isEqualTo("jpaUsage");
    }

}