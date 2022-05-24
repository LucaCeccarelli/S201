package fr.univ_amu.iut.view.map;

import fr.univ_amu.iut.model.Academie;
import javafx.beans.DefaultProperty;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.css.*;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.event.WeakEventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;

import java.util.List;
import java.util.Map;

import static javafx.scene.input.MouseEvent.*;
import static javafx.scene.input.MouseEvent.MOUSE_EXITED;

@DefaultProperty("children")
public class France extends Region {
    protected Pane pane = new Pane();
    protected Group group = new Group();
    private final Map<String, List<AcademiePath>> academiePaths = AcademiePath.createCountryPaths();
    private EventHandler<MouseEvent> mouseEnterHandler;
    private EventHandler<MouseEvent> mousePressHandler;
    private EventHandler<MouseEvent> mouseReleaseHandler;
    private EventHandler<MouseEvent> mouseExitHandler;
    private final EventHandler<MouseEvent> _mouseEnterHandler = evt -> handleMouseEvent(evt, mouseEnterHandler);
    private final EventHandler<MouseEvent> _mousePressHandler= evt -> handleMouseEvent(evt, mousePressHandler);
    private final EventHandler<MouseEvent> _mouseReleaseHandler= evt -> handleMouseEvent(evt, mouseReleaseHandler);
    private final EventHandler<MouseEvent> _mouseExitHandler= evt -> handleMouseEvent(evt, mouseExitHandler);

    private static final StyleablePropertyFactory<France> FACTORY = new StyleablePropertyFactory<>(Region.getClassCssMetaData());
    private static final CssMetaData<France, Color> BACKGROUND_COLOR = FACTORY.createColorCssMetaData("-background-color", s -> s.backgroundColor, Color.web("#3f3f4f"), false);
    private static final CssMetaData<France, Color> FILL_COLOR = FACTORY.createColorCssMetaData("-fill-color", s -> s.fillColor, Color.web("#d9d9dc"), false);
    private static final CssMetaData<France, Color> STROKE_COLOR = FACTORY.createColorCssMetaData("-stroke-color", s -> s.strokeColor, Color.BLACK, false);
    private static final CssMetaData<France, Color> HOVER_COLOR = FACTORY.createColorCssMetaData("-hover-color", s -> s.hoverColor, Color.web("#456acf"), false);
    private static final CssMetaData<France, Color> PRESSED_COLOR = FACTORY.createColorCssMetaData("-pressed-color", s -> s.pressedColor, Color.web("#789dff"), false);
    private static final CssMetaData<France, Color> SELECTED_COLOR = FACTORY.createColorCssMetaData("-selected-color", s -> s.selectedColor, Color.web("#9dff78"), false);
    private final StyleableProperty<Color> backgroundColor = new StyleableObjectProperty<>(BACKGROUND_COLOR.getInitialValue(France.this)) {
        @Override
        protected void invalidated() {
            setBackground(new Background(new BackgroundFill(get(), CornerRadii.EMPTY, Insets.EMPTY)));
        }

        @Override
        public Object getBean() {
            return France.this;
        }

        @Override
        public String getName() {
            return "backgroundColor";
        }

        @Override
        public CssMetaData<? extends Styleable, Color> getCssMetaData() {
            return BACKGROUND_COLOR;
        }
    };

    private final StyleableProperty<Color> fillColor = new StyleableObjectProperty<>(FILL_COLOR.getInitialValue(France.this)) {
        @Override
        protected void invalidated() {
            setFillAndStroke();
        }

        @Override
        public Object getBean() {
            return France.this;
        }

        @Override
        public String getName() {
            return "fillColor";
        }

        @Override
        public CssMetaData<? extends Styleable, Color> getCssMetaData() {
            return FILL_COLOR;
        }
    };
    private final StyleableProperty<Color> strokeColor = new StyleableObjectProperty<>(STROKE_COLOR.getInitialValue(France.this)) {
        @Override
        protected void invalidated() {
            setFillAndStroke();
        }

        @Override
        public Object getBean() {
            return France.this;
        }

        @Override
        public String getName() {
            return "strokeColor";
        }

        @Override
        public CssMetaData<? extends Styleable, Color> getCssMetaData() {
            return STROKE_COLOR;
        }
    };
    private final StyleableProperty<Color> hoverColor = new StyleableObjectProperty<>(HOVER_COLOR.getInitialValue(France.this)) {
        @Override
        protected void invalidated() {
        }

        @Override
        public Object getBean() {
            return France.this;
        }

        @Override
        public String getName() {
            return "hoverColor";
        }

        @Override
        public CssMetaData<? extends Styleable, Color> getCssMetaData() {
            return HOVER_COLOR;
        }
    };
    private final StyleableProperty<Color> pressedColor = new StyleableObjectProperty<>(PRESSED_COLOR.getInitialValue(this)) {
        @Override
        protected void invalidated() {
        }

        @Override
        public Object getBean() {
            return France.this;
        }

        @Override
        public String getName() {
            return "pressedColor";
        }

        @Override
        public CssMetaData<? extends Styleable, Color> getCssMetaData() {
            return PRESSED_COLOR;
        }
    };
    private final StyleableProperty<Color> selectedColor = new StyleableObjectProperty<>(SELECTED_COLOR.getInitialValue(this)) {
        @Override
        protected void invalidated() {
        }

        @Override
        public Object getBean() {
            return France.this;
        }

        @Override
        public String getName() {
            return "selectedColor";
        }

        @Override
        public CssMetaData<? extends Styleable, Color> getCssMetaData() {
            return SELECTED_COLOR;
        }
    };

    private final BooleanProperty hoverEnabled = new SimpleBooleanProperty(true);
    private final BooleanProperty selectionEnabled = new SimpleBooleanProperty(true);

    private final ObjectProperty<Academie> selectedAcademie = new SimpleObjectProperty<>();

    private Academie formerSelectedAcademie;

    public France() {
        initGraphics();
    }

    private void initGraphics() {
        Color fill = getFillColor();
        Color stroke = getStrokeColor();

        academiePaths.forEach((name, pathList) -> {
            Academie academie = Academie.get(name);
            pathList.forEach(path -> {
                path.setFill(fill);
                path.setStroke(stroke);
                path.setStrokeWidth(0.2);
                path.setOnMouseEntered(new WeakEventHandler<>(_mouseEnterHandler));
                path.setOnMousePressed(new WeakEventHandler<>(_mousePressHandler));
                path.setOnMouseReleased(new WeakEventHandler<>(_mouseReleaseHandler));
                path.setOnMouseExited(new WeakEventHandler<>(_mouseExitHandler));
            });
            pane.getChildren().addAll(pathList);
        });
        group.getChildren().add(pane);

        getChildren().setAll(group);

        setBackground(new Background(new BackgroundFill(getBackgroundColor(), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public void setMouseEnterHandler(final EventHandler<MouseEvent> handler) {
        mouseEnterHandler = handler;
    }

    public void setMousePressHandler(final EventHandler<MouseEvent> handler) {
        mousePressHandler = handler;
    }

    public void setMouseReleaseHandler(final EventHandler<MouseEvent> handler) {
        mouseReleaseHandler = handler;
    }

    public void setMouseExitHandler(final EventHandler<MouseEvent> handler) {
        mouseExitHandler = handler;
    }
    public Color getBackgroundColor() {
        return backgroundColor.getValue();
    }

    public void setBackgroundColor(final Color COLOR) {
        backgroundColor.setValue(COLOR);
    }

    public ObjectProperty<Color> backgroundColorProperty() {
        return (ObjectProperty<Color>) backgroundColor;
    }

    public Color getFillColor() {
        return fillColor.getValue();
    }

    public void setFillColor(final Color COLOR) {
        fillColor.setValue(COLOR);
    }

    public ObjectProperty<Color> fillColorProperty() {
        return (ObjectProperty<Color>) fillColor;
    }

    public Color getStrokeColor() {
        return strokeColor.getValue();
    }

    public void setStrokeColor(final Color COLOR) {
        strokeColor.setValue(COLOR);
    }

    public ObjectProperty<Color> strokeColorProperty() {
        return (ObjectProperty<Color>) strokeColor;
    }

    public Color getHoverColor() {
        return hoverColor.getValue();
    }

    public void setHoverColor(final Color COLOR) {
        hoverColor.setValue(COLOR);
    }

    public ObjectProperty<Color> hoverColorProperty() {
        return (ObjectProperty<Color>) hoverColor;
    }

    public Color getPressedColor() {
        return pressedColor.getValue();
    }

    public void setPressedColor(final Color COLOR) {
        pressedColor.setValue(COLOR);
    }

    public ObjectProperty<Color> pressedColorProperty() {
        return (ObjectProperty<Color>) pressedColor;
    }

    public Color getSelectedColor() {
        return selectedColor.getValue();
    }

    public void setSelectedColor(final Color COLOR) {
        selectedColor.setValue(COLOR);
    }

    public ObjectProperty<Color> selectedColorProperty() {
        return (ObjectProperty<Color>) selectedColor;
    }

    public boolean isHoverEnabled() {
        return hoverEnabled.get();
    }

    public void setHoverEnabled(final boolean ENABLED) {
        hoverEnabled.set(ENABLED);
    }

    public BooleanProperty hoverEnabledProperty() {
        return hoverEnabled;
    }

    public boolean isSelectionEnabled() {
        return selectionEnabled.get();
    }

    public void setSelectionEnabled(final boolean ENABLED) {
        selectionEnabled.set(ENABLED);
    }

    public BooleanProperty selectionEnabledProperty() {
        return selectionEnabled;
    }

    public Academie getSelectedAcademie() {
        return selectedAcademie.get();
    }

    public void setSelectedAcademie(final Academie academie) {
        selectedAcademie.set(academie);
    }

    public ObjectProperty<Academie> selectedAcademieProperty() {
        return selectedAcademie;
    }


    private void handleMouseEvent(final MouseEvent EVENT, final EventHandler<MouseEvent> HANDLER) {
        final AcademiePath academiePath = (AcademiePath) EVENT.getSource();
        final Academie academie = academiePath.getAcademie();
        final List<AcademiePath> PATHS = academiePaths.get(academie.getCode());

        final EventType<? extends MouseEvent> TYPE = EVENT.getEventType();
        if (MOUSE_ENTERED == TYPE) {
            if (isHoverEnabled()) {
                Color color = isSelectionEnabled() && academie.equals(getSelectedAcademie()) ? getSelectedColor() : getHoverColor();
                for (SVGPath path : PATHS) {
                    path.setFill(color);
                }
            }
        } else if (MOUSE_PRESSED == TYPE) {
            if (isSelectionEnabled()) {
                Color color;
                if (null == getSelectedAcademie()) {
                    setSelectedAcademie(academie);
                    color = getSelectedColor();
                } else {
                    color = getFillColor();
                }
                for (SVGPath path : academiePaths.get(getSelectedAcademie().getCode())) {
                    path.setFill(color);
                }
            } else {
                if (isHoverEnabled()) {
                    for (SVGPath path : PATHS) {
                        path.setFill(getPressedColor());
                    }
                }
            }
        } else if (MOUSE_RELEASED == TYPE) {
            Color color;
            if (isSelectionEnabled()) {
                if (formerSelectedAcademie == academie) {
                    setSelectedAcademie(null);
                    color = getFillColor();
                } else {
                    setSelectedAcademie(academie);
                    color = getSelectedColor();
                }
                formerSelectedAcademie = getSelectedAcademie();
            } else {
                color = getHoverColor();
            }
            if (isHoverEnabled()) {
                for (SVGPath path : PATHS) {
                    path.setFill(color);
                }
            }
        } else if (MOUSE_EXITED == TYPE) {
            if (isHoverEnabled()) {
                Color color = isSelectionEnabled() && academie.equals(getSelectedAcademie()) ? getSelectedColor() : getFillColor();
                for (SVGPath path : PATHS) {
                    path.setFill(color);
                }
            }
        }

        if (null != HANDLER) HANDLER.handle(EVENT);
    }

    private void setFillAndStroke() {
        academiePaths.keySet().forEach(name -> {
            Academie academie = Academie.get(name);
            setAcademieFillAndStroke(academie, getFillColor() , getStrokeColor());
        });
    }

    private void setAcademieFillAndStroke(final Academie academie, final Color fill, final Color stroke) {
        List<AcademiePath> paths = academiePaths.get(academie.getCode());
        for (AcademiePath path : paths) {
            path.setFill(fill);
            path.setStroke(stroke);
        }
    }
}
