package fr.univ_amu.iut.dao.jpa;

import fr.univ_amu.iut.dao.DAODiscipline;
import fr.univ_amu.iut.model.Acteur;
import fr.univ_amu.iut.model.Discipline;
import fr.univ_amu.iut.model.TypeActeur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DAODisciplineJPA implements DAODiscipline {

    private EntityManager entityManager;

    public DAODisciplineJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public boolean delete(Discipline obj) {
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
    public List<Discipline> findAll() {
        TypedQuery<Discipline> query = entityManager.createNamedQuery("Discipline.findAll", Discipline.class);
        return query.getResultList();
    }

    @Override
    public Discipline getById(Integer id) {
        TypedQuery<Discipline> query = entityManager.createNamedQuery("Discipline.getById", Discipline.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Discipline insert(Discipline obj) {
        entityManager.getTransaction().begin();
        entityManager.persist(obj);
        entityManager.getTransaction().commit();
        return entityManager.find(Discipline.class,obj.getId());
    }

    @Override
    public boolean update(Discipline obj) {
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
    public Discipline findByNom(String nom) {
        TypedQuery<Discipline> query = entityManager.createNamedQuery("Discipline.findByNom", Discipline.class);
        query.setParameter("nom", nom);
        return query.getSingleResult();
    }
}
