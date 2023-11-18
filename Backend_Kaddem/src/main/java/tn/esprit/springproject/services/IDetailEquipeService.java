package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.DetailEquipe;

import java.util.List;

public interface IDetailEquipeService {

    List<DetailEquipe> retrieveAllDetailEquipe();

    DetailEquipe addDetailEquipe (DetailEquipe De);

    void deleteDetailEquipe (Integer id);

    DetailEquipe updateDetailEquipe(DetailEquipe De);

    DetailEquipe retrieveDetailEquipe(Integer id);
}
