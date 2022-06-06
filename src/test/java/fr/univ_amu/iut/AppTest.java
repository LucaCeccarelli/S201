package fr.univ_amu.iut;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.framework.junit5.Start;

import java.util.concurrent.TimeoutException;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(ApplicationExtension.class)
public class AppTest {

    Stage stage;

    @BeforeEach
    void setUpClass() throws Exception {
        ApplicationTest.launch(LaunchApp.class);
    }

    @Start
    void onStart(Stage stage) throws Exception {
        this.stage = stage;
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

}