package fr.univ_amu.iut.dao.jpa;

import fr.univ_amu.iut.dao.DAO;
import fr.univ_amu.iut.dao.DAOActeur;
import fr.univ_amu.iut.model.Academie;
import fr.univ_amu.iut.model.Acteur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DAOActeurJPA implements DAOActeur {

    private EntityManager entityManager;

    public DAOActeurJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public boolean delete(Acteur obj) {
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
    public List<Acteur> findAll() {
        TypedQuery<Acteur> query = entityManager.createNamedQuery("Acteur.findAll", Acteur.class);
        return query.getResultList();
    }

    @Override
    public Acteur getById(Integer id) {
        TypedQuery<Acteur> query = entityManager.createNamedQuery("Acteur.getById",Acteur.class);
        return query.getSingleResult();
    }

    @Override
    public Acteur insert(Acteur obj) {
        entityManager.getTransaction().begin();
        entityManager.persist(obj);
        entityManager.getTransaction().commit();

        return entityManager.find(Acteur.class,obj.getNumero());
    }

    @Override
    public boolean update(Acteur obj) {
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(obj);
            entityManager.getTransaction().commit();

            return true;
        }catch (Exception e){
            return false;
        }
    }
}
