package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Departement;

import tn.esprit.springproject.entities.Universite;
import tn.esprit.springproject.repositories.DepartementRepository;
import tn.esprit.springproject.repositories.EtudiantRepository;
import tn.esprit.springproject.repositories.UniversiteRepository;

import java.util.List;
import java.util.Set;


@Service
@AllArgsConstructor
public class DepartementService implements IDepartementService {

    DepartementRepository departementRepository;
    EtudiantRepository etudiantRepository;
    UniversiteRepository universiteRepository;

    @Override
    public List<Departement> retrievAllDepartement() {
        return departementRepository.findAll();
    }

    @Override
    public Departement addDepartement(Departement D) {
        return departementRepository.save(D);
    }

    @Override
    public void deleteDepartement(Integer id) {
        departementRepository.deleteById(id);
    }

    @Override
    public Departement updateDepartement(Departement D) {
        return departementRepository.save(D);
    }

    @Override
    public Departement retrieveDepartement(Integer id) {
        return departementRepository.findById(id).orElse(null);
    }


    @Override
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement){
        Departement Dep=departementRepository.findById(idDepartement).orElse(null);
        Universite Un=universiteRepository.findById(idUniversite).orElse(null);
        Un.getDepartements().add(Dep);
        universiteRepository.save(Un);
    }

    @Override
    public Set<Departement> retrieveDepartementsByUniversite(Integer idUniversite) {
        Universite Un=universiteRepository.findById(idUniversite).get();
        return Un.getDepartements();
    }
}
