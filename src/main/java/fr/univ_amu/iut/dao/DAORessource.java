package fr.univ_amu.iut.dao;

import fr.univ_amu.iut.model.Ressource;

import java.net.URL;

public interface DAORessource extends DAO<Ressource, Integer>{

    Ressource findByUrl(URL url);

}
