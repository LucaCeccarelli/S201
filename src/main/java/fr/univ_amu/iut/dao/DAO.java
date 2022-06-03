package fr.univ_amu.iut.dao;

import java.util.List;

public interface DAO<Entity, Key> {

    /**
     * Permet la suppression d'un tuple de la base
     *
     * @param obj Objet à supprimer dans la base
     */
    boolean delete(Entity obj);

    /**
     * Permet de récupérer tous les objets d'une table
     *
     * @return liste de tous les objets contenus dans la base
     */
    List<Entity> findAll();

    /**
     * Permet de récupérer un objet via son ID
     *
     * @param id identifiant du tuple recherché
     * @return le tuple recherché s'il existe
     */
    Entity getById(Key id);

    /**
     * Permet de créer une entrée dans la base de données par rapport à un objet
     *
     * @param obj Objet à insérer dans la base
     */
    Entity insert(Entity obj);

    /**
     * Permet de mettre à jour les données d'un tuple dans la base à partir d'un
     * objet passé en paramètre
     *
     * @param obj Objet à mettre à jour dans la base
     */
    boolean update(Entity obj);
}