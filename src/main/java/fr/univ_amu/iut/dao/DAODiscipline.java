package fr.univ_amu.iut.dao;

import fr.univ_amu.iut.model.Discipline;

public interface DAODiscipline extends DAO<Discipline, Integer>{

    Discipline findByNom(String nom);

}
