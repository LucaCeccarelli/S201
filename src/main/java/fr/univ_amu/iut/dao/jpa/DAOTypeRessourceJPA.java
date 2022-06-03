package fr.univ_amu.iut.dao.jpa;

import fr.univ_amu.iut.dao.DAOTypeRessource;
import fr.univ_amu.iut.model.TypeActeur;
import fr.univ_amu.iut.model.TypeRessource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DAOTypeRessourceJPA implements DAOTypeRessource {

    private EntityManager entityManager;

    public DAOTypeRessourceJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public boolean delete(TypeRessource obj) {
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
    public List<TypeRessource> findAll() {
        TypedQuery<TypeRessource> query = entityManager.createNamedQuery("TypeRessource.findAll", TypeRessource.class);
        return query.getResultList();
    }

    @Override
    public TypeRessource getById(Integer id) {
        TypedQuery<TypeRessource> query = entityManager.createNamedQuery("TypeRessource.getById", TypeRessource.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public TypeRessource insert(TypeRessource obj) {
        entityManager.getTransaction().begin();
        entityManager.persist(obj);
        entityManager.getTransaction().commit();
        return entityManager.find(TypeRessource.class, obj.getId());
    }

    @Override
    public boolean update(TypeRessource obj) {
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
    public TypeRessource findByNom(String nom) {
        TypedQuery<TypeRessource> query = entityManager.createNamedQuery("TypeRessource.findByNom", TypeRessource.class);
        query.setParameter("nom", nom);
        return query.getSingleResult();
    }
}
