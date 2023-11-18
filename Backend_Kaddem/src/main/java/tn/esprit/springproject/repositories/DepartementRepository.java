package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.springproject.entities.Departement;

import java.util.List;

public interface DepartementRepository extends JpaRepository<Departement,Integer> {

    //*************List<Departement>findByUniversiteIdUniv(int idUniv);***********
  // @Query("select d from Departement d  where d.idDepart IN (select u.idUniv from  Universite u where u.idUniv=?1)")
    //List<Departement> retrieveByUniversiteIdUniv(int idUniv);

}
