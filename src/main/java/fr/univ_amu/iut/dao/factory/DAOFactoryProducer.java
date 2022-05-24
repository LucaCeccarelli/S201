package fr.univ_amu.iut.dao.factory;

import fr.univ_amu.iut.dao.jdbc.DAOFactoryJDBC;
import fr.univ_amu.iut.dao.jpa.DAOFactoryJPA;

public class DAOFactoryProducer {
    public static DAOFactory getFactory(DAOType type) {
        return switch (type){
            case JPA -> new DAOFactoryJPA();
            case JDBC -> new DAOFactoryJDBC();
            default -> throw new IllegalArgumentException();
        };
    }
}