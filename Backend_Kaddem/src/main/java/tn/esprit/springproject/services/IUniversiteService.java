package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.Universite;

import java.util.List;

public interface IUniversiteService {

    List<Universite> retrieveAllUniversite();

    Universite addUniversite (Universite Un);

    void deleteUniversite (Integer id);

    Universite updateUniversite (Universite Un);

    Universite retrieveUniversite (Integer id);
}
