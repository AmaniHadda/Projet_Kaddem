package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.DetailEquipe;
import tn.esprit.springproject.entities.Equipe;
import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.entities.Niveau;
import tn.esprit.springproject.repositories.DetailEquipeRepository;
import tn.esprit.springproject.repositories.EquipeRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class EquipeService implements IEquipeService{

    EquipeRepository equipeRepository;
    DetailEquipeRepository detailEquipeRepository;

    @Override
    public List<Equipe> retrieveAllEquipe() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe addEquipe(Equipe Eq) {
        return equipeRepository.save(Eq);
    }

    @Override
    public void deleteEquipe(Integer id) {
        equipeRepository.deleteById(id);

    }

    @Override
    public Equipe updateEquipe(Equipe Eq) {
        return equipeRepository.save(Eq);
    }

    @Override
    public Equipe retrieveEquipe(Integer id) {
        return equipeRepository.findById(id).orElse(null);
    }

    @Override
    public void assignDetailsEquipeToEquipe(Integer idEquipe, DetailEquipe detailsEquipe) {
        Equipe equipe= equipeRepository.findById(idEquipe).orElse(null);
        equipe.setDetailEquipe(detailsEquipe);
        equipeRepository.save(equipe);
    }


    @Override
    public Integer NombreEtudiantsEquipe(String nomEquipe) {
        Equipe E=equipeRepository.findBynomEquipe(nomEquipe);
        Integer Nb=E.getEtudiants().size();
        return Nb;

    }

    @Override
    public Integer NombreEquipe() {
        return equipeRepository.findAll().size();
    }

    @Override
    public Integer NombreEquipeByNiveau(Niveau n) {
        return equipeRepository.findByNiveau(n).size();
    }

    @Override
    public Equipe getEquipeByEtudiant(String nomEtudiant) {
        List<Equipe>equipes=equipeRepository.findAll();
        Equipe EquipeG=null;
        for(Equipe Eq:equipes){
            for (Etudiant Et: Eq.getEtudiants()){
                if(Et.getNomE().equals(nomEtudiant)){
                     EquipeG=Eq;
                    break;
                }
            }
        }
        return EquipeG;
    }


}
