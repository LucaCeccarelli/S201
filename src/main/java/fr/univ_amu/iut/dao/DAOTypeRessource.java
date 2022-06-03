package fr.univ_amu.iut.dao;

import fr.univ_amu.iut.model.TypeRessource;

public interface DAOTypeRessource extends DAO<TypeRessource, Integer> {

    TypeRessource findByNom(String nom);

}
