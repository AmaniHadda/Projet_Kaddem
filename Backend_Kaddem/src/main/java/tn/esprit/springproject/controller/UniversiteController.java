package tn.esprit.springproject.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.Universite;
import tn.esprit.springproject.services.IUniversiteService;

import java.util.List;

@RequestMapping("Universite")
@RestController
@AllArgsConstructor
public class UniversiteController {

    IUniversiteService iUniversiteService;

    @GetMapping("/afficherUniversite")
    List<Universite> RetrieveAll(){
        return iUniversiteService.retrieveAllUniversite();
    }

    @PostMapping("/ajouterUniversite")
    Universite ajouterUniversite(@RequestBody Universite Un){
        return iUniversiteService.addUniversite(Un);
    }

    @DeleteMapping ("/supprimerUniversite/{id}")
    void supprimerUnivesite(@PathVariable Integer id){
        iUniversiteService.deleteUniversite(id);
    }
    @PutMapping("/ModifierUniversite")
    Universite updateUniversite(@RequestBody Universite Un){
        return iUniversiteService.updateUniversite(Un);
    }
    @GetMapping("/afficherUniversite/{id}")
    Universite retrieveUniversite(@PathVariable Integer id){
        return iUniversiteService.retrieveUniversite(id);
    }
}
