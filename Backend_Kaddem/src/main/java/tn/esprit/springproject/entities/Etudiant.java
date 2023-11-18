package tn.esprit.springproject.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEtudiant;
    private String prenomE;
    private String nomE;
    @Enumerated(EnumType.STRING)
    private Opt opt;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "etudiant")
    @JsonIgnore
    private Set<Contrat>contrats ;

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "etudiants")
    @JsonIgnore
    private Set<Equipe>equipes ;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    Departement departement;





}
