package tn.esprit.springproject.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.services.IEtudiantService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("Etudiant")
public class EtudiantController {

    IEtudiantService iEtudiantService;

    @GetMapping("/afficherEtudant")
    List<Etudiant> retrieveAll(){
        return iEtudiantService.retrieveAllEtudiant();
    }

    @PostMapping("/ajouterEtudiant")
    Etudiant ajouterEtudiant(@RequestBody Etudiant Et){
        return iEtudiantService.addEtudiant(Et);
    }

    @PutMapping("/modifierEtudiant")
    Etudiant modifierEtudiant(@RequestBody Etudiant Et){
        return iEtudiantService.updateEtudiant(Et);
    }
    @DeleteMapping("/supprimerEtudiant/{id}")
    void supprimerEtudiant(@PathVariable Integer id){
        iEtudiantService.deleteEtudiant(id);
    }

    @GetMapping("/afficherEtudiant/{id}")
    Etudiant retrieveEtudiant(@PathVariable Integer id){
        return iEtudiantService.retrieveEtudiant(id);
    }

    @PutMapping ("/affecterE/{etudiantId}/{departementId}")
    void assignEtudiantToDepartement (@PathVariable Integer etudiantId,@PathVariable Integer departementId){
        iEtudiantService.assignEtudiantToDepartement(etudiantId,departementId);
    }
    @PutMapping("/AddEtToEqAndCont/{idContrat}/{idEquipe}")
    Etudiant addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant e,@PathVariable Integer idContrat,@PathVariable Integer idEquipe){
        return iEtudiantService.addAndAssignEtudiantToEquipeAndContract(e,idContrat,idEquipe);
    }
    @GetMapping ("/GetEtByDep/{idDepartement}")
    List<Etudiant> getEtudiantsByDepartement(@PathVariable Integer idDepartement){
        return iEtudiantService.getEtudiantsByDepartement(idDepartement);
    }
    @PutMapping("/affecterEtudiantToEquipe/{idEtudiant}/{idEquipe}")
    public Etudiant AssignEtudiantToEquipe(@PathVariable Integer idEtudiant, @PathVariable Integer idEquipe){
        return iEtudiantService.AssignEtudiantToEquipe(idEtudiant,idEquipe);
    }
}
