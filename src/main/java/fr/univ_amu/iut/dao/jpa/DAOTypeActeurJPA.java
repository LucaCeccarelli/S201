package fr.univ_amu.iut.dao.jpa;

import fr.univ_amu.iut.dao.DAOTypeActeur;
import fr.univ_amu.iut.model.Ressource;
import fr.univ_amu.iut.model.Thematique;
import fr.univ_amu.iut.model.TypeActeur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DAOTypeActeurJPA implements DAOTypeActeur {

    private EntityManager entityManager;

    public DAOTypeActeurJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public boolean delete(TypeActeur obj) {
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
    public List<TypeActeur> findAll() {
        TypedQuery<TypeActeur> query = entityManager.createNamedQuery("TypeActeur.findAll", TypeActeur.class);
        return query.getResultList();
    }

    @Override
    public TypeActeur getById(Integer id) {
        TypedQuery<TypeActeur> query = entityManager.createNamedQuery("TypeActeur.getById", TypeActeur.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public TypeActeur insert(TypeActeur obj) {
        entityManager.getTransaction().begin();
        entityManager.persist(obj);
        entityManager.getTransaction().commit();
        return entityManager.find(TypeActeur.class,obj.getId());
    }

    @Override
    public boolean update(TypeActeur obj) {
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
    public TypeActeur findByNom(String nom) {
        TypedQuery<TypeActeur> query = entityManager.createNamedQuery("TypeActeur.findByNom", TypeActeur.class);
        query.setParameter("nom", nom);
        return query.getSingleResult();
    }
}
