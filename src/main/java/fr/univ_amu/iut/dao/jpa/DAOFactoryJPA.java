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
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gestionUsagePU");
            entityManager = entityManagerFactory.createEntityManager();
        }
        return entityManager;
    }

    public DAOFactoryJPA() {}

    @Override
    public DAOAcademie createDAOAcademie() {
        return new DAOAcademieJPA(entityManager);
    }

    @Override
    public DAOActeur createDAOActeur() {
        return new DAOActeurJPA(entityManager);
    }

    @Override
    public DAODiscipline createDAODiscipline() {
        return new DAODisciplineJPA(entityManager);
    }

    @Override
    public DAORegionAcademique createDAORegionAcademique() {
        return new DAORegionAcademiqueJPA(entityManager);
    }

    @Override
    public DAORessource createDAORessource() {
        return new DAORessourceJPA(entityManager);
    }

    @Override
    public DAOThematique createDAOThematique() {
        return new DAOThematiqueJPA(entityManager);
    }

    @Override
    public DAOTypeActeur createDAOTypeActeur() {
        return new DAOTypeActeurJPA(entityManager);
    }

    @Override
    public DAOTypeRessource createDAOTypeRessource() {
        return new DAOTypeRessourceJPA(entityManager);
    }

    @Override
    public DAOUsage createDAOUsage() {
        return new DAOUsageJPA(entityManager);
    }
}
