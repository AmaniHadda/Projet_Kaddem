package tn.esprit.springproject.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.DetailEquipe;
import tn.esprit.springproject.services.IDetailEquipeService;

import java.util.List;

@RequestMapping("DetailEquipe")
@RestController
@AllArgsConstructor
public class DetailEquipeController {
    IDetailEquipeService iDetailEquipeService;

    @GetMapping("/afficherDetailEquipe")
    List<DetailEquipe> retrieveAll(){
        return iDetailEquipeService.retrieveAllDetailEquipe();
    }

    @PostMapping("/ajouterDetailEquipe")
    DetailEquipe ajouterDetailEquipe(@RequestBody DetailEquipe De){
        return iDetailEquipeService.addDetailEquipe(De);
    }

    @PutMapping("/modifierDetailEquipe")
    DetailEquipe modifierDetailEquipe(@RequestBody DetailEquipe De){
        return iDetailEquipeService.updateDetailEquipe(De);
    }
    @DeleteMapping("/supprimerDetailEquipe/{id}")
    void supprimerDetailEquipe(@PathVariable Integer id){
        iDetailEquipeService.deleteDetailEquipe(id);
    }

    @GetMapping("/afficherDetailEquipe/{id}")
    DetailEquipe retrieveDetailEquipe(@PathVariable Integer id){
        return iDetailEquipeService.retrieveDetailEquipe(id);
    }
}
