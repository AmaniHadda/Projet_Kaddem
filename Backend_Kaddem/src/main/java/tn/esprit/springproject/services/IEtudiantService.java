package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.Equipe;
import tn.esprit.springproject.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {

    List<Etudiant> retrieveAllEtudiant();

    Etudiant addEtudiant (Etudiant Et);

    void deleteEtudiant (Integer id);

    Etudiant updateEtudiant (Etudiant Et);

    Etudiant retrieveEtudiant(Integer id);

    public void assignEtudiantToDepartement (Integer etudiantId, Integer departementId) ;

    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe);
    List<Etudiant> getEtudiantsByDepartement (Integer idDepartement);
    public Etudiant AssignEtudiantToEquipe( Integer idEtudiant, Integer idEquipe);

}
