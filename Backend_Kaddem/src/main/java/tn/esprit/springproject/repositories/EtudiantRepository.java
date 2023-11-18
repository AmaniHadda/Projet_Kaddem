package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springproject.entities.Etudiant;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant,Integer> {

    /* @Query("SELECT e FROM Etudiant e WHERE e.nomE=?1 and e.prenomE=?2")
    Etudiant retriveEtudiantByNomEtPrenom(String nomE,String prenomE);*/
    Etudiant findByNomEAndPrenomE (String nom,String prenom);



    /*@Query("SELECT e FROM Etudiant e WHERE e.departement.idDepar=?1")
    List<Etudiant> getEtudiantByDepartement(int idDep)*/
    List<Etudiant> findByDepartementIdDepart(int idDep);
}
