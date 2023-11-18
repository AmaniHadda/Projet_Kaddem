package tn.esprit.springproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEquipe;
    private String nomEquipe;
    private String img;
    private String Role;
    private int salle;
    private String thematique;
    @Enumerated(EnumType.STRING)
    private Niveau niveau;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    DetailEquipe detailEquipe;
    @ManyToMany
    @JsonIgnore
    private Set<Etudiant>etudiants;
}
