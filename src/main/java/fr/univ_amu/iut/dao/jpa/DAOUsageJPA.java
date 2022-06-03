package fr.univ_amu.iut.dao.jpa;

import fr.univ_amu.iut.dao.DAOUsage;
import fr.univ_amu.iut.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DAOUsageJPA implements DAOUsage {

    private EntityManager entityManager;

    public DAOUsageJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public boolean delete(Usage obj) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(obj);
            entityManager.getTransaction().commit();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Usage> findAll() {
        TypedQuery<Usage> query = entityManager.createNamedQuery("Usage.findAll", Usage.class);
        return query.getResultList();
    }

    @Override
    public Usage getById(Integer id) {
        TypedQuery<Usage> query = entityManager.createNamedQuery("Etudiant.findById", Usage.class);
        query.setParameter("idUsage", id);
        return query.getSingleResult();
    }

    @Override
    public Usage insert(Usage obj) {
        entityManager.getTransaction().begin();
        entityManager.persist(obj);
        entityManager.getTransaction().commit();
        return entityManager.find(Usage.class, obj.getId());
    }

    @Override
    public boolean update(Usage obj) {
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(obj);
            entityManager.getTransaction().commit();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Usage findByNom(String nom) {
        TypedQuery<Usage> query = entityManager.createNamedQuery("Usage.findByNom", Usage.class);
        query.setParameter("nom", nom);
        return query.getSingleResult();
    }

    @Override
    public List<Usage> findByDiscipline(Discipline discipline) {
        TypedQuery<Usage> query = entityManager.createNamedQuery("Usage.findByDiscipline", Usage.class);
        query.setParameter("discipline", discipline);
        return query.getResultList();
    }

    @Override
    public List<Usage> findByThematique(Thematique thematique) {
        TypedQuery<Usage> query = entityManager.createNamedQuery("Usage.findByThematique", Usage.class);
        query.setParameter("thematique", thematique);
        return query.getResultList();
    }

    @Override
    public List<Usage> findByNiveau(String niveau) {
        TypedQuery<Usage> query = entityManager.createNamedQuery("Usage.findByTNiveau", Usage.class);
        query.setParameter("niveau", niveau);
        return query.getResultList();
    }

    @Override
    public List<Usage> findByAcademie(Academie academie) {
        TypedQuery<Usage> query = entityManager.createNamedQuery("Usage.findByAcademie", Usage.class);
        query.setParameter("academie", academie);
        return query.getResultList();
    }
}
