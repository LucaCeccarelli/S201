package fr.univ_amu.iut.dao.jpa;

import fr.univ_amu.iut.dao.DAOAcademie;
import fr.univ_amu.iut.model.Academie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DAOAcademieJPA implements DAOAcademie {

    private final EntityManager entityManager;

    public DAOAcademieJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public boolean delete(Academie obj) {
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
    public List<Academie> findAll() {
        TypedQuery<Academie> query = entityManager.createNamedQuery("Academie.findAll", Academie.class);
        return query.getResultList();
    }

    @Override
    public Academie getById(String id) {
        TypedQuery<Academie> query = entityManager.createNamedQuery("Academie.getById", Academie.class);
        query.setParameter("code",id);
        return query.getSingleResult();
    }

    @Override
    public Academie insert(Academie obj) {
        entityManager.getTransaction().begin();
        entityManager.persist(obj);
        entityManager.getTransaction().commit();
        return entityManager.find(Academie.class, obj.getCode());
    }

    @Override
    public boolean update(Academie obj) {
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(obj);
            entityManager.getTransaction().commit();
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public Academie findByNom(String nom) {
        TypedQuery<Academie> query = entityManager.createNamedQuery("Academie.findByNom",Academie.class);
        query.setParameter("nom", nom);
        return query.getSingleResult();
    }
}
