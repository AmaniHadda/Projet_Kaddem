package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springproject.entities.Equipe;
import tn.esprit.springproject.entities.Niveau;

import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe,Integer> {
    Equipe findBynomEquipe(String nomEquipe);
    List<Equipe> findByNiveau(Niveau niveau);
}
