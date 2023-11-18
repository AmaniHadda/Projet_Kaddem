package tn.esprit.springproject.controller;


import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.Contrat;
import tn.esprit.springproject.services.IContratService;

import java.util.Date;
import java.util.List;

@RequestMapping("Contrat")
@RestController
@AllArgsConstructor
public class ContratController {

    IContratService icontratService;
    @PostMapping("/ajouterContrat")

    Contrat ajouterContrat(@RequestBody Contrat C){
        return icontratService.addContrat(C);
    }
    @PutMapping("/modifierContrat")
    Contrat modifierContrat(Contrat C){
        return icontratService.updateContrat(C);
    }

    @GetMapping("/afficherContrat")
    List<Contrat> retrieveAllC(){
        return icontratService.retrieveAllContrat();
    }

    @DeleteMapping ("/supprimerContrat/{id}")
    void deleteContrat(@PathVariable Integer id){
        icontratService.deleteContrat(id);
    }


    @GetMapping("/afficherContrat/{id}")
    Contrat retrieveContact(@PathVariable Integer id){
        return icontratService.retrieveContact(id);
    }

    @PutMapping ("/affectConToE/{nomE}/{prenomE}")
    Contrat affectContratToEtudiant(@RequestBody Contrat ce,@PathVariable String nomE,@PathVariable String prenomE){
        return icontratService.affectContratToEtudiant(ce,nomE,prenomE);
    }
    @GetMapping("/nbCon/{startDate}/{endDate}")
    Integer nbContratsValides(@PathVariable @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) Date startDate, @PathVariable @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) Date endDate){
        return icontratService.nbContratsValides(startDate,endDate);
    }
    @GetMapping("/chifre/{startDate}/{endDate}")
    public float getChiffreAffaireEntreDeuxDate(@PathVariable @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) Date startDate, @PathVariable @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) Date endDate) {
        return icontratService.getChiffreAffaireEntreDeuxDate(startDate,endDate);
    }

    @GetMapping("contratget")
    List<Contrat> retrieveAndUpdateStatusContrat(){
      return icontratService.retrieveAndUpdateStatusContrat();
    }

    }
