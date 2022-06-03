package fr.univ_amu.iut.dao.jpa;

import fr.univ_amu.iut.dao.DAOThematique;
import fr.univ_amu.iut.model.Ressource;
import fr.univ_amu.iut.model.Thematique;
import fr.univ_amu.iut.model.TypeActeur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DAOThematiqueJPA implements DAOThematique {

    private EntityManager entityManager;

    public DAOThematiqueJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public boolean delete(Thematique obj) {
        try{
            entityManager.getTransaction().begin();
            entityManager.remove(obj);
            entityManager.getTransaction().commit();
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public List<Thematique> findAll() {
        TypedQuery<Thematique> query = entityManager.createNamedQuery("Thematique.findAll", Thematique.class);
        return query.getResultList();
    }

    @Override
    public Thematique getById(Integer id) {
        TypedQuery<Thematique> query = entityManager.createNamedQuery("Thematique.getById", Thematique.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Thematique insert(Thematique obj) {
        entityManager.getTransaction().begin();
        entityManager.persist(obj);
        entityManager.getTransaction().commit();
        return entityManager.find(Thematique.class,obj.getId());
    }

    @Override
    public boolean update(Thematique obj) {
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
    public Thematique findByNom(String nom) {
        TypedQuery<Thematique> query = entityManager.createNamedQuery("Thematique.findByNom", Thematique.class);
        query.setParameter("nom", nom);
        return query.getSingleResult();
    }
}
