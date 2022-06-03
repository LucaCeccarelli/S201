package fr.univ_amu.iut.dao.jpa;

import fr.univ_amu.iut.dao.*;
import fr.univ_amu.iut.dao.factory.DAOFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class DAOFactoryJPA implements DAOFactory {

    private EntityManager entityManager;

    @Override
    public DAOAcademie createDAOAcademie() {
        return null;
    }

    @Override
    public DAOActeur createDAOActeur() {
        return null;
    }

    @Override
    public DAODiscipline createDAODiscipline() {
        return null;
    }

    @Override
    public DAORegionAcademique createDAORegionAcademique() {
        return null;
    }

    @Override
    public DAORessource createDAORessource() {
        return null;
    }

    @Override
    public DAOThematique createDAOThematique() {
        return null;
    }

    @Override
    public DAOTypeActeur createDAOTypeActeur() {
        return null;
    }

    @Override
    public DAOTypeRessource createDAOTypeRessource() {
        return null;
    }

    @Override
    public DAOUsage createDAOUsage() {
        return null;
    }
}
