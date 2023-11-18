package tn.esprit.springproject.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.services.IDepartementService;

import java.util.List;
import java.util.Set;

@RequestMapping("Departement")
@RestController
@AllArgsConstructor
public class DepartementController {
    IDepartementService iDepartementService;


    @GetMapping("/afficherDepartement")
    List <Departement> retrieveAllD(){
        return iDepartementService.retrievAllDepartement();
    }

    @PostMapping("/ajouterDepartement")
    Departement ajouterDepartement(@RequestBody Departement D){
        return iDepartementService.addDepartement(D);
    }

    @PutMapping("/modifierDepartement")
    Departement modifierDepartement(@RequestBody Departement D){
        return iDepartementService.updateDepartement(D);
    }
    @DeleteMapping("/supprimerDepartement/{id}")
    void supprimerDepartement(@PathVariable Integer id){
        iDepartementService.deleteDepartement(id);
    }

    @GetMapping("/afficherDepartement/{id}")
    Departement retrieveDepartement(@PathVariable Integer id){
        return iDepartementService.retrieveDepartement(id);
    }



    @PutMapping ("/affecterU/{idUniversite}/{idDepartement}")
    public void assignUniversiteToDepartement(@PathVariable Integer idUniversite,@PathVariable Integer idDepartement){
        iDepartementService.assignUniversiteToDepartement(idUniversite,idDepartement);
    }

    @GetMapping("/retDepByU/{idUniversite}")
    Set<Departement> retrieveDepartementsByUniversite(@PathVariable Integer idUniversite){
        return iDepartementService.retrieveDepartementsByUniversite(idUniversite);
    }

}
