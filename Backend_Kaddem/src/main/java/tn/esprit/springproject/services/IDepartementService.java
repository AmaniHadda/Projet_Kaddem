package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.Departement;

import java.util.List;
import java.util.Set;

public interface IDepartementService {

    List<Departement> retrievAllDepartement();

    Departement addDepartement(Departement D);

    void deleteDepartement(Integer id);

    Departement updateDepartement(Departement D);

    Departement retrieveDepartement(Integer id);

    //Services avancés


    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement);

    public Set<Departement> retrieveDepartementsByUniversite(Integer idUniversite);
}
