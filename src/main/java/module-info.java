open module francefx {
    requires transitive javafx.base;
    requires transitive javafx.controls;
    requires transitive javafx.graphics;
    requires transitive javafx.fxml;
    requires transitive org.kordamp.ikonli.javafx;
    requires transitive org.kordamp.ikonli.materialdesign;
    requires transitive org.kordamp.ikonli.core;

    requires jakarta.persistence;

    exports fr.univ_amu.iut.view.map;
    exports fr.univ_amu.iut.model;
    exports fr.univ_amu.iut;
    exports fr.univ_amu.iut.dao;
    exports fr.univ_amu.iut.dao.factory;
}