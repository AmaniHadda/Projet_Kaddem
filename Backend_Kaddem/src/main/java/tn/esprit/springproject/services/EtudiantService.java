package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Contrat;
import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.entities.Equipe;
import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.repositories.ContratRepository;
import tn.esprit.springproject.repositories.DepartementRepository;
import tn.esprit.springproject.repositories.EquipeRepository;
import tn.esprit.springproject.repositories.EtudiantRepository;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class EtudiantService implements IEtudiantService{

    EtudiantRepository etudiantRepository;
    ContratRepository contratRepository;
    EquipeRepository equipeRepository;
    DepartementRepository departementRepository;

    @Override
    public List<Etudiant> retrieveAllEtudiant() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant Et) {
        return etudiantRepository.save(Et);
    }

    @Override
    public void deleteEtudiant(Integer id) {
        etudiantRepository.deleteById(id);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant Et) {
        return etudiantRepository.save(Et);
    }

    @Override
    public Etudiant retrieveEtudiant(Integer id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    @Override
    public void assignEtudiantToDepartement(Integer etudiantId, Integer departementId) {
        Departement Dep=departementRepository.findById(departementId).orElse(null);
        Etudiant Et=etudiantRepository.findById(etudiantId).orElse(null);
        Et.setDepartement(Dep);
        etudiantRepository.save(Et);

    }

    @Override
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) {
        Contrat Con=contratRepository.findById(idContrat).get();
        Equipe Eq=equipeRepository.findById(idEquipe).get();
        Con.setEtudiant(e);
        Eq.getEtudiants().add(e);
        return etudiantRepository.save(e);
    }

    @Override
    public List<Etudiant> getEtudiantsByDepartement(Integer idDepartement) {
        return etudiantRepository.findByDepartementIdDepart(idDepartement);

    }

    @Override
    public Etudiant AssignEtudiantToEquipe(Integer idEtudiant, Integer idEquipe) {
        Etudiant Et=etudiantRepository.findById(idEtudiant).orElse(null);
        Equipe Eq=equipeRepository.findById(idEquipe).orElse(null);
        Eq.getEtudiants().add(Et);
        equipeRepository.save(Eq);
        return etudiantRepository.save(Et);
    }

}
