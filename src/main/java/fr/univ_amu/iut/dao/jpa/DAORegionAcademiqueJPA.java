package fr.univ_amu.iut.dao.jpa;

import fr.univ_amu.iut.dao.DAORegionAcademique;
import fr.univ_amu.iut.model.Discipline;
import fr.univ_amu.iut.model.RegionAcademique;
import fr.univ_amu.iut.model.TypeActeur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DAORegionAcademiqueJPA implements DAORegionAcademique {

    private EntityManager entityManager;

    public DAORegionAcademiqueJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public boolean delete(RegionAcademique obj) {
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
    public List<RegionAcademique> findAll() {
        TypedQuery<RegionAcademique> query = entityManager.createNamedQuery("RegionAcademique.findAll", RegionAcademique.class);
        return query.getResultList();
    }

    @Override
    public RegionAcademique getById(Integer id) {
        TypedQuery<RegionAcademique> query = entityManager.createNamedQuery("RegionAcademique.getById", RegionAcademique.class);
        return query.getSingleResult();
    }

    @Override
    public RegionAcademique insert(RegionAcademique obj) {

        entityManager.getTransaction().begin();
        entityManager.persist(obj);
        entityManager.getTransaction().commit();
        return entityManager.find(RegionAcademique.class,obj.getId());
    }

    @Override
    public boolean update(RegionAcademique obj) {
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
    public RegionAcademique findByNom(String nom) {
        TypedQuery<RegionAcademique> query = entityManager.createNamedQuery("RegionAcademique.findByNom", RegionAcademique.class);
        return query.getSingleResult();
    }
}
