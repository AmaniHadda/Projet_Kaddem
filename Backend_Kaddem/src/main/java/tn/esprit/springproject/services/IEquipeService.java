package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.DetailEquipe;
import tn.esprit.springproject.entities.Equipe;
import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.entities.Niveau;

import java.util.List;

public interface IEquipeService {

    List<Equipe> retrieveAllEquipe();

    Equipe addEquipe(Equipe Eq);

    void deleteEquipe(Integer id);

    Equipe updateEquipe(Equipe Eq);

    Equipe retrieveEquipe(Integer id);

    public void assignDetailsEquipeToEquipe (Integer idEquipe, DetailEquipe detailsEquipe);

    public Integer NombreEtudiantsEquipe(String nomEquipe);

    public Integer NombreEquipe();
    public Integer NombreEquipeByNiveau(Niveau n);
    public Equipe getEquipeByEtudiant(String nomEtudiant );


}
