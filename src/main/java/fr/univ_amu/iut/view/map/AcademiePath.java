package fr.univ_amu.iut.view.map;

import fr.univ_amu.iut.model.Academie;
import javafx.scene.control.Tooltip;
import javafx.scene.shape.SVGPath;
import javafx.scene.transform.Transform;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class AcademiePath extends SVGPath {
    private final static HashMap<Academie, AcademiePath> INSTANCES = new HashMap<>();

    Academie academie;
    private final Tooltip tooltip;

    public AcademiePath(Academie academie){
        this(academie, null);
    }

    public AcademiePath(Academie academie, String content) {
        this.academie = academie;
        this.tooltip = new Tooltip(academie.getNom());
        Tooltip.install(this, tooltip);
        if (null == content) return;
        setContent(content);
        getTransforms().add(Transform.affine(1.3333333,0,0,-1.3333333,-79.268904,937.80293));
        INSTANCES.put(academie,this);
    }

    private static final String LORES_PROPERTIES = "fr/univ_amu/iut/francefx/lores.properties";

    private static Properties readProperties(String fileName) {
        final ClassLoader LOADER = Thread.currentThread().getContextClassLoader();
        final Properties PROPERTIES = new Properties();
        try (InputStream resourceStream = LOADER.getResourceAsStream(fileName)) {
            PROPERTIES.load(resourceStream);
        } catch (IOException exception) {
            System.out.println(Arrays.toString(exception.getStackTrace()));
        }
        return PROPERTIES;
    }

    public static Map<String, List<AcademiePath>> createCountryPaths() {
        Properties resolutionProperties = readProperties(LORES_PROPERTIES);

        Map<String, List<AcademiePath>> academiePaths = new HashMap<>();

        resolutionProperties.forEach((key, value) -> {
            String name = key.toString();
            List<AcademiePath> pathList = new ArrayList<>();
            for (String path : value.toString().split(";")) {
                pathList.add(new AcademiePath(Academie.get(name), path));
            }
            academiePaths.put(name, pathList);
        });

        return academiePaths;
    }

    public static AcademiePath get(Academie academie) {
        return INSTANCES.get(academie);
    }

    public Academie getAcademie() {
        return academie;
    }
}
