package tn.esprit.springproject.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.DetailEquipe;
import tn.esprit.springproject.entities.Equipe;
import tn.esprit.springproject.entities.Niveau;
import tn.esprit.springproject.services.IEquipeService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("Equipe")
public class EquipeController {

    IEquipeService iEquipeService;

    @GetMapping("/afficherEquipe")
    List<Equipe> retrieveAll(){
        return iEquipeService.retrieveAllEquipe();
    }

    @PostMapping("/ajouterEquipe")
    Equipe ajouterEquipe(@RequestBody Equipe E){
        return iEquipeService.addEquipe(E);
    }

    @PutMapping("/modifierEquipe")
    Equipe modifierEquipe(@RequestBody Equipe E){
        return iEquipeService.updateEquipe(E);
    }
    @DeleteMapping("/supprimerEquipe/{id}")
    void supprimerEquipe(@PathVariable Integer id){
        iEquipeService.deleteEquipe(id);
    }

    @GetMapping("/afficherEquipe/{id}")
    Equipe retrieveEquipe(@PathVariable Integer id){
        return iEquipeService.retrieveEquipe(id);
    }

    @PutMapping ("/affecterDetailsEquipeToEquipe/{idEquipe}")
    public void assignDetailsEquipeToEquipe(@PathVariable Integer idEquipe,@RequestBody DetailEquipe detailsEquipe){
        iEquipeService.assignDetailsEquipeToEquipe(idEquipe,detailsEquipe);
    }
    @GetMapping("/GetNbEtudiants/{nomEquipe}")
    public Integer NombreEtudiantsEquipe(@PathVariable String nomEquipe){
       return iEquipeService.NombreEtudiantsEquipe(nomEquipe);
    }
    @GetMapping("/NbEquipe")
    public Integer NombreEquipe(){
        return iEquipeService.NombreEquipe();
    }
    @GetMapping("/NbEquipeByNiveau/{n}")
    public Integer NombreEquipeByNiveau(@PathVariable Niveau n){
        return iEquipeService.NombreEquipeByNiveau(n);
    }
    @GetMapping("/getEquipeByEtudiant/{nomEtudiant}")
    public Equipe getEquipeByEtudiant(@PathVariable String nomEtudiant ){
        return iEquipeService.getEquipeByEtudiant(nomEtudiant);
    }
}
