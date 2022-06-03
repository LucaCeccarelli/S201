package fr.univ_amu.iut.dao.jpa;

import fr.univ_amu.iut.dao.DAORessource;
import fr.univ_amu.iut.model.Discipline;
import fr.univ_amu.iut.model.RegionAcademique;
import fr.univ_amu.iut.model.Ressource;
import fr.univ_amu.iut.model.TypeActeur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.net.URL;
import java.util.List;

public class DAORessourceJPA implements DAORessource {

    private EntityManager entityManager;

    public DAORessourceJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public boolean delete(Ressource obj) {
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
    public List<Ressource> findAll() {
        TypedQuery<Ressource> query = entityManager.createNamedQuery("Ressource.findAll", Ressource.class);
        return query.getResultList();
    }

    @Override
    public Ressource getById(Integer id) {
        TypedQuery<Ressource> query = entityManager.createNamedQuery("Ressource.getById", Ressource.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Ressource insert(Ressource obj) {
        entityManager.getTransaction().begin();
        entityManager.persist(obj);
        entityManager.getTransaction().commit();
        return entityManager.find(Ressource.class,obj.getId());
    }

    @Override
    public boolean update(Ressource obj) {
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
    public Ressource findByUrl(URL url) {
        TypedQuery<Ressource> query = entityManager.createNamedQuery("Ressource.findByUrl", Ressource.class);
        query.setParameter("lienRessource", url);
        return query.getSingleResult();
    }
}
