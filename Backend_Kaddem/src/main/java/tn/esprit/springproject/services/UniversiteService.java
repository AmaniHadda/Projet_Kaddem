package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Universite;
import tn.esprit.springproject.repositories.UniversiteRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class UniversiteService implements IUniversiteService{

    UniversiteRepository universiteRepository;

    @Override
    public List<Universite> retrieveAllUniversite() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite Un) {
        return universiteRepository.save(Un);
    }

    @Override
    public void deleteUniversite(Integer id) {
        universiteRepository.deleteById(id);
    }

    @Override
    public Universite updateUniversite(Universite Un) {
        return universiteRepository.save(Un);
    }

    @Override
    public Universite retrieveUniversite(Integer id) {
        return universiteRepository.findById(id).orElse(null);
    }
}
