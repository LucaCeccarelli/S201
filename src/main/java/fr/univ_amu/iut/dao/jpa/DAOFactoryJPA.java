package fr.univ_amu.iut.dao.jpa;

import fr.univ_amu.iut.dao.*;
import fr.univ_amu.iut.dao.factory.DAOFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DAOFactoryJPA implements DAOFactory {

    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        if(entityManager == null){
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gestionUsagesPU");
            entityManager = entityManagerFactory.createEntityManager();
        }
        return entityManager;
    }

    public DAOFactoryJPA() {}

    @Override
    public DAOAcademie createDAOAcademie() {
        return new DAOAcademieJPA(getEntityManager());
    }

    @Override
    public DAOActeur createDAOActeur() {
        return new DAOActeurJPA(getEntityManager());
    }

    @Override
    public DAODiscipline createDAODiscipline() {
        return new DAODisciplineJPA(getEntityManager());
    }

    @Override
    public DAORegionAcademique createDAORegionAcademique() {
        return new DAORegionAcademiqueJPA(getEntityManager());
    }

    @Override
    public DAORessource createDAORessource() {
        return new DAORessourceJPA(getEntityManager());
    }

    @Override
    public DAOThematique createDAOThematique() {
        return new DAOThematiqueJPA(getEntityManager());
    }

    @Override
    public DAOTypeActeur createDAOTypeActeur() {
        return new DAOTypeActeurJPA(getEntityManager());
    }

    @Override
    public DAOTypeRessource createDAOTypeRessource() {
        return new DAOTypeRessourceJPA(getEntityManager());
    }

    @Override
    public DAOUsage createDAOUsage() {
        return new DAOUsageJPA(getEntityManager());
    }
}
