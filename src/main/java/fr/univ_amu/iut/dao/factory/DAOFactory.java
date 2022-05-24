package fr.univ_amu.iut.dao.factory;

import fr.univ_amu.iut.dao.*;

public interface DAOFactory {
    DAOAcademie createDAOAcademie();
    DAOActeur createDAOActeur();
    DAODiscipline createDAODiscipline();
    DAORegionAcademique createDAORegionAcademique();
    DAORessource createDAORessource();
    DAOThematique createDAOThematique();
    DAOTypeActeur createDAOTypeActeur();
    DAOTypeRessource createDAOTypeRessource();
    DAOUsage createDAOUsage();
}
