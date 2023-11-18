package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.Contrat;

import java.util.Date;
import java.util.List;

public interface IContratService {

    List<Contrat> retrieveAllContrat();

    Contrat addContrat(Contrat C);

    void deleteContrat(Integer id);

    Contrat updateContrat(Contrat C);

    Contrat retrieveContact(Integer id);

    public Contrat affectContratToEtudiant(Contrat ce, java.lang.String nomE, String prenomE);
    Integer nbContratsValides(Date startDate, Date endDate);
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);
    List<Contrat> retrieveAndUpdateStatusContrat();

}
