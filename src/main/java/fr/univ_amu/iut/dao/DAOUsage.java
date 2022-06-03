package fr.univ_amu.iut.dao;

import fr.univ_amu.iut.model.*;

import java.util.List;

public interface DAOUsage extends DAO<Usage, Integer>{

    Usage findByNom(String nom);

    List<Usage> findByDiscipline(Discipline discipline);

    List<Usage> findByThematique(Thematique thematique);

    List<Usage> findByNiveau(String niveau);

    List<Usage> findByAcademie(Academie academie);

}
