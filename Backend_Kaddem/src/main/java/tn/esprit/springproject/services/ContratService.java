package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Contrat;
import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.repositories.ContratRepository;
import tn.esprit.springproject.repositories.EtudiantRepository;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ContratService implements IContratService{
    ContratRepository contratRepository ;
    EtudiantRepository etudiantRepository;

    @Override
    public List<Contrat> retrieveAllContrat() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat addContrat(Contrat C) {
        return contratRepository.save(C);
    }

    @Override
    public void deleteContrat(Integer id) {
        contratRepository.deleteById(id);
    }

    @Override
    public Contrat updateContrat(Contrat C) {
        return contratRepository.save(C);
    }

    @Override
    public Contrat retrieveContact(Integer id) {
        return contratRepository.findById(id).orElse(null);
    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
        Etudiant e =etudiantRepository.findByNomEAndPrenomE(nomE,prenomE);
        if(e==null){System.out.println("not exist"); }
        else if(contratRepository.findByEtudiantIdEtudiantAndArchive(e.getIdEtudiant(),false).size()<=5){
        ce.setEtudiant(e);
        contratRepository.save(ce);
        }
        return ce;
    }

    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {
        List<Contrat> conts = contratRepository.findByDateFinContratBetweenAndArchive(startDate,endDate,false);
        return conts.size();

    }

    @Override
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        float chifre=0;
        List<Contrat> conts = contratRepository.findByDateFinContratBetweenAndArchive(startDate,endDate,false);
        for(Contrat c:conts){
        chifre+=c.getMontantContrat();
        }
        return chifre;
    }

    @Override
    public List<Contrat> retrieveAndUpdateStatusContrat() {
        Date dateToday =new Date(2022,11,27);
        Date datef =new Date(2022,12,13) ;
        List<Contrat> contrats=contratRepository.findByDateFinContratBetweenAndArchive(dateToday,datef,false);
        return contrats;
        }




}
